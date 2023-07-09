package widua.it.kotlinspringapp.spotify

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.PostExchange

interface SpotifyApiClient {

    @PostExchange("/search")
    fun searchForItem(@RequestParam("q") searchQuery : String ,
                      @RequestParam("type") type : String )

}