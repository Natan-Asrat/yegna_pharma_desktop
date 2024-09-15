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

public class DrugsAvailableBox extends JPanel implements Constants, MouseListener {
    String boxName = "Drugs Available";
    JLabel boxValue = new JLabel("0");
    String buttonText = "View Full List >>";
    String iconFilename = "resources/boxIcons/drugs_available_box.png";
    Color themeColor = Guide.DRUGS_AVAILABLE_BOX_BACKGROUND;
    Color buttonColor = Guide.DRUGS_AVAILABLE_CTA_BACKGROUND;
    String query = """
                SELECT COUNT(Drug_code) FROM Drugs WHERE Quantity > 0
                """;
    public DrugsAvailableBox() {

        try{
            ResultSet data = DbFunctions.getData(query);
            if(data.next()){
                boxValue.setText(data.getString(1));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        addMouseListener(this);
        setBackground(Color.white);
//        setPreferredSize(interfaces.Guide.NAVIGATION_BOX_SMALL);
        setBorder(BorderFactory.createLineBorder(themeColor));
//
//        navigationBoxes.NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, false, false);
        setLayout(new BorderLayout());

        add(NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, false, false));

//
//        add(navigationBoxes.NavigationBoxes.aboveCTA, BorderLayout.NORTH);
//        add(navigationBoxes.NavigationBoxes.CTA, BorderLayout.SOUTH);
    }

    public void setBoxValue(String value) {
        this.boxValue.setText(value);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "lod");
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
