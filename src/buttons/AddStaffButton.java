package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStaffButton extends JButton implements Guide, ActionListener {
    ImageIcon icon = new ImageIcon(getClass().getResource("/buttonIcons/add_white.png"));
    public AddStaffButton(){
        setForeground(Color.white);
        addActionListener(this);
        setBackground(ADD_STAFF_BUTTON_COLOR);
        setPreferredSize(EDIT_DETAILS_DRUG_BUTTON_DIMENSION);
        setBorder(null);

        setText("Add Staff");
        setIconTextGap(10);
        setIcon(icon);
        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BodyMain.c.show(BodyMain.card, "staf");

//        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
//        BodyMain.c.show(BodyMain.card, "addO");
    }
}
