package kr.co.jhta.mai.control;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	JavaMailSender mailSender;

	@RequestMapping("/")
	public String hello() {
		return "home";
	}

	@GetMapping("/sendmail")
	public String mail() {

		return "mailForm";
	}

	@PostMapping("/sendmail")
	public String sendmail(@RequestParam("mailTo") String mailTo, @RequestParam("title") String title,
			@RequestParam("contents") String contents) throws AddressException, MessagingException {
		// vo가 있으면 model에트리뷰트로 갖고오면 됌

//		System.out.println(mailTo);
//		System.out.println(title);
//		System.out.println(contents);

		// 메일 보내는 사람
		String from = "rkdeoguq0@naver.com";

		// 메일 내용을 넣는 객체와 이를 도와주는 Helper 객체 생성
		MimeMessage mail = mailSender.createMimeMessage();
		MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");// 메일 한글처리

		// 메일 내용 채우기
		mailHelper.setFrom(from);// 보내는 사람
		mailHelper.setTo(mailTo);// 받는사람
		mailHelper.setSubject(title);// 제목

		// 인증코드 발송 법
//		String html = "<html><head></head><body>"+4321+"</body></html>";
//		mailHelper.setText(contents,true);

		mailHelper.setText(contents);// 내용, 이때 전달할 내용인 html문서인 경우 (태그포함문서, true)이렇게 씀

		mailSender.send(mail);

//		// 메일 발송 코드
//		// 메일 서버 관련정보
//		String host = "smtp.naver.comIMAP";
//		final String username = "rkdeoguq0";
//		final String password = "qlxkals4!";
//		int port = 587;
//		
//		Properties props = System.getProperties();
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", port);
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.ssl.enble", "true");
//		props.put("mail.smtp.ssl.trust", host);
//		
//		Session session = Session.getDefaultInstance(props, 
//				new javax.mail.Authenticator(){
//			String un = username;
//			String pw = password;
//			
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(un, pw);
//			}
//		});
//		
//		session.setDebug(true);
//		// import javax.mail.Message;
//		Message mimeMessage = new MimeMessage(session);
//		
//		//보내는 사람
//		mimeMessage.setFrom(new InternetAddress("rkdeoguq0@naver.com"));
//		
//		// 메세지 받을 사람
//		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
//		
//		// 메세지에 제목 지정
//		mimeMessage.setSubject(title);
//		
//		// 메세지 내용 지정
//		mimeMessage.setText(contents);
//		
//		// 메일 전송
//		Transport.send(mimeMessage);
		return "send";

	}

}
