package widua.it.kotlinspringapp.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import widua.it.kotlinspringapp.model.SpotifyArtistDocument

@Repository
interface SpotifyArtistRepository : ReactiveMongoRepository<SpotifyArtistDocument,String>