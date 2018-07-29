package com.mailchimp.automation.util;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	/*
	 * this method will take email detail from settings file and will send mail
	 * testng.setOutputDirectory(
	 * AppConstant.TESTNG_REPORT_DIR+setting.getBrowser()+"TestReport/"+setting.getYear()+"/"+setting.getMonth()+"/"+setting.getReportTime()
	 * ); 
	 * //yyyy-MM-dd-hh-mm-ss
	 */
	public static void sendmail() {

		final String userID = PropertySettings.getInstance().getMailFrom(); // Sender User ID
		final String userPass = PropertySettings.getInstance().getMailPassword(); // Sender Password
		final String emailTo = PropertySettings.getInstance().getMailTo();
		final String errorLogFile = AppConstant.ERROR_LOG_PATH;

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.host", "smtp.mail.yahoo.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userID, userPass);
					}
				});
		try {

			Message message = new MimeMessage(session);
			//message.setHeader("Content-Type", "text/html");

			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(emailTo));
			message.setSubject("Connectik(Secure) QA automation report");
			message.setText("Please do not reply,"
					+ "\n\n System generated email.");
			
			Multipart multipart = new MimeMultipart();
			DataSource source = null;
			Map<Integer, String> browsers = PropertySettings.getInstance().getBrowserList();
			
			
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			
			messageBodyPart1.setText("\nDear All,\nMailchimp system(Secure) is not working properly.\n\nThank You,\nQA Automation\n24/7 services");
			multipart.addBodyPart(messageBodyPart1);
			for (int i = 0;i<browsers.size(); i++) {
				if (!browsers.get(i).equals("")) {
					MimeBodyPart messageBodyPart = new MimeBodyPart();
				    messageBodyPart.setHeader("Content-Type", "text/html");
					//source = new FileDataSource(AppConstant.TEST_LOG_PATH+browsers.get(i)+".log");
					source = new FileDataSource(AppConstant.TESTNG_REPORT_DIR+browsers.get(i)+"TestReport/"+PropertySettings.getInstance().getYear()+"/"+PropertySettings.getInstance().getMonth()+"/"+PropertySettings.getInstance().getReportTime()+"/qa-automation-report_SECURE.html");
					messageBodyPart.setDataHandler(new DataHandler(source));
					//messageBodyPart.setFileName(AppConstant.TEST_LOG_PATH+browsers.get(i)+".log");
					//messageBodyPart.setFileName(AppConstant.TESTNG_REPORT_DIR+browsers.get(i)+"TestReport/"+setting.getYear()+"/"+setting.getMonth()+"/"+setting.getReportTime()+"/emailable-report.html");
					
					
					messageBodyPart.setFileName("qa-automation-report_SECURE.html");
					multipart.addBodyPart(messageBodyPart);
				}
			}
			message.setContent(multipart);
			Transport.send(message);
			
			System.out.println("Email successfully sent to: " + emailTo);

		} catch (MessagingException e) {
			String errorLogMsg = "Error reported on: " + new Date()
					+ "\n----------------------------------";
			errorLogMsg += "\nError message: " + e.getMessage() + "\n\n";

			CreateLogger.enterLogData(errorLogFile, errorLogMsg);
			System.out.println("Attachment not sent...!!!\n\nPlease check the '"
							+ errorLogFile + "' for details.");
		}
	}
}
