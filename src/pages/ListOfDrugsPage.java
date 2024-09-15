package pages;

import buttons.AddDrugButton;
import interfaces.*;
import layouts.*;
import tables.InheritTable;
import tables.ListOfDrugsTable;
import tables.TableAndFilter;

import javax.swing.*;
import java.awt.*;

public class ListOfDrugsPage extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    BodyHeading bodyHeading;

    JPanel button = new JPanel();
    JPanel table = new JPanel();
    String[] options = {"General Medicine", "Diabetes"};
    public static ListOfDrugsTable list = new ListOfDrugsTable();
    public ListOfDrugsPage(){
        button.add(new AddDrugButton());
        bodyHeading = new BodyHeading("Inventory  >  ", "List of Drugs", button);

        table.setOpaque(false);
        table.add(list);
        midAndHeader.setLayout(new BorderLayout());

        JPanel container = new JPanel();

        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(new TableAndFilter(table, options), BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);

        container.add(midAndHeader);
        add(container, BorderLayout.WEST);
    }
}
