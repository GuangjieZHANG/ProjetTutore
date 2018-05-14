package com.example.ressources.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import readers.StatEntry;

/**
 * Created by 张广洁 et Morgan on 2018/4/9.
 */

public class Database extends SQLiteOpenHelper {

    private final static String DB_NAME = "BDDRessource";
    private final static int VERSION = 1;

    private static Database instance = null;

    public static Database getInstance(Context context){
        if(instance == null){
            instance = new Database(context);
        }
        return instance;
    }

    public Database(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String enumTable = "CREATE TABLE ressources("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "type TEXT"+
                ");";

        String addRessource = "INSERT INTO ressources VALUES "+
                "('GPS'), ('MobileData'),('Wifi'),('SMS'),('Contacts');";
        db.execSQL(enumTable);
        db.execSQL(addRessource);

         String createTable = "CREATE TABLE donneesRessources("
                 +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                 +"timeStamp TIMESTAMP,"
                 +"appName VARCHAR(20),"
                 +"RESSOURCES REFERENCES ressources(type),"+
                 "detail TEXT);";
         /* ici , il veut des entiers mais on a besoin des string */
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //to add datas
    public void addData(Context context, StatEntry statEntry){

        SQLiteDatabase db = Database.getInstance(context).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("timeStamp", statEntry.getTimestamp().getTime());
        contentValues.put("appName",statEntry.getApp_name());
        //contentValues.put("ressources",statEntry.getResource());
        contentValues.put("detail",statEntry.getDetails().toString());
        db.insert("donneesRessources",null,contentValues);
        db.close();

    }

    // on utilise jamais
    private void deleteData (Context context,int id){
        SQLiteDatabase db = Database.getInstance(context).getWritableDatabase();
        db.delete("donneesRessources","id="+id,null);
        db.close();
    }

    //update demande algo
    private void updateData(){

    }

}
