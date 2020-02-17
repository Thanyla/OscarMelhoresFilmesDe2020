package com.example.apposcar2020;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apposcar2020.model.Filme;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextDiretor, editTextCategoria;
    private Button buttonCadastrar, buttonIndicados;
    private List<Filme> filmes;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        editTextNome.findViewById(R.id.editTextNome);
        editTextDiretor.findViewById(R.id.editTextDiretor);
        editTextCategoria.findViewById(R.id.editTextCategoria);
        buttonCadastrar.findViewById(R.id.buttonCadastrar);
        buttonIndicados.findViewById(R.id.buttonIndicados);

        sharedPreferences = getSharedPreferences("jsonFilmes", Context.MODE_PRIVATE);
        filmes = new ArrayList<>();
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Não fiz os set para testar se funciona sem
                String nome = editTextNome.getText().toString();
                String diretor = editTextDiretor.getText().toString();
                String categoria = editTextCategoria.getText().toString();

                //outro método
                if((!nome.isEmpty()) && (!diretor.isEmpty()) && (!categoria.isEmpty())){
                    Filme f = new Filme(nome, diretor, categoria);
                    filmes.add(f);
                    Toast.makeText(getApplicationContext(), "Filme cadastrado", Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getApplicationContext(), "Dados inválidos", Toast.LENGTH_LONG).show();

            }//onclick
        });//setOnClickListener

        buttonIndicados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(filmes.isEmpty())){
                    Gson gson = new Gson();
                    String stringJson = gson.toJson(filmes);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), Indicados.class);
                    startActivity(intent);
                    finish();
                }else
                    Toast.makeText(getApplicationContext(), "Dados inválidos", Toast.LENGTH_LONG).show();
            }
        });

    }
}
