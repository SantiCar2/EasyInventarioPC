import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Maint {

	
	public double precio = 12.99;
	public JFrame frame;
	private JTable table;
	EditTableWindow edit = new EditTableWindow();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maint window = new Maint();
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
	public Maint() throws FontFormatException, IOException {
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
		
		JButton btnNewButton_1 = new JButton("Editar");
		JButton btnNewButton_2 = new JButton("Pagar");;
		
		if(authenticator.payment) {
			btnNewButton_2.setEnabled(false);
		} else {
			btnNewButton_1.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Para poder acceder a la\n"
					+ "funcionalidad completa del software\n"
					+ "recuerda que debes pagar por tu licencia.\n\n"
					+ "Por un valor de: $" + precio + "USD" ,"Info", 1);
		}
		
		
		
		frame = new JFrame();
		frame.setTitle("EasyInventario");
		frame.setBounds(100, 100, 752, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] columnname = getTableInfo.getColumnNames(login.buf, true);
		String[][] data = getTableInfo.getValues(login.buf);
		
		for (int i = 0; i < columnname.length; i++) {
			System.out.println(columnname[i]);
		}
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.println(data[i][j]);
			}
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(12, 65);
	    scrollPane.setSize(712, 300);
	    frame.getContentPane().add(scrollPane);
	    
	    table = new JTable(data, columnname);
	    table.setRowSelectionAllowed(false);
	    scrollPane.setViewportView(table);
	    table.setFillsViewportHeight(true);
	    
	    JLabel lblNewLabel_1 = new JLabel("Vista previa de contenidos de tabla:");
	    lblNewLabel_1.setBounds(12, 37, 401, 16);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    JButton btnNewButton = new JButton("Actualizar");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String[] columnname = getTableInfo.getColumnNames(login.buf, true);
	    		String[][] data = getTableInfo.getValues(login.buf);
	    		
	    		for (int i = 0; i < columnname.length; i++) {
	    			System.out.println(columnname[i]);
	    		}
	    		for (int i = 0; i < data.length; i++) {
	    			for (int j = 0; j < data[0].length; j++) {
	    				System.out.println(data[i][j]);
	    			}
	    		}
	    		DefaultTableModel tableModel = new DefaultTableModel(data, columnname);
	    		table.setModel(tableModel);
	    	}
	    });
	    btnNewButton.setBounds(616, 28, 110, 26);
	    frame.getContentPane().add(btnNewButton);
	    
	    
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		edit.frame.setVisible(true);
	    	}
	    });
	    btnNewButton_1.setBounds(496, 28, 110, 26);
	    frame.getContentPane().add(btnNewButton_1);
		JLabel lblNewLabel = new JLabel("Tabla registrada en el servidor");
		lblNewLabel.setBounds(10, 11, 190, 14);
		
		lblNewLabel_1.setFont(font);
		btnNewButton.setFont(font);
		btnNewButton_1.setFont(font);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Abre panel de pago");
				
				
			}
		});
		btnNewButton_2.setBounds(397, 28, 89, 26);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setFont(font);

	}
}
