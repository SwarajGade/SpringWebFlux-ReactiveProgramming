package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FluxLearnTest {

    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    public void simpleFluxTest(){
    /*fluxLearnService.getFlux()
            .log().subscribe(data->{
        System.out.println(data);
        System.out.println("done with flux data");
            });*/

        fluxLearnService.fruitsFlux().subscribe(
               System.out::println );
    }
 }
