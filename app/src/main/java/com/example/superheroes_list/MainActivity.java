package com.example.superheroes_list;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements com.example.superheroes_list.MyAdapter.OnRecyclerviewClickListener {
    public static final String EXTRA_URL="imageurl";
    public static final String EXTRA_NAME="heroname";
    public static final String EXTRA_OCCU="occupation";
    public static final String EXTRA_ID="id";
    public static final String EXTRA_HEIGHT="height";
    public static final String EXTRA_WEIGHT="weight";
    public static final String EXTRA_INTELLI="intelligence";
    public static final String EXTRA_STRENGTH="strength";
    public static final String EXTRA_SPEED="speed";
    public static final String EXTRA_POWER="power";
    public static final String EXTRA_FIRSTAPPEARANCE="firstappearance";
    public static final String EXTRA_GENDER="gender";
    public static final String EXTRA_RACE="race";

    private static final String url = "https://akabab.github.io/superhero-api/api/all.json";
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<itemlist> itemlists;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemlists = new ArrayList<>();

        loadrecyclerviewdata();
    }
    private void loadrecyclerviewdata() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading data....");
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,
                url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressDialog.dismiss();
                        try {
                            for (int i=0;i<response.length();i++){
                                JSONObject object = response.getJSONObject(i);
                                JSONObject image = object.getJSONObject("images");
                                JSONObject work = object.getJSONObject("work");
                                JSONObject appeararance = object.getJSONObject("appearance");
                                JSONArray height = appeararance.getJSONArray("height");
                                JSONArray weight = appeararance.getJSONArray("weight");
                                JSONObject powerstats = object.getJSONObject("powerstats");
                                JSONObject biography = object.getJSONObject("biography");


                                itemlist item = new itemlist(
                                        object.getString("name"),
                                        image.getString("sm"),
                                        work.getString("occupation"),
                                        object.getInt("id"),
                                        appeararance.getString("gender"),
                                        appeararance.getString("race"),
                                        height.getString(1),
                                        weight.getString(1),
                                        powerstats.getInt("intelligence"),
                                        powerstats.getInt("strength"),
                                        powerstats.getInt("speed"),
                                        powerstats.getInt("power"),
                                        biography.getString("firstAppearance"));
                                itemlists.add(item);
                            }
                            adapter = new MyAdapter(itemlists,getApplicationContext());
                            recyclerView.setAdapter(adapter);
                            adapter.setOnRecyclerViewClickListener(MainActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "error message", Toast.LENGTH_SHORT).show();

            }
        }
        );
        queue.add(stringRequest);
    }


    @Override
    public void OnItemClick(int position, ImageView imageView) {
        Intent detintent = new Intent(MainActivity.this,MainActivity2.class);
        itemlist list = itemlists.get(position);
        detintent.putExtra(EXTRA_ID,list.getId());
        detintent.putExtra(EXTRA_NAME,list.getName());
        detintent.putExtra(EXTRA_URL,list.getImageurl());
        detintent.putExtra(EXTRA_OCCU,list.getDetails());
        detintent.putExtra(EXTRA_GENDER,list.getGender());
        detintent.putExtra(EXTRA_RACE,list.getRace());
        detintent.putExtra(EXTRA_HEIGHT,list.getHeight());
        detintent.putExtra(EXTRA_WEIGHT,list.getWeight());
        detintent.putExtra(EXTRA_INTELLI,list.getIntelligence());
        detintent.putExtra(EXTRA_STRENGTH,list.getStrength());
        detintent.putExtra(EXTRA_SPEED,list.getSpeed());
        detintent.putExtra(EXTRA_POWER,list.getPower());
        detintent.putExtra(EXTRA_FIRSTAPPEARANCE,list.getApp());
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,imageView, ViewCompat.getTransitionName(imageView));
        startActivity(detintent,options.toBundle());

    }
}
