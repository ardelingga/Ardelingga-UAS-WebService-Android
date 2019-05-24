package ardelinggapramestakusuma.ezyro.com.ardelingga_uas_webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView textHasilJSON;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue = Volley.newRequestQueue(this);
        textHasilJSON = findViewById(R.id.textJSON);
        //Button tombolJson = findViewById(R.id.btnJSON);

        String url = "http://papaside.com/data.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject data = response.getJSONObject(i);

                        String kota = data.getString("Kota");
                        String siang= data.getString("siang");
                        String malam = data.getString("malam");
                        String dini_hari = data.getString("dini_hari");
                        String suhu = data.getString("suhu");
                        String kelembapan = data.getString("Kelembapan");

                        textHasilJSON.append("Kota = "+kota+"\n"+"Tanggal = "+siang+"\n"+"Jam Mulai = "
                                +malam+"\n"+"Jam Selesai = "+dini_hari+"\n"+"Jenis Kualitas = "
                                +suhu+"Jenis Kualitas = "+kelembapan+"\n\n");
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.add(request);

//        tombolJson.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                uraiJson();
//            }
//        });
    }

    private void uraiJson(){
        String url = "http://papaside.com/data.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject data = response.getJSONObject(i);

                        String kota = data.getString("Kota");
                        String siang= data.getString("siang");
                        String malam = data.getString("malam");
                        String dini_hari = data.getString("dini_hari");
                        String suhu = data.getString("suhu");
                        String kelembapan = data.getString("Kelembapan");

                        textHasilJSON.append("Kota = "+kota+"\n"+"Tanggal = "+siang+"\n"+"Jam Mulai = "
                                +malam+"\n"+"Jam Selesai = "+dini_hari+"\n"+"Jenis Kualitas = "
                                +suhu+"Jenis Kualitas = "+kelembapan+"\n\n");
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.add(request);
    }
}
