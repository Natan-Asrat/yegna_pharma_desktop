package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsButton extends JButton implements Guide, ActionListener {
    public DetailsButton(){
        setForeground(Color.white);
        addActionListener(this);
        setBackground(SAVE_BUTTON_DRUG_COLOR);
        setPreferredSize(SAVE_BUTTON_DRUG_DIMENSION);
        setBorder(null);
        setText("Details");

        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
//        BodyMain.c.show(BodyMain.card, "addO");
    }
}
