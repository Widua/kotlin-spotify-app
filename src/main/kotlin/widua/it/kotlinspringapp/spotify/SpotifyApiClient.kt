package widua.it.kotlinspringapp.spotify

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono

interface SpotifyApiClient {

    @GetExchange("/search")
    fun searchForItem(@RequestParam("q") searchQuery : String ,
                      @RequestParam("type") type : String ) : Mono<String>

}