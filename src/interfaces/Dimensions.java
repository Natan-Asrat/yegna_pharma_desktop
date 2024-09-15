package interfaces;

import java.awt.*;

public interface Dimensions {
    Dimension JFRAME_SIZE = new Dimension(1280, 720);
    Dimension SIDE_BAR_MAIN = new Dimension(256, 720);
    Dimension SIDE_BAR_TOP = new Dimension(256, 60);
    Dimension SEARCH_BAR_DIMENSION = new Dimension(440, 38);
    Dimension BODY_MAIN = new Dimension(1024, 720);
    Dimension BODY_MAIN_SMALL = new Dimension(1024, 640);
    Dimension BODY_NAV = new Dimension(1024, 60);
    Dimension RIGHT_PADDING = new Dimension(50, 720);
    Dimension SIDE_COMPONENTS = new Dimension(255, 46);
    Dimension SEARCH_BOX = new Dimension(416, 18);
    Dimension PROFILE_SECTION_DIMENSION = new Dimension(256, 72);
    Dimension PROFILE_NAME_DIMENSION = new Dimension(230, 20);
    Dimension PROFILE_ROLE_DIMENSION = new Dimension(230, 20);
    Dimension BODY_HEADING_DIMENSION =  new Dimension(944, 90);

    Dimension NAVIGATION_BOX_SMALL = new Dimension(212, 152);
    Dimension NAVIGATION_BOX_WIDE = new Dimension(456, 152);
    Dimension NAVIGATION_BOX_LONG = new Dimension(212, 323);
    Dimension NAVIGATION_BOX_SMALL_CTA_DIMENSION = new Dimension(212, 27);
    Dimension NAVIGATION_BOX_WIDE_CTA_DIMENSION = new Dimension(456, 27);

    Dimension NAVIGATION_BOX_SMALL_ABOVE_CTA_DIMENSION = new Dimension(212, 122);
    Dimension NAVIGATION_BOX_LONG_ABOVE_CTA_DIMENSION = new Dimension(212, 294);
    Dimension NAVIGATION_BOX_WIDE_ABOVE_CTA_DIMENSION = new Dimension(456, 122);
    Dimension DASHBOARD_MIDDLE_SECTION_DIMENSION = new Dimension(964, 424);
    Dimension DASHBOARD_FOOTER_DIMENSION = new Dimension(1024, 182);

    //----------  TABLES ----------------
    Dimension BUY_SELL_TABLE_ROW_DIMENSION = new Dimension(605,58);

    //INVENTORY PAGE
    Dimension INVENTORY_DRUG_LIST_SMALL = new Dimension(607, 194);

    //SETTINGS PAGE
    Dimension SETTINGS_BRANDING = new Dimension (456, 140);
    Dimension SETTINGS_STAFF = new Dimension (456, 355);
    Dimension SETTINGS_OwNER = SETTINGS_BRANDING;
    Dimension SETTINGS_LEFT_SECTION = new Dimension(456,510);

    //LIST OF DRUGS PAGE
    Dimension LIST_OF_DRUGS_LARGE = new Dimension(944, 438);

    //SALES REPORT PAGE
    Dimension SALES_MADE = new Dimension(526, 378);
    Dimension ORDERS_SALES_REPORT = new Dimension(383, 378);

    //SPECIFIC DRUG PAGE
    Dimension SPECIFIC_DRUG_FIELD_DRUG = new Dimension(456, 210);
    Dimension SPECIFIC_DRUG_FIELD_QUANTITY = new Dimension(456, 140);
    Dimension SPECIFIC_DRUG_FIELD_DATES = new Dimension(189, 246);
    Dimension SPECIFIC_DRUG_FIELD_PRICE = new Dimension(189, 130);

    //PAYMENTS PAGE
    Dimension PAYMENTS_TABLE = SALES_MADE;

    //MY PROFILE PAGE
    Dimension PERSONAL_INFORMATION = new Dimension(456, 287);

    //ORDERS PAGE
    Dimension ORDERS_TABLE_LARGE = SALES_MADE;

    //NEARING EXPIRY PAGE
    Dimension NEARING_EXPIRY_TABLE_LARGE = SALES_MADE;

    //BUY/SELL PAGE
    Dimension BUY_SEARCH_RESULT_TABLE = new Dimension(605, 194);

    //
    Dimension PAGE_SCROLL_BUTTON = new Dimension(27,27);
    Dimension PAGE_SCROLL_SECTION = new Dimension(151, 27);
    Dimension PAGE_COUNT_DIMENSION = new Dimension(97, 27);
    Dimension FILTER_DROP_DOWN = new Dimension(217, 38);
    Dimension FILTER_SECTION = new Dimension(242, 38);
    Dimension FILTER_NORTH_PANEL = new Dimension(944,68);


    //----------- TEXT FIELDS -------

    //Add New Orders
    Dimension TEXT_FIELD_LABEL = new Dimension(304, 21);
    Dimension TEXT_FIELD_PANEL = new Dimension(340, 63);
    Dimension TEXT_FIELDS_FOUR = new Dimension(705, 149);


    //BUTTONS
    Dimension BUY_SELL_BUTTON_DIMENSION = new Dimension(212, 46);
    Dimension ADD_ORDER_BUTTON_DIMENSION = new Dimension(162, 46);
    Dimension SAVE_BUTTON_DRUG_DIMENSION = ADD_ORDER_BUTTON_DIMENSION;
    Dimension SAVE_BUTTON_ORDER_DIMENSION = SAVE_BUTTON_DRUG_DIMENSION;
    Dimension EDIT_DETAILS_DRUG_BUTTON_DIMENSION = new Dimension(144, 46);
    Dimension LIST_DRUGS_BUTTON_DIMENSION = BUY_SELL_BUTTON_DIMENSION;


    Dimension SPECIFIC_DRUG_LABELS_WIDE = new Dimension(456, 70);
    Dimension SETTINGS_LABELS_WIDE = new Dimension(456, 60);

    Dimension SPECIFIC_DRUG_LABELS_LONG = new Dimension(189, 73);
    Dimension SPECIFIC_DRUG_LABELS_SMALL = new Dimension(189, 43);

}