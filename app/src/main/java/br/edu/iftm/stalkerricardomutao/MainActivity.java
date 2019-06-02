package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNew(View view){

        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);

    }

    public void onClickList(View view){

        Intent intent = new Intent(this, SeePersonActivity.class);
        intent.putExtra(InsertActivity.RECORD_KEY, getIntent().getBundleExtra(InsertActivity.RECORD_KEY));
        startActivity(intent);
    }
}
