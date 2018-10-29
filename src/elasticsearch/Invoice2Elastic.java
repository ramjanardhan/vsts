/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elasticsearch;

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
 * @author rrandhi
 */
public class Invoice2Elastic {

    static final String JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    static final String DB_URL = "jdbc:db2://192.168.1.179:50000/B2BSIPRD";

    static final String USER = "MSCVP";
    static final String PASS = "portal1";

    public static void main(String[] args) throws Exception {

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200")
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

            String sql = "SELECT\n"
                    + "    ID,\n"
                    + "    FILE_ID,\n"
                    + "    INVOICE_NUMBER,\n"
                    + "    SHIPMENT_ID,\n"
                    + "    INVOICE_DATE,\n"
                    + "    TOTAL_AMOUNT,\n"
                    + "    PO_NUMBER,\n"
                    + "    TOTAL_WEIGHT,\n"
                    + "    TOTAL_VOLUME\n"
                    + "FROM\n"
                    + "    MSCVP.TRANSPORT_INVOICE"; //EVENT_ID  between 23751000 and 23752000
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("ID");
                String file_id = rs.getString("FILE_ID");
                String invoice_number = rs.getString("INVOICE_NUMBER");
                String shipment_id = rs.getString("SHIPMENT_ID");
                String invoice_date = rs.getString("INVOICE_DATE");
                String total_number = rs.getString("TOTAL_AMOUNT");
                String po_number = rs.getString("PO_NUMBER");
                String total_weight = rs.getString("TOTAL_WEIGHT");
                String total_volume = rs.getString("TOTAL_VOLUME");
                InvoiceBean events = new InvoiceBean(id, file_id, invoice_number, shipment_id, invoice_date, total_number, po_number, total_weight, total_volume);
                System.out.println("events is"+events);
                ObjectMapper mapper = new ObjectMapper();
                String jsonInString = mapper.writeValueAsString(events);
                JSONObject json = (JSONObject) JSONSerializer.toJSON(jsonInString);
                InvoiceBean event = InvoiceBean.fromJSON((JSONObject) json);
                Index index = new Index.Builder(event).index("ltinvoice").type("ltinvoice").build();
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
