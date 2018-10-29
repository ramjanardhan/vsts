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
public class AsnBean {

    @JestId
    private int id;
    private String asnNumber;
    private String poNumber;
    private String bolNumber;
    private String isaNumber;
    private String isaDate;
    private String isaTime;
    private String shipDate;
    private String fileId;

    public static AsnBean fromJSON(JSONObject json) {
        return new AsnBean(
                json.getInt("id"),
                json.getString("asnNumber"),
                json.getString("poNumber"),
                json.getString("bolNumber"),
                json.getString("isaNumber"),
                json.getString("isaDate"),
                json.getString("isaTime"),
                json.getString("shipDate"),
                json.getString("fileId")
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsnNumber() {
        return asnNumber;
    }

    public void setAsnNumber(String asnNumber) {
        this.asnNumber = asnNumber;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getBolNumber() {
        return bolNumber;
    }

    public void setBolNumber(String bolNumber) {
        this.bolNumber = bolNumber;
    }

    public String getIsaNumber() {
        return isaNumber;
    }

    public void setIsaNumber(String isaNumber) {
        this.isaNumber = isaNumber;
    }

    public String getIsaDate() {
        return isaDate;
    }

    public void setIsaDate(String isaDate) {
        this.isaDate = isaDate;
    }

    public String getIsaTime() {
        return isaTime;
    }

    public void setIsaTime(String isaTime) {
        this.isaTime = isaTime;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public AsnBean(int id, String asnNumber, String poNumber, String bolNumber, String isaNumber, String isaDate, String isaTime, String shipDate, String fileId) {
        this.id = id;
        this.asnNumber = asnNumber;
        this.poNumber = poNumber;
        this.bolNumber = bolNumber;
        this.isaNumber = isaNumber;
        this.isaDate = isaDate;
        this.isaTime = isaTime;
        this.shipDate = shipDate;
        this.fileId = fileId;
    }

}
