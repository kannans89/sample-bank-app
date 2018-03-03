package com.techlabs.services;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Service;

@Service
public class DateTime {

	private Date date;
	private Time time;

	public DateTime() {
		System.out.println("DateTime-constr");
	}

	public Date getDate() {
		date = new java.sql.Date(getTimeInMills());
		return date;
	}

	public Time getTime() {
		time = new Time(getTimeInMills());
		return time;
	}

	private long getTimeInMills() {
		return System.currentTimeMillis();
	}

}
