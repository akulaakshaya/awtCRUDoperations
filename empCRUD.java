package JavaCore;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

class awtEMP extends Frame {
	int empno;
	String name;
	String job;
	double sal;
	int deptno;
	private Connection con;
	ResultSet rs;
	ResultSetMetaData md;
	PreparedStatement sp;

	// Buttons creation
	Button b1 = new Button("First");
	Button b2 = new Button("Next");
	Button b3 = new Button("Prev");
	Button b4 = new Button("Add");
	Button b5 = new Button("Edit");
	Button b6 = new Button("Delete");
	Button b7 = new Button("Last");
	Button b8 = new Button("Save");
	Button b9 = new Button("Clear");
	Button b10 = new Button("Exit");

	public awtEMP() {

		String y = "";
		Frame f = new Frame();

		Label ll = new Label("EMPLOYEE DATABASE");
		ll.setBounds(480, 40, 350, 40);
		ll.setFont(new Font("Bold", 50, 30));
		ll.setBackground(Color.lightGray);
		f.add(ll);
		TextArea ta = new TextArea();
		ta.setBounds(340, 580, 700, 250);
		f.add(ta);
		String query = "select * from aks";
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery(query);
			while (rs.next()) {
				y += rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4) + " "
						+ rs.getInt(5) + "\n";
			}
			ta.setText(y);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// label1 textArea1
		Label l1 = new Label("EmpNo  :");
		l1.setBackground(Color.lightGray);
		l1.setBounds(500, 120, 60, 25);
		TextField t1 = new TextField();
		t1.setBounds(650, 120, 120, 25);

		// label2 textArea2
		Label l2 = new Label("EmpName  :");
		l2.setBackground(Color.lightGray);
		l2.setBounds(500, 170, 75, 25);
		TextField t2 = new TextField();
		t2.setBounds(650, 170, 120, 25);

		// label3 TextArea3
		Label l3 = new Label("JOB  :");
		l3.setBackground(Color.lightGray);
		l3.setBounds(500, 220, 70, 25);
		TextField t3 = new TextField();
		t3.setBounds(650, 220, 120, 25);

		// label4 TextArea4
		Label l4 = new Label("Salary  :");
		l4.setBackground(Color.lightGray);
		l4.setBounds(500, 270, 70, 25);
		TextField t4 = new TextField();
		t4.setBounds(650, 270, 120, 25);

		// label5 TextArea5
		Label l5 = new Label("DeptNo  :");
		l5.setBackground(Color.lightGray);
		l5.setBounds(500, 320, 70, 25);
		TextField t5 = new TextField();
		t5.setBounds(650, 320, 120, 25);

		// labels Styling
		l1.setFont(new Font("Bold", 50, 15));
		l2.setFont(new Font("Bold", 15, 15));
		l3.setFont(new Font("Bold", 15, 15));
		l4.setFont(new Font("Bold", 15, 15));
		l5.setFont(new Font("Bold", 15, 15));

		// Button First

