package com.esther.code.modules.service;


import com.esther.code.common.framework.global.PropertiesConstant;
import com.esther.code.common.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
 
	public void send(String toEmail) {
		String str = String.valueOf(Math.round(Math.random() * 1000000));
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(toEmail);
		mail.setFrom(PropertiesUtil.getProperty(PropertiesConstant.MAIL_USERNAME));
		mail.setSubject("价值连城项目验证邮件");
		mail.setText("尊敬的用户：您好，感谢您使用价值连城项目，您的验证码为" + str + "。");
		mailSender.send(mail);
	}
}
