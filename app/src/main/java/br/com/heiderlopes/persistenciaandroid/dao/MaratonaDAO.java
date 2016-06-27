package br.com.heiderlopes.persistenciaandroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.com.heiderlopes.persistenciaandroid.model.Academia;

/**
 * Created by heiderlopes on 08/01/16.
 */
public class MaratonaDAO {


    private SQLiteHelper banco;

    public MaratonaDAO(Context context) {
        banco = new SQLiteHelper(context);
    }


    private static final String TABLE_NAME = "maratona";

    private static final String KEY_ID = "id";
    private static final String KEY_TITULO = "titulo";
    private static final String KEY_PROBLEMA = "problema";
    private static final String KEY_ENTRADA = "entrada";
    private static final String KEY_SAIDA ="saida";
    private static final String KEY_EXEMPLO_ENTRADA = "exemplo_entrada";
    private static final String KEY_EXEMPLO_SAIDA = "exemplo_saida";
    private static final String KEY_CODIGO_FONTE = "codigo_fonte";






    public String add(Academia academia){

        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITULO, academia.getTITULO());
        values.put(KEY_PROBLEMA, academia.getPROBLEMA());
        values.put(KEY_ENTRADA, academia.getENTRADA());
        values.put(KEY_EXEMPLO_ENTRADA, academia.getEXEMPLO_ENTRADA());
        values.put(KEY_EXEMPLO_SAIDA, academia.getEXEMPLO_SAIDA());
        values.put(KEY_CODIGO_FONTE, academia.getCODIGO_FONTE());
        values.put(KEY_SAIDA, academia.getSAÍDA());
        values.put(KEY_ID, academia.getId());
        resultado = db.insert(TABLE_NAME,
                null,
                values);
        db.close();

        if(resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }

    public List<Academia> ConsultaTodos() {
        List<Academia> academias = new LinkedList<>();

        String query = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Academia academia = null;
        if (cursor.moveToFirst()) {
            do {
                academia = new Academia();
                academia.setId(Integer.parseInt(cursor.getString(0)));
                academia.setTITULO(cursor.getString(1));
                academia.setPROBLEMA(cursor.getString(2));
                academia.setENTRADA(cursor.getString(3));
                academia.setSAÍDA(cursor.getString(4));
                academia.setEXEMPLO_ENTRADA(cursor.getString(5));
                academia.setEXEMPLO_SAIDA(cursor.getString(6));
                academia.setCODIGO_FONTE(cursor.getString(7));

                academias.add(academia);
            } while (cursor.moveToNext());
        }
        db.close();
        return academias;
    }

    public Academia ConsultaUnica(String nome) {


        String query = "SELECT * FROM " + TABLE_NAME + " WHERE titulo like '"+ nome+"'";

        SQLiteDatabase db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Academia academia = null;
        if (cursor.moveToFirst()) {
            do {
                academia = new Academia();
                academia.setId(Integer.parseInt(cursor.getString(0)));
                academia.setTITULO(cursor.getString(1));
                academia.setPROBLEMA(cursor.getString(2));
                academia.setENTRADA(cursor.getString(3));
                academia.setSAÍDA(cursor.getString(4));
                academia.setEXEMPLO_ENTRADA(cursor.getString(5));
                academia.setEXEMPLO_SAIDA(cursor.getString(6));
                academia.setCODIGO_FONTE(cursor.getString(7));

            } while (cursor.moveToNext());
        }
        db.close();
        return academia;
    }


    public String update(Academia academia) {

        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITULO, academia.getTITULO());
        values.put(KEY_PROBLEMA, academia.getPROBLEMA());
        values.put(KEY_ENTRADA, academia.getENTRADA());
        values.put(KEY_EXEMPLO_ENTRADA, academia.getEXEMPLO_ENTRADA());
        values.put(KEY_EXEMPLO_SAIDA, academia.getEXEMPLO_SAIDA());
        values.put(KEY_CODIGO_FONTE, academia.getCODIGO_FONTE());
        values.put(KEY_SAIDA, academia.getSAÍDA());
        resultado = db.update(TABLE_NAME, values, "id=" + academia.getId(), null);
        db.close();

        if(resultado == -1) {
            return "Erro ao Atualizar  registro";
        } else {
            return "Registro Atualizar com sucesso";
        }
    }

    public String excluir(int id) {

        SQLiteDatabase db = banco.getWritableDatabase();
        long resultado =  db.delete(TABLE_NAME, KEY_ID + "=" + id, null);
        db.close();
        if(resultado == -1) {
            return "Erro ao excluir registro";
        } else {
            return "Registro excluido com sucesso";
        }
    }

    public int getId() {

        String query = "SELECT id FROM " + TABLE_NAME ;

        SQLiteDatabase db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int id=1;

        if (cursor.moveToFirst()) {
            do {

                id = (cursor.getInt(0));


            } while (cursor.moveToNext());
        }
        else
            return id;
        db.close();
        return id+1;

    }
}
