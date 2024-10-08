package interfaces;

import java.awt.*;

public interface Colors {
    Color MAIN_GRAY = new Color(227, 235, 243);
    Color MAIN_GRAY_LIGHT = new Color(227, 235, 243, 150);

    Color SIDE_BAR_DARK = new Color(30, 36, 60);
    Color SIDE_BAR_LIGHT = new Color(40, 51, 66);
    Color REVENUE_BOX_BACKGROUND = new Color(254, 214, 0);
    Color INVENTORY_STATUS_BOX_BACKGROUND = new Color(1, 167, 104);
    Color DRUGS_AVAILABLE_BOX_BACKGROUND = new Color(3, 169, 245);
    Color DRUG_SHORTAGE_BOX_BACKGROUND = new Color(240, 72, 62);
    Color NEARING_EXPIRY_BOX_BACKGROUND = DRUG_SHORTAGE_BOX_BACKGROUND;
    Color ORDERS_BOX_BACKGROUND = new Color(45, 212, 122);
    Color EMPLOYEES_BOX_BACKGROUND = new Color(38, 84, 202);
    Color PAYMENT_BOX_BACKGROUND = INVENTORY_STATUS_BOX_BACKGROUND;

    Color REVENUE_CTA_BACKGROUND = new Color(254, 214, 0, 80);

    Color INVENTORY_STATUS_CTA_BACKGROUND = new Color(1, 167, 104, 80);
    Color DRUGS_AVAILABLE_CTA_BACKGROUND = new Color(3, 169, 245, 80);
    Color DRUG_SHORTAGE_CTA_BACKGROUND = new Color(240, 72, 62, 80);
    Color DASHBOARD_FOOTER_BACKGROUND = new Color(240, 72, 62, 25);

    Color NEARING_EXPIRY_CTA_BACKGROUND = DRUG_SHORTAGE_CTA_BACKGROUND;
    Color ORDERS_CTA_BACKGROUND = new Color(45, 212, 122, 80);
    Color EMPLOYEES_CTA_BACKGROUND = new Color(38, 84, 202, 80);
    Color PAYMENT_CTA_BACKGROUND = INVENTORY_STATUS_CTA_BACKGROUND;
    Color SEARCH_TEXT_COLOR = new Color(29, 36, 46);
    Color SELECTED_SIDE_BAR_COLOR = new Color(0, 143, 153);
    Color PROFILE_ROLE_COLOR = new Color(254,234, 0);
    Color TEXT_FIELD_COLOR = new Color(227, 235, 243);
    Color DELETE_BUTTON_COLOR = new Color(240, 72, 62);
//    Color DELETE_BUTTON_BACKGROUND = new Color(240, 72, 62, 120);

    Color BUY_SELL_BUTTON_COLOR = new Color(250, 93, 93);

    Color ADD_ORDER_BUTTON_COLOR = new Color(46, 212, 122);
    Color SAVE_BUTTON_DRUG_COLOR = DELETE_BUTTON_COLOR;
    Color SAVE_BUTTON_ORDER_COLOR = ADD_ORDER_BUTTON_COLOR;
    Color EDIT_DETAILS_DRUG_BUTTON = new Color(3, 169, 245);
    Color ADD_STAFF_BUTTON_COLOR = new Color(66, 105, 209);
    Color LIST_DRUGS_BUTTON_COLOR = new Color(29,36,46);

    Color BUY_BUTTON_COLOR = ADD_ORDER_BUTTON_COLOR;
    Color SELL_BUTTON_COLOR = DELETE_BUTTON_COLOR;
    Color TABLE_HEADER_COLOR = new Color(30, 30,30);
    Color TABLE_ROW_LIGHT_COLOR = new Color(50, 50,50);

    Color TABLE_HEADER_FOREGROUND = new Color(200, 200, 200);
}
