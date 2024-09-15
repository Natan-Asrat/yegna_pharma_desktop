package layouts;

import interfaces.Guide;

import javax.swing.*;
import java.awt.*;

public class SideBottom extends JPanel {
    JLabel AAU_TEXT = new JLabel("AAU - CS - OOP PROJECT");
    SideBottom(){
        setBackground(Guide.SIDE_BAR_DARK);
        setPreferredSize(new Dimension(256, 34));
        setBorder(BorderFactory.createEmptyBorder(0, 24, 0, 0));
        setLayout(new BorderLayout());


        AAU_TEXT.setFont(Guide.POPPINS_BOLD_SMALL);
        AAU_TEXT.setForeground(Color.white);

        add(AAU_TEXT);
    }
}
