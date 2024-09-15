package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;
import main.DbFunctions;
import pages.AddNewDrug;
import pages.ListOfDrugsPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveDrugButton extends JButton implements Guide, ActionListener {
    JPanel parent;
    public SaveDrugButton(JPanel parent){
        this.parent = parent;
        setForeground(Color.white);
        addActionListener(this);
        setBackground(ADD_ORDER_BUTTON_COLOR);
        setPreferredSize(SAVE_BUTTON_DRUG_DIMENSION);
        setBorder(null);
        setText("Save");

        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String drugName = AddNewDrug.drugNameField.getText();
        String drugCode = AddNewDrug.drugCodeField.getText();
        String drugType = AddNewDrug.drugTypeField.getText();
        String quantity = AddNewDrug.quantityInNumberField.getText();
        String price = AddNewDrug.priceField.getText();
        String productionDate = AddNewDrug.drugProductionDateField.getText();
        String expirationDate = AddNewDrug.expirationDateField.getText();
        String manufacturer = AddNewDrug.manufacturerField.getText();
        String dose = AddNewDrug.drugDoseField.getText();

        if(drugCode.equals("")){
            return;
        }
        if(price.equals("")){
            price = "0";
        }
        if (quantity.equals("")){
            quantity = "0";
        }
        if(productionDate.equals("")){
            productionDate = "2023-2-7";
        }
        if(expirationDate.equals("")){
            expirationDate = "2023-2-7";
        }

        String query = String.format(
                """
                INSERT INTO Drugs values(%s,'%s','%s','%s',%s,%s,'%s','%s', false);
                INSERT INTO Expiry values(%s, '%s');
                """,
                drugCode, drugName, drugType, manufacturer, quantity, price, dose, productionDate,
                drugCode, expirationDate
        );

        DbFunctions.insertData(query);
        String listQuery = """
                SELECT
                    Drug_Name AS "Drug Name",
                    Drug_Code AS "Drug Code",
                    Drug_Type AS "Drug Type",
                    Quantity AS "Stock in Qty"
                FROM Drugs
                ORDER BY Drug_Name
                """;
        ListOfDrugsPage.list.updatePage(listQuery, 1);


//        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "specD");
    }
}
