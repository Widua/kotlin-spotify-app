package widua.it.kotlinspringapp.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class SpotifyArtistDocument(val artistId : String, val artistName : String)
