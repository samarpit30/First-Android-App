package com.diginfoexpert.MBAutodeals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = findViewById(R.id.login_nm);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });
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
                break;

            case R.id.item2:
                menuIntent = new Intent(getApplicationContext(),LoginActivity.class);
                break;

            case R.id.item3:
                menuIntent = new Intent(getApplicationContext(),MainActivity.class);
                break;

            default:
                menuIntent = new Intent(getApplicationContext(),Web_jsonActivity.class);
        }

        startActivity(menuIntent);

        return super.onOptionsItemSelected(item);
    }
}
