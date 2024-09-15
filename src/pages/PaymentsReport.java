package pages;

import interfaces.*;
import layouts.*;
import tables.InheritTable;
import tables.PaymentsReportTable;
import tables.TableAndFilter;

import javax.swing.*;
import java.awt.*;

public class PaymentsReport extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    BodyHeading bodyHeading = new BodyHeading("Reports  >  ", "Payments Report");

    //    layout.BodyHeading inventoryHeader = new layout.BodyHeading();
    JPanel table = new JPanel();
    String[] options = {"General Medicine", "Diabetes"};

    public PaymentsReport(){
        midAndHeader.setLayout(new BorderLayout());

        table.setOpaque(false);
        table.add(new PaymentsReportTable());

        JPanel container = new JPanel();

        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(new TableAndFilter(table, options), BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);

        container.add(midAndHeader);
        add(container, BorderLayout.WEST);

    }
}
