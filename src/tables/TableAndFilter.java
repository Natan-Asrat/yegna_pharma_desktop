package tables;

import interfaces.Guide;

import javax.swing.*;
import java.awt.*;

public class TableAndFilter extends JPanel implements Guide{
    Filter filter;
    PageScroll pages = new PageScroll();
    public TableAndFilter(JPanel table, String[] options, JPanel TopLeft){
        filter = new Filter(table, options, "- Select Type -");
        JPanel top = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel(new BorderLayout());
        top.add(filter, BorderLayout.EAST);
        bottom.add(pages, BorderLayout.EAST);
        top.setPreferredSize(FILTER_NORTH_PANEL);
        bottom.setPreferredSize(FILTER_NORTH_PANEL);

        table.setPreferredSize(new Dimension(944, 338));
        table.setBackground(Color.white);
        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(table);
        add(bottom, BorderLayout.SOUTH);
    }
    public TableAndFilter(JPanel table, String[] options){
        this(table, options, new JPanel());
    }

}
