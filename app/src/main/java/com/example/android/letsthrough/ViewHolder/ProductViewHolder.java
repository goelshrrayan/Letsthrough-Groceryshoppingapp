package com.example.android.letsthrough.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.letsthrough.Interface.ItemClickListner;
import com.example.android.letsthrough.R;

/**
 * Created by hp on 19-01-2019.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView productName,productDescription,productPrice;
public ImageView imageView;
public ItemClickListner listner;
    public ProductViewHolder(View itemView) {
        super(itemView);

        imageView=(ImageView) itemView.findViewById(R.id.product_image);
        productName=(TextView) itemView.findViewById(R.id.product_name);
        productDescription=(TextView) itemView.findViewById(R.id.product_description);
        productPrice=(TextView) itemView.findViewById(R.id.product_price);

    }

    public  void setItemClickListner(ItemClickListner listner)
    {this.listner=listner;}

    @Override
    public void onClick(View view) {

   listner.onClick(view,getAdapterPosition(),false);

    }
}
