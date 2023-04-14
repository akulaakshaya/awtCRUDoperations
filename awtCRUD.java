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
import java.sql.Statement;

class crudOP extends Frame {
	public crudOP() {
		Frame f = new Frame();
		Button b1 = new Button("CREATE");
		b1.setBounds(50, 150, 50, 30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button b12 = new Button("INSERT");
				b12.setBounds(150, 120, 70, 30);
				Button b13 = new Button("NEW TABLE");
				b13.setBounds(150, 160, 70, 30);

				f.add(b12);
				f.add(b13);
				b12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TextArea t1 = new TextArea();
						t1.setBounds(250, 120, 200, 70);
						Button b11 = new Button("EXECUTE");
						b11.setBounds(300, 200, 70, 30);
						f.add(t1);
						f.add(b11);

						b11.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ex) {
								try {
									String y = " ";
									y = t1.getText();
									Class.forName("org.postgresql.Driver");
									Connection con = DriverManager.getConnection(
											"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
									Statement st = con.createStatement();
									st.executeUpdate(y);
									String ab = "INSERTED";
									t1.setText(ab);
								} catch (Exception exe) {
									System.out.println(exe);
								}

							}
						});

					}
				});
				b13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TextArea t11 = new TextArea();
						t11.setBounds(500, 120, 200, 70);
						Button b111 = new Button("EXECUTE");
						b111.setBounds(570, 200, 70, 30);
						f.add(t11);
						f.add(b111);

						b111.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ex) {
								try {
									String y = " ";
									y = t11.getText();
									Class.forName("org.postgresql.Driver");
									Connection con = DriverManager.getConnection(
											"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
									Statement st = con.createStatement();
									st.executeUpdate(y);
									String ab = "CREATED";
									t11.setText(ab);
								} catch (Exception exe) {
									String ab = "Already Existing Table";
									t11.setText(ab);

									System.out.println(exe);
								}

							}
						});

					}
				});
			}
		});
		Button b2 = new Button("READ");
		b2.setBounds(50, 260, 50, 30);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextArea t2 = new TextArea();
				t2.setBounds(200, 240, 500, 90);
				Button b21 = new Button("EXECUTE");
				b21.setBounds(800, 260, 70, 30);

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
		b3.setBounds(50, 350, 50, 30);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextArea t3 = new TextArea();
				t3.setBounds(200, 330, 500, 90);
				Button b31 = new Button("EXECUTE");
				b31.setBounds(800, 360, 70, 30);

				b31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						String y3 = " ";
						y3 = t3.getText();
						try {
							int nr;
							Class.forName("org.postgresql.Driver");
							Connection con = DriverManager.getConnection(
									"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
							Statement st = con.createStatement();
							nr = st.executeUpdate(y3);
							String abc = "No of records Updated:" + nr;
							t3.setText(abc);
							con.close();
						} catch (Exception e) {
							System.out.println(e);
						}

					}
				});
				f.add(t3);
				f.add(b31);
			}
		});
		Button b4 = new Button("DELETE");
		b4.setBounds(50, 450, 50, 30);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextArea t4 = new TextArea();
				t4.setBounds(200, 430, 500, 90);
				Button b41 = new Button("EXECUTE");
				b41.setBounds(800, 460, 70, 30);

				b41.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						String y3 = " ";
						y3 = t4.getText();
						try {
							int nr = 0;
							Class.forName("org.postgresql.Driver");
							Connection con = DriverManager.getConnection(
									"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
							Statement st = con.createStatement();
							nr = st.executeUpdate(y3);
							String abc = "";
							if (nr > 0) {
								abc = "No of records DELETED:" + nr;
							} else {
								abc = "No records With that Condition Exist";
							}

							t4.setText(abc);
							con.close();
						} catch (Exception e) {
							System.out.println(e);
						}

					}
				});
				f.add(t4);
				f.add(b41);
			}
		});
		f.setLayout(null);
		f.setSize(1300, 1300);
		f.setTitle("HOMEWORK2");
		f.setVisible(true);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.setBackground(Color.lightGray);
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
