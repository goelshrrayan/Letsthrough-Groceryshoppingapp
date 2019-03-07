package com.example.android.letsthrough.Interface;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hp on 19-01-2019.
 */

public interface ItemClickListner {

    void onClick(View view,int position,boolean isLongClick);
}
