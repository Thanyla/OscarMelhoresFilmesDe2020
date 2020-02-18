package com.example.apposcar2020.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.apposcar2020.R;
import com.example.apposcar2020.models.Filme;

import java.util.List;

public class AdapterFilme extends BaseAdapter {

    private List<Filme> filmes;
    private Activity activity;

    public AdapterFilme(List<Filme> filmes, Activity activity) {
        this.filmes = filmes;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return filmes.size();
    }

    @Override
    public Object getItem(int i) {
        return filmes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflater = this.activity.getLayoutInflater().inflate(R.layout.item_lista, viewGroup, false);
        Filme filme = filmes.get(i);

        TextView nome = (TextView) viewInflater.findViewById(R.id.textNome);
        TextView categoria = (TextView) viewInflater.findViewById(R.id.textCategoria);
        TextView diretor = (TextView) viewInflater.findViewById(R.id.textDiretor);

        nome.setText(filme.getNome());
        categoria.setText(filme.getCategoria());
        diretor.setText(filme.getDiretor());

        return viewInflater;
    }
}
