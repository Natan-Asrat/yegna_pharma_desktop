package tables;
import pages.BuySell;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BuySellTable extends InheritTable implements MouseListener {
    public String query = """
                SELECT
                    Drug_Name AS "Drug Name",
                    Drug_Code AS "Drug Code",
                    Drug_Type AS "Drug Type",
                    Quantity AS "Stock in Qty"
                FROM Drugs""";
    public BuySellTable(){
        size = new Dimension(607, 272);
        table.addMouseListener(this);
        recordsPerPage = 8;
        setupTable();

//                WHERE
//                    Drug_Name LIKE %""" + drugNameInput + """
//                    OR Drug_Code LIKE %""" + drugCodeInput +
//                "OFFSET " + ((page-1)*recordsPerPage) + " ROWS " +
//                "FETCH NEXT " + recordsPerPage + " ROWS ONLY"
//                ;
        updatePage(query, page);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String drugName = (String) table.getValueAt(table.getSelectedRow(), 0);
        String drugCode = (String) table.getValueAt(table.getSelectedRow(), 1);

        BuySell.drugNameField.setText(drugName);
        BuySell.drugCodeField.setText(drugCode);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}