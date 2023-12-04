package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrctcMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcMicroserviceApplication.class, args);

		HashMap map = new HashMap<>();
		map.put(1, "123");
		map.put(1, "345");
		map.put(1, "678");
		
		System.out.println(map);
		
		HashSet set = new HashSet<>();
		set.add(1);
		set.add(1);
		set.add(1);
		
		System.out.println(set);
	}

}
