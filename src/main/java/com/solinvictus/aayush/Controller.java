package com.solinvictus.aayush;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;



@RestController
public class Controller {
    private ServiceLayer s = new ServiceLayer();

    @GetMapping("/getMonoModel")
    private Mono<Model> myControllerMethod(){
        return Mono.just(new Model(Flux.fromIterable(this.s.getData())));
    }

    @GetMapping("/getFluxModel")
    private Flux<Model> myControllerMethod1(){
        Model m1 = new Model(Flux.fromIterable(this.s.getData()));
        Model m2 = new Model(Flux.fromIterable(this.s.getData()));

        List<Model> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);

        return Flux.fromIterable(list);
    }

    @GetMapping("/getMonoData")
    private Mono<Data> myControllerMethod3(){
        return Mono.just(new Data(1, "Aayush1"));
    }

    @GetMapping("/getFluxData")
    private Flux<Data> myControllerMethod4(){
        return Flux.fromIterable(this.s.getData());
    }
}
