package pages;

import buttons.AddDrugButton;
import buttons.DetailsButton;
import buttons.ListOfDrugsButtonBlack;
import interfaces.*;
import layouts.*;
import navigationBoxes.*;
import tables.InventoryTable;

import javax.swing.*;
import java.awt.*;

public class InventoryPage extends JPanel implements Constants, Guide {
    JPanel midAndHeader = new JPanel();
    BodyHeading bodyHeading = new BodyHeading("", "Inventory");
    JPanel table = new JPanel();
    public static InventoryStatusBox inventoryStatusBox = new InventoryStatusBox();
    public static DrugShortageBox drugShortageBox = new DrugShortageBox();
    public static NearingExpiryBox nearingExpiryBox = new NearingExpiryBox();
    public static DrugsAvailableBox drugsAvailableBox = new DrugsAvailableBox();

    public InventoryPage(){
        table.setBackground(Color.white);

        setLayout(new BorderLayout());
        JPanel middle = new JPanel();

        table.setOpaque(false);
        table.add(new InventoryTable());

        table.setBounds(252, 0, 607,194);

        ListOfDrugsButtonBlack loDrugs = new ListOfDrugsButtonBlack();
        loDrugs.setBounds(249, 281, 212, 46);

        AddDrugButton addDrug = new AddDrugButton();
        addDrug.setBounds(249, 341,162 ,46);

        DetailsButton details = new DetailsButton();
        details.setBounds(749,281,194, 46);


        drugShortageBox.setBounds(0, 22, 212, 152);
        nearingExpiryBox.setBounds(515, 260, 212,152);
        drugsAvailableBox.setBounds(0, 260, 212, 152);

        middle.setLayout(null);

        middle.add(drugShortageBox);
        middle.add(drugsAvailableBox);
        middle.add(details);
        middle.add(loDrugs);
        middle.add(addDrug);
        middle.add(table);
        middle.add(nearingExpiryBox);
        middle.setPreferredSize(new Dimension(944, 524));

        midAndHeader.setLayout(new BorderLayout());
        midAndHeader.setBorder(BODY_MIDDLE_PADDING);
        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(middle, BorderLayout.CENTER);

        add(midAndHeader, BorderLayout.WEST);

    }
}
