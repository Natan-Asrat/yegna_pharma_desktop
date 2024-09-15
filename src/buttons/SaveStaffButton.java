package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;
import main.DbFunctions;
import pages.AddNewDrug;
import pages.AddNewStaff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveStaffButton extends JButton implements Guide, ActionListener {
    JPanel parent;
    public SaveStaffButton(JPanel parent){
        this.parent = parent;
        setForeground(Color.white);
        addActionListener(this);
        setBackground(SAVE_BUTTON_DRUG_COLOR);
        setPreferredSize(SAVE_BUTTON_DRUG_DIMENSION);
        setBorder(null);
        setText("Add");

        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = AddNewStaff.userIDField.getText();
        String employeeRole = AddNewStaff.employeeRoleField.getText();
        String firstName = AddNewStaff.firstNameField.getText();
        String lastName = AddNewStaff.lastNameField.getText();
        String phoneNumber = AddNewStaff.phoneNumberField.getText();
        String dateOfBirth = AddNewStaff.dateOfBirthField.getText();
        String salary = AddNewStaff.salaryField.getText();
        String companyID = AddNewStaff.companyIDField.getText();
//        String dose = AddNewDrug.drugDoseField.getText();

        if(userID.equals("")){
            return;
        }
        if(phoneNumber.equals("")){
            phoneNumber = "0";
        }
        if (lastName.equals("")){
            lastName = "0";
        }
        if(companyID.equals("")){
            companyID = "0";
        }
        if(salary.equals("")){
            salary = "0";
        }

        String query = String.format(
                """
                INSERT INTO Employee values(%s,'%s','%s','%s',%s,'%s', %s, %s, false)
                """,
                userID, employeeRole,  firstName, lastName, phoneNumber, dateOfBirth, salary, companyID
        );

        DbFunctions.insertData(query);

        SideMiddle.updateSelected(Constants.SELECT_SETTINGS);
        BodyMain.c.show(BodyMain.card, "specD");
    }
}
