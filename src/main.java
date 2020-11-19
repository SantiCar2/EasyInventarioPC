import java.awt.FontFormatException;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws FontFormatException, IOException {
		// TODO Auto-generated method stub
		login init = new login();
		while (!login.auth) {
			init.frmInicioDeSesin.setVisible(true);
			
		}
		Maint main = new Maint();
		init.frmInicioDeSesin.setVisible(false);
		main.frame.setVisible(true);
		init.frmInicioDeSesin.dispose();
		//comentario
	}

}
