package com.example.mabalofernan.mytabugenerator;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mabalofernan.mytabugenerator.adapter.ThemesAdapter;
import com.example.mabalofernan.mytabugenerator.logic.persistence.ThemeJdbc;
import com.example.mabalofernan.mytabugenerator.model.Theme;

import java.util.List;

public class ManageThemesActivity extends AppCompatActivity {

    private ThemeJdbc themeRepository;
    private RecyclerView themesView;
    private RecyclerView.Adapter themesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_manage_themes);

        themeRepository = new ThemeJdbc();
        List<Theme> themes = themeRepository.getThemes();

        themesView = findViewById(R.id.themesView);
        themesAdapter = new ThemesAdapter(themes);
        themesView.setHasFixedSize(true);
        themesView.setLayoutManager(new LinearLayoutManager(this));
        themesView.setAdapter(themesAdapter);
    }
}
