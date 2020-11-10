package com.singgih.image.management.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.singgih.image.management.util.Constants;
import com.singgih.image.management.util.Util;

@Component
public class UploadToGDriveListener {
	private final String SERVICE_NAME = "UPLOAD_TO_GDRIVE";
	Logger logger = LoggerFactory.getLogger(UploadToGDriveListener.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = Constants.UPLOAD_TO_GDRIVE_TOPIC, groupId = Constants.GROUP_ID)
	public void listen(String message) {
		String hashCode = Util.getHashCode(SERVICE_NAME);
		logger.debug(hashCode + "Received Message : " + message);
	}

}
