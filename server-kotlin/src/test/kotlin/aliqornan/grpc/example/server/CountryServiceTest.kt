package aliqornan.grpc.example.server

import aliqornan.grpc.example.protocontract.Country
import aliqornan.grpc.example.protocontract.LookupReply
import aliqornan.grpc.example.protocontract.LookupRequest
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
            val request = LookupRequest.newBuilder()
                .setCode("ID")
                .build()

            val actualReply = runBlocking { service.lookup(request) }

            val expectedReply = LookupReply.newBuilder()
                .setSuccess(true)
                .setData(
                    Country.newBuilder()
                        .setCode("ID")
                        .setOfficialName("Republik Indonesia")
                        .setNumberOfPopulation(2000000)
                        .setTourismRating(4.5f)
                )
                .build()
            assertEquals(expectedReply, actualReply)
        }
    }
}