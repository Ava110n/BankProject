import java.io.*
import java.net.Socket

class Client(val host: String = "localhost", val port: Int = 8080) {

    var socket: Socket? = null
    var br: BufferedReader? = null
    var bw: PrintWriter? = null

    init{
        //start()
    }
    fun start(){
        try{
            socket = Socket(host, port)
        }
        catch (e: Exception){
            println(e.message)
        }
    }
    fun send(vararg text: String){
        bw = PrintWriter(socket?.getOutputStream(),true)
        for(t in text) {
            bw?.println(t)
        }
    }
    fun get(): String? {
        br = BufferedReader(InputStreamReader(socket?.getInputStream()))
        return br?.readLine()
    }
    fun finish(){
        socket?.close()
        bw?.close()
        br?.close()
    }
}