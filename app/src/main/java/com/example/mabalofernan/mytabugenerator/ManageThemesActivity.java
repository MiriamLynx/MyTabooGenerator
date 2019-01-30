package com.example.mabalofernan.mytabugenerator;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import com.example.mabalofernan.mytabugenerator.logic.persistence.ThemeJdbc;
import com.example.mabalofernan.mytabugenerator.model.Theme;

import java.util.List;

public class ManageThemesActivity extends AppCompatActivity {

    private ThemeJdbc themeRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_manage_themes);
        themeRepository = new ThemeJdbc();
        List<Theme> themes = themeRepository.getThemes();
    }
}
