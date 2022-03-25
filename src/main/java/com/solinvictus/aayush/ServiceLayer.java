package com.solinvictus.aayush;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {
    public List<Data> getData(){
        DataLayer d = new DataLayer();
        return d.getData();
    }
}
