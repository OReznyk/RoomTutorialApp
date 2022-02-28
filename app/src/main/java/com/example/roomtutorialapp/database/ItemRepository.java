package com.example.roomtutorialapp.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomtutorialapp.database.dao.ItemDao;
import com.example.roomtutorialapp.database.entity.ItemEntity;

import java.util.List;

//A Repository manages queries and allows you to use multiple backends.
// The Repository implements the logic for deciding whether to fetch data from a network or use results cached in a local database
public class ItemRepository {
    private ItemDao mItemDao;
    private LiveData<List<ItemEntity>> mAllItems;

    public ItemRepository(Application application) {
        ItemRoomDatabase db = ItemRoomDatabase.getDatabase(application);
        mItemDao = db.itemDao();
        mAllItems = mItemDao.getAlphabetizedItems();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<ItemEntity>> getAllItems() {
        return mAllItems;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(ItemEntity item) {
        ItemRoomDatabase.databaseWriteExecutor.execute(() -> {
            mItemDao.insert(item);
        });
    }
}
