package widua.it.kotlinspringapp.model.spotifyApiModels

data class SpotifyArtist(var id : String , var name: String, var genres : MutableSet<String>, var popularity : Int)
