package com.diginfoexpert.MBAutodeals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //Toolbar
        Toolbar toolbar  = findViewById(R.id.main_actionbar_home);
        setSupportActionBar(toolbar);
        //Toolbar
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
