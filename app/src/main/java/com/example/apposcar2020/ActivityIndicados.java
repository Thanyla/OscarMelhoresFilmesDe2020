package com.example.apposcar2020;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.apposcar2020.adapters.AdapterFilme;
import com.example.apposcar2020.models.Filme;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class ActivityIndicados extends AppCompatActivity {

    ListView listView;
    List<Filme> filmes;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicados);

        //objeto ListView do layout
        listView = findViewById(R.id.listView);

        SharedPreferences sharedPreferences = getSharedPreferences("jsonFilmes", Context.MODE_PRIVATE);
        String jsonString = sharedPreferences.getString("json", "");

        Gson gson = new Gson();
        Filme[] filmesJSON = gson.fromJson(jsonString, Filme[].class);

        AdapterFilme adapter = new AdapterFilme(Arrays.asList(filmesJSON), this);

        listView.setAdapter(adapter);
    }
}
