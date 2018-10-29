
package Elastic.coke;
import io.searchbox.annotations.JestId;
import net.sf.json.JSONObject;
/**
 * @author  janardhan randhi
 */
public class DocBean 
{
    @JestId
    private String file_id;
    private int id;
    private String isa_number;
    private String file_type;
    private String carrier_status;
    private String pri_key_val;
    private String sender_id;
    private String receiver_id;
    private String file_origin;
    private String transaction_type;
    private String tmw_senderid;
    private String tmw_receiverid;
    private String direction;
    private String date_time_received;
    private String status;
    private String ack_status;
    private String receiver_name;
    private String sender_name;
    private String ref_id;
    private String sec_key_value;
    private String reprocessstatus;
    private String filename;
    private String response_status;
    private String transaction_purpose;
    private String sec_key_type;

    public static DocBean fromJSON(JSONObject json) {
        return new DocBean(
                json.getString("file_id"),
                json.getInt("id"),
                json.getString("isa_number"),
                json.getString("file_type"),
                json.getString("carrier_status"),
                json.getString("pri_key_val"),
                json.getString("sender_id"),
                json.getString("receiver_id"),
                json.getString("file_origin"),
                json.getString("transaction_type"),
                json.getString("tmw_senderid"),
                json.getString("tmw_receiverid"),
                json.getString("direction"),
                json.getString("date_time_received"),
                json.getString("status"),
                json.getString("ack_status"),
                json.getString("receiver_name"),
                json.getString("sender_name"),
                json.getString("ref_id"),
                json.getString("sec_key_value"),
                json.getString("reprocessstatus"),
                json.getString("filename"),
                json.getString("response_status"),
                json.getString("transaction_purpose"),
                json.getString("sec_key_type")
        );
    }
    public DocBean(String file_id, int id, String isa_number, String file_type, String carrier_staus, String pri_key_val, String sender_id, String receiver_id, String file_origin, String transaction_type, String tmw_senderid, String tmw_receiverid, String direction, String date_time_received, String status, String ack_status, String receiver_name, String sender_name, String ref_id, String sec_key_value, String reprocessstatus, String filename, String response_status, String transaction_purpose,String sec_key_type) {
        this.file_id = file_id;
        this.id = id;
        this.isa_number = isa_number;
        this.file_type = file_type;
        this.carrier_status = carrier_status;
        this.pri_key_val = pri_key_val;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.file_origin = file_origin;
        this.transaction_type = transaction_type;
        this.tmw_senderid = tmw_senderid;
        this.tmw_receiverid = tmw_receiverid;
        this.direction = direction;
        this.date_time_received = date_time_received;
        this.status = status;
        this.ack_status = ack_status;
        this.receiver_name = receiver_name;
        this.sender_name = sender_name;
        this.ref_id = ref_id;
        this.sec_key_value = sec_key_value;
        this.reprocessstatus = reprocessstatus;
        this.filename = filename;
        this.response_status = response_status;
        this.transaction_purpose = transaction_purpose;
        this.sec_key_type=sec_key_type;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsa_number() {
        return isa_number;
    }

    public void setIsa_number(String isa_number) {
        this.isa_number = isa_number;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getCarrier_status() {
        return carrier_status;
    }

    public void setCarrier_status(String carrier_status) {
        this.carrier_status = carrier_status;
    }

    public String getPri_key_val() {
        return pri_key_val;
    }

    public void setPri_key_val(String pri_key_val) {
        this.pri_key_val = pri_key_val;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getFile_origin() {
        return file_origin;
    }

    public void setFile_origin(String file_origin) {
        this.file_origin = file_origin;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getTmw_senderid() {
        return tmw_senderid;
    }

    public void setTmw_senderid(String tmw_senderid) {
        this.tmw_senderid = tmw_senderid;
    }

    public String getTmw_receiverid() {
        return tmw_receiverid;
    }

    public void setTmw_receiverid(String tmw_receiverid) {
        this.tmw_receiverid = tmw_receiverid;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDate_time_received() {
        return date_time_received;
    }

    public void setDate_time_received(String date_time_received) {
        this.date_time_received = date_time_received;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAck_status() {
        return ack_status;
    }

    public void setAck_status(String ack_status) {
        this.ack_status = ack_status;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getSec_key_value() {
        return sec_key_value;
    }

    public void setSec_key_value(String sec_key_value) {
        this.sec_key_value = sec_key_value;
    }

    public String getReprocessstatus() {
        return reprocessstatus;
    }

    public void setReprocessstatus(String reprocessstatus) {
        this.reprocessstatus = reprocessstatus;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getResponse_status() {
        return response_status;
    }

    public void setResponse_status(String response_status) {
        this.response_status = response_status;
    }

    public String getTransaction_purpose() {
        return transaction_purpose;
    }

    public void setTransaction_purpose(String transaction_purpose) {
        this.transaction_purpose = transaction_purpose;
    }

    public String getSec_key_type() {
        return sec_key_type;
    }

    public void setSec_key_type(String sec_key_type) {
        this.sec_key_type = sec_key_type;
    }
    
    
    
}
    

    