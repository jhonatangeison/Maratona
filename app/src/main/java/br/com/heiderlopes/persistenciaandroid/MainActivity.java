package br.com.heiderlopes.persistenciaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrar(View v){
        Intent i = new Intent(this, CadastrarActivity.class);
        startActivity(i);
    }

    public void listar(View v){
        Intent i = new Intent(this, ListaAcademiaActivity.class);
        startActivity(i);

    }

    public void sair(View v){
        finish();

    }
}
