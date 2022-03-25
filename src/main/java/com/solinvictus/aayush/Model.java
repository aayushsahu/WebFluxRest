package com.solinvictus.aayush;

import reactor.core.publisher.Flux;

public class Model {
    private Flux<Data> data;

    public Model(Flux<Data> data) {
        this.data = data;
    }

    public Flux<Data> getData() {
        return data;
    }

    public void setData(Flux<Data> data) {
        this.data = data;
    }
}
