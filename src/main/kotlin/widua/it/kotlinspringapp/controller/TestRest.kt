package widua.it.kotlinspringapp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import widua.it.kotlinspringapp.spotify.SpotifyApiClient


@RestController
class TestRest {

    @Autowired
    private lateinit var spotifyApi : SpotifyApiClient;

    @GetMapping("/test")
    fun getTestMapping() : Mono<String> {
        return Mono.just("TEST!");
    }

    @GetMapping("/artist/{artistName}")
    fun findArtist(@PathVariable artistName : String) : Mono<String>{
        return spotifyApi.searchForItem(artistName,"artist");
    }

}