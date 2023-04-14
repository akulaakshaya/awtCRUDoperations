package JavaCore;

import java.awt.Button;
import java.awt.Color;
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

	public awtEMP() {
		String y = "";
		Frame f = new Frame();
		// label1 textArea1
		TextArea ta = new TextArea();
		ta.setBounds(600, 120, 400, 400);
		f.add(ta);
		String query = "select * from aksemp";
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

		Label l1 = new Label("EmpNo  :");
		l1.setBackground(Color.lightGray);
		l1.setBounds(50, 120, 50, 30);
		TextField t1 = new TextField();
		t1.setBounds(150, 120, 120, 30);

		// label2 textArea2
		Label l2 = new Label("EmpName  :");
		l2.setBackground(Color.lightGray);
		l2.setBounds(50, 180, 70, 30);
		TextField t2 = new TextField();
		t2.setBounds(150, 180, 120, 30);

		// label3 TextArea3
		Label l3 = new Label("JOB  :");
		l3.setBackground(Color.lightGray);
		l3.setBounds(50, 240, 70, 30);
		TextField t3 = new TextField();
		t3.setBounds(150, 240, 120, 30);

		// label4 TextArea4
		Label l4 = new Label("Salary  :");
		l4.setBackground(Color.lightGray);
		l4.setBounds(50, 300, 70, 30);
		TextField t4 = new TextField();
		t4.setBounds(150, 300, 120, 30);

		// label5 TextArea5
		Label l5 = new Label("DeptNo  :");
		l5.setBackground(Color.lightGray);
		l5.setBounds(50, 360, 70, 30);
		TextField t5 = new TextField();
		t5.setBounds(150, 360, 120, 30);

		// Button First
		Button b1 = new Button("First");
		b1.setBounds(50, 410, 70, 30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
				try {
					rs.first();
					if (rs.absolute(1)) {
						empno = rs.getInt(1);
						String y = " " + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = " " + name;
						t2.setText(y);
						job = rs.getString(3);
						y = " " + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = " " + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = " " + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Button b2 = new Button("Next");
		b2.setBounds(150, 410, 70, 30);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					boolean b = rs.next();
					if (b) {
						empno = rs.getInt(1);
						String y = " " + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = " " + name;
						t2.setText(y);
						job = rs.getString(3);
						y = " " + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = " " + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = " " + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Button b3 = new Button("Prev");
		b3.setBounds(250, 410, 70, 30);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					boolean b = rs.previous();
					if (b) {
						empno = rs.getInt(1);
						String y = " " + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = " " + name;
						t2.setText(y);
						job = rs.getString(3);
						y = " " + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = " " + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = " " + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Button b4 = new Button("Add");
		b4.setBounds(350, 410, 70, 30);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String y = "";
				String a = "";
				String b = "";
				String c = "";
				String d = "";
				y = t1.getText();
				a = t2.getText();
				b = t3.getText();
				c = t4.getText();
				d = t5.getText();
				String x = "insert into aksemp values(" + Integer.parseInt(y) + ",'" + a + "','" + b + "',"
						+ Double.parseDouble(c) + "," + Integer.parseInt(d) + ")";
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
					Statement st;
					st = conn.createStatement();
					st.executeUpdate(x);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});

		Button b5 = new Button("Edit");
		b5.setBounds(450, 410, 70, 30);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}
		});

		Button b6 = new Button("Delete");
		b6.setBounds(50, 510, 70, 30);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}
		});

		Button b7 = new Button("Last");
		b7.setBounds(150, 510, 70, 30);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					rs.last();
					if (rs.last()) {
						empno = rs.getInt(1);
						String y = " " + empno;
						t1.setText(y);
						name = rs.getString(2);
						y = " " + name;
						t2.setText(y);
						job = rs.getString(3);
						y = " " + job;
						t3.setText(y);
						sal = rs.getDouble(4);
						y = " " + sal;
						t4.setText(y);
						deptno = rs.getInt(5);
						y = " " + deptno;
						t5.setText(y);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Button b8 = new Button("Save");
		b8.setBounds(250, 510, 70, 30);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}
		});

		// clear button
		Button b9 = new Button("Clear");
		b9.setBounds(350, 510, 70, 30);
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);

			}
		});

		Button b10 = new Button("Exit");
		b10.setBounds(450, 510, 70, 30);
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

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

		// First Button Functionality
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					Statement st = con.createStatement();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

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
}

public class empCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		awtEMP ae = new awtEMP();
	}

}
