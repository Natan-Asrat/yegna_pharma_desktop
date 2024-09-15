package pages;

import buttons.SaveDrugButton;
import interfaces.*;
import layouts.*;

import javax.swing.*;
import java.awt.*;

public class AddNewDrug extends JPanel implements Guide, Constants {
    static JPanel save = new JPanel(new FlowLayout(FlowLayout.LEFT));
    BodyHeading bodyHeading = new BodyHeading("Inventory  >  ", "Add New Drugs");
    JPanel midAndHeader = new JPanel();
    JLabel
            drugNameLabel= new JLabel("Drug Name"),
            drugCodeLabel = new JLabel("Drug Code"),
            drugTypeLabel = new JLabel("Drug Type"),
            quantityInNumberLabel = new JLabel("Quantity In Number"),
            priceLabel = new JLabel("Price"),
            drugProductionDateLabel = new JLabel("Drug Production Date"),
            expirationDateLabel = new JLabel("Expiration Date"),
            manufacturerLabel = new JLabel("Manufacturer"),
            drugDoseLabel = new JLabel("Drug Dose");
    public static JTextField drugNameField = new JTextField();
    public static JTextField drugCodeField = new JTextField();
    public static JTextField drugTypeField = new JTextField();

    public static JTextField quantityInNumberField = new JTextField();
    public static JTextField priceField = new JTextField();
    public static JTextField drugProductionDateField = new JTextField();
    public static JTextField expirationDateField = new JTextField();
    public static JTextField manufacturerField = new JTextField();
    public static JTextField drugDoseField = new JTextField();
    JPanel
            drugName = new JPanel(null),
            drugCode = new JPanel(null),
            drugType = new JPanel(null),
            quantityInNumber = new JPanel(null),
            price = new JPanel(null),
            drugProductionDate = new JPanel(null),
            expirationDate = new JPanel(null),
            manufacturer = new JPanel(null),
            drugDose = new JPanel(null);
    JTextField[] fields = {
            drugNameField, drugCodeField, drugTypeField, drugDoseField, quantityInNumberField, priceField,
            drugProductionDateField, expirationDateField, manufacturerField };
    JLabel[] labels = {
            drugNameLabel, drugCodeLabel, drugTypeLabel, drugDoseLabel, quantityInNumberLabel, priceLabel,
            drugProductionDateLabel, expirationDateLabel, manufacturerLabel};
    JPanel[] panels = {
            drugName, drugCode, drugType, drugDose, quantityInNumber, price,
            drugProductionDate, expirationDate, manufacturer};
    public AddNewDrug(){
        setLayout(new BorderLayout());
        JPanel middle = new JPanel(new GridLayout(6, 2, 32, 20));
        for(int i = 0; i<9; i++){
            labels[i].setBounds(0, 0, 340, 21);
            fields[i].setBounds(0, 25, 340, 38);
            fields[i].setBackground(new Color(227, 235, 243));
            fields[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0,0,0,40)),
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
        SaveDrugButton save = new SaveDrugButton(this);
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