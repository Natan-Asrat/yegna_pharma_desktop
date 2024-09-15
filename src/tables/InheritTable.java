package tables;

import interfaces.Guide;
import pages.BuySell;

import main.DbFunctions;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class InheritTable extends JScrollPane{
    public String query;
    JTable table = new JTable() {
        public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
        }
    };
    JScrollBar coolScroll = new JScrollBar();
    int page = 1;
    int recordsPerPage;
    ResultSet data;
    Object[][] records;
    public Object[] columns;
    String drugNameInput, drugCodeInput;
    Dimension size;

    public void setupTable(){
        setPreferredSize(size);
        setBackground(Guide.TABLE_HEADER_COLOR);

//        updatePage(page);
        table.setBorder(null);
        setDarkMode();
        table.setShowVerticalLines(false);

        coolScroll.setPreferredSize(new Dimension(8, 8));
        coolScroll.setForeground(new Color(48, 144, 216));
        coolScroll.setBackground(Guide.TABLE_HEADER_COLOR);
        coolScroll.setUI(new ScrollBarUI());
        setVerticalScrollBar(coolScroll);
        table.setBorder(null);
        table.setShowGrid(false);
        setViewportView(table);
    }
    public void setDarkMode(){
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bin, boolean bin1, int i, int i1){
                Component comp = super.getTableCellRendererComponent(jtable, o, bin, bin1, i, i1);
                comp.setBackground(Guide.TABLE_HEADER_COLOR);
                comp.setForeground(Guide.TABLE_HEADER_FOREGROUND);
                comp.setFont(Guide.POPPINS_BOLD_MEDIUM);
                this.setBorder(BorderFactory.createEmptyBorder(0, 24, 0,0));

                return comp;
            }
        });
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bin, boolean bin1, int row, int column) {
                Component comp = super.getTableCellRendererComponent(jtable, o, bin, bin1, row, column);
                comp.setForeground(Guide.TABLE_HEADER_FOREGROUND);
                comp.setFont(Guide.POPPINS_BOLD_MEDIUM);


//                if(jtable.isCellSelected(row, column)) {
//
//                }
                if(row%2 == 0){
                    comp.setBackground(Guide.TABLE_ROW_LIGHT_COLOR);
                }else{
                    comp.setBackground(Guide.TABLE_HEADER_COLOR);
                }
                this.setBorder(BorderFactory.createEmptyBorder(0, 24, 0,0));
                return comp;
            }

        });
        table.getTableHeader().setPreferredSize(Guide.BUY_SELL_TABLE_ROW_DIMENSION);
        table.setRowHeight(51);
    }
    public void updatePage(String query ,int page){
        columns = DbFunctions.updateTable(table, query, recordsPerPage);
    }



}