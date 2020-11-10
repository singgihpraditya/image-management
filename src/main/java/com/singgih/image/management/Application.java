package com.singgih.image.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import com.singgih.image.management.util.Constants;
import com.singgih.image.management.util.RecursiveService;
import com.singgih.image.management.util.Util;

@SpringBootApplication
public class Application implements ApplicationRunner {
	Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private RecursiveService recursiveService;

	public void sendMessage(String msg) {
		kafkaTemplate.send(Constants.INSERT_TO_DB_TOPIC, msg);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		logger.info("Send message");
//		Media media = new Media();
//		String message = new Gson().toJson(media);
//		sendMessage(message);
		String hashCode = Util.getHashCode();
		recursiveService.walk(hashCode, "E:/naira");
	}
}