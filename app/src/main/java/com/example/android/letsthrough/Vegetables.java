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

public class Vegetables extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference productReference;
    private RecyclerView recyclerView;
    private TextView textView;
    RecyclerView.LayoutManager layoutManager;
    private SharedPreferences mPrefrences;
    private SharedPreferences.Editor mEditor;


    FirebaseRecyclerAdapter<Products, BlogViewHolder> adapter;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);
        OneSignal.startInit(this).init();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        auth=FirebaseAuth.getInstance();
        productReference= FirebaseDatabase.getInstance().getReference().child("Products");
        productReference.keepSynced(true);
        //Splash Screen









        recyclerView=(RecyclerView) findViewById(R.id.recycler_Vegetables);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        textView=(TextView) findViewById(R.id.login);
    }

    public void Register(View view)
    {
        Intent intent=new Intent(Vegetables.this, AccountMainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();


        adapter  = new FirebaseRecyclerAdapter<Products, BlogViewHolder>
                (Products.class,R.layout.products_items_layout,BlogViewHolder.class,productReference) {

            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, final Products model, final int position) {
                viewHolder.setTitle(model.getPname());
                viewHolder.setDesc(model.getDescription());
                viewHolder.setImage(model.getImage());
                viewHolder.setPrice(model.getPrice());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPrefrences= getSharedPreferences("ItemList",Context.MODE_PRIVATE);
                        mEditor=mPrefrences.edit();
                        mEditor.putString("Item","Products");
                        mEditor.commit();
                        mEditor.apply();
                        Intent i=new Intent(Vegetables.this,Details.class);
                        i.putExtra("ItemId",adapter.getRef(position).getKey());
                        startActivity(i);
                    }
                });

            }



        };
        recyclerView.setAdapter(adapter);
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder{


        public TextView productName,productDescription,productPrice;
        public ImageView imageView;

        View mView;
        public BlogViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }

        public void setTitle(String title)
        {productName=(TextView) mView.findViewById(R.id.product_name);
            productName.setText(title);}

        public void setDesc(String desc)
        {productDescription=(TextView) mView.findViewById(R.id.product_description);
            productDescription.setText(desc);}

        public void setPrice(String price)
        {productPrice=(TextView) mView.findViewById(R.id.product_price);
            productPrice.setText(price);}

        public void setImage(String image)
        {imageView=(ImageView) mView.findViewById(R.id.product_image);
            try {
                Picasso.with(mView.getContext()).load(image).into(imageView);
            }
            catch (Exception e)
            {e.printStackTrace();}}


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                Intent i = new Intent(Vegetables.this, MainActivity.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Vegetables) {
            // Handle the camera action
        } else if (id == R.id.Beverages) {

        } else if (id == R.id.fruits) {
            Intent intent = new Intent(Vegetables.this, SplashActivity1.class);
            startActivity(intent);
        } else if (id == R.id.persona_care) {

        } else if (id == R.id.biscuits) {

        } else if (id == R.id.house_needs) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void openfruits(View view)
    {
        Intent intent = new Intent(Vegetables.this, fruits.class);
        startActivity(intent);}

    public void openbeverages(View view)
    {  mPrefrences= getSharedPreferences("ItemList",Context.MODE_PRIVATE);
        mEditor=mPrefrences.edit();
        mEditor.putString("Item","Beverages");
        mEditor.commit();
        mEditor.apply();
        Intent intent = new Intent(Vegetables.this, beverages.class);
        startActivity(intent);}
    public void openHousehold(View view)
    {
        mPrefrences= getSharedPreferences("ItemList",Context.MODE_PRIVATE);
        mEditor=mPrefrences.edit();
        mEditor.putString("Item","Household");
        mEditor.commit();
        mEditor.apply();
        Intent intent = new Intent(Vegetables.this, Household.class);
        startActivity(intent);}

}
