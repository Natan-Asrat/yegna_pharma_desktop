package layouts;

import interfaces.Constants;
import interfaces.Pages;
import main.User;

import javax.swing.*;
import java.awt.*;

public class Body extends JPanel implements Pages, Constants {
    Nav nav = new Nav();
    static BodyMain bodyMain = new BodyMain();

    public Body(User user){
        setLayout(new BorderLayout());

        add(nav, BorderLayout.NORTH);
        add(bodyMain, BorderLayout.WEST);

    }
}