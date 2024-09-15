package navigationBoxes;

import interfaces.*;
import layouts.BodyMain;
import layouts.SideMiddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryStatusBox extends JPanel implements MouseListener {
    String boxName = "Inventory Status";
    JLabel boxValue = new JLabel("Good");
    String buttonText = "View Inventory Status >>";
    String iconFilename = "resources/boxIcons/inventory_status_box.png";
    Color themeColor = Guide.INVENTORY_STATUS_BOX_BACKGROUND;
    Color buttonColor = Guide.INVENTORY_STATUS_CTA_BACKGROUND;

    public InventoryStatusBox(boolean isLong, boolean isWide) {
        addMouseListener(this);
        setBackground(Color.white);
//        setPreferredSize(interfaces.Guide.NAVIGATION_BOX_SMALL);
        setBorder(BorderFactory.createLineBorder(themeColor));

//        navigationBoxes.NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, false, false);
        setLayout(new BorderLayout());

        add(NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, isLong, isWide));

//
//        add(navigationBoxes.NavigationBoxes.aboveCTA, BorderLayout.NORTH);
//        add(navigationBoxes.NavigationBoxes.CTA, BorderLayout.SOUTH);
    }

    public InventoryStatusBox() {
        this(false, false);
    }

    public void setBoxValue(String value) {
        this.boxValue.setText(value);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "inv");
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

