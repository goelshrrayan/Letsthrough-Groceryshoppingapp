package com.example.android.letsthrough;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Amount extends AppCompatActivity {
private SharedPreferences mSharedPreferences;
private SharedPreferences.Editor mEditor;
TextView veg,fru,bev,hou,total;
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);


        veg=(TextView) findViewById(R.id.Vegetables);
        fru=(TextView) findViewById(R.id.Fruits);
        bev=(TextView) findViewById(R.id.Beverages);
        hou=(TextView) findViewById(R.id.Household);
        total=(TextView) findViewById(R.id.Total);
        mSharedPreferences=getSharedPreferences("TotalAmount", Context.MODE_PRIVATE);
        int a,b,c,d,e;
        a=mSharedPreferences.getInt("Veg",0);
        b=mSharedPreferences.getInt("Fru",0);
        c=mSharedPreferences.getInt("Bev",0);
        d=mSharedPreferences.getInt("Hou",0);
        e=mSharedPreferences.getInt("Amount",0);
a=e-(b+c+d);
        veg.setText("Total Amount For Vegetables:- INR "+a);
        fru.setText("Total Amount For Fruits:- INR "+b);
        bev.setText("Total Amount For Beverages:- INR "+c);
        hou.setText("Total Amount For Household Needs:- INR "+d);
        total.setText("Total Amount:- INR "+e);
    }



    public void Cancel(View view)
    {mSharedPreferences=getSharedPreferences("TotalAmount", Context.MODE_PRIVATE);
        mEditor=mSharedPreferences.edit();

        mEditor.putInt("Amount",0);
        mEditor.commit();
        mEditor.apply();

        mEditor.putInt("Veg",0);
        mEditor.commit();
        mEditor.apply();

        mEditor.putInt("Fru",0);
        mEditor.commit();
        mEditor.apply();

        mEditor.putInt("Bev",0);
        mEditor.commit();
        mEditor.apply();

        mEditor.putInt("Hou",0);
        mEditor.commit();
        mEditor.apply();

        veg.setText("Total Amount For Vegetables:- INR: 0");
        fru.setText("Total Amount For Fruits:- INR: 0");
        bev.setText("Total Amount For Beverages:- INR: 0");
        hou.setText("Total Amount For Household Needs:- INR: 0");
        total.setText("Total Amount:- INR: 0");
    }

    public void Submit(View view)
    {
        Toast.makeText(this,"Coming Soon.",Toast.LENGTH_SHORT).show();}
}
