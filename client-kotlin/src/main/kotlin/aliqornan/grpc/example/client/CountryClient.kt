package aliqornan.grpc.example.client

import aliqornan.grpc.example.protocontract.CountryServiceGrpcKt.CountryServiceCoroutineStub
import aliqornan.grpc.example.protocontract.LookupReply
import aliqornan.grpc.example.protocontract.lookupRequest
import io.grpc.ManagedChannel
import java.io.Closeable
import java.util.concurrent.TimeUnit

class CountryClient(
    private val channel: ManagedChannel,
    private val terminationSec: Long
) : Closeable {

    private val stub: CountryServiceCoroutineStub = CountryServiceCoroutineStub(channel)

    suspend fun lookup(countryCode: String): LookupReply {
        val request = lookupRequest { code = countryCode }
        return stub.lookup(request)
    }

    override fun close() {
        channel.shutdown().awaitTermination(terminationSec, TimeUnit.SECONDS)
    }
}