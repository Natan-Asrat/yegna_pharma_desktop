package navigationBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaces.*;
import layouts.BodyMain;
import layouts.SideMiddle;

public class PaymentsReportBox extends JPanel implements Constants, MouseListener {
    String boxName = "Payment Report";
    JLabel boxValue = new JLabel("0");
    String buttonText = "View Detailed Report >>";
    String iconFilename = "resources/boxIcons/payment_box.png";
    Color themeColor = Guide.PAYMENT_BOX_BACKGROUND;
    Color buttonColor = Guide.PAYMENT_CTA_BACKGROUND;

    PaymentsReportBox(boolean isLong, boolean isWide) {
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

    public PaymentsReportBox() {
        this(false, false);
    }

    public void setBoxValue(String value) {
        this.boxValue.setText(value);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_REPORTS);
        BodyMain.c.show(BodyMain.card, "pay");
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

