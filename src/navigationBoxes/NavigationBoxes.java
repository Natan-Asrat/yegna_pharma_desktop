package navigationBoxes;

import javax.swing.*;
import java.awt.*;
import interfaces.*;

public class NavigationBoxes extends JFrame{
//    static final byte numberOfBoxes = 8;
//    static JLabel
//            revenueValue = new JLabel(),
//            inventoryStatusValue = new JLabel(),
//            drugsAvailableValue = new JLabel(),
//            drugShortageValue = new JLabel(),
//            nearingExpiryValue = new JLabel(),
//            ordersValue = new JLabel(),
//            employeesValue = new JLabel(),
//            paymentValue = new JLabel();

    public static JPanel
            revenue = new RevenueBox(),
            revenueWide = new RevenueBox(false, true),
            inventoryStatus = new InventoryStatusBox(),
            drugsAvailable = new DrugsAvailableBox(),
            drugShortage = new DrugShortageBox(),
            nearingExpiry = new NearingExpiryBox(),
            orders = new OrdersBox(),
            ordersLong = new OrdersBox(true, false),
            employees = new EmployeesBox(),
            employeesLong = new EmployeesBox(true, false),
            paymentReport = new PaymentsReportBox();
    static JPanel[] boxes = {
            revenue,
            inventoryStatus,
            drugsAvailable,
            drugShortage,
            nearingExpiry,
            orders,
            employees,
            paymentReport
    };
//
//    static String[] boxText = {
//            "Revenue",
//            "Inventory Status",
//            "Drugs Available",
//            "Drug Shortage",
//            "Nearing Expiry",
//            "Orders",
//            "Employees",
//            "Payment Report"
//    };
//    static String[] boxValue = {
//            "Birr 0.00",
//            "Good",
//            "0", "0", "0", "0", "0", "0", "0"};
//    static String[] boxCTA_Text = {
//            "View Detailed Report >>",
//            "View Inventory Status >>",
//            "View Full List >>",
//            "Resolve Now >>",
//            "View Details >>",
//            "View Orders >>",
//            "View Employees >>",
//            "View Detailed Report >>"
//    };
//    static String[] boxIconFileNames = {
//            "revenue_box.png",
//            "inventory_status_box.png",
//            "drugs_available_box.png",
//            "warning_icon.png",
//            "warning_icon.png",
//            "orders_box.png",
//            "employees_box.png",
//            "payment_icon.png"
////    };
//    static Color[] boxBackground = {
//            interfaces.Guide.REVENUE_BOX_BACKGROUND,
//            interfaces.Guide.INVENTORY_STATUS_BOX_BACKGROUND,
//            interfaces.Guide.DRUGS_AVAILABLE_BOX_BACKGROUND,
//            interfaces.Guide.DRUG_SHORTAGE_BOX_BACKGROUND,
//            interfaces.Guide.NEARING_EXPIRY_BOX_BACKGROUND,
//            interfaces.Guide.ORDERS_BOX_BACKGROUND,
//            interfaces.Guide.EMPLOYEES_BOX_BACKGROUND,
//            interfaces.Guide.PAYMENT_BOX_BACKGROUND
//    };
//    static Color[] boxCTA_Background = {
//            interfaces.Guide.REVENUE_CTA_BACKGROUND,
//            interfaces.Guide.INVENTORY_STATUS_CTA_BACKGROUND,
//            interfaces.Guide.DRUGS_AVAILABLE_CTA_BACKGROUND,
//            interfaces.Guide.DRUG_SHORTAGE_CTA_BACKGROUND,
//            interfaces.Guide.NEARING_EXPIRY_CTA_BACKGROUND,
//            interfaces.Guide.ORDERS_CTA_BACKGROUND,
//            interfaces.Guide.EMPLOYEES_CTA_BACKGROUND,
//            interfaces.Guide.PAYMENT_CTA_BACKGROUND
//    };
    static JPanel CTA;
    static JPanel aboveCTA;
    static JLabel boxName;
    static JLabel boxValueLabel;
    static JLabel CTA_Text;
    static JLabel ICON;
    public static JPanel newBoxElements(String boxNameString, JLabel boxValue, String buttonText, String iconFilename, Color buttonColor, boolean isLong, boolean isWide){
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        CTA = new JPanel();

        ICON = new JLabel();
        ICON.setIcon(new ImageIcon(iconFilename));
        ICON.setHorizontalAlignment(SwingConstants.CENTER);

        aboveCTA = new JPanel();
        boxName = new JLabel();
        boxValueLabel = new JLabel();
        CTA_Text = new JLabel();

        CTA_Text.setText(buttonText);
        CTA.setBackground(buttonColor);
        CTA.setPreferredSize(Guide.NAVIGATION_BOX_SMALL_CTA_DIMENSION);

        CTA_Text.setHorizontalAlignment(SwingConstants.CENTER);
        CTA.add(CTA_Text);


        aboveCTA.setOpaque(false);
        aboveCTA.setLayout(new BorderLayout());

        if(isLong){
            aboveCTA.setPreferredSize(Guide.NAVIGATION_BOX_LONG_ABOVE_CTA_DIMENSION);
            aboveCTA.setBorder(Guide.NAVIGATION_BOX_LONG_ABOVE_CTA_MARGIN);
            boxName.setPreferredSize(Guide.NAVIGATION_BOX_SMALL_CTA_DIMENSION);

        }else if(isWide){
            aboveCTA.setPreferredSize(Guide.NAVIGATION_BOX_WIDE_ABOVE_CTA_DIMENSION);
            aboveCTA.setBorder(Guide.NAVIGATION_BOX_SMALL_ABOVE_CTA_MARGIN);
            boxName.setPreferredSize(Guide.NAVIGATION_BOX_WIDE_CTA_DIMENSION);

        }else{
            aboveCTA.setPreferredSize(Guide.NAVIGATION_BOX_SMALL_ABOVE_CTA_DIMENSION);
            aboveCTA.setBorder(Guide.NAVIGATION_BOX_SMALL_ABOVE_CTA_MARGIN);
            boxName.setPreferredSize(Guide.NAVIGATION_BOX_SMALL_CTA_DIMENSION);

        }



        boxName.setText(boxNameString);
        boxName.setFont(Guide.POPPINS_BOLD_MEDIUM);
        boxName.setHorizontalAlignment(SwingConstants.CENTER);

        boxValue.setHorizontalAlignment(SwingConstants.CENTER);
        boxValue.setPreferredSize(Guide.NAVIGATION_BOX_SMALL_CTA_DIMENSION);

        aboveCTA.add(ICON, BorderLayout.NORTH);
        aboveCTA.add(boxValue);
        aboveCTA.add(boxName, BorderLayout.SOUTH);
        container.setOpaque(false);
        container.add(NavigationBoxes.aboveCTA, BorderLayout.NORTH);
        container.add(NavigationBoxes.CTA, BorderLayout.SOUTH);
        return container;
    }
//    static {
//
//        for (byte i = 0; i < numberOfBoxes; i++) {
//            JPanel container = new JPanel();
//            container.setBackground(Color.white);
//            container.setPreferredSize(interfaces.Guide.NAVIGATION_BOX_SMALL);
//            container.setBorder(BorderFactory.createLineBorder(boxBackground[i]));
//
//            newBoxElements(i, false, false);
//
//            container.setLayout(new BorderLayout());
//
//            container.add(aboveCTA, BorderLayout.NORTH);
//            container.add(CTA, BorderLayout.SOUTH);
//            boxes[i].add(container);
//
//        }
//
//        revenueWide.setBorder(BorderFactory.createLineBorder(interfaces.Guide.REVENUE_BOX_BACKGROUND));
//        revenueWide.setBackground(Color.white);
//        revenueWide.setPreferredSize(interfaces.Guide.NAVIGATION_BOX_WIDE);
//        revenueWide.setLayout(new BorderLayout());
//
//        newBoxElements((byte) (0), false, true);
//
//        revenueWide.add(aboveCTA, BorderLayout.NORTH);
//        revenueWide.add(CTA, BorderLayout.SOUTH);
//
//
//        ordersLong.setBorder(BorderFactory.createLineBorder(interfaces.Guide.ORDERS_BOX_BACKGROUND));
//        ordersLong.setBackground(Color.white);
//        ordersLong.setPreferredSize(interfaces.Guide.NAVIGATION_BOX_LONG);
//        ordersLong.setLayout(new BorderLayout());
//
//        newBoxElements((byte) (5), true, false);
//
//        ordersLong.add(aboveCTA, BorderLayout.NORTH);
//        ordersLong.add(CTA, BorderLayout.SOUTH);
//
//
//        employeesLong.setBorder(BorderFactory.createLineBorder(interfaces.Guide.EMPLOYEES_BOX_BACKGROUND));
//        employeesLong.setBackground(Color.white);
//        employeesLong.setPreferredSize(interfaces.Guide.NAVIGATION_BOX_LONG);
//        employeesLong.setLayout(new BorderLayout());
//
//        newBoxElements((byte) (6), true, false);
//
//        employeesLong.add(aboveCTA, BorderLayout.NORTH);
//        employeesLong.add(CTA, BorderLayout.SOUTH);
//
//    }
    NavigationBoxes(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/revenue_box.svg"));
        setIconImage(icon.getImage());
        setMinimumSize(new Dimension(1280, 720));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        for(JPanel box: boxes){
            add(box);
        }
        add(revenueWide);
        add(ordersLong);
        add(employeesLong);

    }

    public static void main(String[] args) {
        new NavigationBoxes();
    }
}
