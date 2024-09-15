package pages;

import interfaces.*;
import layouts.*;
import tables.TableAndFilter;

import javax.swing.*;
import java.awt.*;

public class DrugShortagePage extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    BodyHeading bodyHeading = new BodyHeading("Inventory  >  ", "Drug Shortage");

//    JScrollPane table = new JScrollPane();
    String[] options = {"General Medicine", "Diabetes"};

    public DrugShortagePage() {
        midAndHeader.setLayout(new BorderLayout());

        JPanel container = new JPanel();

        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
//        midAndHeader.add(new TableAndFilter(table, options, 3), BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);

        container.add(midAndHeader);
        add(container, BorderLayout.WEST);
    }
}
