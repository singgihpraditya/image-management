package com.singgih.image.management.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.singgih.image.management.db.MediaRepository;
import com.singgih.image.management.entity.Media;
import com.singgih.image.management.util.Constants;
import com.singgih.image.management.util.Util;

@Component
public class MoveFileListener {
	private final String SERVICE_NAME = "MOVE_FILE";
	Logger logger = LoggerFactory.getLogger(MoveFileListener.class);

	@Autowired
	private MediaRepository mediaRepository;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = Constants.MOVE_FILE_TOPIC, groupId = Constants.GROUP_ID)
	public void listen(String message) {
		String hashCode = Util.getHashCode(SERVICE_NAME);
		logger.debug(hashCode + "Received Message : " + message);

		Media media = new Gson().fromJson(message, Media.class);
		mediaRepository.save(hashCode, media);

		logger.info(hashCode + "Send to gdrive topic");
		kafkaTemplate.send(Constants.UPLOAD_TO_GDRIVE_TOPIC, message);
	}

}
