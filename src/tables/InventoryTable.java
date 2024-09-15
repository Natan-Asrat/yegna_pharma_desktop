package tables;
import layouts.BodyMain;
import pages.BuySell;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryTable extends InheritTable implements MouseListener {
    public InventoryTable(){
        size = new Dimension(607,194);
        recordsPerPage = 3;
        setupTable();
        table.addMouseListener(this);
        String query = """
                SELECT
                    Drug_Name AS "Drug Name",
                    Drug_Code AS "Drug Code",
                    Quantity AS "Stock in Qty"
                FROM Drugs
                
                ORDER BY Quantity DESC
                """;
//                WHERE WHERE CAST(Is_Deleted, boolean) = 0
//                    Drug_Name LIKE %""" + drugNameInput + """
//                    OR Drug_Code LIKE %""" + drugCodeInput +
//                "OFFSET " + ((page-1)*recordsPerPage) + " ROWS " +
//                "FETCH NEXT " + recordsPerPage + " ROWS ONLY"
//                ;
        updatePage(query, page);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        BodyMain.c.show(BodyMain.card, "nea");
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