package com.polarbookshop.edgeservice.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.*

import reactor.core.publisher.Mono

@Configuration
class WebEndpoints {
    @Bean
    fun routerFunction(): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .GET(
                "/catalog-fallback"
            ) { ServerResponse.ok().body(
                    Mono.just(""),
                    String::class.java
                )
            }
            .POST(
                "/catalog-fallback"
            ) { ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build()
            }
            .build()
    }
}
