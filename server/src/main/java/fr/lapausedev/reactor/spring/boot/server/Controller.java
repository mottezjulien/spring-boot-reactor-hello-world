package fr.lapausedev.reactor.spring.boot.server;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class Controller {

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> flux() {
        return Flux.just(8, 7, 6, 5, 4, 3, 2, 1).zipWith(Flux.interval(Duration.ofMillis(500)), (integer, aLong) -> integer);
    }

}
