package layouts;

import interfaces.Guide;

import javax.swing.*;
import java.awt.*;

public class BodyHeading extends JPanel implements Guide {
    public JPanel bodyHeadingText;
    public JPanel bodyHeadingRight;
    public JLabel pagePathLabel, pageNameLabel;

    public BodyHeading(String pagePath, String pageName, JPanel bodyHeadingRight){
        setMinimumSize(BODY_HEADING_DIMENSION);
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        bodyHeadingText = new JPanel();
        this.bodyHeadingRight = bodyHeadingRight;

        pagePathLabel = new JLabel(pagePath);
        pagePathLabel.setForeground(Color.gray);
        pagePathLabel.setFont(POPPINS_BOLD_LARGE);
        pageNameLabel = new JLabel(pageName);
        pageNameLabel.setFont(POPPINS_BOLD_LARGE);

        if(!pagePath.equals("")){bodyHeadingText.add(this.pagePathLabel);}
        bodyHeadingText.add(this.pageNameLabel);

        add(bodyHeadingText, BorderLayout.WEST);
        add(bodyHeadingRight, BorderLayout.EAST);

    }
    public BodyHeading(String pagePath, String pageName) {
        this(pagePath, pageName, new JPanel());
    }
    public void setBodyHeadingRight(JPanel bodyHeadingRight){
        this.bodyHeadingRight = bodyHeadingRight;
    }
}
