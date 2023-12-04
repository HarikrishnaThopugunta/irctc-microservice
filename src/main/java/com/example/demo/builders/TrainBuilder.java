package com.example.demo.builders;

import com.example.demo.entities.Train;

public class TrainBuilder {

	private Train train;
	
	public TrainBuilder() {
		this.train = new Train();
	}

	public TrainBuilder addTrainName(String trainName) {
		train.setTrainName(trainName);
		return this;
	}

	public TrainBuilder addTrainNumber(Integer trainNumber) {
		train.setTrainNumber(trainNumber);
		return this;
	}

	public TrainBuilder addSource(String source) {
		train.setSource(source);
		return this;
	}

	public TrainBuilder addDestination(String destination) {
		train.setDestination(destination);
		return this;
	}
	
	public TrainBuilder addIpAddress(String ipAddress) {
		train.setIpAddress(ipAddress);
		return this;
	}
	
	public Train buildTrainObject() {
		return train;
	}

}
