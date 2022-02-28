package com.example.roomtutorialapp.database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.roomtutorialapp.model.Item;

@Entity(tableName = "items")
public class ItemEntity implements Item {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private int quantity;

    public ItemEntity() {
    }

    @Ignore
    public ItemEntity(int id, @NonNull String title, int quantity) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
    }
    @Ignore
    public ItemEntity(@NonNull String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public ItemEntity(Item item){
        this.id = item.getId();
        this.title = item.getTitle();
        this.quantity = item.getQuantity();
    }
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
