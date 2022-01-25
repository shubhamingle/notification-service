package com.reliance.notification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.reliance.notification.model.Notification;
import com.reliance.notification.repository.NotificationRepository;

@Service
public class KafkaConsumer {
	@Autowired
	private NotificationRepository notificationRepository;

	@KafkaListener(topics = "NOTIFICATION_TOPIC", groupId = "group_id")
	public void processMessage(String message) {
		System.out.println(message);
		Notification notification = new Notification();
		notification.setMessage(message);
		notificationRepository.save(notification);
	}

}
