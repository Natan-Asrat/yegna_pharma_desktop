package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewOrderButton extends JButton implements Guide, ActionListener {
    ImageIcon icon = new ImageIcon(getClass().getResource("/buttonIcons/add_white.png"));
    public AddNewOrderButton(){
        setForeground(Color.white);
        addActionListener(this);
        setBackground(ADD_ORDER_BUTTON_COLOR);
        setPreferredSize(ADD_ORDER_BUTTON_DIMENSION);
        setBorder(null);

        setText("Add New Order");
        setIconTextGap(8);
        setIcon(icon);
        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "addO");
    }
}
