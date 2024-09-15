package pages;

import buttons.SaveOrderButton;
import interfaces.*;
import layouts.*;

import javax.swing.*;
import java.awt.*;

public class AddNewOrder extends JPanel implements Guide, Constants {
    static JPanel dashboardFooter = new JPanel();
    BodyHeading bodyHeading = new BodyHeading("Inventory  >  ", "Add New Order");
    JPanel midAndHeader = new JPanel();
    JPanel button = new JPanel();
    JPanel
            employeeID = new JPanel(null),
            quantity = new JPanel(null),
            drugCode = new JPanel(null);
    JLabel
            employeeIDLabel = new JLabel("Employee ID"),
            quantityLabel = new JLabel("Quantity in Number"),
            drugCodeLabel = new JLabel("Drug Code");

    public static JTextField employeeIDField = new JTextField();
    public static JTextField quantityField = new JTextField();
    public static JTextField drugNameField = new JTextField();
    public static JTextField drugCodeField = new JTextField();
    JTextField[] fields = {employeeIDField, quantityField, drugCodeField};
    JLabel[] labels = {employeeIDLabel, quantityLabel, drugCodeLabel};
    JPanel[] panels = {employeeID, quantity, drugCode};

    public AddNewOrder() {
        setLayout(new BorderLayout());
        JPanel middle = new JPanel(new GridLayout(3, 2, 32, 20));
        for (int i = 0; i < 3; i++) {
            labels[i].setBounds(0, 0, 340, 21);
            fields[i].setBounds(0, 25, 340, 38);
            fields[i].setBackground(new Color(227, 235, 243));
            fields[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 0, 0, 40)),
                    BorderFactory.createEmptyBorder(0, 15, 0, 15)
            ));
            fields[i].setFont(ROBOTO_PLAIN_MEDIUM);
            panels[i].add(labels[i]);
            panels[i].add(fields[i]);
            panels[i].setPreferredSize(TEXT_FIELD_PANEL);
            middle.add(panels[i]);
        }
//        drugNameLabel.setBounds(0, 0, 340, 21);
//        drugNameField.setBounds(0, 25, 340, 38);
//        drugNameField.setBackground(new Color(227, 235, 243));
//        drugNameField.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(new Color(0,0,0,40)),
//                BorderFactory.createEmptyBorder(0, 15, 0, 15)
//                ));
//        drugNameField.setFont(ROBOTO_PLAIN_MEDIUM);
//        drugName.add(drugNameLabel);
//        drugName.add(drugNameField);
//        drugName.setPreferredSize(TEXT_FIELD_PANEL);
//        middle.add(drugName);
//        middle.add(drugCode);
        middle.add(new JPanel());
        JPanel container = new JPanel(null);
        SaveOrderButton save = new SaveOrderButton();
        save.setBounds(0, 20, 162, 46);
        container.add(save);
        middle.add(container);

        midAndHeader.setLayout(new BorderLayout());
        container = new JPanel();
        container.add(middle);
        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(container, BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);
        container = new JPanel();
        container.add(midAndHeader);
        add(container, BorderLayout.WEST);
    }
}