package ru.geekbrains.homework2.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.homework2.model.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ProductRepository implements AbstractRepository<Product, Long> {

	private final CopyOnWriteArrayList<Product> productList = new CopyOnWriteArrayList<>();

	private ProductRepository() {
		long id = 0L;
		productList.add(new Product(id++,"Apple",10));
		productList.add(new Product(id++,"Watermelon",8));
		productList.add(new Product(id++,"Banana",6));
		productList.add(new Product(id++,"Orange",12));
		productList.add(new Product(id++,"Lemon",13));
		productList.add(new Product(id++,"Dragon fruit",20));
		productList.add(new Product(id++,"Blueberries",15));
		productList.add(new Product(id++,"Raspberry",21));
		productList.add(new Product(id++,"Strawberry",18));
		productList.add(new Product(id++,"Blackberry",17));
	}

	@Override
	public List<Product> findAll() {
		return productList;
	}

	@Override
	public Product findById(Long id) {
		return productList.stream().filter(pr->pr.getId()==id).findFirst().orElseThrow();
	}
}
