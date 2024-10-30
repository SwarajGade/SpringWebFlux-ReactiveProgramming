package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;
import java.util.Locale;

@SpringBootTest
class ReactiveProjetApplicationTests {

	@Test
	void contextLoads() {
	}
    @Test
    void workingWithMono() throws InterruptedException {

 /*      //mono -->publisher that have  0 or 1 items.
        Mono<String> errorMono =Mono.error(new RuntimeException("Error !!"));

        //created mono
       Mono<String>m1= Mono
               .just("Learn reactive") //mono object is created.
               .log()
               .then(errorMono);


        //consume the mono by subscribing
        m1.subscribe(data->{System.out.println("data is "+data); }); //lambda
       // m1.subscribe(System.out::println); //method reference.

        errorMono.subscribe(System.out::println);*/
        Mono<String> m1=Mono.just("Learn");
        Mono<String> m2=Mono.just("Mono");
        Mono<Integer> m3=Mono.just(123);
       /* //Combining mono with .zip() and .zipWith().

       Mono<Tuple3<String,String,Integer>> combinedMono= Mono.zip(m1, m2, m3);

       combinedMono.subscribe(data->{
           System.out.println(data.getT1());
           System.out.println(data.getT2());
           System.out.println(data.getT3());
       });

       Mono<Tuple2<String,String>> zipWithMono =m1.zipWith(m2);
       zipWithMono.subscribe(data->{
           System.out.println(data.getT1());
           System.out.println(data.getT2());
       });*/

        /*//(map)transform the value emmited by current using syn function
       Mono<String> resultMapMono= m1.map(//item->item.toUpperCase()// //String::toUpperCase// value->value.toUpperCase());
       resultMapMono.subscribe(System.out::println);

       //flatMap()
       Mono<String[]> resultFlatExample =m1.flatMap(valueM1-> Mono.just(valueM1.split(" ")));
       resultFlatExample.subscribe(data->{
           for(String s :data) {
               System.out.println(s);
           }
       });
       System.out.println("------------");

       //by using flatMapMany convert Mono to Flux
      Flux<String> stringFlux= m1.flatMapMany(valueM1-> Flux.just(valueM1.split(" "))).log();

      stringFlux.subscribe(data->{
          System.out.println(data);
        });*/

        System.out.println(Thread.currentThread().getName());
      //.concatWith()-join to mono and provide Flux
        Flux<String> stringFlux =m1.concatWith(m2)
                .log()
                .delayElements(Duration.ofMillis(2000));

        stringFlux.subscribe((data)->{

                System.out.println(Thread.currentThread().getName());
                System.out.println(data);
        });

        Thread.sleep(4000);
        System.out.println("terminated main thread");

    }

}
