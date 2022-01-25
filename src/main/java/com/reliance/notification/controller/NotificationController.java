package com.reliance.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reliance.notification.model.Notification;
import com.reliance.notification.service.NotificationService;

@RestController
@RequestMapping("/api")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@GetMapping("/notifications")
	public List<Notification> getNotifications() {
		List<Notification> notifications = notificationService.getNotifications();
		return notifications;
	}

	@GetMapping("/notifications/{id}")
	public Notification getNotification(@PathVariable("id") Integer id) {
		Notification notification = notificationService.getNotification(id);
		return notification;
	}

	@PostMapping("/notifications")
	public Notification postNotification(@RequestBody Notification notification) {
		return notificationService.createNotification(notification);
	}

	@PutMapping("/notifications/{id}")
	public Notification updateNotification(@PathVariable("id") Integer id, @RequestBody Notification notification) {
		return notificationService.updateNotification(id, notification);
	}

	@DeleteMapping("/notifications/{id}")
	public void deleteNotification(@PathVariable("id") Integer id) {
		notificationService.deleteNotification(id);
	}
}
