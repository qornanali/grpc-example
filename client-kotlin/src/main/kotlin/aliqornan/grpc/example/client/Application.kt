package aliqornan.grpc.example.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.StatusException

suspend fun main() {
    val channel = buildChannel("localhost", 3000)
    val client = CountryClient(channel, 5L)
    try {
        val reply = client.lookup("ID")
        println("Received reply from country-service:\n$reply")
    } catch (e: StatusException) {
        println("Got StatusException: ${e.status}")
    }
}

private fun buildChannel(host: String, port: Int): ManagedChannel {
    return ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext()
        .build()
}