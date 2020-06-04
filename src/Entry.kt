import java.io.InputStreamReader
import java.net.URL
import java.util.*

data class Entry(
    val uid:String = "0",
    val time_start:Long = 0L,
    val time_end:Long = 0L,
    val comment:String = ""
){
    fun save_to_db(webApi:String = "anmedia-server.000webhostapp.com/include/api.php"){
        //пока что сервер в инете
        val request = "$webApi?action=add_data" +
                "&id=$uid" +
                "&time_start=$time_start" +
                "&time_end=$time_end" +
                "&comment=$comment"
        val url = URL(request)
        val isr = InputStreamReader(url.openStream())
        val sc = Scanner(isr)
        var result = ""
        while (sc.hasNextLine()) result += sc.nextLine()
        sc.close()
        if ("OK" in result)
            println("SUCCESS")
        else
            println("ERROR")
    }
}