package widua.it.kotlinspringapp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import widua.it.kotlinspringapp.model.applicationModels.SearchCallResponse
import widua.it.kotlinspringapp.service.SpotifyArtistService
import widua.it.kotlinspringapp.service.SpotifySearchService


@RestController
@RequestMapping("/artists/")
class SpotifyArtistApi {

    private lateinit var artistService: SpotifyArtistService

    @Autowired
    private lateinit var searchService: SpotifySearchService;


    @GetMapping("/find/{artistName}")
    fun findArtist(@PathVariable artistName : String, @RequestParam(name = "offset", defaultValue = "0") offset : Int ) : Mono<SearchCallResponse> {
        return searchService.searchForArtist(artistName, offset)
    }

}