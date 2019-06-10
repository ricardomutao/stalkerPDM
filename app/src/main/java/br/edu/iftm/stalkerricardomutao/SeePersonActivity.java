package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.database.SQLException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.data.DAOPerson;
import br.edu.iftm.stalkerricardomutao.data.DBHelper;
import br.edu.iftm.stalkerricardomutao.data.DBSchema;
import br.edu.iftm.stalkerricardomutao.model.Person;
import br.edu.iftm.stalkerricardomutao.view.PersonListAdapter;

public class SeePersonActivity extends AppCompatActivity implements PersonListAdapter.PersonListener, SearchView.OnQueryTextListener{

    private DBHelper dbHelper;
    private RecyclerView rvPeople;
    private PersonListAdapter personListAdapter;
    private ArrayList<Person> people;
    private static final int REQUEST_CHANGES_CODE = 1245;
    public static final String PERSON_KEY = "br.edu.iftm.stalkerricardomutao.SeePersonActivity.PERSON";

    //private Toast resumeToast;
    private Person lastPerson = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_person);


        rvPeople = findViewById(R.id.rvPeople);
        this.dbHelper = new DBHelper(this);


        try{
            super.onResume();
            this.people = DAOPerson.getAllPeople(this.dbHelper);
            this.personListAdapter = new PersonListAdapter(this.people, this);
            this.rvPeople.setLayoutManager(new LinearLayoutManager(this));
            this.rvPeople.setHasFixedSize(true);
            this.rvPeople.setAdapter(this.personListAdapter);
        }catch (SQLException e){
            Toast.makeText(this, "DB Problem: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }







    @Override
    public void onClickPersonListener(Person person) {
        Intent intent = new Intent(this, ShowPersonActivity.class);
        intent.putExtra(PERSON_KEY, person);
        startActivityForResult(intent, REQUEST_CHANGES_CODE);//Esperando requisição
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CHANGES_CODE && resultCode == RESULT_OK){
            Person person = data.getParcelableExtra(ShowPersonActivity.PERSON_KEY);
            switch (data.getIntExtra(ShowPersonActivity.MODE_KEY, 0)){
                case ShowPersonActivity.MODE_EDIT:
                    this.personListAdapter.notifyContactUpdated(person);
                    break;

                case ShowPersonActivity.MODE_REMOVE:
                    this.personListAdapter.notifyContactRemoved(person);
                    break;


            }
        }
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
