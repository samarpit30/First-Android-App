package com.diginfoexpert.MBAutodeals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.diginfoexpert.MBAutodeals.Web_jsonActivity.EXTRA_CREATOR;
import static com.diginfoexpert.MBAutodeals.Web_jsonActivity.EXTRA_LIKES;
import static com.diginfoexpert.MBAutodeals.Web_jsonActivity.EXTRA_URL;

public class Web_json_product_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_json_product_);


        //Toolbar
        Toolbar toolbar  = findViewById(R.id.main_actionbar_home);
        setSupportActionBar(toolbar);
        //Toolbar


        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES,0);

        ImageView imageView = findViewById(R.id.web_image_detail);
        TextView textCreator = findViewById(R.id.web_creator_detail);
        TextView textLikes = findViewById(R.id.web_likes_detail);


        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textCreator.setText(creatorName);
        textLikes.setText("Likes: "+likeCount);
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
