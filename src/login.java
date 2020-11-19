import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Toolkit;


public class login {

	public JFrame frmInicioDeSesin;
	private JTextField txtCorreo;
	private JPasswordField passwordField;
	public static boolean auth = false;
	public static String buf = "1234";
	public static boolean registrando = false;
	registro reg = new registro();
	boolean y = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmInicioDeSesin.setVisible(true);
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
	public login() throws FontFormatException, IOException {
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
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		
		
	
		
		frmInicioDeSesin = new JFrame();
		frmInicioDeSesin.setAutoRequestFocus(false);
		frmInicioDeSesin.setResizable(false);
		frmInicioDeSesin.setIconImage(Toolkit.getDefaultToolkit().getImage("Asset 1.png"));
		frmInicioDeSesin.getContentPane().setBackground(Color.WHITE);
		frmInicioDeSesin.setBackground(Color.WHITE);
		frmInicioDeSesin.setTitle("Inicio de sesi\u00F3n");
		frmInicioDeSesin.setBounds(100, 100, 666, 142);
		frmInicioDeSesin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicioDeSesin.getContentPane().setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(font);
		txtCorreo.setToolTipText("Usuario");
		txtCorreo.setBounds(10, 30, 350, 23);
		frmInicioDeSesin.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 77, 350, 23);
		frmInicioDeSesin.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCorreo.getText() != null && passwordField.getText() != null) {
					buf = authenticator.connect(txtCorreo.getText(), AES.encrypt(passwordField.getText(), AES.keyString));
					if(buf != null && !buf.contains("E")) {
						JOptionPane.showMessageDialog(null, "Se ha conectado exitosamente al servidor!" ,"Info", 1);
						auth = true;
					}else if (buf != null) {
						buf = buf.split(":", 2)[1];
						JOptionPane.showMessageDialog(null, buf ,"Error", 0);
					}else{
						JOptionPane.showMessageDialog(null, "Credenciales incorrectas" ,"Error", 0);
						passwordField.setText("");
					}
				}
			}
		});
		btnNewButton.setBounds(513, 77, 135, 23);
		frmInicioDeSesin.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Correo electronico:");
		lblNewLabel_1.setFont(font);
		lblNewLabel_1.setBounds(10, 11, 183, 14);
		frmInicioDeSesin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setFont(font);
		lblNewLabel_2.setBounds(10, 61, 89, 14);
		frmInicioDeSesin.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Registro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrando = true;
				if(registrando) {
					registrando = false;
					registro.frmRegistro.setVisible(true);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(372, 77, 135, 23);
		frmInicioDeSesin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Olvid\u00E9 mi contrase\u00F1a");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
					openWebpage(new URI("https://forms.gle/WVV6i6ctkzmMT2Pa7"));
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}*/
				forgotpass.main();
			}
		});
		btnNewButton_2.setBounds(372, 30, 225, 23);
		frmInicioDeSesin.getContentPane().add(btnNewButton_2);
		
		
		btnNewButton.setFont(font);
		btnNewButton_1.setFont(font);
		btnNewButton_2.setFont(font);
		
		JButton btnNewButton_3 = new JButton("?");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				try {
					desktop.browse(new URI("https://docs.google.com/forms/d/e/1FAIpQLSdIjptRSYaU76ruNC926fvyjgbFhEMy0kQjpqEn6rx68um0Lw/viewform"));
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_3.setBounds(603, 30, 45, 23);
		frmInicioDeSesin.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setFont(font);
		
	}
	
	public static boolean openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}
}
