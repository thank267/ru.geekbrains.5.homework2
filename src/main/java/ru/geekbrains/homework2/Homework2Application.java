package ru.geekbrains.homework2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.geekbrains.homework2.component.Cart;

@Slf4j
@SpringBootApplication
public class Homework2Application  implements CommandLineRunner {

	private ApplicationContext context;

	@Autowired
	public void context(ApplicationContext context) { this.context = context; }

	public static void main(String[] args) {
		SpringApplication.run(Homework2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cart cart1 = context.getBean(Cart.class);
		cart1.add(1L);
		cart1.add(2L);
		cart1.add(2L);
		cart1.add(2L);
		cart1.add(2L);
		cart1.add(2L);
		cart1.remove(2L);

		Cart cart2 = context.getBean(Cart.class);
		cart2.add(3L);
		cart2.add(4L);
		cart2.remove(4L);
		cart2.remove(4L);

		log.info("cart1  {}", cart1);
		log.info("cart2  {}", cart2);
	}
}
