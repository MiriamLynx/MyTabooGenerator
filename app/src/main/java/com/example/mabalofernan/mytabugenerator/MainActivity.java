package com.example.mabalofernan.mytabugenerator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.DriverManager;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private Button manageThemesButton;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        manageThemesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, ManageThemesActivity.class);
              startActivity(intent);
            }
        });

    }

    public void init(){
        manageThemesButton = findViewById(R.id.manage);
        context = getApplicationContext();
    }

}
