package JavaCore;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class crudOP extends Frame {
	public crudOP() {
		Frame f = new Frame();
		Button b1 = new Button("CREATE");
		b1.setBounds(50, 120, 50, 30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextArea t1 = new TextArea();
				t1.setBounds(250, 120, 500, 90);
				Button b11 = new Button("DO");
				b11.setBounds(800, 150, 50, 30);
				f.add(t1);
				f.add(b11);
			}
		});
		Button b2 = new Button("READ");
		b2.setBounds(50, 250, 50, 30);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextArea t2 = new TextArea();
				t2.setBounds(250, 220, 500, 90);
				Button b21 = new Button("DO");
				b21.setBounds(800, 250, 50, 30);

				f.add(t2);
				f.add(b21);
				b21.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						String x = "";

						x = t2.getText();
						System.out.println(x);
						try {
							Class.forName("org.postgresql.Driver");
							Connection con = DriverManager.getConnection(
									"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
							PreparedStatement ps = con.prepareStatement(x);
							ResultSet rs = ps.executeQuery();
							String y = "";
							while (rs.next()) {
								y += rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getDouble(4)
										+ "\n";
							}
							t2.setText(y);
							con.close();
						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				});

			}
		});
		Button b3 = new Button("UPDATE");
		Button b4 = new Button("DELETE");
		f.setLayout(null);
		f.setSize(1300, 1300);
		f.setTitle("HOMEWORK2");
		f.setVisible(true);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.setBackground(Color.cyan);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}

		});
	}
}

public class awtCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crudOP ob = new crudOP();
	}

}
