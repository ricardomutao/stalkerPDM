package br.edu.iftm.stalkerricardomutao.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.edu.iftm.stalkerricardomutao.R;
import br.edu.iftm.stalkerricardomutao.model.Person;


public class PeopleListViewHolder
        extends RecyclerView.ViewHolder
        implements View.OnClickListener
{

    private TextView txtFirstName;
    private TextView txtLastName;
    private TextView txtAge;
    private Person person;
    private PeopleListAdapter.PersonListener listener;

    public PeopleListViewHolder(@NonNull View itemView, PeopleListAdapter.PersonListener listener) {
        super(itemView);
        txtFirstName = itemView.findViewById(R.id.txtFirstName);
        txtAge = itemView.findViewById(R.id.txtAge);
        txtLastName = itemView.findViewById(R.id.txtLastName);
        this.listener = listener;
        itemView.setOnClickListener(this);

    }

    public void bind(Person p){
        txtFirstName.setText(p.getFirstName());
        txtAge.setText(p.getAge());
        txtLastName.setText(p.getLastName());
        this.person = p;
    }

    @Override
    public void onClick(View v) {
        listener.onClickPersonListener(this.person);
    }
}