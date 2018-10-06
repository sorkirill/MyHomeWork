package ru.sorkirill.myhomework.sharedPreferences;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.sorkirill.myhomework.R;

public class MySharedPreferences extends AppCompatActivity {

    private EditText editTextShared;
    public static final String KEY = "key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        Button buttonSave = findViewById(R.id.button_save_shared);
        Button buttonExit = findViewById(R.id.button_exit_shared);
        editTextShared =findViewById(R.id.editTextShared);
        final Context context = MySharedPreferences.this;
        //установим текст из параметров SharedPreferences
        editTextShared.setText(SharedPreferencesManager.getStringPreferences(this,KEY));

        //запишем в sharedpreferences
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editTextShared.getText().toString();
                SharedPreferencesManager.putStrringPreferences(context,KEY,value);
                Toast.makeText(context, "Значение строки = "+value, Toast.LENGTH_SHORT).show();
                Toast.makeText(context, "Записано значение "+ SharedPreferencesManager.getStringPreferences(context,KEY), Toast.LENGTH_SHORT).show();
            }
        });

        //Exit
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
            }
        });
    }
}
