package com.example.roomtutorialapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtutorialapp.R;
import com.example.roomtutorialapp.database.entity.ItemEntity;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private  final TextView itemRightTV, itemLeftTV;

    private ItemViewHolder(View itemView){
        super(itemView);
        itemRightTV = itemView.findViewById(R.id.rtv_right);
        itemLeftTV = itemView.findViewById(R.id.rtv_left);
    }
    public void bind(ItemEntity item) {
        itemLeftTV.setText(item.getTitle());
        itemRightTV.setText(item.getQuantity() + "");
    }

    static ItemViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }
}
