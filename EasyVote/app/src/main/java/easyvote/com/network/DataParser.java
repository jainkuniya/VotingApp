package easyvote.com.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by vishwesh on 16/3/16.
 */
public class DataParser {
    ArrayList<String> subList = new ArrayList<>();
    public int createposition(Context context, JSONObject jsonObject) {
        try {
            /*String error = jsonObject.getString("error");
            String status = jsonObject.getString("status");
            if (error.equals("true"))
                return -1;
            else {
                if (status.equals("1"))*/ {

                    //JSONArray message = jsonObject.getJSONArray("result");
                //Toast.makeText(context, String.valueOf(message.length()) + "vbnm", Toast.LENGTH_LONG).show();

                if (jsonObject.getString("success").equals("1"))
                {
                    Toast.makeText(context,"Successfully Inserted",Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(context,"Please try again",Toast.LENGTH_SHORT).show();
                }




                    return 1;
                }/* else {
                    return 2;
                }*/
            } catch (JSONException e1) {
            e1.printStackTrace();
        }



      return -1;
    }
    public int createelection(Context context, JSONObject jsonObject, ProgressDialog progressDialog) {
        try {
            /*String error = jsonObject.getString("error");
            String status = jsonObject.getString("status");
            if (error.equals("true"))
                return -1;
            else {
                if (status.equals("1"))*/ {

                //JSONArray message = jsonObject.getJSONArray("result");
                //Toast.makeText(context, String.valueOf(message.length()) + "vbnm", Toast.LENGTH_LONG).show();

                if (jsonObject.getString("success").equals("1"))
                {
                    Toast.makeText(context,"Successfully Inserted",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(context,"Please try again",Toast.LENGTH_SHORT).show();
                }

                progressDialog.setProgress(100);
                progressDialog.dismiss();



                return 1;
            }/* else {
                    return 2;
                }*/
        } catch (JSONException e1) {
            e1.printStackTrace();
        }



        return -1;
    }



}
