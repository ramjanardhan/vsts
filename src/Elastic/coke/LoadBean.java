
package Elastic.coke;

import io.searchbox.annotations.JestId;
import net.sf.json.JSONObject;

/**
 *
 * @author rrandhi
 */
public class LoadBean {

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
}
