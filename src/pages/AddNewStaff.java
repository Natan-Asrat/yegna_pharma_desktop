package pages;

import buttons.SaveDrugButton;
import buttons.SaveStaffButton;
import interfaces.*;
import layouts.*;

import javax.swing.*;
import java.awt.*;

public class AddNewStaff extends JPanel implements Guide, Constants {
    static JPanel save = new JPanel(new FlowLayout(FlowLayout.LEFT));
    BodyHeading bodyHeading = new BodyHeading("Settings  >  ", "Add New Staff");
    JPanel midAndHeader = new JPanel();
    JLabel
            userIDLabel = new JLabel("User ID"),
            employeeRoleLabel = new JLabel("Employee Role"),
            firstNameLabel = new JLabel("First Name"),
            lastNameLabel = new JLabel("Last Name"),
            phoneNumberLabel = new JLabel("Phone Number"),
            dateOfBirthLabel = new JLabel("Date of Birth"),
            salaryLabel = new JLabel("Salary"),
            companyIDLabel = new JLabel("Company ID");
//            drugDoseLabel = new JLabel("Drug Dose");
    public static JTextField userIDField = new JTextField();
    public static JTextField employeeRoleField = new JTextField();
    public static JTextField firstNameField = new JTextField();

    public static JTextField lastNameField = new JTextField();
    public static JTextField phoneNumberField = new JTextField();
    public static JTextField dateOfBirthField = new JTextField();
    public static JTextField salaryField = new JTextField();
    public static JTextField companyIDField = new JTextField();
//    public static JTextField drugDoseField = new JTextField();
    JPanel
            userID = new JPanel(null),
            employeeRole = new JPanel(null),
            firstName = new JPanel(null),
            lastName = new JPanel(null),
            phoneNumber = new JPanel(null),
            dateOfBirth = new JPanel(null),
            salary = new JPanel(null),
            companyID = new JPanel(null);
//            drugDose = new JPanel(null);
    JTextField[] fields = {
        userIDField, employeeRoleField, firstNameField, lastNameField, phoneNumberField,
        dateOfBirthField, salaryField, companyIDField};
    JLabel[] labels = {
            userIDLabel, employeeRoleLabel, firstNameLabel, lastNameLabel, phoneNumberLabel,
            dateOfBirthLabel, salaryLabel, companyIDLabel};
    JPanel[] panels = {
            userID, employeeRole, firstName, lastName, phoneNumber,
            dateOfBirth, salary, companyID};
    public AddNewStaff(){
        setLayout(new BorderLayout());
        JPanel middle = new JPanel(new GridLayout(6, 2, 32, 20));
        for(int i = 0; i<8; i++){
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
//        middle.add(new JPanel());
        JPanel container = new JPanel(null);
        SaveStaffButton save = new SaveStaffButton(this);
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