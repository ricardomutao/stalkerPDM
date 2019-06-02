package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.edu.iftm.stalkerricardomutao.data.DAOPerson;
import br.edu.iftm.stalkerricardomutao.model.Person;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lnvPeopleList;
    public static final String PERSON_KEY = "br.edu.iftm.stalkerricardomutao.MainActivity.PERSON";

    //private Toast resumeToast;
    private Person lastPerson = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lnvPeopleList = (LinearLayout) findViewById(R.id.lnvPeopleList);
        this.createPeople();
        this.createList();
    }

    public void createPeople(){
    if (getIntent().getBundleExtra(InsertActivity.RECORD_KEY) != null){



        Bundle bundle = getIntent().getBundleExtra(InsertActivity.RECORD_KEY);
        String firstName = bundle.getString("firstName");
        String lastName = bundle.getString("lastName");
        String age = bundle.getString("age");
        String job = bundle.getString("job");
        String birthday = bundle.getString("birthday");
        String phone = bundle.getString("phone");
        String description = bundle.getString("description");

        Person p = new Person(firstName, lastName, age, job, birthday, phone, description);
        DAOPerson.getINSTANCE().addPerson(p);


    }






    }

    public void createList(){


        for (final Person person: DAOPerson.getINSTANCE().getPeople()){ //Person deve ser final para evitar concorrência, dentro do for não dá pra alterar o valor de person
            

            LinearLayout lnvPersonResume = (LinearLayout) getLayoutInflater().inflate(R.layout.person_resume, null);

            TextView txtFirstName = (TextView) lnvPersonResume.findViewById(R.id.txtFirstName);
            txtFirstName.setText(person.getFirstName());
            TextView txtLastName = (TextView) lnvPersonResume.findViewById(R.id.txtLastName);
            txtLastName.setText(person.getLastName());
            TextView txtAge = (TextView) lnvPersonResume.findViewById(R.id.txtAge);
            txtAge.setText(person.getAge());


            lnvPersonResume.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* if (resumeToast != null){ //Faz com que o Toast seja substituído de modo a ir direto para o próximo, em casa de button smash
                        resumeToast.cancel();
                    }

                    resumeToast = Toast.makeText(getBaseContext(), person.getLastName(), Toast.LENGTH_SHORT);
                    resumeToast.show();*/

                    Intent intent = new Intent(getBaseContext(), ShowPersonActivity.class);
                    intent.putExtra(PERSON_KEY, person);
                    startActivity(intent);
                }
            });
            lnvPeopleList.addView(lnvPersonResume); //Adiciona a view(botão) dentro do layout
        }


    }

}
