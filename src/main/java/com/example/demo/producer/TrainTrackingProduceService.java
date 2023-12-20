package com.example.demo.producer;
 
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.config.TrainProducerConfig;
import com.example.demo.entities.TrakingEntity;
 
@Service
//@RequiredArgsConstructor
public class TrainTrackingProduceService {
 
	
	private final KafkaTemplate<String, Object> kafkaTemplate;
	private static final String TOPIC_ANME = "17235";
	public TrainTrackingProduceService(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void process() throws Exception {
//		TrackingDispatched trackingDispatched = new TrackingDispatched();
//		trackingDispatched.setUuid(trackingEntity.getTrainId());
		TrakingEntity trackingEntity = new TrakingEntity();
		trackingEntity.setTrainName("Venkatadri Express");
		trackingEntity.setTrainNumber(17235);
		trackingEntity.setLocationName("At Guntur");
		trackingEntity.setLangitude("82828");
		trackingEntity.setLatitude("29213");		
//		
		kafkaTemplate.send(TOPIC_ANME, trackingEntity).get();
		
		System.out.println("Kafka template called...");
	}

}