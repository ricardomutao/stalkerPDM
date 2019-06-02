package br.edu.iftm.stalkerricardomutao.data;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.model.Person;

public class DAOPerson {//Singleton
    private int counter;
    private ArrayList<Person> people;
    private static DAOPerson INSTANCE;

    private DAOPerson(){//Construtor

        people = new ArrayList<>();
        counter = 0;
    }

    public static DAOPerson getINSTANCE(){
        if (INSTANCE == null)
            INSTANCE = new DAOPerson();

        return INSTANCE;
    }

    public void addPerson(Person p) {
        p.setId(counter++);
        people.add(p);
    }

    public  ArrayList<Person> getPeople(){
        return people;
    }

}

