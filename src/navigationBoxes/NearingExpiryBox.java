package navigationBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaces.*;
import layouts.BodyMain;
import layouts.SideMiddle;

public class NearingExpiryBox extends JPanel implements MouseListener {
    String boxName;
    JLabel boxValue;
    String buttonText;
    String iconFilename;
    Color themeColor;
    Color buttonColor;
    NearingExpiryBox(boolean isLong, boolean isWide){
        addMouseListener(this);

        setBackground(Color.white);
//        setPreferredSize(interfaces.Guide.NAVIGATION_BOX_SMALL);
        themeColor = Guide.NEARING_EXPIRY_BOX_BACKGROUND;
        setBorder(BorderFactory.createLineBorder(themeColor));

//        navigationBoxes.NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, false, false);
        setLayout(new BorderLayout());

        buttonColor = Guide.NEARING_EXPIRY_CTA_BACKGROUND;
        iconFilename = "resources/boxIcons/warning_icon.png";
        buttonText = "View Details >>";
        boxValue = new JLabel("0");
        boxName = "Nearing Expiry";
        add(NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, isLong, isWide));

//
//        add(navigationBoxes.NavigationBoxes.aboveCTA, BorderLayout.NORTH);
//        add(navigationBoxes.NavigationBoxes.CTA, BorderLayout.SOUTH);
    }

    public NearingExpiryBox(){this(false, false);}

    public void setBoxValue(String value) {
        this.boxValue.setText(value);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "nea");
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

