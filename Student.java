//package pack;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.sql.*;
import java.awt.event.*;

public class Student implements ActionListener{
	JFrame f;
	JPanel p;
	JLabel ltitle,ldetails,ladmno,lrollno,lname,lclass,lmarks,lenglish,lhindi,lscience,lsst,lmath,lpercentage,lmsg,lentry,limage;
	JTextField tfadmno,tfrollno,tfname,tfclass,tfenglish,tfhindi,tfscience,tfsst,tfmath,tfpercentage;
	JButton bcal,binsert,bupdate,bdelete,bclear,bexit;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	JComboBox cb;
	
	Student()
	{	//frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		f=new JFrame("Student Database");
		f.setSize(500,400);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//panel
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.pink);
		f.add(p);
		
		//Label
		ltitle=new JLabel("Student's Database");
		ltitle.setFont(new Font("Segoe Print",Font.BOLD,35));
		ltitle.setForeground(Color.BLUE);
		ldetails=new JLabel("Enter Details of the Student");
		ldetails.setFont(new Font("Terminal",Font.BOLD,15));
		ldetails.setForeground(Color.darkGray);
		ladmno=new JLabel("Admission ID");
		lrollno=new JLabel("Roll Number");
		lname=new JLabel("Name");
		lclass=new JLabel("Class");
		lmarks=new JLabel("Enter the marks of the student");
		lmarks.setFont(new Font("Terminal",Font.BOLD,15));
		lmarks.setForeground(Color.darkGray);
		lenglish=new JLabel("English");
		lhindi=new JLabel("Hindi");
		lscience=new JLabel("Science");
		lsst=new JLabel("Social Studies");
		lmath=new JLabel("Mathematics");
		lpercentage=new JLabel("Percentage");
		lmsg=new JLabel("Message :");
		lentry=new JLabel("Entries Entered");
		limage=new JLabel();
		limage.setIcon(new ImageIcon("D:\\desktop\\chirag\\images\\School.jpg"));
		
		//TextField
		tfadmno=new JTextField(20);
		tfrollno=new JTextField(20);
		tfname=new JTextField(20);
		tfclass=new JTextField(20);
		tfenglish=new JTextField(20);
		tfhindi=new JTextField(20);
		tfscience=new JTextField(20);
		tfsst=new JTextField(20);
		tfmath=new JTextField(20);
		tfpercentage=new JTextField(20);
		
		//JButton
		bcal=new JButton("Calculate the percentage");
		bcal.setBackground(Color.cyan);
		binsert=new JButton("Insert");
		binsert.setBackground(Color.cyan);
		bupdate=new JButton("Update");
		bupdate.setBackground(Color.cyan);
		bdelete=new JButton("Delete");
		bdelete.setBackground(Color.cyan);
		bclear=new JButton("Clear");
		bclear.setBackground(Color.cyan);
		bexit=new JButton("Exit");
		bexit.setBackground(Color.cyan);
		//Combobox
		cb=new JComboBox();
		cb.addActionListener(this);
		cb.setBackground(Color.ORANGE);
		
		
		//Settinglayout
		ltitle.setBounds(550,05,400,100);
		ldetails.setBounds(350,70,200,100);
		ladmno.setBounds(50,110,100,100);
		tfadmno.setBounds(170,150,150,20);
		lrollno.setBounds(50,140,100,100);
		tfrollno.setBounds(170,180,150,20);
		lname.setBounds(50,170,100,100);
		tfname.setBounds(170,210,150,20);
		lclass.setBounds(50,200,100,100);
		tfclass.setBounds(170,240,150,20);
		lmarks.setBounds(350,250,250,100);
		lenglish.setBounds(50,290,100,100);
		tfenglish.setBounds(170,330,150,20);
		lhindi.setBounds(50,330,100,100);
		tfhindi.setBounds(170,370,150,20);
		lscience.setBounds(50,370,100,100);
		tfscience.setBounds(170,410,150,20);
		lsst.setBounds(50,410,100,100);
		tfsst.setBounds(170,450,150,20);
		lmath.setBounds(50,450,100,100);
		tfmath.setBounds(170,490,150,20);
		bcal.setBounds(50,530,250,20);
		bcal.addActionListener(this);
		bcal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lpercentage.setBounds(50,530,100,100);
		tfpercentage.setBounds(170,570,150,20);
		lmsg.setBounds(350,560,1200,100);
		binsert.setBounds(50,640,150,20);
		binsert.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		binsert.addActionListener(this);
		bupdate.setBounds(250,640,150,20);
		bupdate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bupdate.addActionListener(this);
		bdelete.setBounds(450,640,150,20);
		bdelete.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bdelete.addActionListener(this);
		bclear.setBounds(650,640,150,20);
		bclear.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bclear.addActionListener(this);
		bexit.setBounds(850,640,150,20);
		bexit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bexit.addActionListener(this);
		lentry.setBounds(650,110,180,20);
		cb.setBounds(650,130,250,50);
		limage.setBounds(650,240,650,350);
		limage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		updateCombo();
		
