package tables;
import interfaces.*;

import javax.swing.*;
import java.awt.*;

public class PageScroll extends JPanel implements Guide {
    JLabel pageNO = new JLabel("Page 01");
    JPanel nextPage =  new JPanel(), previousPage = new JPanel();
    ImageIcon forwardIcon = new ImageIcon(getClass().getResource("/tableIcons/next_arrow.png"));
    ImageIcon backwardIcon = new ImageIcon(getClass().getResource("/tableIcons/back_arrow.png"));

    public PageScroll(){
        JLabel next = new JLabel();
        JLabel back = new JLabel();
        next.setIcon(forwardIcon);
//        next.setPreferredSize(PAGE_SCROLL_BUTTON);
//        back.setPreferredSize(PAGE_SCROLL_BUTTON);
//        next.setVerticalAlignment(SwingConstants.CENTER);
//        nextPage.set(CENTER_ALIGNMENT);
//        previousPage.setAlignmentY(CENTER_ALIGNMENT);
        back.setIcon(backwardIcon);
        nextPage.add(next);
        previousPage.add(back);

        nextPage.setPreferredSize(PAGE_SCROLL_BUTTON);
        previousPage.setPreferredSize(PAGE_SCROLL_BUTTON);

        nextPage.setBackground(Color.white);
        previousPage.setBackground(Color.white);

        JPanel pageCount = new JPanel();
        pageCount.setPreferredSize(PAGE_COUNT_DIMENSION);
        pageNO.setHorizontalAlignment(SwingConstants.CENTER);
        pageCount.add(pageNO);

        JPanel box = new JPanel(new BorderLayout());

        box.add(previousPage, BorderLayout.WEST);
        box.add(pageCount);
        box.add(nextPage, BorderLayout.EAST);

        add(box);
        setPreferredSize(PAGE_SCROLL_SECTION);
    }
}
