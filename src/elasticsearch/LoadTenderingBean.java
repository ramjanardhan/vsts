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
public class LoadTenderingBean {

    @JestId

    private int id;
    private String fileId;
    private String shipmentId;
    private String bolNumber;
    private String poNumber;
    private String coNumber;
    private String totalWeight;
    private String totalPieces;
    private String totalVolume;

    //
    public static LoadTenderingBean fromJSON(JSONObject json) {
        return new LoadTenderingBean(
                json.getInt("id"),
                json.getString("fileId"),
                json.getString("shipmentId"),
                json.getString("bolNumber"),
                json.getString("poNumber"),
                json.getString("coNumber"),
                json.getString("totalWeight"),
                json.getString("totalPieces"),
                json.getString("totalVolume")
        );
    }

    public LoadTenderingBean(int id, String fileId, String shipmentId, String bolNumber, String poNumber, String coNumber, String totalWeight, String totalPieces, String totalVolume) {
        this.id = id;
        this.fileId = fileId;
        this.shipmentId = shipmentId;
        this.bolNumber = bolNumber;
        this.poNumber = poNumber;
        this.coNumber = coNumber;
        this.totalWeight = totalWeight;
        this.totalPieces = totalPieces;
        this.totalVolume = totalVolume;
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

    public String getCoNumber() {
        return coNumber;
    }

    public void setCoNumber(String coNumber) {
        this.coNumber = coNumber;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getTotalPieces() {
        return totalPieces;
    }

    public void setTotalPieces(String totalPieces) {
        this.totalPieces = totalPieces;
    }

    public String getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(String totalVolume) {
        this.totalVolume = totalVolume;
    }

}
