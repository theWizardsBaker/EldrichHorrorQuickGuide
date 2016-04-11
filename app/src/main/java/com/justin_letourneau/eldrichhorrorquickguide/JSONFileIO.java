package com.justin_letourneau.eldrichhorrorquickguide;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Neil on 4/10/2016.
 */
public final class JSONFileIO {

    public String readJSON(InputStream in) throws IOException, JSONException{

        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                jsonString.append(line);
            }
            return jsonString.toString();
        } catch (Exception e) {
            return "";
        } finally {
            if(reader != null)
                reader.close();
        }
    }
}
