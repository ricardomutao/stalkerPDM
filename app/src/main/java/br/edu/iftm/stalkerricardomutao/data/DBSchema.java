package br.edu.iftm.stalkerricardomutao.data;

import android.provider.BaseColumns;

public class DBSchema {

    public static final class Person implements BaseColumns {

        /*private String firstName;
        private String lastName;
        private String age;
        private  String job;
        private String birth;
        private  String phone;
        private String description;
        private ArrayList<Bitmap> pics;*/


        public static final String TABLENAME = "person";
        public static final String FNAME = "p_fname";
        public static final String LNAME = "p_lname";
        public static final String AGE = "p_age";
        public static final String JOB = "p_job";
        public static final String BIRTH = "p_birth";
        public static final String PHONE = "p_phone";
        public static final String DESCRIPTION = "p_description";
        public static final String PICS = "p_pics";

        public static final String createQuery(){
            return "CREATE TABLE " + TABLENAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FNAME + " TEXT NOT NULL, " +
                    LNAME + " TEXT NOT NULL, " +
                    AGE + " TEXT NOT NULL, " +
                    JOB + " TEXT NOT NULL, " +
                    BIRTH + " TEXT NOT NULL, " +
                    PHONE + " TEXT NOT NULL, " +
                    DESCRIPTION + " TEXT NOT NULL, " +
                    ");";
        }

    }


    public static final class PersonPic implements BaseColumns {




        public static final String TABLENAME = "personpic";
        public static final String PATH = "pp_path";
        public static final String PERSON_ID = "p_id";


        //Temos que criar outra tabela para relacionar com a Person:

        public static final String createQuery2(){
            return "CREATE TABLE " + TABLENAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PATH + " TEXT NOT NULL, " +
                    PERSON_ID + " INTEGER, " +
                    " FOREIGN KEY ("+PERSON_ID+") REFERENCES "+Person.TABLENAME+"("+Person._ID+"));";

        }

    }

}
