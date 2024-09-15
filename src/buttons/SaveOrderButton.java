package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;
import main.DbFunctions;
import pages.AddNewDrug;
import pages.AddNewOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveOrderButton extends JButton implements Guide, ActionListener {
    public SaveOrderButton(){
        setForeground(Color.white);
        addActionListener(this);
        setBackground(SAVE_BUTTON_ORDER_COLOR);
        setPreferredSize(SAVE_BUTTON_ORDER_DIMENSION);
        setBorder(null);
        setText("Save");

        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String employeeID = AddNewOrder.employeeIDField.getText();
        String quantity = AddNewOrder.quantityField.getText();
        String drugCode = AddNewOrder.drugCodeField.getText();

        if(drugCode.equals("")){
            return;
        }
        if(employeeID.equals("")){
            return;
        }
        if (quantity.equals("")){
            quantity = "0";
        }

        String query = String.format(
                """
                INSERT INTO Employee_Drugs values(%s,%s, '%s', 'SELL',false);
                """,
                employeeID, drugCode, quantity, employeeID+quantity+drugCode
        );

        DbFunctions.insertData(query);

//        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
//        BodyMain.c.show(BodyMain.card, "addO");
    }
}
