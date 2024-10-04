package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.auto.ShapeFactory;
import com.example.jauto.Player;
import com.example.jbased.Student;

@SpringBootApplication(scanBasePackages = { "com.example", "com.spring" })
public class SpringBootBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	@Autowired
	private ShapeFactory factory;
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	private Student stud;
	
	@Autowired
	private Player player;
	
	@Override
	public void run(String... args) throws Exception {
//		factory.printArea(12, 120);
//		System.out.println(stud);
//		System.out.println();
//	Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
	
		player.gamesPlayed().forEach(System.out::println);
	}

}
