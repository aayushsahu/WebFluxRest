package com.solinvictus.aayush;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller2 {

    private ServiceLayer s = new ServiceLayer();

    @GetMapping("/getMonoModel2")
    private Mono<Model> myControllerMethod(){
        return Mono.just(new Model(Flux.fromIterable(this.s.getData())));
    }

    @GetMapping("/getFluxModel2")
    private Mono<Object> myControllerMethod1(){
        Model m1 = new Model(Flux.fromIterable(this.s.getData()));
        Model m2 = new Model(Flux.fromIterable(this.s.getData()));

        List<Model> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);

        return Flux.fromIterable(list)
                .collectList()
                .flatMap(JsonWriter::write)
                .flatMap((json) -> ServerResponse.ok()
                        .body(Mono.just(json), String.class)
                );
    }
}
