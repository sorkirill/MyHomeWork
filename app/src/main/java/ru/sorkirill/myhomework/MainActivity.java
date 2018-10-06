package ru.sorkirill.myhomework;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import ru.sorkirill.myhomework.sharedPreferences.MySharedPreferences;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = ListFragment.class.getName();
    private static  int changeStep = 0;
    public static final String EXTRA_MESSAGE = "extraMessage";
    private Button buttonFragment = findViewById(R.id.button_fragment);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //кнопка на открытие фрагмента
        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    //создадим меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.action_start:
               Intent intent = new Intent(MainActivity.this, MySharedPreferences.class);
               startActivity(intent);
               return true;
           case R.id.action_exit:
               finish();
               return true;
               default: return super.onOptionsItemSelected(item);
       }
    }


}


