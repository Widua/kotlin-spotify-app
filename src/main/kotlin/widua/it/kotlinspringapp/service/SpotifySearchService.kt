package widua.it.kotlinspringapp.service

import reactor.core.publisher.Mono
import widua.it.kotlinspringapp.model.applicationModels.SearchCallResponse

interface SpotifySearchService {
    fun searchForArtist(query : String, offset : Int) : Mono<SearchCallResponse>
}