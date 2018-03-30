package fr.lapausedev.reactor.spring.boot.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

public class AppClient {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> flux = WebClient.create("http://localhost:8080/test")
                .get()
                .retrieve()
                .bodyToFlux(String.class);
        Disposable disposable = flux.subscribe(body -> System.out.println("body -> " + body));
        while (!disposable.isDisposed()) {
            Thread.sleep(1000);
        }
    }

}
