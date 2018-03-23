package com.bitcamp.open.member.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bitcamp.open.member.model.Member;

public class SimpleRegistrationNotifier {
	
	@Autowired
	private MailSender mailSender;
	
	public void sendMail(Member member) {
		
		//보내는 정보를 SimpleMailMessage 객체에 담는다.

		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입안내]" + member.getMember_name() + "님 회원가입을 축하합니다");
		message.setFrom("sojiyoon7@gmail.com");
		message.setText("회원가입 성공");
		message.setTo(member.getMember_id());
		
		mailSender.send(message);
		
		
	}
	public void sendMail(String email) {
		
		//보내는 정보를 SimpleMailMessage 객체에 담는다.
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입안내]회원가입을 축하합니다.");
		message.setFrom("sojiyoon7@gmail.com");
		message.setText("회원가입 성공");
		message.setTo(email);
	
		mailSender.send(message);
	}
	
	public void sendMail(String email, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입안내]회원가입을 축하합니다.");
		message.setFrom("sojiyoon7@gmail.com");
		message.setText(msg);
		message.setTo(email);
		
		mailSender.send(message);
	}
	
}
