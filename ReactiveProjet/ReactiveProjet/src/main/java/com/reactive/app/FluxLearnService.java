package com.reactive.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class FluxLearnService {
    // all operators example goes here
    /*Creating flux */

    public Flux<String>getFlux(){
       return Flux.just("swaraj","santosh","abhi","bhavya");
    }

    public Flux<String> fruitsFlux(){
        List<String> fruitsName=List.of("Apple","Banana","Mango");
        return Flux.fromIterable(fruitsName).log();
    }

    public Flux<Void> getBlankFlux(){
        return Flux.empty();
    }
//map

    public Flux<String> mapExampleFlux(){
       Flux<String> capFlux= getFlux().map(name->name.toUpperCase());
   return capFlux;
    }


}



