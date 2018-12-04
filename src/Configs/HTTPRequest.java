/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configs;

import Models.Location;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author adis
 */
public class HTTPRequest {
    private URL url = null;
    private HttpURLConnection con = null;
    
    public HTTPRequest(String url) throws Exception{
        this.setURL(url);
        con = (HttpURLConnection) this.url.openConnection();
    }
    
    public void setURL(String url) throws Exception{
        this.url = new URL(url);
    }
    
    public void setMethod(String method) throws Exception {
        this.con.setRequestMethod(method);
    }
    

    
    public LinkedList<Location> getResponse() throws IOException, JSONException{
        int status = con.getResponseCode();
        
        JSONObject jsnobject = null;
        LinkedList<Location> locations = new LinkedList();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
          String inputLine;
          StringBuffer content = new StringBuffer();

          while ((inputLine = in.readLine()) != null) {
//              System.out.println(inputLine);
              jsnobject = new JSONObject(inputLine);
          }

          in.close();
          
          
          if (jsnobject != null) {
            JSONArray jsonArray = jsnobject.getJSONArray("resourceSets");
            JSONObject explrObject = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                explrObject = jsonArray.getJSONObject(i);
//                System.out.println(explrObject);                
            }
            
            jsonArray = explrObject.getJSONArray("resources");
            
            String name = null;
            String address = null;
            String coordinates = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                explrObject = jsonArray.getJSONObject(i);
                                
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                name = jsonObject1.optString("name");
                coordinates = jsonObject1.optString("point");

                JSONObject coordinatesObj = new JSONObject(coordinates);
                coordinates = coordinatesObj.getJSONArray("coordinates").toString();

                locations.add(new Location(name, coordinates));
        }
          

                
          }            
            
            return locations;                      
    }
    
//    public static void main(String[] args) throws IOException, JSONException{
//        HTTPRequest req = null;
//        try {
//            req = new HTTPRequest("http://dev.virtualearth.net/REST/v1/Locations?query="+URLEncoder.encode("adelaide south australia", "UTF-8")+"&key=AiOtGAc694vVDVHMbMauu_fkxtvhvUX4tjpHuN76_h0nUGc-e2Ov7quNYMpA9Vnk");
//            req.setMethod("GET");
//        } catch (Exception ex) {
//            Logger.getLogger(HTTPRequest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        req.getResponse();
//    }
}

