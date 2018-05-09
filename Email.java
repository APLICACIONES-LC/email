/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.net.InetAddress;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author hp
 */
public class Email {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

		final String username = "hola21@aplicacioneslc.xyz";//email id 1st
		final String password = "prueba";       //passwd

//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "mx1.hostinger.mx");
//		props.put("mail.smtp.port", "587");
//props.put("mail.smtp.auth","true");
//props.put("mail.smtp.user",username);
//		Session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//                        @Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(username));            ///email id
//			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("icruz.ecc@gmail.com"));//emailid
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler,"
//				+ "\n\n No spam to my email, please!");
//
//			Transport.send(message);
//
//			System.out.println("Done");
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}

   //////////////////////////////////////////////////////////////////////////////////
   try{

String host="mx1.hostinger.mx";

Properties prop=System.getProperties();

prop.put("mail.smtp.starttls.enable","true");
prop.put("mail.smtp.host",host);
prop.put("mail.smtp.user",username);
prop.put("mail.smtp.password",password);
prop.put("mail.smtp.port",587);
prop.put("mail.smtp.auth","true");

Session session=Session.getDefaultInstance(prop,null);
MimeMessage message= new MimeMessage(session);

message.setFrom(new InternetAddress(username));

message.setRecipient(Message.RecipientType.TO, new InternetAddress("appapocut-5814@yopmail.com"));
message.setSubject("tas chavo");
message.setText("espero esto haya llegado");



Transport transport=session.getTransport("smtp");
transport.connect(host,username,password);

transport.sendMessage(message, message.getAllRecipients());
transport.close();

System.out.print("creen q se encvio");

}catch (Exception e){
e.printStackTrace();

}
   
   }

}


