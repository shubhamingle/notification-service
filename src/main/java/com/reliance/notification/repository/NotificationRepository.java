package com.reliance.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reliance.notification.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
