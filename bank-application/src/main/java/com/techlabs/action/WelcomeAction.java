package com.techlabs.action;

import com.opensymphony.xwork2.Action;

public class WelcomeAction implements Action
{
	@Override
	public String execute() throws Exception {
		System.out.println("Welcome Action Execute");
		return "success";
	}
}
