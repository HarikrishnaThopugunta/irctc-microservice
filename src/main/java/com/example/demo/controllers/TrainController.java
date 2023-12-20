package com.example.demo.controllers;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.builders.TrainBuilder;
import com.example.demo.entities.TrainTrakingEntity;
import com.example.demo.producer.TrainTrackingProduceService;

@RestController()
public class TrainController {
	
	@Autowired
	TrainTrackingProduceService trainTrackingProduceService;

	@GetMapping("/irctc-microservice")
	public String healthCheck() {
		return "{healthy:true}";
	}

	@GetMapping("/irctc-microservice/get-train-list")
	public List<TrainTrakingEntity> getTrainsList() throws Exception {
		
		System.out.println("=======before");
		trainTrackingProduceService.process();
		System.out.println("=======after");
		
		String ipAddress = new String();
		final DatagramSocket socket = new DatagramSocket();
		socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		ipAddress = socket.getLocalAddress().getHostAddress();

		TrainTrakingEntity train1 = new TrainBuilder().addTrainNumber(101).addTrainName("Narayanadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").addIpAddress(ipAddress).buildTrainObject();
		TrainTrakingEntity train2 = new TrainBuilder().addTrainNumber(102).addTrainName("Venkatadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").addIpAddress(ipAddress).buildTrainObject();
		TrainTrakingEntity train3 = new TrainBuilder().addTrainNumber(103).addTrainName("Sheshadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").addIpAddress(ipAddress).buildTrainObject();
		socket.close();		
		
		return Arrays.asList(train1, train2, train3);
	}

}
