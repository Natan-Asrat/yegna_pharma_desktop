package pages;

import buttons.AddStaffButton;
import interfaces.*;
import layouts.*;
import main.DbFunctions;
import tables.StaffList;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static pages.SpecificDrug.*;

public class SettingsPage extends JPanel implements Guide, Constants {
    BodyHeading bodyHeading;
    JPanel midAndHeader = new JPanel();
    JPanel button = new JPanel();
    JLabel
            companyLabel = new JLabel("Company");
    JLabel ownerLabel = new JLabel("Owner");
    JLabel ownerNameLabel = new JLabel("Owner Name");
    JLabel ownerContactLabel = new JLabel("Owner Contact");
    JLabel pharmacyNameLabel = new JLabel("Pharmacy Name");
    JLabel pharmacyIDLabel = new JLabel("Pharmacy ID");
    static JLabel ownerNameValue = new JLabel();
    static JLabel ownerContactValue = new JLabel();
    static JLabel pharmacyNameValue = new JLabel();
    static JLabel pharmacyIDValue = new JLabel();
    JPanel company = new JPanel();
    JPanel staffTable = new JPanel();
    JPanel owner = new JPanel();
    JPanel ownerName = new JPanel();
    JPanel ownerContact = new JPanel();
    static JPanel pharmacyName = new JPanel();
    static JPanel pharmacyID = new JPanel()
    ;
    private static String getOwnerName(){

        try{
            ResultSet rs = DbFunctions.getData("SELECT first_name, last_name FROM Employee WHERE Employee_Role='Owner';");
            if (rs.next()) {
                String name = rs.getString("first_name") + " " + rs.getString("last_name");
                System.out.println("Owner: " + name);
                return name;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("NO owner");
        return "";
    }
    private static String getOwnerContact(){

        try{
            ResultSet rs = DbFunctions.getData("SELECT Phone_Number FROM Employee WHERE Employee_Role='Owner';");
            if (rs.next()) {
                String num = rs.getString("Phone_Number");
                System.out.println("Owner Contact: " + num);
                return num;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("NO owner");
        return "";
    }

    JLabel[] values = {pharmacyNameValue, pharmacyIDValue,ownerNameValue, ownerContactValue};
    JPanel[] valuePanels = {pharmacyName, pharmacyID,ownerName, ownerContact};
    JLabel[] valueLabels = {pharmacyNameLabel, pharmacyIDLabel,ownerNameLabel, ownerContactLabel};

    public SettingsPage(){
        button.add(new AddStaffButton());
        bodyHeading = new BodyHeading("", "Settings", button);

        staffTable.setOpaque(false);

        company.setBackground(Color.white);
        owner.setBackground(Color.white);
        company.add(companyLabel);
        staffTable.add(new StaffList());

        for(int i = 0; i < 4; i++){
            valuePanels[i].setLayout(new BorderLayout());
            valuePanels[i].setBorder(BorderFactory.createEmptyBorder(15, 24, 15,0));
            values[i].setFont(POPPINS_BOLD_L);
            values[i].setVerticalAlignment(SwingConstants.TOP);
            valueLabels[i].setBorder(BorderFactory.createEmptyBorder());
            valueLabels[i].setFont(POPPINS_PLAIN_SMALL);
            valuePanels[i].add(values[i], BorderLayout.NORTH);
            valuePanels[i].add(valueLabels[i], BorderLayout.SOUTH);
            valuePanels[i].setPreferredSize(SETTINGS_LABELS_WIDE);
            valuePanels[i].setOpaque(false);
        }
        ownerNameValue.setText(getOwnerName());
        refreshPanel();
        companyLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MAIN_GRAY_LIGHT),
                BorderFactory.createEmptyBorder(0,24,0,0)
        ));
        ownerLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MAIN_GRAY_LIGHT),
                BorderFactory.createEmptyBorder(0,24,0,0)
        ));
        companyLabel.setPreferredSize(SETTINGS_LABELS_WIDE);
        ownerLabel.setPreferredSize(SETTINGS_LABELS_WIDE);


        company.add(companyLabel, BorderLayout.NORTH);
        company.setBorder(BorderFactory.createLineBorder(MAIN_GRAY));
        JPanel container = new JPanel(new BorderLayout());
        pharmacyName.setPreferredSize(new Dimension(228, 70));
        pharmacyName.setOpaque(false);
        pharmacyID.setPreferredSize(new Dimension(228, 70));
        pharmacyID.setOpaque(false);
        container.setOpaque(false);
        container.add(pharmacyName, BorderLayout.WEST);
        container.add(pharmacyID, BorderLayout.EAST);
        company.add(container, BorderLayout.SOUTH);

        owner.add(ownerLabel, BorderLayout.NORTH);
        owner.setBorder(BorderFactory.createLineBorder(MAIN_GRAY));
        container = new JPanel(new BorderLayout());
        ownerName.setPreferredSize(new Dimension(228, 70));
        ownerName.setOpaque(false);
        ownerContact.setPreferredSize(new Dimension(228, 70));
        ownerContact.setOpaque(false);
        container.setOpaque(false);
        container.add(ownerName, BorderLayout.WEST);
        container.add(ownerContact, BorderLayout.EAST);
        owner.add(container, BorderLayout.SOUTH);

        company.setPreferredSize(Guide.SETTINGS_BRANDING);
        staffTable.setPreferredSize(Guide.SETTINGS_STAFF);
        owner.setPreferredSize(Guide.SETTINGS_OwNER);

        setLayout(new BorderLayout());

        JPanel middle = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();

        left.setPreferredSize(Guide.SETTINGS_LEFT_SECTION);
        left.setLayout(new BorderLayout());
        left.add(company, BorderLayout.NORTH);
        left.add(staffTable, BorderLayout.SOUTH);

        right.add(owner);

        middle.setLayout(Guide.TWO_COLUMN);
        middle.add(left);
        middle.add(right);

        container = new JPanel();
        midAndHeader.setLayout(new BorderLayout());
        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(middle, BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);

        container.add(midAndHeader);
        add(container, BorderLayout.CENTER);
        update();
        ownerNameValue.setText(getOwnerName());
        ownerContactValue.setText(getOwnerContact());

    }

    static public void getRecord(String drug_code){
        String companyQuery = "SELECT * FROM Company";
        String ownerQuery = "SELECT CONCAT(First_name, Last_name) AS Full_name, Phone_number AS Contact  FROM Employee WHERE Employee_role = 'owner'";
        try{
            ResultSet companyData = DbFunctions.getData(companyQuery);
            ResultSet ownerData = DbFunctions.getData(ownerQuery);
            companyData.next();
            ownerData.next();
            System.out.println("In getRecord, Settings Page");
            pharmacyNameValue.setText(companyData.getString(2));
            pharmacyIDValue.setText(companyData.getString(1));
            ownerNameValue.setText(ownerData.getString(1)) ;
            ownerContactValue.setText(ownerData.getString(2)) ;


            System.out.println("Drug Name: " + specifyDrugName);
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public void refreshPanel() {
        // Example of refreshing the panel
        this.revalidate();
        this.repaint();
    }

    public static void update(){
        getRecord(specifyDrugCode);
    }
}
