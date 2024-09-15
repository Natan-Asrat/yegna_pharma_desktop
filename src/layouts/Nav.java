package layouts;

import interfaces.Guide;

import javax.swing.*;
import java.awt.*;

public class Nav extends JPanel {
    JPanel navMiddle = new JPanel();
    JPanel searchBar;
    JTextField searchBox;
    JLabel navRight = new JLabel();

    Nav(){
        setBackground(Color.white);
        setLayout(new BorderLayout());
        setPreferredSize(Guide.BODY_NAV);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));

        searchBar = new JPanel();
        searchBar.setBackground(Guide.MAIN_GRAY);
        searchBar.setSize(Guide.SEARCH_BAR_DIMENSION);
        searchBar.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));

        searchBox = new JTextField();
        searchBox.setPreferredSize(Guide.SEARCH_BOX);
        searchBox.setForeground(Guide.SEARCH_TEXT_COLOR);
        searchBox.setText("Search...");
        searchBox.setOpaque(false);
        searchBox.setBorder(null);

        searchBar.add(searchBox);
        navMiddle.setOpaque(false);
        navMiddle.add(searchBar);

        navRight.setText("June 2023 version");
        navRight.setFont(Guide.POPPINS_BOLD_SMALL);
        navRight.setVerticalAlignment(JLabel.CENTER);

        add(navMiddle, BorderLayout.CENTER);
        add(navRight, BorderLayout.EAST);
    }
}
