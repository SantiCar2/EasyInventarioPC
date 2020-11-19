import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class forgotpass {
	
	final static String CONN = "jdbc:mysql://190.249.57.11:25565/login";
	
	public static void main() {
		String from = "easyinventario@gmail.com";
		String password = "Proyecto2";
		Properties props = new Properties();  
		String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        Random rand = new Random();
 		String verif = String.format("%04d", rand.nextInt(1000000));
		
		String mail = JOptionPane.showInputDialog(null, "Introduzca Su correo electronico registrado en el sistema ", "Recuperación de contraseña", JOptionPane.QUESTION_MESSAGE);
		if(!registroBack.checkmail(mail)) {
			JOptionPane.showMessageDialog(null, "El correo electronico ingresado\n no está registrado.", "Error", 0);
		} else {
			try {
		         MimeMessage message = new MimeMessage(session);
		         message.setFrom(new InternetAddress(from));
		         message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
		         message.setSubject("Codigo de verificación para el cambio de contraseña de cuanta de EasyInventario");
		         message.setText("Su código de verificación es " + verif);

		         Transport.send(message);
		         System.out.println("Sent message successfully....");
		      } catch (MessagingException mex) {
		         mex.printStackTrace();
		      }
			String code = JOptionPane.showInputDialog(null, "Introduzca el código que se envió al correo " + mail, "Verificación", JOptionPane.QUESTION_MESSAGE);
			if(code.compareTo(verif) == 0) {
				JPanel panel = new JPanel();
				JLabel label = new JLabel("Introduzca su nueva contraseña:");
				JPasswordField pass = new JPasswordField(10);
				panel.add(label);
				panel.add(pass);
				String[] options = new String[]{"OK", "Cancel"};
				int option = JOptionPane.showOptionDialog(null, panel, "Restrablecimiento de contraseña",
				                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				                         null, options, options[1]);
				while(option != 0) {}
				if(option == 0) {
					String newpass = pass.getText();
					try {
						Connection CON = DriverManager.getConnection(CONN, "auth", "4815162342");
						Statement stmt = CON.createStatement();
						ResultSet rs = stmt.executeQuery("select * from `main` where email = \"" + mail + "\"");
						rs.next();
						int userid = rs.getInt("id");
						System.out.println(userid);
						stmt.executeUpdate("UPDATE `login`.`main` SET `password` = '" + AES.encrypt(newpass, AES.keyString) + "' WHERE (`id` = '10');");
						CON.close();
						JOptionPane.showMessageDialog(null, "Se ha realizado el cambio de contraseña exitosamente" ,"Info", 1);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
	         } else {
	        	 JOptionPane.showMessageDialog(null, "El código de verificación es incorrecto\n Intentelo nuevamente", "Error de verificación", 0);
	         }
		}
	}
}
