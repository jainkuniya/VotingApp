package easyvote.com.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by vishwesh on 16/3/16.
 */
public class HttpCall {
    int result;


    public void createelection(final Context context, final ProgressDialog progressDialog, String electionname, String electionplace,
                               String electiondate, String from_time, String to_time){
        RequestParams requestParams = new RequestParams();
        requestParams.put("name", electionname);
        requestParams.put("place", electionplace);
        requestParams.put("date", electiondate);
        requestParams.put("from_time", from_time);
        requestParams.put("to_time", to_time);
        requestParams.put("electioncreate", "");

        Log.e("inGetLogin",to_time);

        EndPoints.createelection(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        progressDialog.show();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        /*if (service != null)
                            service.stopSelf();*/
                        //Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                        Log.e("response", response.toString());
                        result = new DataParser().createelection(context, response, progressDialog);
                        /*if (result == 1) {
                            Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show();
                        } else if (result == -1) {
                            Toast.makeText(context, "No updates", Toast.LENGTH_SHORT).show();
                        }*/
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        //Log.e("error", errorResponse.toString() + " vishwesh");
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
        );
    }

    public void createposition(final Context context,  String electionposition){
        RequestParams requestParams = new RequestParams();
        requestParams.put("position", electionposition);
        requestParams.put("electionposition", "");

        Log.e("inGetLogin",electionposition);

        EndPoints.createposition(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        /*if (service != null)
                            service.stopSelf();*/
                        //Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                        Log.e("response", response.toString());
                        result = new DataParser().createposition(context, response);
                        /*if (result == 1) {
                            Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show();
                        } else if (result == -1) {
                            Toast.makeText(context, "No updates", Toast.LENGTH_SHORT).show();
                        }*/
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        //Log.e("error", errorResponse.toString() + " vishwesh");
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


}

