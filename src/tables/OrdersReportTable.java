package tables;
import java.awt.*;

public class OrdersReportTable extends InheritTable {
    public String query = """
                SELECT
                    Drug_Name,
                    Drug_Code,
                    Quantity
                FROM Drugs""";
    public OrdersReportTable(){
        size = new Dimension(944, 338);
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

}