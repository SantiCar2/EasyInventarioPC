import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Payment {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public static boolean pagando = true;
	public static boolean pagado = false;

	/**
	 * Launch the application.
	 */
	public static void main() {
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
	public void initialize() throws FontFormatException, IOException {
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf"));
		font = font.deriveFont(Font.PLAIN, 15);
		Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf"));
		font2 = font2.deriveFont(Font.PLAIN, 25);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		ge.registerFont(font2);
		
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 491, 202);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(frame.getContentPane());
		
		JLabel lblNewLabel = new JLabel("Pagos");
		lblNewLabel.setBounds(10, 11, 211, 28);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(font2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 75, 211, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(10, 127, 58, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));
		comboBox_1.setBounds(78, 127, 86, 20);
		frame.getContentPane().add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(174, 127, 47, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de tarjeta");
		lblNewLabel_1.setBounds(10, 50, 150, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(font);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento");
		lblFechaDeVencimiento.setBounds(10, 106, 164, 14);
		frame.getContentPane().add(lblFechaDeVencimiento);
		lblFechaDeVencimiento.setFont(font);
		
		JLabel lblCcv = new JLabel("CVV:");
		lblCcv.setBounds(174, 106, 80, 14);
		frame.getContentPane().add(lblCcv);
		lblCcv.setFont(font);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				pagando = false;
			}
		});
		btnNewButton.setBounds(266, 125, 100, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setFont(font);
		
		JButton button = new JButton("Pagar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable.changePayment(login.buf);
				frame.dispose();
				pagado = true;
				pagando = true;
			}
		});
		button.setBounds(376, 126, 89, 23);
		frame.getContentPane().add(button);
		button.setFont(font);
	}
}
