package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDrugButton extends JButton implements Guide, ActionListener {
    ImageIcon icon = new ImageIcon(getClass().getResource("/buttonIcons/edit_white.png"));
    public EditDrugButton(){
        setForeground(Color.white);
        addActionListener(this);
        setBackground(EDIT_DETAILS_DRUG_BUTTON);
        setPreferredSize(EDIT_DETAILS_DRUG_BUTTON_DIMENSION);
        setBorder(null);

        setText("Edit Details");
        setIconTextGap(10);
        setIcon(icon);
        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
//        BodyMain.c.show(BodyMain.card, "addO");
    }
}
