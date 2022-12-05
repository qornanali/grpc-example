package aliqornan.grpc.example.server

import io.grpc.ServerBuilder

class Server(private val port: Int) {

    private val server: io.grpc.Server = ServerBuilder.forPort(port)
        .addService(CountryService())
        .build()

    fun start() {
        println("Starting server..")
        server.start()
        println("Server started, listening at $port")
        Runtime.getRuntime().addShutdownHook(shutdown())
    }

    private fun shutdown() = Thread {
        println("Shutting down server..")
        server.shutdown()
        println("Server shut down")
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

}