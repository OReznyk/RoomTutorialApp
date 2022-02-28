package com.example.roomtutorialapp.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomtutorialapp.database.entity.ItemEntity;
import java.util.List;

@Dao
public interface ItemDao {
    // allowing the insert of the same item multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ItemEntity item);

    @Query("DELETE FROM items")
    void deleteAll();

    @Query("SELECT * FROM items ORDER BY title ASC")
    LiveData<List<ItemEntity>> getAlphabetizedItems();

}