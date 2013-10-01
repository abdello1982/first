/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONSerializer;
//import sun.misc.IOUtils;
//import java.util.*;
import org.apache.commons.io.IOUtils;

public class FileReader {
    public static String loadFileIntoString(String filePath, String fileEncoding) throws FileNotFoundException, IOException {
        return IOUtils.toString(new FileInputStream(filePath), fileEncoding);
    }
}
