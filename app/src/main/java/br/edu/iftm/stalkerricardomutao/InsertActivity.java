package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.data.DAOPerson;
import br.edu.iftm.stalkerricardomutao.data.DBHelper;
import br.edu.iftm.stalkerricardomutao.model.Person;

public class InsertActivity extends AppCompatActivity {

    public static final String RECORD_KEY = "br.edu.iftm.StalkerRicardoMutao.InsertActivity.NAME";//PARA BUNDLE

    private EditText ptxtFN;
    private EditText ptxtLN;
    private EditText ptxtAge;
    private EditText ptxtJob;
    private EditText ptxtBir;
    private EditText ptxtPhone;
    private EditText ptxtDesc;
    private static final int CAMERA_CODE = 0000;
    private ArrayList<Bitmap> tempGallery;
    private Bitmap btm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        ptxtFN = (EditText)findViewById(R.id.ptxtFN);
        ptxtLN = (EditText)findViewById(R.id.ptxtLN);
        ptxtAge = (EditText)findViewById(R.id.ptxtAge);
        ptxtJob = (EditText)findViewById(R.id.ptxtJob);
        ptxtBir = (EditText)findViewById(R.id.ptxtBir);
        ptxtPhone = (EditText)findViewById(R.id.ptxtPhone);
        ptxtDesc = (EditText)findViewById(R.id.ptxtDesc);

        tempGallery = new ArrayList<>();
    }

    public void onClickSave(View view) {


        String firstName = ptxtFN.getText().toString();
        String lastName = ptxtLN.getText().toString();
        String age = ptxtAge.getText().toString();
        String job = ptxtJob.getText().toString();
        String birthday = ptxtBir.getText().toString();
        String phone = ptxtPhone.getText().toString();
        String description = ptxtDesc.getText().toString();


        if(!firstName.isEmpty() && !lastName.isEmpty() && !age.isEmpty() && !job.isEmpty() && !birthday.isEmpty() && !phone.isEmpty() && !description.isEmpty()){
            DBHelper dbHelper = new DBHelper(this);
            Person person = new Person(firstName, lastName, age, job, birthday, phone, description, tempGallery);
            DAOPerson.insert(dbHelper, person);
            Toast.makeText(this, "Person created: "+person.getFirstName(), Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "Person not created", Toast.LENGTH_SHORT).show();

        }

    }

    public void onClickTakePic(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_CODE);
        }
    }

    public void onClickGallery(View view){
        Intent intent = new Intent(this, GalleryActivity.class);

        intent.putExtra("tempGallery", tempGallery);

        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CAMERA_CODE && resultCode == RESULT_OK && data != null){
            Bundle bundle = data.getExtras();
            if (bundle != null && bundle.containsKey("data")){
                btm = (Bitmap) bundle.get("data");
                tempGallery.add(btm);
                //DAOPic.getINSTANCE().addPic(btm);
            }
        }
    }
}
