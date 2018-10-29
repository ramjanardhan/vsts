
package Elastic.coke;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author janardhan randhi
 */
public class LoadToElastic {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://172.17.0.180;DatabaseName=MSCVP_COKE";

    static final String USER = "MSCVP_SQL";
    static final String PASS = "Change@16";

    public static void main(String[] args) throws Exception {

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://172.17.12.122:9200/")
                .build());

        JestClient client = factory.getObject();

        StringWriter writer = new StringWriter();

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // Extract records without any condition.
            System.out.println("Fetching records ");

            String sql = "SELECT DISTINCT (FILES.FILE_ID) as FILE_ID,FILES.ID as ID,\n"
                    + "                FILES.ISA_NUMBER as ISA_NUMBER,FILES.FILE_TYPE as FILE_TYPE,FILES.CARRIER_STATUS,FILES.PRI_KEY_VAL  as PRI_KEY_VAL,FILES.SENDER_ID,FILES.RECEIVER_ID,\n"
                    + "                FILES.FILE_ORIGIN as FILE_ORIGIN,FILES.TRANSACTION_TYPE as TRANSACTION_TYPE,FILES.TMW_SENDERID as TMW_SENDERID,FILES.TMW_RECEIVERID as TMW_RECEIVERID,\n"
                    + "                FILES.DIRECTION as DIRECTION,FILES.DATE_TIME_RECEIVED as DATE_TIME_RECEIVED,\n"
                    + "                FILES.STATUS as STATUS,FILES.ACK_STATUS as ACK_STATUS,TP2.NAME as RECEIVER_NAME,TP1.NAME as SENDER_NAME,trsrsp.REF_ID,\n"
                    + "                FILES.SEC_KEY_VAL,FILES.REPROCESSSTATUS,FILES.FILENAME,trsrsp.RESPONSE_STATUS,FILES.TRANSACTION_PURPOSE,FILES.SEC_KEY_TYPE FROM FILES \n"
                    + "               \n"
                    + "                LEFT OUTER JOIN TRANSPORT_LT_RESPONSE trsrsp on (trsrsp.FILE_ID=FILES.FILE_ID)\n"
                    + "               \n"
                    + "                 LEFT OUTER JOIN TP TP1 ON (TP1.ID=FILES.TMW_SENDERID)\n"
                    + "                 LEFT OUTER JOIN TP TP2 ON (TP2.ID=FILES.TMW_RECEIVERID)\n"
                    + "                 LEFT OUTER JOIN TP TP3 ON (TP3.ID=FILES.SENDER_ID)\n"
                    + "                LEFT OUTER JOIN TP TP4 ON (TP4.ID=FILES.RECEIVER_ID) ORDER BY DATE_TIME_RECEIVED";
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                String file_id = rs.getString("FILE_ID");
                int id = rs.getInt("ID");
                String isa_Number = rs.getString("ISA_NUMBER");
                String file_type = rs.getString("FILE_TYPE");
                String carrier_status = rs.getString("CARRIER_STATUS");
                String pri_key_val = rs.getString("PRI_KEY_VAL");
                String sender_id = rs.getString("SENDER_ID");
                String receiver_id = rs.getString("RECEIVER_ID");
                String file_origin = rs.getString("FILE_ORIGIN");
                String transaction_type = rs.getString("TRANSACTION_TYPE");
                String tmw_senderid = rs.getString("TMW_SENDERID");
                String tmw_receiverid = rs.getString("TMW_RECEIVERID");
                String direction = rs.getString("DIRECTION");
                String date_time_received = rs.getString("DATE_TIME_RECEIVED");
                String status = rs.getString("STATUS");
                String ack_status = rs.getString("ACK_STATUS");
                String receiver_name = rs.getString("RECEIVER_NAME");
                String sender_name = rs.getString("SENDER_NAME");
                String ref_id = rs.getString("REF_ID");
                String sec_key_value = rs.getString("SEC_KEY_VAL");
                String reprocessstatus = rs.getString("REPROCESSSTATUS");
                String filename = rs.getString("FILENAME");
                String response_status = rs.getString("RESPONSE_STATUS");
                String transaction_purpose = rs.getString("TRANSACTION_PURPOSE");
                String sec_key_type = rs.getString("SEC_KEY_TYPE");
                DocBean events = new DocBean(file_id, id, isa_Number, file_type, carrier_status, pri_key_val, sender_id, receiver_id, file_origin, transaction_type, tmw_senderid, tmw_receiverid, direction, date_time_received, status, ack_status, receiver_name, sender_name, ref_id, sec_key_value, reprocessstatus, filename, response_status, transaction_purpose,sec_key_type);
                ObjectMapper mapper = new ObjectMapper();
                String jsonInString = mapper.writeValueAsString(events);
                JSONObject json = (JSONObject) JSONSerializer.toJSON(jsonInString);
                DocBean event = DocBean.fromJSON((JSONObject) json);
                Index index = new Index.Builder(event).index("doc").type("doc").build();
                client.execute(index);
                count++;
            }
            System.out.println("Count--->" + count);
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception-->" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

}
