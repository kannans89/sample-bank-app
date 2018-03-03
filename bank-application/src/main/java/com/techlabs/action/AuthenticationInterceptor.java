package com.techlabs.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.techlabs.entity.Account;

public class AuthenticationInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception  {
		session=invocation.getInvocationContext().getSession();
		System.out.println("AuthenticationInterceptor");
		Account status = (Account) session.get("user");
		if(status==null){
			System.out.println("not login");
			
			return "input";
		}
	return invocation.invoke();
	}

}
