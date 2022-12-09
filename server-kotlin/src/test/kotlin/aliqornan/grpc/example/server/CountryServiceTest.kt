package aliqornan.grpc.example.server

import aliqornan.grpc.example.protocontract.country
import aliqornan.grpc.example.protocontract.lookupReply
import aliqornan.grpc.example.protocontract.lookupRequest
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountryServiceTest {

    @Nested
    class `When lookup` {

        private val service = CountryService()

        @Test
        fun `given code is ID, it should return with Indonesia`() {
            val request = lookupRequest {
                code = "ID"
            }

            val actualReply = runBlocking { service.lookup(request) }

            val expectedReply = lookupReply {
                data = country {
                    code = "ID"
                    officialName = "Republik Indonesia"
                    numberOfPopulation = 2000000
                    tourismRating = 4.5f
                }
                success = true
            }
            assertEquals(expectedReply, actualReply)
        }
    }
}