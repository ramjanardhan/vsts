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
public class ShipmentBean 
{
  @JestId
 
    private int id;
    private String fileId;
    private String shipmentId;
    private String bolNumber;
    private String poNumber;
    private String totalWeight;
    private String totalVolume;
    private String stopSeqNum;
    
    
    public static ShipmentBean fromJSON(JSONObject json) {
        return new ShipmentBean(
                json.getInt("id"),
                json.getString("fileId"),
                json.getString("shipmentId"),
                json.getString("bolNumber"),
                json.getString("poNumber"),
                json.getString("totalWeight"),
                json.getString("totalVolume"),
                json.getString("stopSeqNum")
        );
    }

    public ShipmentBean(int id, String fileId, String shipmentId, String bolNumber, String poNumber, String totalWeight, String totalVolume, String stopSeqNum) {
        this.id = id;
        this.fileId = fileId;
        this.shipmentId = shipmentId;
        this.bolNumber = bolNumber;
        this.poNumber = poNumber;
        this.totalWeight = totalWeight;
        this.totalVolume = totalVolume;
        this.stopSeqNum = stopSeqNum;
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

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getBolNumber() {
        return bolNumber;
    }

    public void setBolNumber(String bolNumber) {
        this.bolNumber = bolNumber;
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

    public String getStopSeqNum() {
        return stopSeqNum;
    }

    public void setStopSeqNum(String stopSeqNum) {
        this.stopSeqNum = stopSeqNum;
    }
     
    
}
