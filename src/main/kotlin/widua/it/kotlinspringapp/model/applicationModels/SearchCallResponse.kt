package widua.it.kotlinspringapp.model.applicationModels

import widua.it.kotlinspringapp.model.spotifyApiModels.SpotifyArtist

data class SearchCallResponse(var prev: String?, var next: String?, var items: List<SpotifyArtist>)
