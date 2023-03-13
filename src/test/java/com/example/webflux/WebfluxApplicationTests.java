package com.example.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class WebfluxApplicationTests {

	@Test
	void contextLoads() {
		 Flux.just("Adam","Anna","Marek","Bartosz","Jan","Oliwia","Justyna").filter(name->name.startsWith("J")).subscribe(System.out::println);
	}

}
