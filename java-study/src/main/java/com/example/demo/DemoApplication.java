package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	public static class MyController{
		@RequestMapping("/")
		public List<User> users(){
			return Arrays.asList(new User("A"), new User("B"), new User("C"));
		}
	}

	public static class User{
		String name;

		public User() {
		}

		@Override
		public String toString() {
			return "User{" +
					"name='" + name + '\'' +
					'}';
		}

		public User(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
