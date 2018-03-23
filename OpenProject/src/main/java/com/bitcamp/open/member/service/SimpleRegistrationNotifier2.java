package com.bitcamp.open.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bitcamp.open.member.model.Member;

public class SimpleRegistrationNotifier2 {

	@Autowired
	private MailSender mailSender;

	public void sendMail(Member member) {

		// 보내는 정보를 SimpleMailMessage 객체에 담는다.
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입안내] " + member.getMember_name() + "님 회원가입을 축하합니다.");
		message.setFrom("sojiyoon7@gmail.com");
		message.setText("회원가입 성공");
		message.setTo(member.getMember_id());

		mailSender.send(message);

	}

	public void sednMail(String email, String msg) {

		// 보내는 정보를 SimpleMailMessage 객체에 담는다.
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입안내] 회원가입을 축하합니다.");
		message.setFrom("sojiyoon7@gmail.com");
		message.setText("회원가입 성공");
		message.setText(msg);
		message.setTo(email);

		mailSender.send(message);

	}

		public void sendMailAttach(Member memeber) {
			
			MimeMessage message = mailSender.createMimeMessage();
			
			try {
				//메일에 파일 첨부를 위해서 MimeMessageHelper 클래스 이용,
				//생성자 매개변수(메시지, 파일 첨부여부, 인코딩)
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			
			//제목설정
			helper.setSubject("회원가입");
			
			//내용설정
			String htmlContent = "<strong>안녕하세요</strong>, 반값습니다";
			helper.setText(htmlContent, true);
			
			//보내는 사람 설정
			helper.setFrom("sojiyoon7@gmail.com", "메일");
			
			
			//받는사람 설정
			helper.setTo(new InternetAddress(member.getMember_id(), member.getMember_name(), "UTF-8"));
			
			
			//첨부파일 설정
			DataSource dataSource = new FileDataSource("d:\\첫 번째 결과.png");
			helper.addAttachment(MimeUtility.encodeText("다스.png","UTF-8","B"), dataSource);
			
			
			
			mailSender.send(message);
			
		
			
			
			}catch(MessagingException e){
				e.printStackTrace();
			}
		}

	}

