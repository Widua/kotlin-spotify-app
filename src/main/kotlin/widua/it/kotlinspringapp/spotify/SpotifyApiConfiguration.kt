package widua.it.kotlinspringapp.spotify

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientProvider
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientProviderBuilder
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.web.DefaultReactiveOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient

@Configuration
class SpotifyApiConfiguration {

    @Bean
    fun authorizedClientManager(
        clientRegistrationRepository: ReactiveClientRegistrationRepository?,
        authorizedClientRepository: ServerOAuth2AuthorizedClientRepository): ReactiveOAuth2AuthorizedClientManager? {

        val authorizedClientProvider: ReactiveOAuth2AuthorizedClientProvider = ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
            .clientCredentials()
            .build()

        val authorizedClientManager = DefaultReactiveOAuth2AuthorizedClientManager(
            clientRegistrationRepository, authorizedClientRepository)

        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider)
        return authorizedClientManager
    }

    @Bean
    fun spotifyApiClient( authorizedClientManager: ReactiveOAuth2AuthorizedClientManager ) : SpotifyApiClient{
        val oauth = ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager)
        oauth.setDefaultClientRegistrationId("spotify")

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
