package br.edu.iftm.stalkerricardomutao.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.model.Person;

public class DAOPerson {//Singleton
    public static final void insert(DBHelper dbHelper, Person person){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues(); //Serve para guardar par de valores
        //INSERT INTO CONTACT(C_NAME, C_PNUMBER) VALUES ("fulano", "1234");
        cv.put(DBSchema.Person.FNAME, person.getFirstName());
        cv.put(DBSchema.Person.LNAME, person.getLastName());
        cv.put(DBSchema.Person.AGE, person.getAge());
        cv.put(DBSchema.Person.JOB, person.getJob());
        cv.put(DBSchema.Person.BIRTH, person.getBirth());
        cv.put(DBSchema.Person.PHONE, person.getPhone());
        cv.put(DBSchema.Person.DESCRIPTION, person.getDescription());

        db.insert(DBSchema.Person.TABLENAME, null, cv);
        db.close();
    }

    public static final void remove(DBHelper dbHelper, long id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] args = new String[]{
                Long.toString(id)
        };

        //DELETE FROM CONTACT where _id = 1234;
        db.delete(DBSchema.Person.TABLENAME, DBSchema.Person._ID +" = ?", args);
        db.close();
    }

    public static final void update(DBHelper dbHelper, Person person){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.Person.FNAME, person.getFirstName());
        cv.put(DBSchema.Person.LNAME, person.getLastName());
        cv.put(DBSchema.Person.AGE, person.getAge());
        cv.put(DBSchema.Person.JOB, person.getJob());
        cv.put(DBSchema.Person.BIRTH, person.getBirth());
        cv.put(DBSchema.Person.PHONE, person.getPhone());
        cv.put(DBSchema.Person.DESCRIPTION, person.getDescription());
        String[] args = new String[]{
                Long.toString((person.getId()))
        };

        //UPDATE contact SET c_name = "FULANO", c_pnumber = 1234 WHERE _id = 500;
        db.update(DBSchema.Person.TABLENAME, cv, DBSchema.Person._ID +" = ?", args);
        db.close();
    }public void notifyContactUpdated(Person person){

    }



    public static final ArrayList<Person> getAllPeople(DBHelper dbHelper) throws SQLException {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Person> people = new ArrayList<>();
        /*String[] cols = new String[]{
            DBSchema.Contact.NAME,
            DBSchema.Contact.PNUMBER,
            DBSchema.Contact.TIMESTAMP,
        };*/


        //SELECT * FROM CONTACT;
        Cursor cursor = db.query(DBSchema.Person.TABLENAME,
                null,
                null,
                null,
                null,
                null,
                "UPPER("+DBSchema.Person.FNAME+")"
        );

        while (cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndex(DBSchema.Person._ID));
            String fname = cursor.getString(cursor.getColumnIndex(DBSchema.Person.FNAME));
            String lname = cursor.getString(cursor.getColumnIndex(DBSchema.Person.LNAME));
            String age = cursor.getString(cursor.getColumnIndex(DBSchema.Person.AGE));
            String job = cursor.getString(cursor.getColumnIndex(DBSchema.Person.JOB));
            String phone = cursor.getString(cursor.getColumnIndex(DBSchema.Person.PHONE));
            String description = cursor.getString(cursor.getColumnIndex(DBSchema.Person.DESCRIPTION));
            //Person person = new Person(id, fname, lname, age, job, phone, description);
            //people.add(person);

        }
        cursor.close();
        db.close();
        return people;
    }

}

