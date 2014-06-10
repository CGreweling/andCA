package de.larskiesow.andca.matterhorn;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import de.larskiesow.andca.AndCAApplication;
import de.larskiesow.andca.model.IcalObject;

/**
 * Created by cgreweling on 10.02.14.
 */
public class GetIcal {



    public String doInBackground(AndCAApplication app) {

        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {

				/* First login to the MH core server */
            HttpPost httpPost = new HttpPost("http://" + app.host + ":" + app.port + "/j_spring_security_check");

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("j_username", app.user));
            nvps.add(new BasicNameValuePair("j_password", app.passwd));

            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

				/* Then send the data to ingest */
           HttpGet httpGet = new HttpGet("http://" + app.host + ":" + app.port + "/recordings/calendars?agentid="+app.agentID);

            //MultipartEntity multipartEntity =  new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

            response = httpClient.execute(httpGet);
            BufferedReader reader = new BufferedReader( new InputStreamReader(
                    response.getEntity().getContent(), "UTF-8"));
            String sResponse = null;
            String temp;
            ArrayList list = new ArrayList();
            while ((temp = reader.readLine()) != null) {
              //  Log.d("getical",temp);

               sResponse+=temp + "\n";
            }

            return sResponse;

        } catch (Exception e) {
            Log.e("HTTP POST", e.getLocalizedMessage(), e);

            return null;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }

    }

}
