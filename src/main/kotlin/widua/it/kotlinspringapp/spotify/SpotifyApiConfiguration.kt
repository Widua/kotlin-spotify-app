package widua.it.kotlinspringapp.spotify

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient

@Configuration
class SpotifyApiConfiguration {

    @Bean
    fun spotifyApiClient( clientRegistrations : ReactiveClientRegistrationRepository,
                          authorizedClients : ServerOAuth2AuthorizedClientRepository) : SpotifyApiClient{

        val oauth = ServerOAuth2AuthorizedClientExchangeFilterFunction(
            clientRegistrations,
            authorizedClients
        );

        val client = WebClient
            .builder()
            .filter(oauth)
            .baseUrl("https://api.spotify.com/v1")
            .build();

        val serviceFactory : HttpServiceProxyFactory = HttpServiceProxyFactory
            .builder( WebClientAdapter.forClient(client) )
            .build();

        return serviceFactory.createClient();
    }

}
