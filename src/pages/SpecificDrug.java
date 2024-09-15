package pages;

import buttons.EditDrugButton;
import interfaces.*;
import layouts.*;
import main.DbFunctions;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class SpecificDrug extends JPanel implements Guide, Constants {
    static JPanel dashboardFooter = new JPanel();
    static BodyHeading bodyHeading;
    JPanel midAndHeader = new JPanel();
    JButton deleteButton = new JButton("Delete Button");
    JPanel editButton = new JPanel();
    JPanel
            drugInfo = new JPanel(new BorderLayout()),
            quantity = new JPanel(new BorderLayout()),
            dates = new JPanel(new BorderLayout()),
            price = new JPanel(new BorderLayout()),
            doseInfo = new JPanel(new BorderLayout()),
            drugCode = new JPanel(),
            drugName = new JPanel(),
            drugType = new JPanel(),
            manufacturer = new JPanel(),
            lifeTimeSales = new JPanel(),
            stockLeft = new JPanel(),
            expirationDate = new JPanel(),
            productionDate = new JPanel(),
            pricePanel = new JPanel();
    JLabel
            drugInfoLabel = new JLabel("Drug");
    JLabel quantityLabel = new JLabel("Inventory");
    JLabel datesLabel = new JLabel("Dates");
    JLabel priceLabel = new JLabel("Price");
    JLabel doseInfoLabel = new JLabel("Drug Dose");
    JLabel drugCodeLabel = new JLabel("Drug Code");
    JLabel drugNameLabel = new JLabel("Drug Name");
    JLabel drugTypeLabel = new JLabel("Drug Type");
    JLabel manufacturerLabel = new JLabel("Manufacturer");
    JLabel lifeTimeSalesLabel = new JLabel("Lifetime Sales");
    JLabel stockLeftLabel = new JLabel("Stock Left");
    JLabel expirationDateLabel = new JLabel("Expiration Date");
    JLabel productionDateLabel = new JLabel("Drug Production Date");
    static JLabel drugCodeValue = new JLabel();
    static JLabel drugNameValue = new JLabel();
    static JLabel drugTypeValue = new JLabel();
    static JLabel manufacturerValue = new JLabel();
    JLabel lifeTimeSalesValue = new JLabel();
    static JLabel stockLeftValue = new JLabel();
    static JLabel expirationDateValue = new JLabel();
    static JLabel productionDateValue = new JLabel();
    static JLabel priceValue = new JLabel();
    static JLabel drugDoseValue = new JLabel();


    JPanel[] valuePanels = {
            drugCode,
            drugName,
            drugType ,
            manufacturer ,
            lifeTimeSales ,
            stockLeft,
            expirationDate,
            productionDate,
            price
    };

    JLabel[] valueLabels = {
            drugCodeLabel,
            drugNameLabel,
            drugTypeLabel ,
            manufacturerLabel ,
            lifeTimeSalesLabel ,
            stockLeftLabel,
            expirationDateLabel,
            productionDateLabel
    };
    JLabel[] values = {
            drugCodeValue,
            drugNameValue,
            drugTypeValue ,
            manufacturerValue ,
            lifeTimeSalesValue ,
            stockLeftValue,
            expirationDateValue,
            productionDateValue,
            priceValue,
            drugDoseValue
    };
    public static String specifyDrugCode = "0001";
    static String specifyDrugName;
    public SpecificDrug(){
        for(int i = 0; i < 8; i++){
            valuePanels[i].setLayout(new BorderLayout());
            valuePanels[i].setBorder(BorderFactory.createEmptyBorder(15, 24, 15,0));
            values[i].setFont(POPPINS_BOLD_L);
            values[i].setVerticalAlignment(SwingConstants.TOP);
            valueLabels[i].setBorder(BorderFactory.createEmptyBorder());
            valueLabels[i].setFont(POPPINS_PLAIN_SMALL);
            valuePanels[i].add(values[i], BorderLayout.NORTH);
            valuePanels[i].add(valueLabels[i], BorderLayout.SOUTH);
            valuePanels[i].setPreferredSize(SPECIFIC_DRUG_LABELS_WIDE);
            valuePanels[i].setOpaque(false);
        }

        expirationDate.setPreferredSize(SPECIFIC_DRUG_LABELS_LONG);
        productionDate.setPreferredSize(SPECIFIC_DRUG_LABELS_LONG);

        pricePanel.setLayout(new BorderLayout());
        pricePanel.setOpaque(false);
        pricePanel.setBorder(BorderFactory.createEmptyBorder(0, 24, 0,0));
        priceValue.setFont(POPPINS_BOLD_LARGE);
        pricePanel.add(priceValue);
        pricePanel.setPreferredSize(SPECIFIC_DRUG_LABELS_SMALL);



        drugInfoLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MAIN_GRAY_LIGHT),
                BorderFactory.createEmptyBorder(0,24,0,0)
        ));
        quantityLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MAIN_GRAY_LIGHT),
                BorderFactory.createEmptyBorder(0,24,0,0)

        ));
        datesLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MAIN_GRAY_LIGHT),
                BorderFactory.createEmptyBorder(0,24,0,0)

        ));
        doseInfoLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MAIN_GRAY_LIGHT),
                BorderFactory.createEmptyBorder(0,24,0,0)

        ));
        priceLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MAIN_GRAY_LIGHT),
                BorderFactory.createEmptyBorder(0,24,0,0)

        ));

        drugInfoLabel.setPreferredSize(SPECIFIC_DRUG_LABELS_WIDE);
        quantityLabel.setPreferredSize(SPECIFIC_DRUG_LABELS_WIDE);
        datesLabel.setPreferredSize(SPECIFIC_DRUG_LABELS_WIDE);
        doseInfoLabel.setPreferredSize(SPECIFIC_DRUG_LABELS_WIDE);
        priceLabel.setPreferredSize(SPECIFIC_DRUG_LABELS_SMALL);


        editButton.add(new EditDrugButton());
        getRecord(specifyDrugCode);
        bodyHeading = new BodyHeading("Inventory  >  List of Drugs  >  ", specifyDrugName, editButton);
        setLayout(new BorderLayout());

        deleteButton.setBackground(Color.white);
        deleteButton.setBorder(DELETE_BUTTON_BORDER);
        deleteButton.setForeground(DELETE_BUTTON_COLOR);

        drugInfo.setBackground(Color.white);
        drugInfo.setBorder(BorderFactory.createLineBorder(MAIN_GRAY));
        quantity.setBackground(Color.white);
        dates.setBackground(Color.white);
        price.setBackground(Color.white);
        doseInfo.setBackground(Color.white);

        drugInfo.add(drugInfoLabel, BorderLayout.NORTH);
        drugInfo.add(drugCode, BorderLayout.CENTER);
        drugInfo.add(drugName, BorderLayout. SOUTH);
        drugInfoLabel.setLayout(null);
        drugInfo.setBounds(0,0, 456, 210);

        quantity.add(quantityLabel, BorderLayout.NORTH);
        quantity.setBorder(BorderFactory.createLineBorder(MAIN_GRAY));
        JPanel container = new JPanel(new BorderLayout());
        lifeTimeSales.setPreferredSize(new Dimension(228, 70));
        lifeTimeSales.setOpaque(false);
        stockLeft.setPreferredSize(new Dimension(228, 70));
        stockLeft.setOpaque(false);
        container.setOpaque(false);
        container.add(lifeTimeSales, BorderLayout.WEST);
        container.add(stockLeft, BorderLayout.EAST);
        quantity.add(container, BorderLayout.SOUTH);
        quantityLabel.setLayout(null);
        quantity.setBounds(488, 0, 456, 140);

        dates.setBorder(BorderFactory.createLineBorder(MAIN_GRAY));
        dates.add(datesLabel, BorderLayout.NORTH);
        dates.add(expirationDate, BorderLayout.CENTER);
        dates.add(productionDate, BorderLayout.SOUTH);
        datesLabel.setLayout(null);
        dates.setBounds(488, 193, 189, 220);

        price.setBorder(BorderFactory.createLineBorder(MAIN_GRAY));
        price.add(priceLabel, BorderLayout.NORTH);
        price.add(pricePanel, BorderLayout.WEST);
        priceLabel.setLayout(null);
        price.setBounds(723, 254, 189, 130);

        doseInfo.setBorder(BorderFactory.createLineBorder(MAIN_GRAY));
        drugDoseValue.setBorder(BorderFactory.createEmptyBorder(0, 24, 0,0));
        container = new JPanel(new GridLayout(1, 2, 0,0));
        container.add(doseInfoLabel);
        container.add(drugDoseValue);
        container.setOpaque(false);
        doseInfo.add(container, BorderLayout.SOUTH);
        container = new JPanel(new GridLayout(1, 2, 0,0));
        container.setOpaque(false);
        container.add(drugType);
        container.add(manufacturer);
        doseInfo.add(container, BorderLayout.CENTER);
        doseInfoLabel.setLayout(null);
        doseInfo.setBounds(0, 253, 458, 159);

        deleteButton.setBounds(0, 442, 179, 46);

       JPanel middle = new JPanel();
       middle.setLayout(null);
       middle.add(drugInfo);
       middle.add(quantity);
       middle.add(dates);
       middle.add(price);
       middle.add(doseInfo);
       middle.add(deleteButton);
       middle.setPreferredSize(new Dimension(944, 488));

        midAndHeader.setLayout(new BorderLayout());

        container = new JPanel();

        midAndHeader.add(bodyHeading, BorderLayout.NORTH);
        midAndHeader.add(middle, BorderLayout.WEST);
        midAndHeader.setBorder(Guide.BODY_MIDDLE_PADDING);
