package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.iftm.stalkerricardomutao.model.Person;





public class ShowPersonActivity extends AppCompatActivity {


    public static final String MODE_KEY = "br.edu.iftm.stalkerricardomutao.show.MODE";
    public static final int MODE_EDIT = 1;
    public static final int MODE_REMOVE = 2;
    public static final String PERSON_KEY = "br.edu.iftm.stalkerricardomutao.show.CONTACT";


    private TextView txtFNR;
    private TextView txtLNR;
    private TextView txtAR;
    private TextView txtJR;
    private TextView txtBR;
    private TextView txtPR;
    private TextView txtDR;

    private Person person;

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



        person = getIntent().getParcelableExtra("person");

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

    public void onClickPersonGallery(View v){
        Intent intent = new Intent(this, GalleryActivity.class);

        intent.putExtra("tempGallery", person.getPics());

        startActivity(intent);
    }
}