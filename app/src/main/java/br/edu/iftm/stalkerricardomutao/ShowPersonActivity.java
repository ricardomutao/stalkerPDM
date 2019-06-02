package br.edu.iftm.stalkerricardomutao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.iftm.stalkerricardomutao.model.Person;

public class ShowPersonActivity extends AppCompatActivity {

    private TextView txtFNR;
    private TextView txtLNR;
    private TextView txtAR;
    private TextView txtJR;
    private TextView txtBR;
    private TextView txtPR;
    private TextView txtDR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);

        txtFNR = (TextView) findViewById((R.id.txtFNR));
        txtLNR = (TextView) findViewById((R.id.txtLNR));
        txtAR = (TextView) findViewById((R.id.txtAR));
        txtJR = (TextView) findViewById((R.id.txtJR));
        txtBR = (TextView) findViewById((R.id.txtBR));
        txtPR = (TextView) findViewById((R.id.txtPR));
        txtDR = (TextView) findViewById((R.id.txtDR));



        Person person = getIntent().getParcelableExtra(MainActivity.PERSON_KEY);

        txtFNR.setText(person.getFirstName());
        txtLNR.setText(person.getLastName());
        txtAR.setText(person.getAge());
        txtJR.setText(person.getJob());
        txtBR.setText(person.getBirth());
        txtPR.setText(person.getPhone());
        txtDR.setText(person.getDescription());

    }

    public void onCLickCancel(View view){
        finish();
    }
}