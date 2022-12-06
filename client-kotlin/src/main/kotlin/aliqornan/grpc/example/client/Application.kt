package aliqornan.grpc.example.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.StatusException

suspend fun main() {
    val client = buildCountryClient()
    try {
        val reply = client.lookup("ID")
        println("Received reply from country-service:\n$reply")
    } catch (e: StatusException) {
        println("Got StatusException: ${e.status}")
    }
}

private fun buildCountryClient(): CountryClient {
    val channel = buildChannel("localhost", 3000)
    return CountryClient(channel, 5L)
}

private fun buildChannel(host: String, port: Int): ManagedChannel {
    return ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext()
        .build()
}