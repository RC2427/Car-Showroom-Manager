import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;





public class Send {
	private static String path;
	

	public static void sendMail(String recepient) throws Exception
	{
		System.out.print("Preparing to Send\n");
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String myAccountEmail="dchoudhary442000@gmail.com";
		String password="paviliong6";
		
		javax.mail.Session session= Session.getInstance(properties,new javax.mail.Authenticator()
				{
					@Override
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication(myAccountEmail,password);
					}
			
			
				});
		
		
		Message message=prepareMessage(session,myAccountEmail,recepient);
		Transport.send(message);
		
	System.out.print("Message Sent");
		
		
	}
		
		@SuppressWarnings("deprecation")
		private static Message prepareMessage(javax.mail.Session session,String myAccountEmail,String recepient)
		{
		try
		
		{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Service Reminder From Toyota Showroom!");
			StringWriter writer = new StringWriter();
			
			IOUtils.copy(new FileInputStream(new File(path)), writer);

			message.setContent(writer.toString(), "text/html");
			
			//message.setText("hey there\n");
			return message;
		}
				
		
		catch(Exception ex)
		{
			Logger.getLogger(Send.class.getName()).log(Level.SEVERE,null,ex);
			
			
		}
		
		return null;
		
		
	}
		
		
		
		
		public static void setpath(String path)
		{
			Send.path=path;
			
		}
	
	
	
	
	public static void main(String[] args) {
		try {
			Send.sendMail("dchoudhary442000@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.print("dwef");
		}

	}

}
