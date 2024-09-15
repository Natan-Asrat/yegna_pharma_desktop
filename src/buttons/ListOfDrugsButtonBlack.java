package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListOfDrugsButtonBlack extends JButton implements Guide, ActionListener {
    public ListOfDrugsButtonBlack(){
        setForeground(Color.white);
        addActionListener(this);
        setBackground(LIST_DRUGS_BUTTON_COLOR);
        setPreferredSize(LIST_DRUGS_BUTTON_DIMENSION);
        setBorder(null);
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(BorderFactory.createEmptyBorder(0, 46, 0, 0));

        setText("List of Drugs");
        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "lod");
    }
}
