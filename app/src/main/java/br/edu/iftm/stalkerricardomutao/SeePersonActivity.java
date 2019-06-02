package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.edu.iftm.stalkerricardomutao.data.DAOPerson;
import br.edu.iftm.stalkerricardomutao.model.Person;
import br.edu.iftm.stalkerricardomutao.view.PersonListAdapter;

public class SeePersonActivity extends AppCompatActivity implements PersonListAdapter.PersonListener{

    private RecyclerView rvPeople;
    private PersonListAdapter personListAdapter;
    public static final String PERSON_KEY = "br.edu.iftm.stalkerricardomutao.SeePersonActivity.PERSON";

    //private Toast resumeToast;
    private Person lastPerson = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_person);


        rvPeople = findViewById(R.id.rvPeople);
        personListAdapter = new PersonListAdapter(this);
        rvPeople.setLayoutManager(new LinearLayoutManager(this));
        rvPeople.setHasFixedSize(true);
        rvPeople.setAdapter(personListAdapter);
    }





    @Override
    public void onClickPersonListener(Person p) {
        Intent intent = new Intent(getBaseContext(), ShowPersonActivity.class);
        intent.putExtra("person", p);
        startActivity(intent);
        finish();
    }
}
