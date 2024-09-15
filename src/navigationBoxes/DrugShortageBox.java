package navigationBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaces.*;
import layouts.BodyMain;
import layouts.SideMiddle;

public class DrugShortageBox extends JPanel implements Constants, MouseListener {
    ImageIcon icon = new ImageIcon("warning_icon.png");
    String boxName = "Drug Shortage";
    JLabel boxValue = new JLabel("0");
    String buttonText = "Resolve Now >>";
    String icconFilename = "resources/boxIcons/warning_icon.png";
    Color themeColor = Guide.DRUG_SHORTAGE_BOX_BACKGROUND;
    Color buttonColor = Guide.DRUG_SHORTAGE_CTA_BACKGROUND;

    public DrugShortageBox() {
        addMouseListener(this);
        setBackground(Color.white);
//        setPreferredSize(interfaces.Guide.NAVIGATION_BOX_SMALL);
        setBorder(BorderFactory.createLineBorder(themeColor));

//        navigationBoxes.NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, icconFilename, buttonColor, false, false);
        setLayout(new BorderLayout());

        add(NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, icconFilename, buttonColor, false, false));
//        add(navigationBoxes.NavigationBoxes.aboveCTA, BorderLayout.NORTH);
//        add(navigationBoxes.NavigationBoxes.CTA, BorderLayout.SOUTH);
    }

    public void setBoxValue(String value) {
        this.boxValue.setText(value);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "dshort");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
