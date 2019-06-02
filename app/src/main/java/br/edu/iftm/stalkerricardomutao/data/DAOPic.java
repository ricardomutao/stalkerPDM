package br.edu.iftm.stalkerricardomutao.data;

import android.graphics.Bitmap;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.model.Person;
import br.edu.iftm.stalkerricardomutao.model.PersonGallery;

public class DAOPic {
    private static DAOPic INSTANCE;
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
}

