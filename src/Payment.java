import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment {

	public static JFrame frame;
	public static boolean pagando = false;
	public static boolean pagado = false;
	private JTextField textField;
	private JTextField textField_1;
	private String error = "Account restricted (Err:2537)";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Payment() throws FontFormatException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	private void initialize() throws FontFormatException, IOException {
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf"));
		font = font.deriveFont(Font.PLAIN, 15);
		Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf"));
		font2 = font2.deriveFont(Font.PLAIN, 25);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		ge.registerFont(font2);
		
		pagando = true;
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 486, 226);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pago");
		lblNewLabel.setBounds(10, 11, 184, 27);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(font2);
		
		textField = new JTextField();
		textField.setBounds(10, 90, 222, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de tarjeta de cr\u00E9dito:");
		lblNewLabel_1.setBounds(10, 65, 209, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(font);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(10, 150, 47, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Vencimiento:");
		lblNewLabel_2.setBounds(10, 125, 116, 14);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(font);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2021", "2022", "2023", "2024", "2025", "2026", "2027"}));
		comboBox_1.setBounds(67, 150, 59, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("CVV:");
		lblNewLabel_3.setBounds(173, 125, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(font);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 150, 59, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable.changePayment(login.buf);
				
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
		        try {
			         MimeMessage message = new MimeMessage(session);
			         message.setFrom(new InternetAddress(from));
			         System.out.println(getTableInfo.getMail(login.buf));
			         message.addRecipient(Message.RecipientType.TO, new InternetAddress(getTableInfo.getMail(login.buf)));
			         message.setSubject("FACTURA");
			         message.setText("FACTURA");

			         Transport.send(message);
			         System.out.println("Sent message successfully....");
			      } catch (MessagingException mex) {
			         mex.printStackTrace();
			      }
		        
		        frame.dispose();
		        
			}
		});
		btnNewButton.setBounds(371, 149, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setFont(font);
		
		JLabel lblNewLabel_4 = new JLabel("Detalles:");
		lblNewLabel_4.setBounds(257, 6, 137, 36);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setFont(font2);
		
		JLabel lblNewLabel_5 = new JLabel("Licencia     $12.99 USD");
		lblNewLabel_5.setBounds(257, 59, 167, 27);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setFont(font);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(246, 14, 1, 162);
		frame.getContentPane().add(separator);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setFont(null);
		btnCancelar.setBounds(257, 149, 104, 23);
		frame.getContentPane().add(btnCancelar);
		btnCancelar.setFont(font);
	}
}
