package com.solinvictus.aayush;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class DataLayer {
    public List<Data> getData(){
        Data[] d ={new Data(1, "Aayush"), new Data(2, "Aayush2"), new Data(3, "Aayush3")};
        return Arrays.asList(d);
    }
}
