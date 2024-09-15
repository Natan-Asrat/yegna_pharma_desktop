package navigationBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import interfaces.*;
import layouts.BodyMain;
import layouts.SideMiddle;
import main.DbFunctions;

public class RevenueBox extends JPanel implements Constants, MouseListener {
    String boxName = "Revenue";
    JLabel boxValue = new JLabel("Birr 0.00");
    String buttonText = "View Detailed Report >>";
    String iconFilename = "resources/boxIcons/revenue_box.png";
    Color themeColor = Guide.REVENUE_BOX_BACKGROUND;
    Color buttonColor = Guide.REVENUE_CTA_BACKGROUND;

    public RevenueBox(boolean isLong, boolean isWide) {
        String query = """
                SELECT SUM(Price) AS Revenue FROM Drugs, Employee_Drugs 
                WHERE Drugs.Drug_code = Employee_Drugs.Drug_code
                AND Quantity > 0
                """;
        try{
            ResultSet data = DbFunctions.getData(query);
            if(data.next()){
                boxValue.setText("Birr "+data.getString(1));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        addMouseListener(this);

        setBackground(Color.white);
//        setPreferredSize(interfaces.Guide.NAVIGATION_BOX_SMALL);
        setBorder(BorderFactory.createLineBorder(themeColor));

//        navigationBoxes.NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, false, false);
        setLayout(new BorderLayout());

        add(NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, isLong, isWide));

//
//        add(navigationBoxes.NavigationBoxes.aboveCTA, BorderLayout.NORTH);
//        add(navigationBoxes.NavigationBoxes.CTA, BorderLayout.SOUTH);
    }

    public RevenueBox() {
        this(false, false);
    }

    public void setBoxValue(String value) {
        this.boxValue.setText(value);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_REPORTS);
        BodyMain.c.show(BodyMain.card, "pay");
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

