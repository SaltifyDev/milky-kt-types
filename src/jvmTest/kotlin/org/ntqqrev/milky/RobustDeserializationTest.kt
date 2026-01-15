package org.ntqqrev.milky

import kotlinx.serialization.decodeFromString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class RobustDeserializationTest {
    private val json = milkyJsonModule

    @Test
    fun dropBadElementListSerializerDropsInvalidOutgoingSegment() {
        val payload = """
            {
              "user_id": 123,
              "message": [
                {"type":"text","data":{"text":"ok"}},
                {"type":"mention","data":{"user_id":"bad"}}
              ]
            }
        """.trimIndent()

        val decoded = json.decodeFromString<SendPrivateMessageInput>(payload)

        assertEquals(1, decoded.message.size)
        val segment = assertIs<OutgoingSegment.Text>(decoded.message.first())
        assertEquals("ok", segment.data.text)
    }

    @Test
    fun transformUnknownSegmentListSerializerFallbacksToText() {
        val payload = """
            {
              "message_scene":"friend",
              "peer_id": 1,
              "message_seq": 2,
              "sender_id": 3,
              "time": 4,
              "segments": [
                {"type":"text","data":{"text":"hello"}},
                {"type":"unknown_segment","data":{"foo":"bar"}}
              ],
              "friend": {
                "user_id": 1,
                "nickname": "n",
                "sex": "unknown",
                "qid": "q",
                "remark": "r",
                "category": {"category_id": 1, "category_name": "c"}
              }
            }
        """.trimIndent()

        val decoded = json.decodeFromString<IncomingMessage>(payload)
        val message = assertIs<IncomingMessage.Friend>(decoded)

        assertEquals(2, message.segments.size)
        val first = assertIs<IncomingSegment.Text>(message.segments[0])
        assertEquals("hello", first.data.text)
        val second = assertIs<IncomingSegment.Text>(message.segments[1])
        assertEquals("[unknown_segment]", second.data.text)
    }
}
