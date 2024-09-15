package pages;

import interfaces.*;
import layouts.*;
import navigationBoxes.*;

import javax.swing.*;
import java.awt.*;

public class EmployeesPage extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    BodyHeading bodyHeading = new BodyHeading("Settings  >  ", "Employees");

    //    layout.BodyHeading inventoryHeader = new layout.BodyHeading();
    public EmployeesPage(){
        setLayout(new BorderLayout());
        JPanel middle = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel bottomLeft = new JPanel();
        JPanel bottomRight = new JPanel();


        middle.setLayout(TWO_ROWS);
        top.setLayout(TWO_COLUMN);
        bottom.setLayout(TWO_COLUMN);
        bottomLeft.setLayout(TWO_COLUMN);
        bottomRight.setLayout(TWO_COLUMN);

        top.add(new DrugShortageBox());
        bottomLeft.add(new DrugsAvailableBox());
        bottomRight.add(new NearingExpiryBox());

        midAndHeader.setLayout(new BorderLayout());
        midAndHeader.setBorder(BODY_MIDDLE_PADDING);

        bottom.add(bottomLeft);
        bottom.add(bottomRight);

        middle.add(top);
        middle.add(bottom);


        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(middle, BorderLayout.CENTER);

        add(midAndHeader, BorderLayout.WEST);


    }

}
