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

public class EmployeesBox extends JPanel implements Constants, MouseListener {
    String boxName = "Employees";
    JLabel boxValue = new JLabel("0");
    String buttonText = "View Employees >>";
    String iconFilename = "resources/boxIcons/employees_box.png";
    Color themeColor = Guide.EMPLOYEES_BOX_BACKGROUND;
    Color buttonColor = Guide.EMPLOYEES_CTA_BACKGROUND;

    public EmployeesBox(boolean isLong, boolean isWide) {
        String query = """
                SELECT COUNT(User_Id) FROM Employee
                """;
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

//        navigationBoxes.NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, false, false);
        setLayout(new BorderLayout());

        add(NavigationBoxes.newBoxElements(boxName, boxValue, buttonText, iconFilename, buttonColor, isLong, isWide));

//
//        add(navigationBoxes.NavigationBoxes.aboveCTA, BorderLayout.NORTH);
//        add(navigationBoxes.NavigationBoxes.CTA, BorderLayout.SOUTH);
    }

    EmployeesBox() {
        this(false, false);
    }

    public void setBoxValue(String value) {
        this.boxValue.setText(value);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_REPORTS);
        BodyMain.c.show(BodyMain.card, "set");
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

