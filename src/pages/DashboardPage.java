package pages;

import buttons.BuySellButton;
import interfaces.*;
import layouts.*;
import navigationBoxes.*;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JPanel implements Guide, Constants {
    public static DrugShortageBox drugShortage;
    static JPanel dashboardFooter = new JPanel();
    JPanel button = new JPanel();
    BodyHeading bodyHeading;
    JPanel midAndHeader = new JPanel();
    BuySellButton buySellButton = new BuySellButton();
    public static RevenueBox revenueBox = new RevenueBox(false, true);
    public static InventoryStatusBox inventoryStatusBox = new InventoryStatusBox();
    public static DrugShortageBox drugShortageBox = new DrugShortageBox();
    public static DrugsAvailableBox drugsAvailableBox = new DrugsAvailableBox();
    public static NearingExpiryBox nearingExpiryBox = new NearingExpiryBox();
    public static OrdersBox ordersBox = new OrdersBox(true, false);
    public static EmployeesBox employeesBox = new EmployeesBox(true, false);

    public DashboardPage(){
        setLayout(new BorderLayout());


        button.add(buySellButton);
        bodyHeading = new BodyHeading("", "Dashboard", button);

        JPanel middle = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel leftBottom = new JPanel();

        middle.setLayout(Guide.TWO_COLUMN);
        left.setLayout(Guide.TWO_ROWS);
        right.setLayout(Guide.TWO_COLUMN);

        leftBottom.setLayout(Guide.TWO_COLUMN);
        leftBottom.add(inventoryStatusBox);
        leftBottom.add(drugsAvailableBox);

        midAndHeader.setLayout(new BorderLayout());

        left.add(revenueBox);
        left.add(leftBottom);

        right.add(ordersBox);
        right.add(employeesBox);

        middle.add(left);
        middle.add(right);

        JPanel container = new JPanel();
        container.setPreferredSize(DASHBOARD_MIDDLE_SECTION_DIMENSION);
        container.add(middle);

        bodyHeading.setBodyHeadingRight(button);

        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(container, BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);

        dashboardFooter.setLayout(Guide.TWO_COLUMN);
        dashboardFooter.setPreferredSize(DASHBOARD_FOOTER_DIMENSION);
        dashboardFooter.setBorder(DASHBOARD_FOOTER_MARGIN);
        dashboardFooter.setBackground(Guide.DASHBOARD_FOOTER_BACKGROUND);
        dashboardFooter.add(drugShortageBox);
        dashboardFooter.add(nearingExpiryBox);

        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(midAndHeader, BorderLayout.WEST);
        container.add(dashboardFooter, BorderLayout.SOUTH);

        add(container, BorderLayout.WEST);
    }

}
