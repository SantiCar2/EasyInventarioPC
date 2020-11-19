import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.util.StringUtils;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class EditTableWindow {

	public static JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblNewLabel_3 = new JLabel("");
	boolean validated = false;
	JButton btnNewButton_2 = new JButton("Guardar cambios");
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTableWindow window = new EditTableWindow();
					EditTableWindow.frame.setVisible(true);
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
	public EditTableWindow() throws FontFormatException, IOException {
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
		
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 897, 469);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 234, 328);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JComboBox<Object> comboBox = new JComboBox<Object>(getTableInfo.getColumnNames(login.buf, false));
		comboBox.setBounds(10, 60, 89, 25);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cambiado");
				String[] columns = {"ID", comboBox.getSelectedItem().toString()};
				DefaultTableModel tableModel = new DefaultTableModel(getTableInfo.getTableInforID(login.buf, comboBox.getSelectedItem().toString()), columns);
				table.setModel(tableModel);
			}
		});
		comboBox.setFont(font);
		String[] columns = {"ID", comboBox.getSelectedItem().toString()};
		DefaultTableModel tableModel = new DefaultTableModel(getTableInfo.getTableInforID(login.buf, comboBox.getSelectedItem().toString()), columns);
		table.setModel(tableModel);
		
		JLabel lblNewLabel = new JLabel("Edici\u00F3n de tablas");
		lblNewLabel.setBounds(10, 11, 209, 42);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(font2);
		
		JButton btnNewButton = new JButton("?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "La tabla que se encuentra a la izquierda de la ventana\n"
						+ "sirve para poder conocer el ID de la fila que desee editar\n"
						+ "ese ID lo necesitarás para poder realizar la edición de la información.","Info", 1);
			}
		});
		btnNewButton.setBounds(201, 60, 43, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setFont(font);
		
		textField = new JTextField();
		textField.setDisabledTextColor(Color.WHITE);
		textField.setBounds(323, 95, 71, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				validated = false;
	        	lblNewLabel_3.setIcon(new ImageIcon(EditTableWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
	        	textField_1.setText("");
	        	textField_2.setText("");
	        	textField_3.setText("");
	        	textField_2.setEditable(false);
	        	btnNewButton_2.setEnabled(false);
			}
		});
		/*textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_DELETE) {
	            	textField.setEditable(true);
	            	validated = false;
	            	lblNewLabel_3.setIcon(new ImageIcon(EditTableWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
	            	btnNewButton_2.setEnabled(false);
	            	textField_1.setText("");
	            	textField_2.setEditable(false);
	            	textField_2.setText("");
	            	
	            } else {
	            	textField.setEditable(false);
	            }
			}
		});*/
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(323, 60, 25, 21);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(font);
		
		JComboBox<?> comboBox_1 = new JComboBox<Object>(getTableInfo.getColumnNames(login.buf, false));
		comboBox_1.setBounds(537, 93, 128, 25);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.setFont(font);
		comboBox_1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cambiado 1");
				if(textField.getText().length() != 0 && validated) {
					String oldInfo = getTableInfo.getOldInfo(login.buf, comboBox_1.getSelectedItem().toString(), Integer.parseInt(textField.getText()));
					textField_1.setText(oldInfo);
					System.out.println(getTableInfo.getColumnType(login.buf, comboBox_1.getSelectedItem().toString()));
					if(getTableInfo.getColumnType(login.buf, comboBox_1.getSelectedItem().toString()) == 4) {
						textField_3.setText("Int");
					} else {
						textField_3.setText("String");
					}
				}
				
			}
		});
		
		JLabel lblColumnaAEditar = new JLabel("Columna a editar:");
		lblColumnaAEditar.setFont(new Font("Brutal Type", Font.PLAIN, 15));
		lblColumnaAEditar.setBounds(537, 60, 128, 21);
		frame.getContentPane().add(lblColumnaAEditar);
		lblColumnaAEditar.setFont(font);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(323, 242, 148, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setFont(font);
		
		JLabel lblNewLabel_2 = new JLabel("Informaci\u00F3n anterior:");
		lblNewLabel_2.setBounds(323, 206, 148, 25);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(font);
		
		
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(EditTableWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		lblNewLabel_3.setBounds(344, 56, 43, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Validar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() != 0) {
					boolean x = false;
					try {
						Integer.parseInt(textField.getText());
						x = true;
					} catch (Exception e2) {
						x = false;
					}
					if(x) {
						if(getTableInfo.isID(login.buf, Integer.parseInt(textField.getText()))) {
							lblNewLabel_3.setIcon(getImageIcon(new File("check.png")));
							btnNewButton_2.setEnabled(true);
							validated = true;
							String oldInfo = getTableInfo.getOldInfo(login.buf, comboBox_1.getSelectedItem().toString(), Integer.parseInt(textField.getText()));
							textField_2.setEditable(true);
							textField_1.setText(oldInfo);
							System.out.println(getTableInfo.getColumnType(login.buf, comboBox_1.getSelectedItem().toString()));
							if(getTableInfo.getColumnType(login.buf, comboBox_1.getSelectedItem().toString()) == 4) {
								textField_3.setText("Int");
							} else {
								textField_3.setText("String");
							}
						} else {
							validated = false;
							lblNewLabel_3.setIcon(new ImageIcon(EditTableWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
							JOptionPane.showMessageDialog(null, "El ID no existe." ,"Error", 0);
							textField.setEditable(true);
							textField.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "El ID debe ser un número." ,"Error", 0);
						textField.setText("");
					}
				} else {
					validated = false;
					lblNewLabel_3.setIcon(new ImageIcon(EditTableWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
					JOptionPane.showMessageDialog(null, "Introduzca un ID." ,"Error", 0);
					textField.setEditable(true);
				}
			}
		});
		btnNewButton_1.setBounds(323, 131, 96, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setFont(font);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Para guardar cambios debes llenar los campos obligatorios." ,"Error", 0);
				} else if(JOptionPane.showConfirmDialog(null, "¿Seguro que deseas continuar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					if(getTableInfo.getColumnType(login.buf, comboBox_1.getSelectedItem().toString()) == 4) {
						int number;
						try {
							number = Integer.parseInt(textField_2.getText());
							System.out.println(number);
							//INT
							updateTable.editTable(login.buf, comboBox_1.getSelectedItem().toString(), textField_2.getText(), Integer.parseInt(textField.getText()));
							frame.setVisible(false);
							frame.dispose();
						} catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "El contenido de la información no coincide\n con el tipo de columna." ,"Error", 0);
							frame.setVisible(false);
							frame.dispose();
						}
					} else {
						//STRING
						updateTable.editTable(login.buf, comboBox_1.getSelectedItem().toString(), textField_2.getText(), Integer.parseInt(textField.getText()));
					}
				}
			}
		});
		
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(font);
		btnNewButton_2.setBounds(662, 396, 209, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblInformacinModificada = new JLabel("Informaci\u00F3n modificada:");
		lblInformacinModificada.setFont(new Font("Brutal Type", Font.PLAIN, 15));
		lblInformacinModificada.setBounds(537, 206, 180, 25);
		frame.getContentPane().add(lblInformacinModificada);
		lblInformacinModificada.setFont(font);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Brutal Type", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(537, 242, 167, 25);
		frame.getContentPane().add(textField_2);
		
		JButton btnAadirFila = new JButton("A\u00F1adir fila");
		btnAadirFila.setFont(new Font("Brutal Type", Font.PLAIN, 15));
		btnAadirFila.setBounds(439, 396, 209, 23);
		frame.getContentPane().add(btnAadirFila);
		btnAadirFila.setFont(font);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnCancelar.setBounds(300, 396, 119, 23);
		frame.getContentPane().add(btnCancelar);
		btnCancelar.setFont(font);
		
		JLabel lblTipoDeColumna = new JLabel("Tipo de columna:");
		lblTipoDeColumna.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTipoDeColumna.setBounds(727, 60, 128, 21);
		frame.getContentPane().add(lblTipoDeColumna);
		lblTipoDeColumna.setFont(font);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Brutal Type", Font.PLAIN, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(727, 94, 128, 25);
		frame.getContentPane().add(textField_3);
		
		
	}
	@SuppressWarnings("finally")
	public ImageIcon getImageIcon(File f)
    {
		ImageIcon ii = null;
        try
        {
            Image im = ImageIO.read(f);
            ii = new ImageIcon(im);
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        finally
        {
            return ii;
        }
    }
}
