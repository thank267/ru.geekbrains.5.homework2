package ru.geekbrains.homework2.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework2.model.Product;
import ru.geekbrains.homework2.repositories.AbstractRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class Cart {

	private final Map<Product, Integer> cart = new HashMap<>();

	private final AbstractRepository<Product, Long> repo;

	public Cart(AbstractRepository abstractRepository) {
		repo = abstractRepository;
	}

	public void add(Long id) {

		Product product = repo.findById(id);
		Integer count = Optional.ofNullable(cart.computeIfPresent(product,(key, value) -> ++value)).orElse(1);
		cart.putIfAbsent(product,count);

	}

	public void remove(Long id) {

		Product product = repo.findById(id);
		Integer count = Optional.ofNullable(cart.computeIfPresent(product,(key, value) -> --value)).orElse(0);
		if (count<=0) {
			cart.remove(product,count);
		}
	}

	@Override
	public String toString() {
		return  cart.keySet().stream()
				.map(key -> key + " count: " + cart.get(key))
				.collect(Collectors.joining(", ", "Cart"+this.hashCode()+" {", "}"));

	}

}
