package tables;
import layouts.BodyMain;
import pages.SpecificDrug;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListOfDrugsTable extends InheritTable implements MouseListener {
    public String query = """
                SELECT
                    Drug_Name AS "Drug Name",
                    Drug_Code AS "Drug Code",
                    Drug_Type AS "Drug Type",
                    Quantity AS "Stock in Qty"
                FROM Drugs
                ORDER BY Drug_Name
                """;
    public ListOfDrugsTable(){
        size = new Dimension(944, 338);
        recordsPerPage = 8;
        setupTable();
        table.addMouseListener(this);

//                WHERE                WHERE Is_Deleted = 'false'
//                    Drug_Name LIKE %""" + drugNameInput + """
//                    OR Drug_Code LIKE %""" + drugCodeInput +
//                "OFFSET " + ((page-1)*recordsPerPage) + " ROWS " +
//                "FETCH NEXT " + recordsPerPage + " ROWS ONLY"
//                ;
        updatePage(query, page);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String drugCode = (String) table.getValueAt(table.getSelectedRow(), 1);
        SpecificDrug.specifyDrugCode = drugCode;
        SpecificDrug.update();
        BodyMain.c.show(BodyMain.card, "spD");
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