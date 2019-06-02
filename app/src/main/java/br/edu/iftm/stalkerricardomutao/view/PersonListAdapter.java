package br.edu.iftm.stalkerricardomutao.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.R;
import br.edu.iftm.stalkerricardomutao.data.DAOPerson;
import br.edu.iftm.stalkerricardomutao.model.Person;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListViewHolder> {

    private ArrayList<Person> peoplelist;
    private PersonListener listener;

    public PersonListAdapter(PersonListener listener) {

        peoplelist = DAOPerson.getINSTANCE().getPeople();
        this.listener = listener;
    }


    public interface PersonListener {
        void onClickPersonListener(Person p);
    }

    @NonNull
    @Override
    public PersonListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.person_resume, viewGroup, false);
        PersonListViewHolder peopleListViewHolder = new PersonListViewHolder(view, this.listener);
        return peopleListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonListViewHolder peopleListViewHolder, int i) {
        peopleListViewHolder.bind(peoplelist.get(i));

    }

    @Override
    public int getItemCount() {
        return peoplelist.size();
    }
}
