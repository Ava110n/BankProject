import kotlin.coroutines.suspendCoroutine

fun main() {
    while(true) {
        val server = Server()
        server.Start()
    }
}