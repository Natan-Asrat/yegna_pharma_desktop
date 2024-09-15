package main;

import interfaces.Guide;
import layouts.Body;
import layouts.SideBar;

import javax.swing.*;
import java.awt.*;

public class YegnaPharma extends JFrame implements Guide {
    private final User user;
    ImageIcon brandIcon = new ImageIcon(getClass().getResource("/brand/logo.png"));
    Body body;
    SideBar sideBar;
    public static String username;

    YegnaPharma(User user){
        this.user = user;
        sideBar  = new SideBar(user);
        body  = new Body(user);
        setIconImage(brandIcon.getImage());
        setBackground(MAIN_GRAY);
        setMinimumSize(JFRAME_SIZE);

        setVisible(true);
        setTitle(BRAND_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(sideBar, BorderLayout.WEST);
        add(body, BorderLayout.CENTER);
    }
}
