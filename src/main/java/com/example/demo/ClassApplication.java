package com.example.demo;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ClassApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;


	public static void main(String[] args) {

		SpringApplication.run(ClassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.printf("Pedido código %d", order.getCode());
		System.out.println();
		System.out.printf("Valor total = %.2f%n", orderService.total(order));

		sc.close();
	}
}
