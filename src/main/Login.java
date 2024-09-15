package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener{
    JButton button;
    JTextField userField, passwordField;
    JLabel UserName = new JLabel("UserName");
    JLabel Password= new JLabel("Password");
    public static String username;
    public boolean pass = false;
    ImageIcon icon = new ImageIcon(getClass().getResource("/brand/logo.png"));
    Login(){
        setIconImage(icon.getImage());
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LoginForm");
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("/login_background.jpg"))));

        button= new JButton("Login");
        userField =new JTextField(240);
        passwordField =new JPasswordField();

        UserName.setBounds(410,112,190,20);
        UserName.setForeground(Color.cyan);
        UserName.setFont(new Font("ARIEL",Font.BOLD,17));

        userField.setBounds(500,104,250,36);
        userField.setFont(new Font("ROBOTO",Font.BOLD,14));
        userField.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        userField.setBackground(new Color(227,235,243));
        userField.setOpaque(true);

        Password.setBounds(410,172,190,20);
        Password.setForeground(Color.cyan);
        Password.setFont(new Font("ARIEL",Font.BOLD,17));
        passwordField.setBounds(500,163,250,36);
        passwordField.setFont(new Font("ROBOTO",Font.BOLD,14));
        passwordField.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        passwordField.setBackground(new Color(227,235,243));

        button.setBounds(520,240,110,40);
        button.setFocusable(false);
        button.setBackground(new Color(177,254,88));
        button.setBorder(null);
        button.setSize(212,46);
        button.addActionListener(this);

        add(UserName);
        add(userField);
        add(Password);
        add(passwordField);
        add(button);

        setBounds(350,90,800,650);
        setVisible(true);
        setMaximumSize(new Dimension(800,650));
        setResizable(false);



        System.out.println("out of while loop");
    }


    @Override
    public void actionPerformed(ActionEvent f) {
        String userName = userField.getText();
        System.out.println(userName);

        String passwordText = passwordField.getText();
        System.out.println(passwordText);

        String query = String.format("SELECT * FROM Employee WHERE first_name = '%s'", userName);
        try{
            DbFunctions db =new DbFunctions();
//            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/" + "YegnaPharma", "postgres", "nats");
            Connection conn = DriverManager.getConnection(DbFunctions.get_url());
            Statement statement = conn.createStatement();
            System.out.println(statement);
            ResultSet data = statement.executeQuery(query);

//            ResultSet data = DbFunctions.getData(query);
            data.next();
            String actualPassword = data.getString(10);
            System.out.println("back in login");
            System.out.println(actualPassword);
            if (passwordText.equals(actualPassword)) {
                pass = true;
                String id = data.getString(1);
                User user = new User(userName, id);
                JFrame y = new YegnaPharma(user);
//                User.saveUserName(userName);
                username = userName;
                this.dispose();
                System.out.println(pass);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong username or password!", "Unable to login!", JOptionPane.ERROR_MESSAGE);
            }



        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Could not connect to the database!","Unable to connect!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
}







