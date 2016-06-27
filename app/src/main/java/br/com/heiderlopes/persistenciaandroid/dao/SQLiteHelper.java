package br.com.heiderlopes.persistenciaandroid.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by heiderlopes on 08/01/16.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "maratona";

    private static final String DATABASE_NAME = "maratona.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement para criar a tabela
        String CREATE_BOOK_TABLE = "CREATE TABLE "+TABLE_NAME+" ( " +
                "id INTEGER, " +
                "titulo TEXT, " +"problema TEXT, " + "entrada TEXT, " +
                "saida TEXT, " + "exemplo_entrada TEXT, " + "exemplo_saida TEXT, " +
                "codigo_fonte TEXT)";

        // cria a tabela
        db.execSQL(CREATE_BOOK_TABLE);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Apaga tabela game se ja existir
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        this.onCreate(db);
    }

}