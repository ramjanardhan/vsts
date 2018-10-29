/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elasticsearch;

import io.searchbox.annotations.JestId;
import net.sf.json.JSONObject;

/**    
 *
 * @author rrandhi
 */
public class InvoiceBean 
{
    
     @JestId
    private int id;
    private String fileId;
    private String invoiceNumber;
    private String shipmentId;
    private String invoiceDate;
    private String totalAmount;
    private String poNumber;
    private String totalWeight;
    private String totalVolume;
    
     public static InvoiceBean fromJSON(JSONObject json) {
        return new InvoiceBean(
                json.getInt("id"),
                json.getString("fileId"),
                json.getString("invoiceNumber"),
                json.getString("shipmentId"),
                json.getString("invoiceDate"),
                json.getString("totalAmount"),
                json.getString("poNumber"),
                json.getString("totalWeight"),
                json.getString("totalVolume")
        );
    }
    
    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(String totalVolume) {
        this.totalVolume = totalVolume;
    }
    
    
    public InvoiceBean(int id, String fileId, String invoiceNumber, String shipmentId, String invoiceDate, String totalAmount, String poNumber, String totalWeight, String totalVolume) {
        this.id = id;
        this.fileId = fileId;
        this.invoiceNumber = invoiceNumber;
        this.shipmentId = shipmentId;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.poNumber = poNumber;
        this.totalWeight = totalWeight;
        this.totalVolume = totalVolume;
    }
   
    
}
