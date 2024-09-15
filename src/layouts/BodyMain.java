package layouts;

import interfaces.*;

import javax.swing.*;
import java.awt.*;
import main.*;

public class BodyMain extends JPanel implements Constants, Guide, Pages {
    static GroupMembers members = new GroupMembers();
    public static JPanel card = new JPanel();
    public static CardLayout c;

    BodyMain() {
        setLayout(new BorderLayout());

        card.setLayout(new CardLayout());
        card.add(DASHBOARD, "dash");
        card.add(INVENTORY, "inv");
        card.add(REPORTS, "rep");
        card.add(SETTINGS, "set");
        card.add(CONTACT, "con");
        card.add(LO_DRUGS, "lod");
        card.add(ADD_DRUG, "addD");
        card.add(SPECIFIC_DRUG, "spD");
        card.add(BUY_SELL, "buy");
        card.add(NEARING_EXPIRY, "nea");
        card.add(PAYMENTS_REPORT, "pay");
        card.add(ORDERS_REPORT, "ord");
        card.add(ADD_ORDER, "addO");
        card.add(MY_PROFILE, "myp");
        card.add(DRUG_SHORTAGE, "dshort");
        card.add(EMPLOYEES_PAGE, "emp");
        card.add(ADD_STAFF, "staf");


        c = (CardLayout) card.getLayout();
        c.show(card, "dash");

        setMinimumSize(BODY_MAIN_SMALL);

        JPanel container = new JPanel();
        card.setOpaque(false);
        container.add(card);
        container.setOpaque(false);

        add(card, BorderLayout.CENTER);
        add(members, BorderLayout.EAST);
    }

}