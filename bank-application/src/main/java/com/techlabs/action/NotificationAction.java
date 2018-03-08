package com.techlabs.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.techlabs.service.NotificationService;

public class NotificationAction 
{
	@Autowired
	private NotificationService notificationService;
	private String notifyTo;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNotifyTo() {
		return notifyTo;
	}

	public void setNotifyTo(String notifyTo) {
		this.notifyTo = notifyTo;
	}

	public NotificationAction() {
		System.out.println("Notification Action");
	}
	
	public void execute() throws IOException  {
		System.out.println("Execute notify action");
		
		if(notifyTo.equals("allUser")) {
			System.out.println("Send to all");
			notificationService.sendNotificationToAllUsers();
		}
		else {
			System.out.println("Send to some");
			notificationService.sendNotificationToSpecificUser(userId);
			
		}
	}
}
