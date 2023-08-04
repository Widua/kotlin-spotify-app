package widua.it.kotlinspringapp.spotify

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import widua.it.kotlinspringapp.model.SpotifyResponseModel

interface SpotifyApiClient {

    @GetExchange("/search")
    fun searchForItem(@RequestParam("q") searchQuery : String ,
                      @RequestParam("type") type : String ) : Mono<SpotifyResponseModel>

}