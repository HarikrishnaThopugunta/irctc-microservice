package com.example.demo.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Train implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "trainName")
	private String trainName;
	
	@JsonProperty(value = "trainNumber")
	private Integer trainNumber;
	
	@JsonProperty(value = "source")
	private String source;
	
	@JsonProperty(value = "destination")
	private String destination;

	public Train() {

	}

	public Train(String trainName, Integer trainNumber, String source, String destination) {
		super();
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.source = source;
		this.destination = destination;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
