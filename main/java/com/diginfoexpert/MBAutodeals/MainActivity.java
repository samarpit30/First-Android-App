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

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private ArrayList<ExampleItem> mExampleList = new ArrayList<>();

    private RecyclerView mRecyclerview;
    private ExampleAdpater mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        //Toolbar
        Toolbar toolbar  = findViewById(R.id.main_actionbar_home);
        setSupportActionBar(toolbar);
        //Toolbar


        //Start recyclerview
        createExampleList();
        buildRecyclerView();

    }

    public void changeItem(int position/*, String text*/){
        //mExampleList.get(position).changeText(text);
        mAdapter.notifyItemChanged(position);
        Intent intent = new Intent(getApplicationContext(),ProductActivity.class);
        startActivity(intent);
    }

        public void createExampleList(){
            mExampleList.add(new ExampleItem(R.drawable.car, "Product1", "Description1", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product2", "Description2", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product3", "Description3", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product4", "Description4", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product5", "Description5", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product6", "Description6", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product7", "Description7", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product8", "Description8", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product9", "Description9", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product10", "Description10", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product11", "Description11", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
            mExampleList.add(new ExampleItem(R.drawable.car, "Product12", "Description12", "Bla Bla Bla Bla Bla Bla Bla Bla Bla", "Bla Bla Bla Bla Bla Bla Bla Bla Bla"));
        }

        public void buildRecyclerView() {
            mRecyclerview = findViewById(R.id.main_recyclerview);
            mRecyclerview.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new ExampleAdpater(mExampleList);

            mRecyclerview.setLayoutManager(mLayoutManager);
            mRecyclerview.setAdapter(mAdapter);

            mAdapter.setOnItemClicListener(new ExampleAdpater.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    changeItem(position);
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
