package br.edu.iftm.stalkerricardomutao.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "dbstalker.db";
    private static final int DBVERSION = 1;


    public DBHelper(Context context){
        super(context, DBNAME, null, DBVERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBSchema.Person.createQuery());
        db.execSQL(DBSchema.PersonPic.createQuery2());
        //DummyData.createData(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
