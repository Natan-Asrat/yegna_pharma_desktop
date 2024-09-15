package layouts;

import interfaces.Constants;
import interfaces.Guide;
import interfaces.Labels;
import main.Login;
import main.User;
import main.YegnaPharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SideMiddle extends JPanel implements Constants, Guide {
    static JLabel
            dashboard = new JLabel("Dashboard"),
            inventory = new JLabel("Inventory"),
            reports = new JLabel("Reports"),
            settings = new JLabel("Settings"),
            contact = new JLabel("Contact Management");
    static JLabel[] components = {dashboard, inventory, reports, settings, contact};
    static String[] iconFilePaths = {
            "resources/brand/dashboard_icon.png",
            "resources/brand/inventory_icon.png",
            "resources/brand/reports_icon.png",
            "resources/brand/settings_white.png",
            "resources/brand/people_white.png"
    };
    JPanel profileSection = new JPanel();
    JLabel profileName;
    JLabel profileRole = new JLabel("Admin");
    JPanel topThree = new JPanel();
    SideMiddle(User user){
        setOpaque(false);
        profileSection.setPreferredSize(PROFILE_SECTION_DIMENSION);
        profileSection.setBorder(BorderFactory.createEmptyBorder(17, 24, 20, 0));
        profileSection.setOpaque(false);
        profileName  = new JLabel(user.getUsername());
        profileName.setFont(POPPINS_BOLD_MEDIUM);
        profileName.setPreferredSize(PROFILE_NAME_DIMENSION);
        profileName.setForeground(Color.white);
        profileRole.setFont(POPPINS_BOLD_SMALL);
        profileRole.setPreferredSize(PROFILE_ROLE_DIMENSION);
        profileRole.setForeground(PROFILE_ROLE_COLOR);

        profileSection.add(profileName);
        profileSection.add(profileRole);
        add(profileSection);
        for(byte i =0 ; i<5;i++){
            JLabel comp = components[i];
            comp.setPreferredSize(SIDE_COMPONENTS);
            comp.setIcon(new ImageIcon(iconFilePaths[i]));
            comp.setIconTextGap(12);
            comp.setForeground(Color.white);
            comp.setBorder(BorderFactory.createEmptyBorder(0, 24, 0, 0));
            comp.setFont(POPPINS_BOLD_MEDIUM);
            comp.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e){
                    if (e.getSource().equals(dashboard)) {
                        updateSelected(SELECT_DASHBOARD);
                        BodyMain.c.show(BodyMain.card, "dash");
                    } else if(e.getSource().equals(inventory)){
                        updateSelected(SELECT_INVENTORY);
                        BodyMain.c.show(BodyMain.card, "inv");
                    } else if(e.getSource().equals(reports)){
                        updateSelected(SELECT_REPORTS);
                        BodyMain.c.show(BodyMain.card, "rep");
                    } else if(e.getSource().equals(settings)){
                        updateSelected(SELECT_SETTINGS);
                        BodyMain.c.show(BodyMain.card, "set");
                    } else if(e.getSource().equals(contact)){
                        updateSelected(SELECT_CONTACT);
                        BodyMain.c.show(BodyMain.card, "con");
                    }
                }
            });
            add(comp);
        }
        updateSelected(SELECT_DASHBOARD);
    }
    public static void updateSelected(byte index){
        for(int i = 0; i < 5; i++){
            components[i].setBackground(null);
            components[i].setOpaque(false);

            if(i==index){
                components[i].setBackground(SELECTED_SIDE_BAR_COLOR);
                components[i].setOpaque(true);

            }
        }
    }
}