package com.example.roomtutorialapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomtutorialapp.database.ItemRepository;
import com.example.roomtutorialapp.database.entity.ItemEntity;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private ItemRepository itemRepository;
    private final LiveData<List<ItemEntity>> mAllItems;

    // TIP: If you need the application context (which has a lifecycle that lives as long as the application does), use AndroidViewModel
    public ItemViewModel(@NonNull Application application) {
        super(application);
        itemRepository = new ItemRepository(application);
        this.mAllItems = itemRepository.getAllItems();
    }

    public LiveData<List<ItemEntity>> getAllItems() {
        return mAllItems;
    }
    public void insert(ItemEntity item){
        itemRepository.insert(item);
    }
}
