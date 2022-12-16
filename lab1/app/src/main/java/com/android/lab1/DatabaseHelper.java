package com.android.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

class DatabaseHelper extends SQLiteOpenHelper {

    DatabaseHelper(@Nullable Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE font_text (font_type TEXT, input TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS font_text");
        onCreate(db);
    }

    public Boolean insertData(String path, String text) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("font_type", path);
        contentValues.put("input", text);
        return db.insert("font_text", null, contentValues) != -1;
    }

    public void deleteData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+"font_text");
    }
    public String getDataStrings() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM font_text;", null);
        String text_data = "";
        while (cursor.moveToNext()) {
            String font = cursor.getString(0);
            String text = cursor.getString(1);
            text_data += ("* Font path: " + font + " | Text: " + text + "\n");
        }
        return text_data;
    }
}