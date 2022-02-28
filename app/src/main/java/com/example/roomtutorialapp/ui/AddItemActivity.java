package com.example.roomtutorialapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomtutorialapp.R;
import com.example.roomtutorialapp.database.entity.ItemEntity;

public class AddItemActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY_TITLE = "com.example.android.itemlistsql.REPLY_TITLE";
    public static final String EXTRA_REPLY_QUANTITY = "com.example.android.itemlistsql.REPLY_QUANTITY";
    private EditText mEditTitle, mEditQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        mEditTitle = findViewById(R.id.edit_title);
        mEditQuantity = findViewById(R.id.edit_quantity);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditTitle.getText()) || TextUtils.isEmpty(mEditQuantity.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String title = mEditTitle.getText().toString();
                String quantity = mEditQuantity.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY_TITLE, title);
                replyIntent.putExtra(EXTRA_REPLY_QUANTITY, quantity);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}