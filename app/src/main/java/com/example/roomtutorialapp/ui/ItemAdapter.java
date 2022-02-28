package com.example.roomtutorialapp.ui;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.roomtutorialapp.database.entity.ItemEntity;

class ItemListAdapter extends ListAdapter<ItemEntity, ItemViewHolder> {
    protected ItemListAdapter(@NonNull DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
    }


    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemEntity current = (ItemEntity) getItem(position);
        holder.bind(current);
    }

    static class ItemDiff extends DiffUtil.ItemCallback<ItemEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull ItemEntity oldItem, @NonNull ItemEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemEntity oldItem, @NonNull ItemEntity newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}
