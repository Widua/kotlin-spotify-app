package widua.it.kotlinspringapp.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ServerConfiguration {

    @Value("\${server.address}")
    lateinit var hostname : String

    @Value("\${server.port}")
    lateinit var port : String

    fun getApiAddress() : String{
        return "http://${hostname}:${port}"
    }

}