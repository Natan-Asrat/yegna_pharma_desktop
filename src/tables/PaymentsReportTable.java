package tables;
import java.awt.*;

public class PaymentsReportTable extends InheritTable {

    public PaymentsReportTable(){

        size = new Dimension(944, 338);
        recordsPerPage = 8;
        setupTable();
        String query = """
                 SELECT
                    Drug_Name AS "Drug Name",
                    Drug_Code AS "Drug Code",
                    Drug_Type AS "Drug Type",
                    Quantity AS "Stock in Qty"
                FROM Drugs""";

//                WHERE
//                    Drug_Name LIKE %""" + drugNameInput + """
//                    OR Drug_Code LIKE %""" + drugCodeInput +
//                "OFFSET " + ((page-1)*recordsPerPage) + " ROWS " +
//                "FETCH NEXT " + recordsPerPage + " ROWS ONLY"
//                ;
        updatePage(query, page);
    }

}