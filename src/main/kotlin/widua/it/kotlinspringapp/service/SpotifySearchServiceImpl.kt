package widua.it.kotlinspringapp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import widua.it.kotlinspringapp.configuration.ServerConfiguration
import widua.it.kotlinspringapp.model.applicationModels.SearchCallResponse

@Service
class SpotifySearchServiceImpl : SpotifySearchService {

    @Autowired
    private lateinit var spotifyApi : SpotifyApiClient

    @Autowired
    private lateinit var serverConfiguration : ServerConfiguration

    @Value("\${application.base-url}")
    private lateinit var apiBaseUrl : String



    override fun searchForArtist(query: String, offset: Int): Mono<SearchCallResponse> {
        val apiLink = serverConfiguration.getApiAddress() + "/artists/find/${query}"
        return spotifyApi.searchForItem(query , "artist", offset).mapNotNull { it ->
            it.artists?.items?.let { it1 ->
                SearchCallResponse(
                    prev =  it.artists?.previous
                        ?.replace("$apiBaseUrl/search",apiLink)
                        ?.replace("?query=${query}&","?")
                        ?.replace("&limit=20",""),
                    next = it.artists?.next
                        ?.replace("$apiBaseUrl/search",apiLink)
                        ?.replace("?query=${query}&","?")
                        ?.replace("&limit=20",""),
                    items =  it1.filter {
                        it.popularity > 25
                    }
                )
            }
        }
    }

}