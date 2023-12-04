package com.example.demo.controllers;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.builders.TrainBuilder;
import com.example.demo.entities.Train;

@RestController()
public class TrainController {

	@GetMapping("/irctc-microservice")
	public String healthCheck() {
		return "{healthy:true}";
	}

	@GetMapping("/irctc-microservice/get-train-list")
	public List<Train> getTrainsList() throws SocketException, UnknownHostException {
		String ipAddress = new String();
		final DatagramSocket socket = new DatagramSocket();
		socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		ipAddress = socket.getLocalAddress().getHostAddress();

		Train train1 = new TrainBuilder().addTrainNumber(101).addTrainName("Narayanadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").addIpAddress(ipAddress).buildTrainObject();
		Train train2 = new TrainBuilder().addTrainNumber(102).addTrainName("Venkatadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").addIpAddress(ipAddress).buildTrainObject();
		Train train3 = new TrainBuilder().addTrainNumber(103).addTrainName("Sheshadri Express").addSource("Hyderabad")
				.addDestination("Tirupati").addIpAddress(ipAddress).buildTrainObject();
		socket.close();		
		
		return Arrays.asList(train1, train2, train3);
	}

}
