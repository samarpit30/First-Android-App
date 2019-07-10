package com.diginfoexpert.MBAutodeals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Web_jsonActivity extends AppCompatActivity implements WebAdapter.OnItemClickListener {

    public static final String EXTRA_URL = "imageURL";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";

    //private static int pageNo = 1;

    private RecyclerView mRecyclerView;
    private WebAdapter mWebAdapter;
    private ArrayList<WebItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_json);

        mRecyclerView = findViewById(R.id.web_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Toolbar
        Toolbar toolbar  = findViewById(R.id.main_actionbar_home);
        setSupportActionBar(toolbar);
        //Toolbar



        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        Toast.makeText(getApplicationContext(),"App started", Toast.LENGTH_LONG).show();

        //mExampleList.add(new WebItem("https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Samarpit",1009));
        //mExampleList.add(new WebItem("https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Pawanpreet",2965));
        //mWebAdapter = new WebAdapter(Web_jsonActivity.this,mExampleList);
        //mRecyclerView.setAdapter(mWebAdapter);

        parseJSON();


    }

    private void parseJSON(){
        String url = "https://pixabay.com/api/?key=12937834-7f518bd06dc5be4bcad6a76cf&q=cars&image_type=photo&page="/*+pageNo*/+"&per_page=10";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("hits");

                    for(int i = 0;i < jsonArray.length(); i++){
                        JSONObject hit = jsonArray.getJSONObject(i);
                        String creatorName = hit.getString("user");
                        String imageUrl = hit.getString("webformatURL");
                        int likeCount = hit.getInt("likes");

                        mExampleList.add(new WebItem(imageUrl,creatorName,likeCount));

                    }

                    mWebAdapter = new WebAdapter(Web_jsonActivity.this,mExampleList);
                    mRecyclerView.setAdapter(mWebAdapter);
                    mWebAdapter.setOnItemClickListener(Web_jsonActivity.this);
                    //pageNo++;

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Data not coming", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(Web_jsonActivity.this,Web_json_product_Activity.class);
        WebItem clickedItem = mExampleList.get(position);

        detailIntent.putExtra(EXTRA_URL,clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_CREATOR,clickedItem.getCreator());
        detailIntent.putExtra(EXTRA_LIKES,clickedItem.getLikes());

        startActivity(detailIntent);
    }

    //To show menu in toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sample_menu, menu);
        return true;
    }
    //To show menu in toolbar


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent menuIntent;

        switch (item.getItemId()){
            case R.id.item1:
                menuIntent = new Intent(getApplicationContext(),Web_jsonActivity.class);
                startActivity(menuIntent);
                break;

            case R.id.item2:
                menuIntent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(menuIntent);
                break;

            case R.id.item3:
                menuIntent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(menuIntent);
                break;
        }



        return super.onOptionsItemSelected(item);
    }

}


