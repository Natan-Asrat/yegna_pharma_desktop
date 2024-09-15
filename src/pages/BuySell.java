package pages;

import buttons.AddDrugButton;
import buttons.ListOfDrugsButtonBlack;
import interfaces.*;
import layouts.*;
import navigationBoxes.*;
import tables.BuySellTable;

import javax.swing.*;
import java.awt.*;

public class BuySell extends JPanel implements Guide, Constants {
    BodyHeading bodyHeading = new BodyHeading("Inventory  >  ", "Buy/Sell");
    JPanel midAndHeader = new JPanel();
    JPanel table = new JPanel();
    JLabel
            drugNameLabel = new JLabel("Drug Name"),
            drugCodeLabel = new JLabel("Drug Code"),
            quantityLabel = new JLabel("Quantity in Number"),
            showingResults =  new JLabel("");

    public static JTextField drugNameField = new JTextField();
    public static JTextField drugCodeField = new JTextField();
    public static JTextField quantityField = new JTextField();
    JButton buyButton = new JButton("Buy"),
            sellButton = new JButton("Sell"),
            loDrugs = new ListOfDrugsButtonBlack(),
            addDrug = new AddDrugButton();
    public static DrugShortageBox drugShortage = new DrugShortageBox();
    public static NearingExpiryBox nearingExpiry = new NearingExpiryBox();


    public BuySell(){
        setLayout(new BorderLayout());

        table.add(new BuySellTable());
        table.setOpaque(false);
        buyButton.setBorder(null);
        sellButton.setBorder(null);
        buyButton.setForeground(Color.white);
        sellButton.setForeground(Color.white);
        buyButton.setFont(POPPINS_BOLD_MEDIUM);
        sellButton.setFont(POPPINS_BOLD_MEDIUM);

        JPanel middle = new JPanel(null);
        drugNameLabel.setBounds(0, 0, 340, 21);
        drugCodeLabel.setBounds(0, 83, 340, 21);
        quantityLabel.setBounds(0, 166, 340, 21);
        loDrugs.setBounds(0, 487, 212, 46);
        addDrug.setBounds(264, 487, 162, 46);
        table.setBounds(0, 273, 607, 194);
        showingResults.setBounds(0, 240, 607, 21);
        drugShortage.setBounds(707, 62, 212, 152);
        nearingExpiry.setBounds(707, 259, 212, 152);


        drugNameField.setBounds(0, 25, 340, 38);
        drugCodeField.setBounds(0, 108, 340, 38);
        quantityField.setBounds(0, 191, 340, 38);

        drugNameField.setBackground(new Color(227, 235, 243));
        drugCodeField.setBackground(new Color(227, 235, 243));
        quantityField.setBackground(new Color(227, 235, 243));

        drugNameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 40)),
                BorderFactory.createEmptyBorder(0, 15, 0, 15)
        ));
        drugCodeField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 40)),
                BorderFactory.createEmptyBorder(0, 15, 0, 15)
        ));
        quantityField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 40)),
                BorderFactory.createEmptyBorder(0, 15, 0, 15)
        ));

        drugNameField.setFont(ROBOTO_PLAIN_MEDIUM);
        drugCodeField.setFont(ROBOTO_PLAIN_MEDIUM);
        quantityField.setFont(ROBOTO_PLAIN_MEDIUM);

        buyButton.setBounds(395, 62, 212, 46);
        sellButton.setBounds(395, 146, 212, 46);

        buyButton.setBackground(BUY_BUTTON_COLOR);
        sellButton.setBackground(SELL_BUTTON_COLOR);

        middle.add(drugNameField);
        middle.add(drugNameLabel);
        middle.add(drugCodeField);
        middle.add(drugCodeLabel);
        middle.add(quantityField);
        middle.add(quantityLabel);
        middle.add(buyButton);
        middle.add(sellButton);
        middle.add(table);
        middle.add(showingResults);
        middle.add(drugShortage);
        middle.add(nearingExpiry);
        middle.add(loDrugs);
        middle.add(addDrug);

        middle.setPreferredSize(new Dimension(923, 604));

        midAndHeader.setLayout(new BorderLayout());

        JPanel container = new JPanel();

        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(middle, BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);
        container.setPreferredSize(BODY_MAIN);
        container.add(midAndHeader);
        add(container, BorderLayout.CENTER);
    }

}
