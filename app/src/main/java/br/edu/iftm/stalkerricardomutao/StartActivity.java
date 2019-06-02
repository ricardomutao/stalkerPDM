package br.edu.iftm.stalkerricardomutao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClickNew(View view){

        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);

    }

    public void onClickList(View view){

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(InsertActivity.RECORD_KEY, getIntent().getBundleExtra(InsertActivity.RECORD_KEY));
        startActivity(intent);
    }
}
