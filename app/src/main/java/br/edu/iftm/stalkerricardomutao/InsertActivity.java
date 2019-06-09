package br.edu.iftm.stalkerricardomutao;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.iftm.stalkerricardomutao.data.DAOPerson;
import br.edu.iftm.stalkerricardomutao.data.DAOPic;
import br.edu.iftm.stalkerricardomutao.data.DBHelper;
import br.edu.iftm.stalkerricardomutao.model.Person;

/*TO DO
* Recriar on Take Pic para adicionar no Arraylist
*
*
* */

public class InsertActivity extends AppCompatActivity {

    public static final String RECORD_KEY = "br.edu.iftm.StalkerRicardoMutao.InsertActivity.NAME";//PARA BUNDLE

    private EditText ptxtFN;
    private EditText ptxtLN;
    private EditText ptxtAge;
    private EditText ptxtJob;
    private EditText ptxtBir;
    private EditText ptxtPhone;
    private EditText ptxtDesc;



    //Coisas da imagem:
    private static final int CAMERA_CODE = 0000;
    private static final int REQUEST_CAMERA_CODE = 1234;
    private static final int REQUEST_PERMISSIONS_CODE = 1235;
    private ArrayList<String> tempGallery;
    private Bitmap btm;

    private static final String[] PERMISSIONS = {
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private File file;
    private Uri fileUri;

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

        this.verifyPermission();
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
            Person person = new Person(0 ,firstName, lastName, age, job, birthday, phone, description/*, tempGallery*/);
            long lastId = DAOPerson.insert(dbHelper, person);
            //Depois montar o esquema de relacionar a imagem com a pessoa e salvar aqui após ter o id da pessoa
            //DAOPIC INSERT TEMPGALLERY PERSON_ID = LASTID
            DAOPic.insert(dbHelper, tempGallery, lastId);


            Toast.makeText(this, "Person created: "+person.getFirstName(), Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "Person not created", Toast.LENGTH_SHORT).show();

        }

    }

    public void onClickTakePic(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            this.fileUri = this.getUri();

            Toast.makeText(this, this.fileUri.toString(), Toast.LENGTH_SHORT).show();
            intent.putExtra(MediaStore.EXTRA_OUTPUT, this.fileUri);
            startActivityForResult(intent, CAMERA_CODE);
        }
    }

    public void onClickGallery(View view){
        Intent intent = new Intent(this, GalleryActivity.class);

        intent.putExtra("tempGallery", tempGallery);

        startActivity(intent);
    }

    private Uri getUri(){
        File path = new File(Environment.getExternalStorageDirectory(), "stalker/stalker_images");
        if(!path.exists() && !path.mkdirs()){
            Toast.makeText(this, "Failed to create dirs...", Toast.LENGTH_SHORT).show();
        }
        this.file = new File(path, this.generateFileName());
        return FileProvider.getUriForFile(this, "br.edu.iftm.stalkerricardomutao", file);
    }

    private String generateFileName() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return "Stalker_"+timeStamp+".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CAMERA_CODE && resultCode == RESULT_OK && data != null){
             btm = BitmapFactory.decodeFile(this.file.getAbsolutePath());

             this.addPictureToGallery();





            /*Bundle bundle = data.getExtras();
            if (bundle != null && bundle.containsKey("data")){
                btm = (Bitmap) bundle.get("data");
                tempGallery.add(btm);
                //DAOPic.getINSTANCE().addPic(btm);
            }*/
        }
    }

    protected void addPictureToGallery(){
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(this.file);
        intent.setData(uri);
        tempGallery.add(uri.toString());

        this.sendBroadcast(intent);

    }

    private void verifyPermission() {
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    PERMISSIONS,
                    REQUEST_PERMISSIONS_CODE);
        }
    }



}
