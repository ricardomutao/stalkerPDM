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

    public PersonListAdapter(ArrayList<Person> people, PersonListener personListener){
        this.peoplelist = people;
        this.listener = personListener;
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

    public void notifyContactUpdated(Person person){
        int index = this.peoplelist.indexOf(person);//pega o indice do contact, que usa internamente o index
        this.peoplelist.get(index).setFirstName(person.getFirstName());
        this.peoplelist.get(index).setLastName(person.getLastName());
        this.peoplelist.get(index).setAge(person.getAge());
        this.peoplelist.get(index).setBirth(person.getBirth());
        this.peoplelist.get(index).setJob(person.getJob());
        this.peoplelist.get(index).setPhone(person.getPhone());
        this.peoplelist.get(index).setDescription(person.getDescription());
        notifyItemChanged(index);//Forçar o recyclerview ir naquela posição e colocar o valor correto
    }

    public void notifyContactRemoved(Person person){
        int index = this.peoplelist.indexOf(person);
        this.peoplelist.remove(index);
        notifyItemRemoved(index);//Forçar o recyclerview a ir naquela posição e apagar o valor
    }

    public void setFilteredResult(ArrayList<Person> filteredResult){
        this.peoplelist = filteredResult;
        notifyDataSetChanged();
    }


}
