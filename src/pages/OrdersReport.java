package pages;

import buttons.AddNewOrderButton;
import interfaces.*;
import layouts.*;
import tables.InheritTable;
import tables.OrdersReportTable;
import tables.TableAndFilter;

import javax.swing.*;
import java.awt.*;

public class OrdersReport extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    JPanel button = new JPanel();
    BodyHeading bodyHeading;
    JPanel table = new JPanel();
    String[] options = new String[10];
    public OrdersReport(){
        button.add(new AddNewOrderButton());
        bodyHeading = new BodyHeading("Reports  >  ", "Orders Report", button);

        table.setOpaque(false);

        String optionsQuery = "SELECT DINSTINCT Date FROM Employee_Drugs";
//        try{
//            ResultSet optionsData = DbFunctions.getData(optionsQuery);
//            for(int i = 0; optionsData.next(); i++) {
//                options[i] = optionsData.getString(i+1);
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }
//
        table.add(new OrdersReportTable());
        midAndHeader.setLayout(new BorderLayout());

        JPanel container = new JPanel();

        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(new TableAndFilter(table, options), BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);

        container.add(midAndHeader);
        add(container, BorderLayout.WEST);
    }
}
