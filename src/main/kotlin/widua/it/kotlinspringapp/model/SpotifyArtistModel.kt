package widua.it.kotlinspringapp.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SpotifyArtistModel( @JsonProperty("id") val id : String,
                               @JsonProperty("name") val name : String)
