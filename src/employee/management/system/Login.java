
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField t_fusername, t_fpassword;
    
    
    
    
    
    Login(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new JLabel ("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
       t_fusername = new JTextField();
        t_fusername.setBounds(150, 20, 150, 30);
        add(t_fusername );
        
        
        JLabel lblpassword = new JLabel ("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        t_fpassword = new JTextField();
        t_fpassword.setBounds(150, 70, 150, 30);
        add(t_fpassword );
        
        JButton Login = new JButton("LOGIN");
        Login.setBounds(150, 140, 150, 30);
        Login.setBackground(Color.BLACK);
       Login.setForeground(Color.white);
       Login.addActionListener(this);
        add(Login);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        
        
        
        
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username =t_fusername.getText();
            String password =t_fpassword.getText();
            
            Conn c = new Conn();
            
            
            
            String query = "select * from login where username = '"+username+"' and password= '"+password+"'"; 
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
            
                
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    public static void main (String[] args){
        new Login();
    }

}



