package interfaces;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public interface Borders extends Colors{
    Border NAVIGATION_BOX_SMALL_ABOVE_CTA_MARGIN = BorderFactory.createEmptyBorder(20, 0, 20, 0);
    Border NAVIGATION_BOX_LONG_ABOVE_CTA_MARGIN = BorderFactory.createEmptyBorder(63, 0, 53, 0);

    Dimension NAVIGATION_BOX_SMALL_LABELS_DIMENSION = new Dimension(212, 20);
    Border DASHBOARD_ELEMENT_RIGHT_ONLY_MARGIN = BorderFactory.createEmptyBorder(0, 0, 0, 32);
    Border BODY_MIDDLE_PADDING = BorderFactory.createEmptyBorder(20, 40, 0, 30);
    Border DASHBOARD_FOOTER_MARGIN = BorderFactory.createEmptyBorder(15, 40, 15,30);
    Border DELETE_BUTTON_BORDER = BorderFactory.createLineBorder(DELETE_BUTTON_COLOR);

}
