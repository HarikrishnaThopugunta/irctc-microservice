package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import com.example.demo.builders.TrainBuilder;
import com.example.demo.entities.Train;

@RestController
public class TrainController {

	@GetMapping("/")
	public String healthCheck() {
		return "{healthy:true}";
	}

	@GetMapping("/get-train-list")
	public List<Train> getTrainsList() {
		Train train1 = new TrainBuilder().addTrainNumber(101).addTrainName("Narayanadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").buildTrainObject();
		Train train2 = new TrainBuilder().addTrainNumber(102).addTrainName("Venkatadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").buildTrainObject();
		Train train3 = new TrainBuilder().addTrainNumber(103).addTrainName("Sheshadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").buildTrainObject();
		return Arrays.asList(train1, train2, train3);
	}

}
