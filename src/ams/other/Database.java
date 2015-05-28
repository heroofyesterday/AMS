/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.other;

import ams.AMS;
import ams.Asset;
import ams.Invoice;
import ams.User;
import java.sql.*;
import ams.other.Utilities;
import com.sun.scenario.effect.AbstractShadow;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import sun.misc.ASCIICaseInsensitiveComparator;

/**
 *
 * @author kieranross
 */
public class Database {
    
    public static String getLastInvoiceNumberUsed(Connection dconnection) {
        
    String InvoiceNumber = null;
    Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT InvoiceNo\n" +
                    "FROM Invoices\n" +
                    "ORDER BY InvoiceNo DESC\n" +
                    "LIMIT 1;");
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                InvoiceNumber = result.getString("InvoiceNo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return InvoiceNumber;
    }
    
    public static String getLastAssetNumberUsed(Connection dconnection) {
        
    String AssetNumber = null;
    Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT assetNumber\n" +
                    "FROM Assets\n" +
                    "ORDER BY assetNumber DESC\n" +
                    "LIMIT 1;");
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                AssetNumber = result.getString("assetNumber");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return AssetNumber;
    }
    
    public static String getLastUserIDNumberUsed(Connection dconnection) {
        
    String UserIDNumber = null;
    Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT IDnumber\n" +
                    "FROM Users\n" +
                    "ORDER BY IDnumber DESC\n" +
                    "LIMIT 1;");
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                UserIDNumber = result.getString("IDnumber");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return UserIDNumber;
    }
    
    
    public static void insertAsset(Connection dConnection, Asset asset){
        
        
        String purchaseDate = asset.getAssetPurchaseDate();
        String disposalDate = asset.getAssetDisposalDate();
        String assetStatus = "Operational";
        String assetCategory = "Hardware";
        String assetTitle = asset.getAssetTitle();
        String assetLocation = asset.getAssetLocation();
        String assetSerialNumber = asset.getAssetSerialNumber();
        String assetType = asset.getAssetType();
        String assetManufacturer = asset.getAssetManufacturer();
        String assetModel = asset.getAssetModel();
        String assetNotes = asset.getAssetNotes();
        String assetInvoiceNumber = asset.getAssetInvoiceNumber();
        String assetUnitCost = Utilities.convertDoubleToString(asset.getAssetUnitCost());
        
        
        if(purchaseDate == "NULL"){
            purchaseDate = "NULL,";
        } else {
            purchaseDate = "'"+ purchaseDate +"', ";
        }
        
        
        if(disposalDate == "NULL"){
            disposalDate = "NULL,";
        } else {
            disposalDate = "'"+ disposalDate +"', ";
        }
        
        if(assetTitle == "NULL"){
            assetTitle = "NULL,";
        } else {
            assetTitle = "'"+ assetTitle +"', ";
        }
        
        if(assetLocation == "NULL"){
            assetLocation = "NULL,";
        } else {
            assetLocation = "'"+ assetLocation +"', ";
        }
        
        if(assetSerialNumber == "NULL"){
            assetSerialNumber = "NULL,";
        } else {
            assetSerialNumber = "'"+ assetSerialNumber +"', ";
        }
        
        if(assetType == "NULL"){
            assetType = "NULL,";
        } else {
            assetType = "'"+ assetType +"', ";
        }
        
        if(assetManufacturer == "NULL"){
            assetManufacturer = "NULL,";
        } else {
            assetManufacturer = "'"+ assetManufacturer +"', ";
        }
        
        if(assetModel == "NULL"){
            assetModel = "NULL,";
        } else {
            assetModel = "'"+ assetModel +"', ";
        }
        
        if(assetNotes == "NULL"){
            assetNotes = "NULL,";
        } else {
            assetNotes = "'"+ assetNotes +"', ";
        }
        
        if(assetInvoiceNumber == "NULL"){
            assetInvoiceNumber = "NULL,";
        } else {
            assetInvoiceNumber = "'"+ assetInvoiceNumber +"', ";
        }
        
        if(assetUnitCost == "NULL"){
            assetUnitCost = "NULL";
        } else {
            assetUnitCost = "'"+ assetUnitCost +"' ";
        }
        
        
        
        switch (asset.assetStatus){
            case Operational : 
              assetStatus = "Operational";
                break;
            case Sold :
                assetStatus = "Sold";
                break;
                
            case Recycled :
                assetStatus = "Recycled";
                break;
                
            case Repaired :
                assetStatus = "Repaired";
                break;
        }
       
        
        switch (asset.assetCategory){
            case Hardware : 
              assetCategory = "Hardware";
                break;
            case Software :
                assetCategory = "Software";
                break;
                
        }
        
        
        
        String Command = null;
        Command = "insert into Assets values ( '"
                + asset.getAssetNumber() +"', "
                + assetTitle
                + "'"+ assetStatus +"', "
                + assetLocation
                + assetSerialNumber
                + assetType
                + assetManufacturer
                + assetModel
                + "'"+ assetCategory +"', "
                + assetNotes
                + purchaseDate
                + disposalDate 
                + assetInvoiceNumber
                + assetUnitCost + ")";
        
        SQL.insert(dConnection, Command);
        Utilities.consoleMessage(Command);
        
    }
    
    public static JTable getTableView(Connection dconnection, String SQLcommand){
        
        JTable table;
        
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        Connection connection = dconnection;
        
        String sql = SQLcommand;

        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

 
        return table;
    }
    
    
    public static DefaultComboBoxModel getComboBoxList(Connection dconnection, String SQLcommand){
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        Connection connection = dconnection;
        
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
       
        try {
            statement = connection.prepareStatement(SQLcommand);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs = statement.executeQuery(SQLcommand);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while (rs.next()) {
                String item = rs.getString(1);
                list.add(item);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(list.toArray());
        
        return model;
        

    }

    public static void insertUser(Connection dConnection, User user){
        
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String jobTitle = user.getJobTitle();
        String company = user.getCompany();
        String email = user.getEmailAddress();
        String phone = user.getTelephoneNumber();
        String mob = user.getMobileNumber();
        
        if(firstName == "NULL"){
            firstName = "NULL,";
        } else {
            firstName = "'"+ firstName +"', ";
        }
        
        if(lastName == "NULL"){
            lastName = "NULL,";
        } else {
            lastName = "'"+ lastName +"', ";
        }
        
        if(jobTitle == "NULL"){
            jobTitle = "NULL,";
        } else {
            jobTitle = "'"+ jobTitle +"', ";
        }
        
        if(company == "NULL"){
            company = "NULL,";
        } else {
            company = "'"+ company +"', ";
        }
        
        if(email == "NULL"){
            email = "NULL,";
        } else {
            email = "'"+ email +"', ";
        }
        
        if(phone == "NULL"){
            phone = "NULL,";
        } else {
            phone = "'"+ phone +"', ";
        }
        
        if(mob == "NULL"){
            mob = "NULL";
        } else {
            mob = "'"+ mob +"' ";
        }
        
        String Command = null;
        Command = "insert into Users values ( '"
                + user.getIDnumber() + "', "
                + firstName
                + lastName
                + jobTitle
                + company
                + email
                + phone
                + mob + ")";
        
        SQL.insert(dConnection, Command);
        Utilities.consoleMessage(Command);
        
    }
    
    public static void insertInvoice(Connection dConnection, Invoice invoice){
        
        
        String Command = null;
        String invoiceTotal = Utilities.convertIntToString(invoice.getInvoiceTotal());
        String invoiceDate = invoice.getInvoiceDate();
        String invoiceAddress = invoice.getInvoiceAddress();
        
        if(invoiceAddress == "NULL"){
            invoiceAddress = "NULL,";
        } else {
            invoiceAddress = "'"+ invoiceAddress +"', ";
        }
        
        if(invoiceDate == "NULL"){
            invoiceDate = "NULL,";
        } else {
            invoiceDate = "'"+ invoiceDate +"', ";
        }
        
        if(invoiceTotal == "NULL"){
            invoiceTotal = "NULL";
        } else {
            invoiceTotal = "'"+ invoiceTotal +"' ";
        }
        
        Command = "insert into Invoices values ( '"
                + invoice.getInvoiceNumber() + "', "
                + invoiceDate
                + invoiceAddress
                + invoiceTotal  + ")";
        
        SQL.insert(dConnection, Command);
        Utilities.consoleMessage(Command);
        
          
    }
    
    public static void updateAsset(Connection dConnection, Asset asset, String selector){
        
        String purchaseDate = asset.getAssetPurchaseDate();
        String disposalDate = asset.getAssetDisposalDate();
        
        String assetStatus = null;
        String assetCategory = null;
        String assetTitle = asset.getAssetTitle();
        String assetLocation = asset.getAssetLocation();
        String assetSerialNumber = asset.getAssetSerialNumber();
        String assetType = asset.getAssetType();
        String assetManufacturer = asset.getAssetManufacturer();
        String assetModel = asset.getAssetModel();
        String assetNotes = asset.getAssetNotes();
        String assetInvoiceNumber = asset.getAssetInvoiceNumber();
        String assetUnitCost = Utilities.convertDoubleToString(asset.getAssetUnitCost());
        
        switch (asset.assetStatus){
            case Operational : 
              assetStatus = "Operational";
                break;
            case Sold :
                assetStatus = "Sold";
                break;
                
            case Recycled :
                assetStatus = "Recycled";
                break;
                
            case Repaired :
                assetStatus = "Repaired";
                break;
        }
       
        
        switch (asset.assetCategory){
            case Hardware : 
              assetCategory = "Hardware";
                break;
            case Software :
                assetCategory = "Software";
                break;
                
        }
        
        
        if(purchaseDate == "NULL"){
            purchaseDate = "NULL,";
        } else {
            purchaseDate = "'"+ purchaseDate +"', ";
        }
        
        
        if(disposalDate == "NULL"){
            disposalDate = "NULL,";
        } else {
            disposalDate = "'"+ disposalDate +"', ";
        }
        
        if(assetTitle == "NULL"){
            assetTitle = "NULL,";
        } else {
            assetTitle = "'"+ assetTitle +"', ";
        }
        
        if(assetLocation == "NULL"){
            assetLocation = "NULL,";
        } else {
            assetLocation = "'"+ assetLocation +"', ";
        }
        
        if(assetSerialNumber == "NULL"){
            assetSerialNumber = "NULL,";
        } else {
            assetSerialNumber = "'"+ assetSerialNumber +"', ";
        }
        
        if(assetType == "NULL"){
            assetType = "NULL,";
        } else {
            assetType = "'"+ assetType +"', ";
        }
        
        if(assetManufacturer == "NULL"){
            assetManufacturer = "NULL,";
        } else {
            assetManufacturer = "'"+ assetManufacturer +"', ";
        }
        
        if(assetModel == "NULL"){
            assetModel = "NULL,";
        } else {
            assetModel = "'"+ assetModel +"', ";
        }
        
        if(assetNotes == "NULL"){
            assetNotes = "NULL,";
        } else {
            assetNotes = "'"+ assetNotes +"', ";
        }
        
        if(assetInvoiceNumber == "NULL"){
            assetInvoiceNumber = "NULL,";
        } else {
            assetInvoiceNumber = "'"+ assetInvoiceNumber +"', ";
        }
        
        if(assetUnitCost == "NULL"){
            assetUnitCost = "NULL";
        } else {
            assetUnitCost = "'"+ assetUnitCost +"' ";
        }
        
        String Command = null;
        Command = "update Assets set assetNumber = '"
                + asset.getAssetNumber() +"', "
                + "title = " + assetTitle
                + "status = '"+ assetStatus +"', "
                + "location = " + assetLocation
                + "serialNumber = " + assetSerialNumber
                + "type = " + assetType
                + "manufacturer = " + assetManufacturer
                + "model = " + assetModel
                + "category = '"+ assetCategory +"', "
                + "notes = " + assetNotes
                + "purchaseDate = " + purchaseDate
                + "disposalDate = " + disposalDate 
                + "InvoiceNo = " + assetInvoiceNumber
                + "UnitCost = " + assetUnitCost +
                " where assetNumber = '" + selector + "'";
        
        SQL.update(dConnection, Command);
        Utilities.consoleMessage(Command);
                
    }
    
    public static Asset getAssetAt(Connection dConnection, int row, JTable table){
        
        
        Asset newAsset = new Asset();
        
        int selectedRow = row;
        newAsset.setAssetNumber(Utilities.convertStringToInt(table.getValueAt(selectedRow, 0).toString()));
        
        if(table.getValueAt(selectedRow, 1) == null){
            newAsset.setAssetTitle("");
        } else {
            newAsset.setAssetTitle(table.getValueAt(selectedRow, 1).toString());
        }
        
        if(table.getValueAt(selectedRow, 3)==null){
            newAsset.setAssetLocation("");
        } else {
            newAsset.setAssetLocation(table.getValueAt(selectedRow, 3).toString());
        }
        
        if(table.getValueAt(selectedRow, 4)==null){
            newAsset.setAssetSerialNumber("");
        } else {
            newAsset.setAssetSerialNumber(table.getValueAt(selectedRow, 4).toString());
        }
        
        if(table.getValueAt(selectedRow, 5)==null){
            newAsset.setAssetType("");
        } else {
            newAsset.setAssetType(table.getValueAt(selectedRow, 5).toString());
        }
        
        if(table.getValueAt(selectedRow, 6)==null){
            newAsset.setAssetManufacturer("");
        } else {
            newAsset.setAssetManufacturer(table.getValueAt(selectedRow, 6).toString());
        }
            
        if(table.getValueAt(selectedRow, 7)==null){
            newAsset.setAssetModel("");
        } else {
            newAsset.setAssetModel(table.getValueAt(selectedRow, 7).toString());
        }
        
        if(table.getValueAt(selectedRow, 9)==null){
            newAsset.setAssetNotes("");
        } else {           
            newAsset.setAssetNotes(table.getValueAt(selectedRow, 9).toString());
        }
        
        
        newAsset.setAssetInvoiceNumber(table.getValueAt(selectedRow, 12).toString());
        
        newAsset.setAssetUnitCost(Utilities.convertStringToInt(table.getValueAt(selectedRow, 13).toString()));
        
        String enumStatusValue = table.getValueAt(selectedRow, 2).toString();
        
        switch (enumStatusValue){
            case "Operational" : 
              newAsset.assetStatus = Asset.AssetStatus.Operational;
                break;
            case "Sold" :
                newAsset.assetStatus = Asset.AssetStatus.Sold;
                break;
                
            case "Recycled" :
                newAsset.assetStatus = Asset.AssetStatus.Recycled;
                break;
                
            case "Reparied" :
                newAsset.assetStatus = Asset.AssetStatus.Repaired;
                break;
        }
        
        String enumCategoryValue = table.getValueAt(selectedRow, 8).toString();
        
        switch (enumStatusValue){
            case "Hardware" : 
              newAsset.assetCategory = Asset.AssetCategory.Hardware;
                break;
            case "Software" :
                newAsset.assetCategory = Asset.AssetCategory.Software;
                break;
                
        }
        
        
        if(table.getValueAt(selectedRow, 10)==null){
            newAsset.setAssetPurchaseDate("");
        } else {
            newAsset.setAssetPurchaseDate(table.getValueAt(selectedRow, 10).toString());
        }
        
        if(table.getValueAt(selectedRow, 11)==null){
            newAsset.setAssetDisposalDate("");
        } else {
            newAsset.setAssetDisposalDate(table.getValueAt(selectedRow, 11).toString());
        }
        
        return newAsset;
                
    }
    
    
    public static void updateUser(Connection dConnection, User user, String selector){
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String jobTitle = user.getJobTitle();
        String company = user.getCompany();
        String email = user.getEmailAddress();
        String phone = user.getTelephoneNumber();
        String mob = user.getMobileNumber();
        
        if(firstName == "NULL"){
            firstName = "NULL,";
        } else {
            firstName = "'"+ firstName +"', ";
        }
        
        if(lastName == "NULL"){
            lastName = "NULL,";
        } else {
            lastName = "'"+ lastName +"', ";
        }
        
        if(jobTitle == "NULL"){
            jobTitle = "NULL,";
        } else {
            jobTitle = "'"+ jobTitle +"', ";
        }
        
        if(company == "NULL"){
            company = "NULL,";
        } else {
            company = "'"+ company +"', ";
        }
        
        if(email == "NULL"){
            email = "NULL,";
        } else {
            email = "'"+ email +"', ";
        }
        
        if(phone == "NULL"){
            phone = "NULL,";
        } else {
            phone = "'"+ phone +"', ";
        }
        
        if(mob == "NULL"){
            mob = "NULL";
        } else {
            mob = "'"+ mob +"' ";
        }
        
        String Command = null;
        Command = "update  Users set IDnumber = '"
                + user.getIDnumber() + "', "
                + "firstName = " + firstName
                + "lastName = " + lastName
                + "jobTitle = " + jobTitle
                + "company = " + company
                + "emailAddress = " + email
                + "telephoneNumber = " + phone
                + "mobileNumber = " + mob +
                " where IDnumber = '" + selector + "'";
        
        SQL.update(dConnection, Command);
        Utilities.consoleMessage(Command);
        
    }
    
    public static void updateInvoice(Connection dConnection, Invoice invoice, String selector){
        
        
        String Command = null;
        String invoiceTotal = Utilities.convertIntToString(invoice.getInvoiceTotal());
        String invoiceDate = invoice.getInvoiceDate();
        String invoiceAddress = invoice.getInvoiceAddress();
        
        if(invoiceAddress == "NULL"){
            invoiceAddress = "NULL,";
        } else {
            invoiceAddress = "'"+ invoiceAddress +"', ";
        }
        
        if(invoiceDate == "NULL"){
            invoiceDate = "NULL,";
        } else {
            invoiceDate = "'"+ invoiceDate +"', ";
        }
        
        if(invoiceTotal == "NULL"){
            invoiceTotal = "NULL";
        } else {
            invoiceTotal = "'"+ invoiceTotal +"' ";
        }
        
        Command = "update Invoices set InvoiceNo =  '"
                + invoice.getInvoiceNumber() + "', "
                + "Date = " + invoiceDate
                + "invoiceAddress = " + invoiceAddress
                + "Total = " + invoiceTotal  +
                " where InvoiceNo = '" + selector + "'";
        
       
        SQL.update(dConnection, Command);
        Utilities.consoleMessage(Command);
        
          
    }
    
    public static Invoice getInvoiceAt(Connection dConnection, int row, JTable table){
        
        
        Invoice newInvoice = new Invoice();
        
        int selectedRow = row;
        newInvoice.setInvoiceNumber(table.getValueAt(selectedRow, 0).toString());
        
        if(table.getValueAt(selectedRow, 1) == null){
            newInvoice.setInvoiceDate("");
        } else {
            newInvoice.setInvoiceDate(table.getValueAt(selectedRow, 1).toString());
        }
        
        if(table.getValueAt(selectedRow, 2)==null){
            newInvoice.setInvoiceAddress("");
        } else {
            newInvoice.setInvoiceAddress(table.getValueAt(selectedRow, 2).toString());
        }
        
        if(table.getValueAt(selectedRow, 4)==null){
            newInvoice.setInvoiceTotal(0);
        } else {
            newInvoice.setInvoiceTotal(Utilities.convertStringToInt(table.getValueAt(selectedRow, 4).toString()));
        }
        
        
        
        return newInvoice;
                
    }
    
    public static User getUserAt(Connection dConnection, int row, JTable table){
        
        
        User newUser = new User();
        
        int selectedRow = row;
        newUser.setIDnumber(Utilities.convertStringToInt(table.getValueAt(selectedRow, 0).toString()));
        
        if(table.getValueAt(selectedRow, 1) == null){
            newUser.setFirstName("");
        } else {
            newUser.setFirstName(table.getValueAt(selectedRow, 1).toString());
        }
        
        if(table.getValueAt(selectedRow, 2)==null){
            newUser.setLastName("");
        } else {
            newUser.setLastName(table.getValueAt(selectedRow, 2).toString());
        }
        
        if(table.getValueAt(selectedRow, 3)==null){
            newUser.setJobTitle("");
        } else {
            newUser.setJobTitle(table.getValueAt(selectedRow, 3).toString());
        }
        
        if(table.getValueAt(selectedRow, 4)==null){
            newUser.setCompany("");
        } else {
            newUser.setCompany(table.getValueAt(selectedRow, 4).toString());
        }
        
        if(table.getValueAt(selectedRow, 5)==null){
            newUser.setEmailAddress("");
        } else {
            newUser.setEmailAddress(table.getValueAt(selectedRow, 5).toString());
        }
            
        if(table.getValueAt(selectedRow, 6)==null){
            newUser.setTelephoneNumber("");
        } else {
            newUser.setTelephoneNumber(table.getValueAt(selectedRow, 6).toString());
        }
        
        if(table.getValueAt(selectedRow, 7)==null){
            newUser.setMobileNumber("");
        } else {           
            newUser.setMobileNumber(table.getValueAt(selectedRow, 7).toString());
        }
        
        
        
        
        return newUser;
                
    }
    
    public static JTable searchAssets(Connection dconnection, String search){
        
        JTable table;
        
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        Connection connection = dconnection;
        
        
        
        String sql = "SELECT * FROM Assets WHERE `Assets`.`assetNumber` LIKE '%" + search + "%'"
	+ "OR `Assets`.`category` LIKE '%" + search + "%'"
        + "OR  `Assets`.`location` LIKE '%" + search + "%'"
        + "OR `Assets`.`manufacturer` LIKE '%" + search + "%'"
        + "OR  `Assets`.`model` LIKE '%" + search + "%'"
        + "OR  Assets.notes LIKE '%" + search + "%'"
	+ "OR Assets.`status` LIKE '%" + search + "%'"
	+ "OR Assets.title LIKE '%" + search + "%'"	
	+ "OR Assets.serialNumber LIKE '%" + search + "%'"
	+ "OR Assets.type LIKE '%" + search + "%'";
        
        

        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

 
        return table;
    }
    
     public static JTable searchAssigns(Connection dconnection, String search){
        
        JTable table;
        
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        Connection connection = dconnection;
        
        
        
        String sql = "Select CONCAT(AssetOwners.IDnumber,': ', Users.firstName,' ', Users.lastName) as 'assetOwner', AssetOwners.assetNumber, Assets.model, Assets.location, Assets.`status` "
                + " FROM AssetOwners "
                + "INNER join Users on AssetOwners.IDnumber = Users.IDnumber "
                + "inner join Assets on Assets.assetNumber = AssetOwners.assetNumber "
                + "WHERE CONCAT(AssetOwners.IDnumber,': ', Users.firstName,' ', Users.lastName) LIKE '%"+search+"%'";
        
        

        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

 
        return table;
    }
    
    public static JTable searchUsers(Connection dconnection, String search){
        
        JTable table;
        
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        Connection connection = dconnection;
        
        
        
        String sql = "SELECT * FROM Users WHERE `Users`.`IDnumber` LIKE '%" + search + "%'"
	+ "OR `Users`.`firstName` LIKE '%" + search + "%'"
        + "OR  `Users`.`lastName` LIKE '%" + search + "%'"
        + "OR `Users`.`jobTitle` LIKE '%" + search + "%'"
        + "OR  `Users`.`company` LIKE '%" + search + "%'"
        + "OR  Users.emailAddress LIKE '%" + search + "%'";
        
        

        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

 
        return table;
    }
    
    public static JTable searchInvoices(Connection dconnection, String search){
        
        JTable table;
        
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        Connection connection = dconnection;
        
        
        
        String sql = "SELECT * FROM Invoices WHERE `Invoices`.`InvoiceNo` LIKE '%" + search + "%'"
	+ "OR `Invoices`.`Date` LIKE '%" + search + "%'"
        + "OR  `Invoices`.`InvoiceAddress` LIKE '%" + search + "%'"
        + "OR `Invoices`.`Total` LIKE '%" + search + "%'";
        
        

        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

 
        return table;
    }
    
    public static void addUser(Connection dconnection, String username, String password, String type){
         
        
        String SQLcommand = null;
        String SQLcommand1 = null;
        
         switch (type) {
            case "Observe":  
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT SELECT ON AMPDatabase.* TO '" + username + "'@'localhost'";
                
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                
                
                     break;
                
            case "Regular":  
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT SELECT, INSERT, UPDATE ON AMPDatabase.* TO '" + username + "'@'localhost'";
                
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                
                
                    break;
                
            case "Administrator":
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT SELECT, INSERT, DELETE, UPDATE ON AMPDatabase.* TO '" + username + "'@'localhost'";
                
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                
                
                    break;
                
            case "Superuser":
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT ALL PRIVILEGES ON AMPDatabase.* TO '" + username + "'@'localhost' WITH GRANT OPTION";
                String SQLcommand3 = "GRANT ALL PRIVILEGES ON mysql.* TO '" + username + "'@'localhost' WITH GRANT OPTION";
                
                
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                SQL.execute(dconnection, SQLcommand3);
                
                
                    break;
         }
               
    }
    
     public static void editUser(Connection dconnection, String username, String password, String type){
         
        
        String SQLcommand = null;
        String SQLcommand1 = null;
        
         switch (type) {
            case "Observe":  
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT SELECT ON AMPDatabase.* TO '" + username + "'@'localhost'";
                
                SQL.execute(dconnection, "DROP USER '"+username+"'@'localhost'");
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                
                
                     break;
                
            case "Regular":  
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT SELECT, INSERT, UPDATE ON AMPDatabase.* TO '" + username + "'@'localhost'";
                
                SQL.execute(dconnection, "DROP USER '"+username+"'@'localhost'");
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                
                
                    break;
                
            case "Administrator":
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT SELECT, INSERT, DELETE, UPDATE ON AMPDatabase.* TO '" + username + "'@'localhost'";
                
                SQL.execute(dconnection, "DROP USER '"+username+"'@'localhost'");
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                
                
                    break;
                
            case "Superuser":
                
                SQLcommand = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
                SQLcommand1 = "GRANT ALL PRIVILEGES ON AMPDatabase.* TO '" + username + "'@'localhost' WITH GRANT OPTION";
                String SQLcommand3 = "GRANT ALL PRIVILEGES ON mysql.* TO '" + username + "'@'localhost' WITH GRANT OPTION";
                
                SQL.execute(dconnection, "DROP USER '"+username+"'@'localhost'");
                SQL.create(dconnection, SQLcommand);
                SQL.execute(dconnection, SQLcommand1);
                SQL.execute(dconnection, SQLcommand3);
                
                
                
                    break;
         }
               
    }
    
    public static void assignAsset(Connection dConnection, String assetNumber, String userNumber){
        
        String SQLcommand = "INSERT INTO AssetOwners VALUES ("+assetNumber+", "+userNumber+")";
        SQL.insert(dConnection, SQLcommand);
    }
    
    public static void assignAssetUpdate(Connection dConnection, String assetNumber, String userNumber){
        
        String SQLcommand;
        
        Statement st = null;
        try {
            st = dConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT * FROM AssetOwners WHERE assetNumber = '" + assetNumber + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        boolean val = true; 
        try {
            val = rs.next(); //next() returns false if there are no-rows retrieved
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(val==false){
            System.out.println("Asset not owned"); //prints this message if your resultset is empty
             SQLcommand = "INSERT INTO AssetOwners VALUES ("+assetNumber+", "+userNumber+")";
         } else {// only runs when there are rows in the resultset
            SQLcommand = "UPDATE AssetOwners SET assetNumber = '"+assetNumber+"', IDnumber = '"+userNumber+"' Where assetNumber = '" + assetNumber+"'";
        }
        
        
        SQL.update(dConnection, SQLcommand);
        Utilities.consoleMessage(SQLcommand);
    }
    
    public static String getNumberOfAssets(Connection dconnection){
        String number = null;
        Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT COUNT(assetNumber) AS 'Number of Assets'\n" +
                    "FROM Assets");
                    
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                number = result.getString("Number of Assets");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return number;
    }
    
    public static String getNumberOfAssignees(Connection dconnection){
        String number = null;
        Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT COUNT(idNumber) AS 'Number of Assignees'\n" +
                    "FROM Users");
                    
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                number = result.getString("Number of Assignees");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return number;
    }
    
    public static String getNumberOfInvoices(Connection dconnection){
        String number = null;
        Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT COUNT(InvoiceNo) AS 'Number of Invoices'\n" +
                    "FROM Invoices");
                    
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                number = result.getString("Number of Invoices");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return number;
    }
    
    public static String getCostOfInvoices(Connection dconnection){
        String number = null;
        Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT SUM(Total) AS 'Total of Invoices'\n" +
                    "FROM Invoices");
                    
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                number = result.getString("Total of Invoices");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return number;
    }
    
    public static String getCostOfAssets(Connection dconnection){
        String number = null;
        Connection connection = dconnection;
    
    PreparedStatement Statement = null;
        try {
            Statement = connection.prepareStatement(""
                    + "SELECT SUM(unitCost) AS 'Cost of Assets'\n" +
                    "FROM Assets");
                    
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        ResultSet result = null; 
        try {
            result = Statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while (result.next()) {
                number = result.getString("Cost of Assets");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return number;
    }
    
    
}


    
