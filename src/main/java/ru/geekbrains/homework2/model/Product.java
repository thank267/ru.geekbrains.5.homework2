package ru.geekbrains.homework2.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	private long id;
	private String title;
	private int cost;
}
