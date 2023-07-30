package widua.it.kotlinspringapp.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Artists (@JsonProperty("items") val items : List<SpotifyArtistModel> )