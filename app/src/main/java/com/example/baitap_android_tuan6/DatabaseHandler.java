package com.example.baitap_android_tuan6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "poularDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "poulars";

    private static final String KEY_ID = "id";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_poulars_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s INTEGER, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_IMAGES, KEY_NAME, KEY_PRICE);
        db.execSQL(create_poulars_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_poulars_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_poulars_table);

        onCreate(db);
    }
    public void addPoular(Poular poular) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(String.valueOf(KEY_IMAGES),poular.getImagesPoular());
        values.put(KEY_NAME,poular.getNamePoular());
        values.put(KEY_PRICE,poular.getPricePoular());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Poular getPoular(int poularId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = ?", new String[] { String.valueOf(poularId) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Poular poular = new Poular(cursor.getInt(0), cursor.getInt(1), cursor.getString(3), cursor.getString(2));
        return poular;
    }
    public ArrayList<Poular> getAllPoular() {
        ArrayList<Poular>  poularArrayList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Poular poular = new Poular(cursor.getInt(0), cursor.getInt(1), cursor.getString(3), cursor.getString(2));
            poularArrayList.add(poular);
            cursor.moveToNext();
        }
        return poularArrayList;
    }
}