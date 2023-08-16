package widua.it.kotlinspringapp.service

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono
import widua.it.kotlinspringapp.model.spotifyApiModels.SpotifySearchResponseModel

interface SpotifyApiClient {

    @GetExchange("/search")
    fun searchForItem(@RequestParam("q") searchQuery : String,
                      @RequestParam("type") type : String,
                      @RequestParam(name="offset", required = false) offset : Int ) : Mono<SpotifySearchResponseModel>

}