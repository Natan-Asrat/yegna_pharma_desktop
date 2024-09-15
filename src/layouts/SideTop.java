package layouts;

import interfaces.Guide;

import javax.swing.*;
import java.awt.*;

public class SideTop extends JPanel {
    JLabel YegnaPharmaText = new JLabel(Guide.BRAND_NAME);
    ImageIcon YegnaPharmaIcon = new ImageIcon(getClass().getResource("/brand/logo.png"));
    SideTop(){
        setBackground(Guide.SIDE_BAR_DARK);
        setPreferredSize(Guide.SIDE_BAR_TOP);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 24, 0, 0));

        YegnaPharmaText.setFont(Guide.POPPINS_BOLD_LARGE);
        YegnaPharmaText.setForeground(Color.white);

        YegnaPharmaText.setIcon(YegnaPharmaIcon);
        YegnaPharmaText.setIconTextGap(20);
        add(YegnaPharmaText);

    }
}
