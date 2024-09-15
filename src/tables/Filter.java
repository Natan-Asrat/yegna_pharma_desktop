package tables;

import interfaces.Guide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Filter extends JPanel implements Guide, ActionListener {
    JComboBox dropdown;
    ImageIcon icon = new ImageIcon(getClass().getResource("/tableIcons/filter_icon.png"));
    JLabel filterIcon = new JLabel();

    JPanel Table;
    public Filter(JPanel table, String[] options, String placeholder){
        dropdown = new JComboBox(options);
        dropdown.setPreferredSize(FILTER_DROP_DOWN);
        dropdown.setBackground(Color.white);
//        dropdown.set
//        dropdown.setOpaque(false);
//        dropdown.setBorder(BorderFactory.createEmptyBorder(10, 45, 0 ,0));
        Table = table;

        filterIcon.setIcon(icon);
        filterIcon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JPanel container = new JPanel(new BorderLayout());
        container.add(filterIcon, BorderLayout.WEST);
        container.add(dropdown, BorderLayout.EAST);
        container.setOpaque(false);

        add(container);
        setPreferredSize(FILTER_SECTION);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