		//AddingComponents
		p.add(ltitle);
		p.add(ldetails);
		p.add(ladmno);p.add(tfadmno);
		p.add(lrollno);p.add(tfrollno);
		p.add(lname);p.add(tfname);
		p.add(lclass);p.add(tfclass);
		p.add(lmarks);
		p.add(lenglish);p.add(tfenglish);
		p.add(lhindi);p.add(tfhindi);
		p.add(lscience);p.add(tfscience);
		p.add(lsst);p.add(tfsst);
		p.add(lmath);p.add(tfmath);
		p.add(lpercentage);p.add(tfpercentage);
		p.add(bcal);
		p.add(lmsg);
		p.add(binsert);p.add(bupdate);p.add(bdelete);p.add(bclear);p.add(bexit);
		p.add(cb);
		p.add(lentry);
		p.add(limage);
	}
	
	public void clear()
	{
		tfadmno.setText("");
		tfrollno.setText("");
		tfname.setText("");
		tfclass.setText("");
		tfenglish.setText("");
		tfhindi.setText("");
		tfscience.setText("");
		tfsst.setText("");
		tfmath.setText("");
		tfpercentage.setText("");
		lmsg.setText("Message : Successfully cleared");
	}
	public void cal()
	{
		int eng=Integer.parseInt(tfenglish.getText());
		int hindi=Integer.parseInt(tfhindi.getText());
		int science=Integer.parseInt(tfscience.getText());
		int sst=Integer.parseInt(tfsst.getText());
		int math=Integer.parseInt(tfmath.getText());
		int p=(eng+hindi+science+sst+math)/5;
		tfpercentage.setText(Integer.toString(p));
	}
	public void updateCombo()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql:///home","root","root123");
		ps=con.prepareStatement("select admno from studinfo");
		cb.removeAllItems();
		rs=ps.executeQuery();
		while(rs.next())
		{
			cb.addItem(rs.getString("admno"));
		}
		
		
		}
		catch(Exception e)
		{  
			lmsg.setText("Message :"+e);
		}
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()==bclear)
		 {
			 clear();
		 }
		 else if(ae.getSource()==bexit)
		 {
				System.exit(0);
		 }
		 else if(ae.getSource()==bcal)
		 {
			 cal();
		 }
		 else if(ae.getSource()==cb)
			{
				String admno=cb.getSelectedItem()+"";
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql:///home","root","root123");
				ps=con.prepareStatement("select * from studinfo");
				rs=ps.executeQuery();
				while(rs.next())
				{ if(admno.equals(rs.getString("admno")))
				 {
					tfadmno.setText(rs.getInt("admno")+"");
					tfrollno.setText(rs.getInt("rollno")+"");
					tfname.setText(rs.getString("name"));
					tfclass.setText(rs.getInt("class")+"");
					tfenglish.setText(rs.getInt("english")+"");
					tfhindi.setText(rs.getInt("hindi")+"");
					tfscience.setText(rs.getInt("science")+"");
					tfsst.setText(rs.getInt("sst")+"");
					tfmath.setText(rs.getInt("math")+"");
					tfpercentage.setText(rs.getInt("percentage")+"");

				}}
				updateCombo();
		
				
				lmsg.setText("Message :"+"Succesfully shown");
				}
				catch(Exception e)
				{  
					lmsg.setText("Message :"+e);
				}
				
				
				
		 
	}
		 else if(ae.getSource()==binsert)
			{	
				String admno1=tfadmno.getText();
				String rollno=tfrollno.getText();
				String name=tfname.getText();
				String class1=tfclass.getText();
				String english=tfenglish.getText();
				String hindi=tfhindi.getText();
				String science=tfscience.getText();
				String sst=tfsst.getText();
				String math=tfmath.getText();								
				String percentage=tfpercentage.getText();
				boolean valid=false;
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql:///home","root","root123");
				ps=con.prepareStatement("select admno from studinfo");
				rs=ps.executeQuery();
				while(rs.next())
				{
					if(admno1.equals(rs.getString("admno")))
					valid=true;
				}
				if(valid)
				{
					lmsg.setText("Message :"+"Admission ID already exists");
					clear();
				}
				else
				{
					ps=con.prepareStatement("insert into studinfo values(?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, Integer.parseInt(admno1));
					ps.setInt(2, Integer.parseInt(rollno));
					ps.setString(3, name);
					ps.setInt(4,Integer.parseInt(class1));
					ps.setInt(5,Integer.parseInt(english));
					ps.setInt(6,Integer.parseInt(hindi));
					ps.setInt(7,Integer.parseInt(science));
					ps.setInt(8,Integer.parseInt(sst));
					ps.setInt(9,Integer.parseInt(math));
					ps.setInt(10,Integer.parseInt(percentage));
					ps.executeUpdate();
					clear();
					updateCombo();
					lmsg.setText("Message :"+"Succesfully entered");
				}
				
				}
				catch(Exception e)
				{  
					lmsg.setText("Message :"+e);
				}
				
			}
		 else if(ae.getSource()==bupdate)
		 {
			 String admno1=tfadmno.getText();
			 String rollno=tfrollno.getText();
				String name=tfname.getText();
				String class1=tfclass.getText();
				String english=tfenglish.getText();
				String hindi=tfhindi.getText();
				String science=tfscience.getText();
				String sst=tfsst.getText();
				String math=tfmath.getText();								
				String percentage=tfpercentage.getText();
			 boolean valid=false;
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql:///home","root","root123");
				ps=con.prepareStatement("select admno from studinfo");
				rs=ps.executeQuery();
				while(rs.next())
				{
					if(admno1.equals(rs.getString("admno")))
					valid=true;
				}
				if(valid)
				{	
					ps=con.prepareStatement("delete from studinfo where admno=?");
					ps.setInt(1,Integer.parseInt(admno1));
					ps.executeUpdate();
				ps=con.prepareStatement("insert into studinfo values(?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, Integer.parseInt(admno1));
				ps.setInt(2, Integer.parseInt(rollno));
				ps.setString(3, name);
				ps.setInt(4,Integer.parseInt(class1));
				ps.setInt(5,Integer.parseInt(english));
				ps.setInt(6,Integer.parseInt(hindi));
				ps.setInt(7,Integer.parseInt(science));
				ps.setInt(8,Integer.parseInt(sst));
				ps.setInt(9,Integer.parseInt(math));
				ps.setInt(10,Integer.parseInt(percentage));
				ps.executeUpdate();
				clear();
				updateCombo();
				lmsg.setText("Message :"+"Succesfully updated");
				
				}
				else
				{
					lmsg.setText("Message :"+"Cant update,doesnt exist.");
				}
				
				
				}
				catch(Exception e)
				{  
					lmsg.setText("Message :"+e);
				}
		 }
		 else if(ae.getSource()==bdelete)
		 { int admno1=Integer.parseInt(tfadmno.getText());
			 try
				{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql:///home","root","root123");
				ps=con.prepareStatement("delete from studinfo where admno=?");
				ps.setInt(1,admno1);
				ps.executeUpdate();
				clear();
				updateCombo();
				lmsg.setText("Message : Successfully Deleted");

				}
					
				
				catch(Exception e)
				{  
					lmsg.setText("Message :"+e);
				}
			 
		 }
	}
	
	public static void main(String[] args) {
		new Student();
	}

}
