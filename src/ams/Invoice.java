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
public class Invoice {
    
    //Variables
    private String invoiceNumber;
    private String invoiceDate;
    private String invoceAddress;
    private Integer invoiceTotal;

    //Empty Constuctor
    public Invoice() {
    }

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    
    
    //Get and Sets
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceAddress() {
        return invoceAddress;
    }

    public void setInvoiceAddress(String invoceAddress) {
        this.invoceAddress = invoceAddress;
    }

    public Integer getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(Integer invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }
    
    
    
    
}
