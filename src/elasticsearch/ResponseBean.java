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
public class ResponseBean {

    @JestId

    private int id;
    private String fileId;
    private String shipmentId;
    private String refId;

    public static ResponseBean fromJSON(JSONObject json) {
        return new ResponseBean(
                json.getInt("id"),
                json.getString("fileId"),
                json.getString("shipmentId"),
                json.getString("refId")
        );
    }

    public ResponseBean(int id, String fileId, String shipmentId, String refId) {
        this.id = id;
        this.fileId = fileId;
        this.shipmentId = shipmentId;
        this.refId = refId;
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

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

}
