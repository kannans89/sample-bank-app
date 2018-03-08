package com.techlabs.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techlabs.dao.AccountDao;

@Service("homeService")
public class HomeService 
{
	@Autowired
	private AccountDao dao;
	
	public HomeService() {
		System.out.println("Home Service Constructor");
	}
	@Transactional
	public String getBase64EncodedImage() {
		System.out.println("getBase64EncodedImage called**********");
		String base64EncodedImage="";
		byte[] byteImage=dao.getAccount().getProfileImage();
		byte[] encodedBase64 = Base64.getEncoder().encode(byteImage);
		try {base64EncodedImage=new String(encodedBase64,"UTF-8");}
		catch (UnsupportedEncodingException e) {e.printStackTrace();}
		return base64EncodedImage;
	}
}
