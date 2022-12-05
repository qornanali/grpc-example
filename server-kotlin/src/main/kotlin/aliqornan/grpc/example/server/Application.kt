package aliqornan.grpc.example.server

private const val DEFAULT_APP_PORT = 3000

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val port = System.getenv("APP_PORT")?.toInt() ?: DEFAULT_APP_PORT
            val server = Server(port)
            server.start()
            server.blockUntilShutdown()
        }
    }
}
