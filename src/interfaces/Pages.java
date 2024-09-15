package interfaces;

import javax.swing.*;
import pages.*;

public interface Pages {
    DashboardPage DASHBOARD = new DashboardPage();
    InventoryPage INVENTORY = new InventoryPage();
    ReportsPage REPORTS = new ReportsPage();
    SettingsPage SETTINGS = new SettingsPage();
    ContactPage CONTACT = new ContactPage();
    ListOfDrugsPage LO_DRUGS = new ListOfDrugsPage();
    MyProfile MY_PROFILE = new MyProfile();
    SpecificDrug SPECIFIC_DRUG = new SpecificDrug();
    PaymentsReport PAYMENTS_REPORT = new PaymentsReport();
    AddNewDrug ADD_DRUG = new AddNewDrug();
    AddNewStaff ADD_STAFF = new AddNewStaff();
    OrdersReport ORDERS_REPORT = new OrdersReport();
    NearingExpiry NEARING_EXPIRY = new NearingExpiry();
    AddNewOrder ADD_ORDER = new AddNewOrder();
    BuySell BUY_SELL = new BuySell();
    DrugShortagePage DRUG_SHORTAGE = new DrugShortagePage();
    EmployeesPage EMPLOYEES_PAGE = new EmployeesPage();
}
