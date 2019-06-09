package br.edu.iftm.stalkerricardomutao.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.model.Person;
import br.edu.iftm.stalkerricardomutao.model.PersonGallery;

public class DAOPic {

    public static final void insert(DBHelper dbHelper, ArrayList<String> tempGallery, long lastId){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues(); //Serve para guardar par de valores
        //INSERT INTO CONTACT(C_NAME, C_PNUMBER) VALUES ("fulano", "1234");

        for(int i=0;i<tempGallery.size();i++){
            cv.put(DBSchema.PersonPic.PATH, tempGallery.get(i));
            cv.put(DBSchema.PersonPic.PERSON_ID, lastId);

        }


        db.insert(DBSchema.Person.TABLENAME, null, cv);
        db.close();

    }


}
   /* private static DAOPic INSTANCE;
    private ArrayList<PersonGallery> pics;
    private static int counter;

    private DAOPic(){
        pics = new ArrayList<>();
        counter = 0;
    }


    public static DAOPic getINSTANCE(){
        if (INSTANCE ==null)
            INSTANCE = new DAOPic();
        return INSTANCE;
    }


    public void addPic(Bitmap pic){
        PersonGallery personGallery = new PersonGallery(counter, pic);
        pics.add(personGallery);
        counter++;

    }

    public ArrayList<PersonGallery> getPics(){
        return pics;
    }
}*/

