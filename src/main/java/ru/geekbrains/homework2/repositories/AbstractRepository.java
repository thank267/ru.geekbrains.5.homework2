package ru.geekbrains.homework2.repositories;

import java.util.List;

public interface AbstractRepository<T, Long> {
	List<T> findAll();
	T findById(Long id);
}
