package main;
import pages.*;

public class UpdateHandler {
    static String
            drugShortageValue, nearingExpiryValue, inventoryStatusValue,
            drugsAvailableValue, revenueValue, ordersValue, employeesValue, paymentsReportValue;



    public static void updateAllBoxes(){
        BuySell.drugShortage.setBoxValue(drugShortageValue);
        BuySell.nearingExpiry.setBoxValue(nearingExpiryValue);
        DashboardPage.drugShortageBox.setBoxValue(drugShortageValue);
        DashboardPage.inventoryStatusBox.setBoxValue(inventoryStatusValue);
        DashboardPage.drugsAvailableBox.setBoxValue(drugsAvailableValue);
        DashboardPage.nearingExpiryBox.setBoxValue(nearingExpiryValue);
        DashboardPage.revenueBox.setBoxValue(revenueValue);
        DashboardPage.ordersBox.setBoxValue(ordersValue);
        DashboardPage.employeesBox.setBoxValue(employeesValue);
        InventoryPage.drugShortageBox.setBoxValue(drugShortageValue);
        InventoryPage.drugsAvailableBox.setBoxValue(drugsAvailableValue);
        InventoryPage.nearingExpiryBox.setBoxValue(nearingExpiryValue);
        ReportsPage.ordersBox.setBoxValue(ordersValue);
        ReportsPage.paymentsReportBox.setBoxValue(paymentsReportValue);
    }
}
