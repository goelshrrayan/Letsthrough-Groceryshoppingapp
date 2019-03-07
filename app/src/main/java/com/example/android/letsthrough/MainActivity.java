package com.example.android.letsthrough;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.letsthrough.Model.Products;
import com.example.android.letsthrough.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;


import com.example.android.letsthrough.AccountActivity.AccountMainActivity;
import com.example.android.letsthrough.AccountActivity.LoginActivity;
import com.example.android.letsthrough.AccountActivity.SignupActivity;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
private DatabaseReference productReference;
private RecyclerView recyclerView;
private TextView textView;
RecyclerView.LayoutManager layoutManager;
private SharedPreferences mPrefrences;
private SharedPreferences.Editor mEditor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OneSignal.startInit(this).init();
        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Amount.class);
                startActivity(intent);
            }
        });






    }

    public void Register(View view)
    {
        Intent intent=new Intent(MainActivity.this, AccountMainActivity.class);
        startActivity(intent);
    }

    public void openVegetables(View view)
    {
        mPrefrences= getSharedPreferences("ItemList",Context.MODE_PRIVATE);
        mEditor=mPrefrences.edit();
        mEditor.putString("Item","Vegetables");
        mEditor.commit();
        mEditor.apply();
        Intent i=new Intent(MainActivity.this,Vegetables.class);
    startActivity(i);}

    public void openfruits(View view)
    {mPrefrences= getSharedPreferences("ItemList",Context.MODE_PRIVATE);
        mEditor=mPrefrences.edit();
        mEditor.putString("Item","Fruits");
        mEditor.commit();
        mEditor.apply();
        Intent i=new Intent(MainActivity.this,fruits.class);
        startActivity(i);}


    public void openbeverages(View view)
    {
        mPrefrences= getSharedPreferences("ItemList",Context.MODE_PRIVATE);
        mEditor=mPrefrences.edit();
        mEditor.putString("Item","Beverages");
        mEditor.commit();
        mEditor.apply();
        Intent i=new Intent(MainActivity.this,beverages.class);
        startActivity(i);}

    public void openHousehold(View view)
    {
        mPrefrences= getSharedPreferences("ItemList",Context.MODE_PRIVATE);
        mEditor=mPrefrences.edit();
        mEditor.putString("Item","Household");
        mEditor.commit();
        mEditor.apply();
        Intent i=new Intent(MainActivity.this,Household.class);
        startActivity(i);}



}
