package layouts;

import interfaces.Guide;
import main.User;

import javax.swing.*;
import java.awt.*;


public class SideBar extends JPanel implements Guide {
    SideTop sideTop;
    SideBottom sideBottom;
    SideMiddle sideMiddle;

    public SideBar(User user){

        SideTop sideTop = new SideTop();
        SideBottom sideBottom = new SideBottom();
        SideMiddle sideMiddle = new SideMiddle(user);
        setBackground(Guide.SIDE_BAR_LIGHT);
        setPreferredSize(SIDE_BAR_MAIN);
        setLayout(new BorderLayout());

        add(sideTop, BorderLayout.NORTH);
        add(sideMiddle, BorderLayout.CENTER);
        add(sideBottom, BorderLayout.SOUTH);
    }
}