//        container.setBorder(BODY_MIDDLE_PADDING);

        container.add(midAndHeader);
        add(container, BorderLayout.WEST);
    }

    static public void getRecord(String drug_code){
        String query = "SELECT * FROM Drugs WHERE drug_code = " + drug_code;
        String expiryQuery = "SELECT * FROM Expiry WHERE product_code = " + drug_code;
        try{
            ResultSet data = DbFunctions.getData(query);
            ResultSet expiryData = DbFunctions.getData(expiryQuery);
            data.next();
            expiryData.next();
            System.out.println("In getRecord, spD");
            specifyDrugName = data.getString(2);
            drugCodeValue.setText(data.getString(1));
            drugNameValue.setText(specifyDrugName) ;
            drugTypeValue.setText(data.getString(3)) ;
            drugDoseValue.setText(data.getString(7));
            manufacturerValue.setText(data.getString(4)) ;
//            lifeTimeSalesValue = data.getString(1),
            stockLeftValue.setText(data.getString(5)) ;
            expirationDateValue.setText(expiryData.getString(2));
            productionDateValue.setText(data.getString(8)) ;
            priceValue.setText(data.getString(6)) ;

            System.out.println("Drug Name: " + specifyDrugName);
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public static void update(){
        getRecord(specifyDrugCode);
        bodyHeading.pageNameLabel.setText(specifyDrugName);

    }

}
