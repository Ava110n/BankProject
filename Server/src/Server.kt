import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(val port: Int = 8080) {
    val socketServer = ServerSocket(port)

    init{
        count++
    }

    companion object{
        var count: Int = 0
    }

    fun Start(){
        var socketClient: Socket? = null
        var br: BufferedReader? = null
        var pw: PrintWriter? = null

        try{

            socketClient = socketServer.accept()
            ///var br = BufferedReader(InputStreamReader(socketClient.getInputStream()))
            with(BufferedReader(InputStreamReader(socketClient.getInputStream()))){
                var line = this.readLine()
                println(line)
            }

            pw = PrintWriter(socketClient.getOutputStream(), true)
            pw.println("hello from server"+ count)
            //Thread.sleep(8000)
        }
        catch (e: Exception){
            println(e.message)
        }
        finally {
            br?.close()
            pw?.close()
            socketClient?.close()
            socketServer.close()
        }


    }
}