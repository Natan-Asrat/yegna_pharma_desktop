package tables;
import layouts.BodyMain;
import pages.SpecificDrug;
import interfaces.Guide;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StaffList extends InheritTable implements MouseListener {
    public StaffList(){
        size = Guide.SETTINGS_STAFF;
        recordsPerPage = 10;
        setupTable();
        table.addMouseListener(this);
        String query = """
                SELECT
                    CONCAT(First_name, Last_name) AS "Full Name",
                    Employee_role AS "Role"
                FROM Employee
                ORDER BY Employee_role
                """;
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