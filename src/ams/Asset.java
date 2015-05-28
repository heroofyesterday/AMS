/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import java.util.Date;

/**
 *
 * @author kieranross
 */
public class Asset {
    
    private int assetNumber;
    private String assetTitle;
    private String assetLocation;
    
    private String assetSerialNumber;
    private String assetType;
    private String assetManufacturer;
    private String assetModel;
    private String assetNotes;
    private String assetPurchaseDate;
    private String assetDisposalDate;
    private String assetInvoiceNumber;
    private Integer assetUnitCost;
    
    
    public enum AssetStatus{
     Operational, Sold, Recycled, Repaired;
    }
    public AssetStatus assetStatus;
  
    public enum AssetCategory{
     Hardware, Software;
    }
    
    public AssetCategory assetCategory;

    
    //Constructors
    
    //Empty Constructor

    public Asset() {
        this.assetCategory = AssetCategory.Hardware;
        this.assetDisposalDate = null;
        this.assetInvoiceNumber = null;
        this.assetLocation = null;
        this.assetManufacturer = null;
        this.assetModel = null;
        this.assetNotes = null;
        this.assetNumber = 0;
        
        this.assetPurchaseDate = null;
        this.assetSerialNumber = null;
        this.assetStatus = AssetStatus.Operational;
        this.assetTitle = null;
        this.assetType = null;
        this.assetUnitCost = 0;
        
    }
    
    //Constructor with Asset ID, Title and Owner

    public Asset(int assetNumber, String assetTitle) {
        this.assetNumber = assetNumber;
        this.assetTitle = assetTitle;
        
    }
    
    //Methods
    
    //Get Methods

    public int getAssetNumber() {
        return assetNumber;
    }

    public String getAssetTitle() {
        return assetTitle;
    }
    
    
    public String getAssetStatus(){
        return assetStatus.name();
    }
    
    public String getAssetLocation() {
        return assetLocation;
    }

   

    public String getAssetSerialNumber() {
        return assetSerialNumber;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getAssetManufacturer() {
        return assetManufacturer;
    }

    public String getAssetModel() {
        return assetModel;
    }

    public String getAssetCategory(){
        return assetCategory.name();
    }

    public String getAssetNotes() {
        return assetNotes;
    }

    public String getAssetPurchaseDate() {
        return assetPurchaseDate;
    }

    public String getAssetDisposalDate() {
        return assetDisposalDate;
    }
    
    public String getAssetInvoiceNumber(){
        return assetInvoiceNumber;
    }
    
    public Integer getAssetUnitCost(){
        return assetUnitCost;
    }
    
    //Set Methods

    public void setAssetNumber(int assetNumber) {
        this.assetNumber = assetNumber;
    }

    public void setAssetTitle(String assetTitle) {
        this.assetTitle = assetTitle;
    }

    public void setAssetLocation(String assetLocation) {
        this.assetLocation = assetLocation;
    }

    

    public void setAssetSerialNumber(String assetSerialNumber) {
        this.assetSerialNumber = assetSerialNumber;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setAssetManufacturer(String assetManufacturer) {
        this.assetManufacturer = assetManufacturer;
    }

    public void setAssetModel(String assetModel) {
        this.assetModel = assetModel;
    }


    public void setAssetNotes(String assetNotes) {
        this.assetNotes = assetNotes;
    }

    public void setAssetPurchaseDate(String assetPurchaseDate) {
        this.assetPurchaseDate = assetPurchaseDate;
    }

    public void setAssetDisposalDate(String assetDisposalDate) {
        this.assetDisposalDate = assetDisposalDate;
    }
    
    public void setAssetInvoiceNumber(String number){
        this.assetInvoiceNumber = number;
    }
    
    public void setAssetUnitCost(Integer cost){
        this.assetUnitCost = cost;
    }
    
    
    
}
