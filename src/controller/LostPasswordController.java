package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import service.AccountService;
import service.impl.AccountServiceImpl;
import utils.GeneratePassword;

@WebServlet("/forgot-password")
public class LostPasswordController extends HttpServlet {
	AccountService service = new AccountServiceImpl();
	
	private String HOST_NAME = "smtp.gmail.com";
	private int SSL_PORT = 465;
	private int TSL_PORT = 587;
	private String APP_EMAIL = "bboyroz1201@gmail.com";
	private String APP_PASSWORD = "nguyenthanhnhat";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/client/forgot-password.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		Account account = service.get(uname);
		if(account == null) {
			req.setAttribute("error", "Không tồn tại username này");
			doGet(req, resp);
			return;
		}
		
		String email = account.getEmail();
		
        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", HOST_NAME);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", TSL_PORT);
 
        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
            }
        });
 
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("NLU Electron");
            String pwd = GeneratePassword.generatePassword();
            boolean result = service.edit(new Account(account.getUserId(), account.getUsername(), pwd, account.getFirstName(), account.getLastName(), account.getAddress(), account.getEmail(), account.getPhone(), account.getCreatedDate(), account.getCreatedBy(), account.isStatus()));
            message.setText("New password: "+ pwd);

            // send message
            Transport.send(message);
             
            resp.sendRedirect("/login");
        } catch (MessagingException e) {
        	req.setAttribute("error", "Không tìm được gmail này");
        	req.getRequestDispatcher("/forgot-password").forward(req, resp);
        }	    
	}
}
