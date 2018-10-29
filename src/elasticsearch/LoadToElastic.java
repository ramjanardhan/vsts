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
public class LoadToElastic {

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
                    + "    ASN_NUMBER,\n"
                    + "    PO_NUMBER,\n"
                    + "    BOL_NUMBER,\n"
                    + "    ISA_NUMBER,\n"
                    + "    ISA_DATE,\n"
                    + "    ISA_TIME,\n"
                    + "    SHIP_DATE,\n"
                    + "    FILE_ID\n"
                    + "FROM\n"
                    + "    MSCVP.ASN"; //EVENT_ID  between 23751000 and 23752000
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            if(rs.next())
            {
                 int count1 = rs.getRow();
    rs.beforeFirst();
                System.out.println(count1);
            }
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("ID");
                String asn_Number = rs.getString("ASN_NUMBER");
                String po_Number = rs.getString("PO_NUMBER");
                String bol_Number = rs.getString("BOL_NUMBER");
                String isaNumber = rs.getString("ISA_NUMBER");
                String isaDate = rs.getString("ISA_DATE");
                String isTime = rs.getString("ISA_TIME");
                String shipDate = rs.getString("SHIP_DATE");
                String fileId = rs.getString("FILE_ID");
                AsnBean events = new AsnBean(id, asn_Number, po_Number, bol_Number, isaNumber, isaDate, isTime, shipDate, fileId);
                ObjectMapper mapper = new ObjectMapper();
                String jsonInString = mapper.writeValueAsString(events);
                JSONObject json = (JSONObject) JSONSerializer.toJSON(jsonInString);
                AsnBean event = AsnBean.fromJSON((JSONObject) json);
                Index index = new Index.Builder(event).index("asnindex").type("asnindex").build();
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
