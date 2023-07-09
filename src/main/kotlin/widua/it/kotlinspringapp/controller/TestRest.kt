package widua.it.kotlinspringapp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
class TestRest {

    @GetMapping("/test")
    fun getTestMapping() : Mono<String> {
        return Mono.just("TEST!");
    }

}