package com.bitcamp.open.member.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bitcamp.open.member.model.Member;

public class SimpleRegistrationNotifier2 {

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(Member member) {

		MimeMessage message = mailSender.createMimeMessage();
		try {
			
			//제목 설정
			message.setSubject("회원가입 안내");
			
			//내용설정(HTML)
			String htmlMsg = "<strong>안녕하세요." 
					+ member.getMember_name() + "님 </strong>, 반갑습니다.";
			message.setText(htmlMsg, "utf-8","html");
			//보내는 메일 주소
			message.setFrom(new InternetAddress());
			//받는 메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(member.getMember_id()));
			
			mailSender.send(message);

			
		}catch(MessagingException e) {
			
			
			e.printStackTrace();
			
			
		}
	}
		
		public void sendMailAttach(Member member) {
			
			MimeMessage message = mailSender.createMimeMessage();
			
			
			try {
				//메일에 파일 첨부를 위해서 MimeMessageHelper 클래스 이용,
				//생성자 매개변수(메시지, 파일 첨부여부, 인코딩)
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
				//제목설정
				helper.setSubject("회원가입");
				
				// 내용설정
				String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다.";
				helper.setText(htmlContent, true);
				
				// 보내는 사람 설정
				helper.setFrom("bit@gmail.com", "비트");
				
				// 받는사람 설정
				helper.setTo(new InternetAddress(member.getMember_id(), member.getMember_name(), "UTF-8"));
				
				// 첨부파일 설정
				DataSource dataSource = new FileDataSource("d:\\1300.jpg");
				helper.addAttachment(MimeUtility.encodeText("다스.jpg", "UTF-8", "B"), dataSource);
				
				
				mailSender.send(message);
				
				
				
			} catch (MessagingException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	
}
