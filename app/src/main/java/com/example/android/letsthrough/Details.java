package com.example.android.letsthrough;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.android.letsthrough.Model.Products;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
TextView name,price,description;
ImageView image;
CollapsingToolbarLayout collapsingToolbarLayout;
FloatingActionButton btn_cart;
ElegantNumberButton number_btn;
String ItemId="";
FirebaseDatabase database;
DatabaseReference reference,mref;
String n;
private int single;
    private SharedPreferences mPrefrences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        database=FirebaseDatabase.getInstance();
        SharedPreferences mPreferences=getSharedPreferences("ItemList", Context.MODE_PRIVATE);

        n=mPreferences.getString("Item","Products");
if(n=="Products")
{ reference= database.getReference("Products");}
if(n=="Fruits")
{reference=database.getReference("fruits");}
        if(n=="Beverages")
        {reference=database.getReference("Beverages");}
        if(n=="Household")
        {reference=database.getReference("Household");}

        number_btn=(ElegantNumberButton) findViewById(R.id.button_elegant);
        btn_cart=(FloatingActionButton) findViewById(R.id.btn_cart);
        description=(TextView) findViewById(R.id.item_description);
        name=(TextView) findViewById(R.id.item_name);
        price=(TextView) findViewById(R.id.item_price);
        image=(ImageView) findViewById(R.id.img_item);
        collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsingAppBar);

        if(getIntent()!=null)
        {
            ItemId=getIntent().getStringExtra("ItemId");}
            if(!ItemId.isEmpty())
            {
                getDetailItem(ItemId);
            }
        }



    private void getDetailItem(String itemId) {

        reference.child(itemId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Products products=dataSnapshot.getValue(Products.class);
                Picasso.with(getBaseContext()).load(products.getImage()).into(image);

                price.setText(products.getPrice2());
                single=Integer.parseInt(products.getPrice2());
                name.setText(products.getPname());
                description.setText(products.getDescription());
                collapsingToolbarLayout.setTitle(name.getText());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void AddToCart(View view)
    {mPrefrences=getSharedPreferences("TotalAmount",Context.MODE_PRIVATE);
        mEditor=mPrefrences.edit();

        int a,b,c,d,e,f,g,h,i,j,k,m;
        a=b=c=d=e=f=g=h=i=j=k=m=0;
        int l=mPrefrences.getInt("Amount",0);
         d=Integer.parseInt(number_btn.getNumber());
        int amount=(d*single)+l;
        mEditor.putInt("Amount",amount);
        mEditor.commit();
        mEditor.apply();

        if(n=="Vegetables")
        {a=mPrefrences.getInt("Veg",0);
             b=Integer.parseInt(number_btn.getNumber());
             c=(b*single)+a;
            mEditor.putInt("Veg",c);
            mEditor.commit();
            mEditor.apply();}

        if(n=="Fruits")
        {d=mPrefrences.getInt("Fru",0);
            e=Integer.parseInt(number_btn.getNumber());
            f=(e*single)+d;
            mEditor.putInt("Fru",f);
            mEditor.commit();
            mEditor.apply();}

        if(n=="Beverages")
        {g=mPrefrences.getInt("Bev",0);
            h=Integer.parseInt(number_btn.getNumber());
            i=(h*single)+g;
            mEditor.putInt("Bev",i);
            mEditor.commit();
            mEditor.apply();}

        if(n=="Household")
        {j=mPrefrences.getInt("Hou",0);
            k=Integer.parseInt(number_btn.getNumber());
            m=(k*single)+j;
            mEditor.putInt("Hou",m);
            mEditor.commit();
            mEditor.apply();}


Toast.makeText(this,"Added to Cart Successfully.\nCheck Amount in Home Screen Cart.",Toast.LENGTH_SHORT).show();

    }

}
