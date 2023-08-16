package widua.it.kotlinspringapp.service

import widua.it.kotlinspringapp.model.spotifyApiModels.SpotifyArtist

interface SpotifyArtistService {
    fun findSpotifyArtistInfo(artistId : String) : SpotifyArtist

}