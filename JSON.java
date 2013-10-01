/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_session;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;
import net.sf.json.*;
public class JSON {

    public static void main(String[] args) throws Exception {
        String jsonTxt = FileReader.loadFileIntoString("src/projet_de_session/json/library.json", "UTF-8");

        JSONArray root = (JSONArray) JSONSerializer.toJSON(jsonTxt);
        //int documentCount = root.size();
        for (int i = 0; i < 2; i++) {
            JSONObject document = root.getJSONObject(i);
            if (document.getString("type").equals("book")) {
                System.out.println(document.getString("title") + " publié en " + document.getInt("year"));
            }
        }
    }
}