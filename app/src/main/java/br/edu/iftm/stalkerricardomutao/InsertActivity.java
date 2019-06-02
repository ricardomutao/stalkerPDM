package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    public static final String RECORD_KEY = "br.edu.iftm.StalkerRicardoMutao.InsertActivity.NAME";//PARA BUNDLE

    private EditText ptxtFN;
    private EditText ptxtLN;
    private EditText ptxtAge;
    private EditText ptxtJob;
    private EditText ptxtBir;
    private EditText ptxtPhone;
    private EditText ptxtDesc;


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
    }

    public void onClickSave(View view) {

        String firstName = ptxtFN.getText().toString();
        String lastName = ptxtLN.getText().toString();
        String age = ptxtAge.getText().toString();
        String job = ptxtJob.getText().toString();
        String birthday = ptxtBir.getText().toString();
        String phone = ptxtPhone.getText().toString();
        String description = ptxtDesc.getText().toString();


        Intent intent = new Intent(this, StartActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("firstName", firstName);
        bundle.putString("lastName", lastName);
        bundle.putString("age", age);
        bundle.putString("job", job);
        bundle.putString("birthday", birthday);
        bundle.putString("phone", phone);
        bundle.putString("description", description);
        intent.putExtra(RECORD_KEY, bundle);

        startActivity(intent);

    }
}
