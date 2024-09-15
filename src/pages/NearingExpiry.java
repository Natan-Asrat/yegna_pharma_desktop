package pages;

import interfaces.*;
import layouts.*;
import tables.InheritTable;
import tables.NearingExpiryTable;
import tables.TableAndFilter;

import javax.swing.*;
import java.awt.*;

public class NearingExpiry extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    BodyHeading bodyHeading = new BodyHeading("Inventory  >  ", "Nearing Expiry");

    JPanel table = new JPanel();
    String[] options = {"General Medicine", "Diabetes"};
    public NearingExpiry(){
        midAndHeader.setLayout(new BorderLayout());

        JPanel container = new JPanel();


        table.setOpaque(false);
        table.add(new NearingExpiryTable()) ;
        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(new TableAndFilter(table, options), BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);

        container.add(midAndHeader);
        add(container, BorderLayout.WEST);
    }

}
