package com.example.proyectofinaldtifernandez;
//librerias de conexion a BD SQLite

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    //constructor que se conecta y genera base de datos
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crea tabla en base de datos
        db.execSQL("create table articulo (cod integer primary key, descripcion text, ubicacion text, existencia integer )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists articulo");
        db.execSQL("create table articulo (cod integer primary key, descripcion text, ubicacion text, existencia integer )");
    }//inicia clase
}//termina clase

