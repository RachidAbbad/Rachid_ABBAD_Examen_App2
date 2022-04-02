package com.rachid_abbad.rachid_abbad_examen_app2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.rachid_abbad.rachid_abbad_examen_app2.classes.Prof_Rachid;

import java.util.ArrayList;
import java.util.List;

public class ManageDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "ProfMods";
    public static final int DB_VERSION = 1;

    public static final String TABLE_MODULE_NAME = "Module";
    public static final String MODULE_ID = "id";
    public static final String MODULE_INTITULE = "intitule";
    public static final String MODULE_CIN = "cin";
    public static final String MODULE_HORAIRE = "horaire";

    public static final String TABLE_PROF_NAME = "Professeur";
    public static final String PROF_CIN = "cin";
    public static final String PROF_NOM = "nom";
    public static final String PROF_SPECIALITE = "specialite";

    public ManageDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String scriptPilote = "CREATE TABLE " + TABLE_PROF_NAME + "("
                + PROF_CIN + " TEXT PRIMARY KEY,"
                + PROF_SPECIALITE + " TEXT ,"
                + PROF_NOM + " TEXT" + ")";

        String scriptVol = "CREATE TABLE " + TABLE_MODULE_NAME + "("
                + MODULE_ID + " INTEGER PRIMARY KEY,"
                + MODULE_INTITULE + " TEXT,"
                + MODULE_HORAIRE + " INTEGER,"
                + MODULE_CIN + " TEXT,"
                + "FOREIGN KEY (" + MODULE_CIN + ") REFERENCES " + TABLE_PROF_NAME + "(" + PROF_CIN + "))";

        sqLiteDatabase.execSQL(scriptPilote);
        sqLiteDatabase.execSQL(scriptVol);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MODULE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PROF_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addProfs(ArrayList<Prof_Rachid> list) {
        SQLiteDatabase db = this.getWritableDatabase();

        deleteAllProf();

        for (Prof_Rachid prof:list) {
            ContentValues values = new ContentValues();
            values.put(PROF_CIN, prof.getCin());
            values.put(PROF_NOM, prof.getNom());
            values.put(PROF_SPECIALITE, prof.getSpecialite());

            db.insert(TABLE_PROF_NAME, null, values);
        }

        db.close();
    }


    public void deleteAllProf() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_PROF_NAME);
    }
}
