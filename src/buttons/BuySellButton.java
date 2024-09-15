package buttons;

import interfaces.Constants;
import interfaces.Guide;
import layouts.BodyMain;
import layouts.SideMiddle;
import tables.BuySellTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuySellButton extends JButton implements Guide, ActionListener {
    public BuySellButton(){
        setForeground(Color.white);
        addActionListener(this);
        setBackground(BUY_SELL_BUTTON_COLOR);
        setPreferredSize(BUY_SELL_BUTTON_DIMENSION);
        setBorder(null);
        setText("Buy/Sell");
        setFont(POPPINS_BOLD_MEDIUM);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SideMiddle.updateSelected(Constants.SELECT_INVENTORY);
        BodyMain.c.show(BodyMain.card, "buy");
//        BuySellTable.updatePage(1);
    }
}
