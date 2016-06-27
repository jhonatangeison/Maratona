package br.com.heiderlopes.persistenciaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.heiderlopes.persistenciaandroid.adapter.MaratonaAdapter;
import br.com.heiderlopes.persistenciaandroid.dao.MaratonaDAO;
import br.com.heiderlopes.persistenciaandroid.model.Academia;

public class ListaAcademiaActivity extends AppCompatActivity {

    private ListView lvAcademia;
    private EditText numero,titulo,problema,entrada,saida,exemploEntrada,exemploSaida,codigo;
    private Button btnSair,btnExcluir;
    private Academia academia;
    private MaratonaDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        lvAcademia = (ListView)findViewById(R.id.lvUsuarios);
         dao = new MaratonaDAO(this);

        lvAcademia.setAdapter(new MaratonaAdapter(this, dao.ConsultaTodos()));

        lvAcademia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                TextView deleteIcon = (TextView) lvAcademia.getChildAt(position).findViewById(R.id.tvNome);
                String nomeUser= deleteIcon.getText().toString();
                dao = new MaratonaDAO(ListaAcademiaActivity.this);


                setContentView(R.layout.activity_mostra_usuario);
                iniciaObj();
                academia = dao.ConsultaUnica(nomeUser);




                titulo.setText(academia.getTITULO());
                problema.setText(academia.getPROBLEMA());
                entrada.setText(academia.getENTRADA());
                saida.setText(academia.getSAÍDA());
                exemploEntrada.setText(academia.getEXEMPLO_ENTRADA());
                exemploSaida.setText(academia.getEXEMPLO_SAIDA());
                codigo.setText(academia.getCODIGO_FONTE());
                numero.setText(String.valueOf(academia.getId()));




                btnSair.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        academia.setTITULO(titulo.getText().toString());
                        academia.setPROBLEMA(problema.getText().toString());
                        academia.setENTRADA(entrada.getText().toString());
                        academia.setSAÍDA(saida.getText().toString());
                        academia.setEXEMPLO_ENTRADA(exemploEntrada.getText().toString());
                        academia.setEXEMPLO_SAIDA(exemploSaida.getText().toString());
                        academia.setCODIGO_FONTE(codigo.getText().toString());
                        String var=  dao.update(academia);

                        Toast.makeText(ListaAcademiaActivity.this,var,Toast.LENGTH_LONG).show();
                        onBackPressed();
                    }


                });


                btnExcluir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    String var =  dao.excluir(academia.getId());
                       Toast.makeText(ListaAcademiaActivity.this,var,Toast.LENGTH_LONG).show();
                        onBackPressed();
                    }
                });



            }



            private void iniciaObj() {
                numero = (EditText)findViewById(R.id.txtNumLista);
                numero.setEnabled(false);
                titulo = (EditText)findViewById(R.id.txtTiluloLista);
                problema = (EditText)findViewById(R.id.txtProblemaLista);
                entrada = (EditText)findViewById(R.id.txtEntradaLista);
                saida = (EditText)findViewById(R.id.txtSaidaLista);
                exemploEntrada = (EditText)findViewById(R.id.txtExemploEntradaLista);
                exemploSaida = (EditText)findViewById(R.id.txtExemploSaidaLista);
                codigo = (EditText)findViewById(R.id.txtCodigoLista);
                btnSair = (Button)findViewById(R.id.btnAlterar);
                btnExcluir = (Button)findViewById(R.id.btnExcluir);


            }
        });

    }
}
