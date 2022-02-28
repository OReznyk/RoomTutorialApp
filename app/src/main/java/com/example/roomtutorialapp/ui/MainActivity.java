package com.example.roomtutorialapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.roomtutorialapp.R;
import com.example.roomtutorialapp.database.entity.ItemEntity;
import com.example.roomtutorialapp.viewmodel.ItemViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_ITEM_ACTIVITY_REQUEST_CODE = 1;
    private ItemViewModel mItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // rv init
        RecyclerView recyclerView = findViewById(R.id.rv_main_view);
        final ItemListAdapter adapter = new ItemListAdapter(new ItemListAdapter.ItemDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mItemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        mItemViewModel.getAllItems().observe(this, items-> {
            adapter.submitList(items);
        });
        FloatingActionButton fab = findViewById(R.id.fab_main_view);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
            startActivityForResult(intent, NEW_ITEM_ACTIVITY_REQUEST_CODE);
        });


    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_ITEM_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            int q = 0;
            if(data.getStringExtra(AddItemActivity.EXTRA_REPLY_QUANTITY) == null ) q = 0;
            else q = Integer.parseInt(data.getStringExtra(AddItemActivity.EXTRA_REPLY_QUANTITY));

            Toast.makeText(this, q + "", Toast.LENGTH_LONG).show();
            ItemEntity item = new ItemEntity(data.getStringExtra(AddItemActivity.EXTRA_REPLY_TITLE), q);
            mItemViewModel.insert(item);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}