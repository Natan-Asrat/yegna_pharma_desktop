package layouts;

import interfaces.Guide;

import javax.swing.*;
import java.awt.*;

public class GroupMembers extends JPanel implements Guide {
    public static final byte numberOfMembers = 10;
    public static JPanel members[] = new JPanel[10];
    public static String[]
            firstNames = {
                    "NATAN",
                    "NATNAEL",
                    "EDEN",
                    "BETHLEHEM",
                    "FIREHIWOT",
                    "KALEAB",
                    "BONTU",
                    "BETHLEHEM",
                    "BETHLEHEM",
                    "MAHDER"
            },
            lastNames = {
                    "ASRAT",
                    "MULUGETA",
                    "ESAYAS",
                    "YIBELTAL",
                    "GETAHUN",
                    "ALEBACHEW",
                    "DEREJE",
                    "LAMESGEN",
                    "MELAKU",
                    "SOLOMON"
            },
            idNumbers = {
                    "UGR/5768/14",
                    "UGR/2097/14",
                    "UGR/8887/14",
                    "UGR/4047/14",
                    "UGR/3775/14",
                    "UGR/7568/14",
                    "UGR/1308/14",
                    "UGR/7820/14",
                    "UGR/0601/14",
                    "UGR/4954/14"
            }
                    ;
    public GroupMembers(){
        setLayout(new BorderLayout());
        JPanel container = new JPanel(new GridLayout(numberOfMembers, 1, 0,0));
        for(byte i = 0; i<numberOfMembers; i++){
            members[i] = new JPanel();
            members[i].setLayout(new BorderLayout());
            JLabel firstName = new JLabel(firstNames[i]);
            firstName.setHorizontalTextPosition(SwingConstants.LEFT);
            JLabel lastName = new JLabel(lastNames[i]);
            lastName.setHorizontalTextPosition(SwingConstants.LEFT);

            JLabel idNO = new JLabel(idNumbers[i]);
            idNO.setHorizontalTextPosition(SwingConstants.LEFT);


            firstName.setFont(Guide.POPPINS_ITALIC_MEDIUM);
            lastName.setFont(Guide.POPPINS_ITALIC_MEDIUM);
            idNO.setFont(Guide.ROBOTO_BOLD_SMALL);

            members[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 10 ,0));
            members[i].setPreferredSize(new Dimension(86, 64));
            members[i].add(firstName, BorderLayout.NORTH);
            members[i].add(lastName, BorderLayout.CENTER);
            members[i].add(idNO, BorderLayout.SOUTH);

            members[i].setOpaque(false);

            container.add(members[i]);
        }
        container.setMinimumSize(new Dimension(86, 720));
        container.setOpaque(false);
        setBackground(PROFILE_ROLE_COLOR);
        setBorder(BorderFactory.createEmptyBorder(1, 2, 0, 0));
        add(container, BorderLayout.WEST);
    }
}