		b1.setBounds(450, 430, 70, 30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
				voidColor();
				try {
					b1.setBackground(Color.pink);
					b1.setBounds(450, 430, 80, 35);
					rs.first();
					if (rs.absolute(1)) {
						empno = rs.getInt(1);
						String y = "" + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = "" + name;
						t2.setText(y);
						job = rs.getString(3);
						y = "" + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = "" + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = "" + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		b2.setBounds(550, 430, 70, 30);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b2.setBackground(Color.pink);
				b2.setBounds(550, 430, 80, 35);
				try {
					boolean b = rs.next();
					if (b) {
						empno = rs.getInt(1);
						String y = "" + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = "" + name;
						t2.setText(y);
						job = rs.getString(3);
						y = "" + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = "" + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = "" + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		b3.setBounds(650, 430, 70, 30);
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b3.setBackground(Color.pink);
				b3.setBounds(650, 430, 80, 35);
				try {
					boolean b = rs.previous();
					if (b) {
						empno = rs.getInt(1);
						String y = "" + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = "" + name;
						t2.setText(y);
						job = rs.getString(3);
						y = "" + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = "" + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = "" + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		b4.setBounds(750, 430, 70, 30);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b4.setBackground(Color.pink);
				b4.setBounds(750, 430, 80, 35);
				String x = "insert into aks values(?,?,?,?,?)";
				try {
					sp = con.prepareStatement(x);
					sp.setInt(1, Integer.parseInt(t1.getText()));
					sp.setString(2, t2.getText());
					sp.setString(3, t3.getText());
					sp.setDouble(4, Double.parseDouble(t4.getText()));
					sp.setInt(5, Integer.parseInt(t5.getText()));
					sp.execute();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		b5.setBounds(850, 430, 70, 30);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b5.setBackground(Color.pink);
				b5.setBounds(850, 430, 80, 35);
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
					PreparedStatement stmt = conn
							.prepareStatement("update aks set empname=?,job=?,salary=?,deptno=? where empno=?");
					stmt.setInt(5, Integer.parseInt(t1.getText()));
					stmt.setString(1, t2.getText());
					stmt.setString(2, t3.getText());
					stmt.setInt(3, Integer.parseInt(t4.getText()));
					stmt.setInt(4, Integer.parseInt(t5.getText()));
					stmt.execute();
					int i = stmt.executeUpdate();
					System.out.println("Records Updated :" + i);
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		b6.setBounds(450, 520, 70, 30);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b6.setBackground(Color.pink);

				b6.setBounds(450, 520, 80, 35);
				String query = "delete from aks where empno=?and empname=? and job=? and salary=? and deptno=?";
				try {
					sp = con.prepareStatement(query);
					sp.setInt(1, Integer.parseInt(t1.getText()));
					sp.setString(2, t2.getText());
					sp.setString(3, t3.getText());
					sp.setDouble(4, Double.parseDouble(t4.getText()));
					sp.setInt(5, Integer.parseInt(t5.getText()));
					sp.execute();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		b7.setBounds(550, 520, 70, 30);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b7.setBackground(Color.pink);
				b7.setBounds(550, 520, 80, 35);
				try {
					rs.last();
					if (rs.last()) {
						empno = rs.getInt(1);
						String y = "" + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = "" + name;
						t2.setText(y);
						job = rs.getString(3);
						y = "" + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = "" + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = "" + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		b8.setBounds(650, 520, 70, 30);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b8.setBackground(Color.pink);
				b8.setBounds(650, 520, 80, 35);
				String y = "";
				ta.setText(null);
				try {
					Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					rs = ps.executeQuery(query);
					rs.absolute(0);
					while (rs.next()) {
						y += rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4) + " "
								+ rs.getInt(5) + "\n";
					}
					ta.setText(y);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		// clear button

		b9.setBounds(750, 520, 70, 30);
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b9.setBackground(Color.pink);
				b9.reshape(750, 520, 80, 35);
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				// b9.setBackground(Color.LIGHT_GRAY);
				voidColor();
			}

		});

		b10.setBounds(850, 520, 70, 30);
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voidColor();
				b10.setBackground(Color.pink);
				System.exit(0);

			}
		});

		// creating Connection
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
		} catch (Exception e) {
			System.out.println(e);
		}

		f.setLayout(null);
		f.setSize(1300, 1300);
		f.setTitle("EMP CRUD");
		f.setVisible(true);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b9);
		f.add(b10);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.setBackground(Color.lightGray);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}

		});

	}

	public void voidColor() {
		this.b1.setBackground(Color.lightGray);
		this.b2.setBackground(Color.lightGray);
		this.b3.setBackground(Color.lightGray);
		this.b4.setBackground(Color.lightGray);
		this.b5.setBackground(Color.lightGray);
		this.b6.setBackground(Color.lightGray);
		this.b7.setBackground(Color.lightGray);
		this.b8.setBackground(Color.lightGray);
		this.b9.setBackground(Color.lightGray);
		this.b10.setBackground(Color.lightGray);
		b1.setBounds(450, 430, 70, 30);
		b2.setBounds(550, 430, 70, 30);
		b3.setBounds(650, 430, 70, 30);
		b4.setBounds(750, 430, 70, 30);
		b5.setBounds(850, 430, 70, 30);
		b6.setBounds(450, 520, 70, 30);
		b7.setBounds(550, 520, 70, 30);
		b10.setBounds(850, 520, 70, 30);
		b8.setBounds(650, 520, 70, 30);
		b9.setBounds(750, 520, 70, 30);
	}
}

public class empCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		awtEMP ae = new awtEMP();
	}

}
