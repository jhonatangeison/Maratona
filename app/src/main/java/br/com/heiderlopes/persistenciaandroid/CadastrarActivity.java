package br.com.heiderlopes.persistenciaandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.heiderlopes.persistenciaandroid.dao.MaratonaDAO;
import br.com.heiderlopes.persistenciaandroid.model.Academia;

public class CadastrarActivity extends AppCompatActivity {

    private EditText id,titulo,problema,entrada,saida,exemploEntrada,exemploSaida,codigo;
    private Button btnSalvar;
    private MaratonaDAO dao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);


        iniciaEditText();
        dao = new MaratonaDAO(this);
        id.setText(String.valueOf(dao.getId()));


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verfica())
                 Salvar();
                else
                    Toast.makeText(CadastrarActivity.this,"Prencha todos os campos obrigatorios",Toast.LENGTH_SHORT).show();
            }

            private boolean verfica() {

                if(titulo.getText().toString().isEmpty())
                    return false;
                if(problema.getText().toString().isEmpty())
                    return false;
                if(entrada.getText().toString().isEmpty())
                    return false;
                if(saida.getText().toString().isEmpty())
                    return false;
                if(exemploEntrada.getText().toString().isEmpty())
                    return false;
                if(exemploSaida.getText().toString().isEmpty())
                    return false;
                return true;

            }
        });


    }



    private void iniciaEditText() {

        id = (EditText)findViewById(R.id.txtNum);
        id.setEnabled(false);
        titulo = (EditText)findViewById(R.id.txtTITULO);

        problema = (EditText)findViewById(R.id.txtProblema);

        entrada = (EditText)findViewById(R.id.txtEntrada);

        saida = (EditText)findViewById(R.id.txtSaida);

        exemploEntrada = (EditText)findViewById(R.id.txtExemploEntrada);

        exemploSaida = (EditText)findViewById(R.id.txtExemploSaida);

        codigo = (EditText)findViewById(R.id.txtCodigo);

        btnSalvar = (Button)findViewById(R.id.btnExcluir);

    }



    public void Salvar() {


        dao = new MaratonaDAO(this);
        Academia academia = new Academia();
        academia.setTITULO(titulo.getText().toString());
        academia.setPROBLEMA(problema.getText().toString());
        academia.setENTRADA(entrada.getText().toString());
        academia.setSAÍDA(saida.getText().toString());
        academia.setEXEMPLO_ENTRADA(exemploEntrada.getText().toString());
        academia.setEXEMPLO_SAIDA(exemploSaida.getText().toString());
        academia.setCODIGO_FONTE(codigo.getText().toString());
        academia.setId(Integer.parseInt(id.getText().toString()));
        Toast.makeText(this, dao.add(academia), Toast.LENGTH_LONG).show();
        onBackPressed();
    }



}
