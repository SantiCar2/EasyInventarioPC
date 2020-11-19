import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class anadirFila extends JFrame {

	public static JPanel JPane;
	private JTextField textField;
	private JLabel lblColumna;
	private JTextField textField_1;
	private JLabel label;
	private JTextField textField_2;
	private JLabel label_1;
	private JTextField textField_3;
	private JLabel label_2;
	private JTextField textField_4;
	private JLabel label_3;
	private JTextField textField_5;
	private JLabel lblNewLabel_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anadirFila frame = new anadirFila();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public anadirFila() throws FontFormatException, IOException {
		setType(Type.UTILITY);
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\santi\\eclipse-workspace\\Proyecto 2\\font.ttf"));
		font = font.deriveFont(Font.PLAIN, 15);
		Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\santi\\eclipse-workspace\\Proyecto 2\\font.ttf"));
		font2 = font2.deriveFont(Font.PLAIN, 25);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		ge.registerFont(font2);
		
		String[] columnNames = getTableInfo.getColumnNames(login.buf, false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 234);
		JPane = new JPanel();
		JPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPane);
		JPane.setLayout(null);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(424, 161, 105, 23);
		JPane.add(btnNewButton_1);
		btnNewButton_1.setFont(font);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir fila");
		lblNewLabel.setBounds(10, 11, 145, 31);
		JPane.add(lblNewLabel);
		lblNewLabel.setFont(font2);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(10, 53, 46, 14);
		JPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(font);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 78, 54, 20);
		JPane.add(textField);
		textField.setColumns(10);
		
		lblColumna = new JLabel("N/A");
		lblColumna.setFont(new Font("Brutal Type", Font.PLAIN, 15));
		lblColumna.setBounds(171, 53, 86, 14);
		JPane.add(lblColumna);
		lblColumna.setFont(font);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(171, 78, 86, 20);
		JPane.add(textField_1);
		
		label = new JLabel("N/A");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(267, 53, 86, 14);
		JPane.add(label);
		label.setFont(font);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(267, 78, 86, 20);
		JPane.add(textField_2);
		
		label_1 = new JLabel("N/A");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(363, 53, 86, 14);
		JPane.add(label_1);
		label_1.setFont(font);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(363, 78, 86, 20);
		JPane.add(textField_3);
		
		label_2 = new JLabel("N/A");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(459, 53, 86, 14);
		JPane.add(label_2);
		label_2.setFont(font);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(459, 78, 86, 20);
		JPane.add(textField_4);
		
		label_3 = new JLabel("N/A");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_3.setBounds(555, 53, 86, 14);
		JPane.add(label_3);
		label_3.setFont(font);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(555, 78, 86, 20);
		JPane.add(textField_5);
		
		lblNewLabel_2 = new JLabel("Tipo de columnas:");
		lblNewLabel_2.setBounds(10, 129, 133, 14);
		JPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(font);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(171, 127, 86, 20);
		JPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(267, 127, 86, 20);
		JPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(363, 127, 86, 20);
		JPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(459, 127, 86, 20);
		JPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(555, 127, 86, 20);
		JPane.add(textField_10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] newInfo = new String[getTableInfo.columnCount(login.buf)];
				String[] columnNamesWId = new String[getTableInfo.getColumnNames(login.buf, false).length + 1];
				for (int i = 0; i < columnNamesWId.length; i++) {
					if(i == 0) {
						columnNamesWId[0] = "id";
					} else {
						columnNamesWId[i] = getTableInfo.getColumnNames(login.buf, false)[i - 1];
					}
				}
				for (int i = 0; i < columnNames.length; i++) {
					if(i == 0) {
						newInfo[i] = textField.getText();
					} if(i == 1) {
						newInfo[i] = textField_1.getText();
					} if(i == 2) {
						newInfo[i] = textField_2.getText();
					} if(i == 3) {
						newInfo[i] = textField_3.getText();
					} if(i == 4) {
						newInfo[i] = textField_4.getText();
					} if(i == 5) {
						newInfo[i] = textField_5.getText();
					}
				}
				if(updateTable.addTable(login.buf, columnNamesWId, newInfo)) {
					//todo bien
				} else {
					//algo malo pasó
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
				}
			}
		});
		btnNewButton.setBounds(539, 161, 105, 23);
		JPane.add(btnNewButton);
		btnNewButton.setFont(font);
		
		boolean x = true;
		if(x) {
			textField.setText(Integer.toString(getTableInfo.generateId(login.buf)));
			for(int i = 0; i < columnNames.length; i++) {
				if(i == 0) {
					textField_1.setEditable(true);
					lblColumna.setText(columnNames[i]);
					if(getTableInfo.getColumnType(login.buf, columnNames[i]) == 4) {
						textField_6.setText("Int");
					} else {
						textField_6.setText("String");
					}
				} if(i == 1) {
					textField_2.setEditable(true);
					label.setText(columnNames[i]);
					if(getTableInfo.getColumnType(login.buf, columnNames[i]) == 4) {
						textField_7.setText("Int");
					} else {
						textField_7.setText("String");
					}
				} if(i == 2) {
					textField_3.setEditable(true);
					label_1.setText(columnNames[i]);
					if(getTableInfo.getColumnType(login.buf, columnNames[i]) == 4) {
						textField_8.setText("Int");
					} else {
						textField_8.setText("String");
					}
				} if(i == 3) {
					textField_4.setEditable(true);
					label_2.setText(columnNames[i]);
					if(getTableInfo.getColumnType(login.buf, columnNames[i]) == 4) {
						textField_9.setText("Int");
					} else {
						textField_9.setText("String");
					}
				} if(i == 4) {
					textField_5.setEditable(true);
					label_3.setText(columnNames[i]);
					if(getTableInfo.getColumnType(login.buf, columnNames[i]) == 4) {
						textField_10.setText("Int");
					} else {
						textField_10.setText("String");
					}
				}
			}
			x = !x;
		}
	}
}
