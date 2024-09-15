package pages;

import interfaces.*;
import layouts.*;
import navigationBoxes.OrdersBox;
import navigationBoxes.PaymentsReportBox;
import navigationBoxes.RevenueBox;
//import navigationBoxes.NavigationBoxes;

import javax.swing.*;
import java.awt.*;

public class ReportsPage extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    BodyHeading reportsHeader = new BodyHeading("", "Reports");
    public static OrdersBox ordersBox = new OrdersBox();
    public static PaymentsReportBox paymentsReportBox = new PaymentsReportBox();


    public ReportsPage(){
        setLayout(new BorderLayout());
        SideMiddle.updateSelected(SELECT_REPORTS);

        JPanel middle = new JPanel();

        middle.setLayout(THREE_COLUMN);

        midAndHeader.setLayout(new BorderLayout());
        midAndHeader.setBorder(BODY_MIDDLE_PADDING);

        paymentsReportBox.setBounds(0,0, 212, 152);

        ordersBox.setBounds(244, 0, 212, 152);

        middle.add(paymentsReportBox);
        middle.add(ordersBox);

        middle.setPreferredSize(new Dimension(700, 152));
        midAndHeader.add(reportsHeader, BorderLayout.NORTH);
        midAndHeader.add(middle, BorderLayout.WEST);
        midAndHeader.setMinimumSize(Guide.BODY_MAIN);

        add(midAndHeader, BorderLayout.NORTH);
    }
}