package widua.it.kotlinspringapp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import widua.it.kotlinspringapp.model.SpotifyArtist
import widua.it.kotlinspringapp.model.SpotifyArtists
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
    fun findArtist(@PathVariable artistName : String) : Flux<SpotifyArtist> {
        return spotifyApi.searchForItem(artistName,"artist").flatMap { it.artists?.items?.toFlux() }
    }

}