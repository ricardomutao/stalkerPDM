package br.edu.iftm.stalkerricardomutao;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;

import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.model.PersonGallery;
import br.edu.iftm.stalkerricardomutao.view.GalleryAdapter;
import br.edu.iftm.stalkerricardomutao.view.PhotoOpenDialogFragment;

public class GalleryActivity extends AppCompatActivity implements GalleryAdapter.GalleryListener{

    private RecyclerView rvGallery;
    private GalleryAdapter galleryAdapter;
    private PhotoOpenDialogFragment photoOpenDialogFragment;
    private ArrayList<PersonGallery> selected;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        Bundle extras = getIntent().getExtras();
        ArrayList<Bitmap> tempGallery = extras.getParcelableArrayList("tempGallery");

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int spanCount = (int) Math.ceil(dpWidth/100.0);

        rvGallery = (RecyclerView) findViewById(R.id.rvGallery);
        galleryAdapter = new GalleryAdapter(this, tempGallery);
        photoOpenDialogFragment = new PhotoOpenDialogFragment();

        selected = new ArrayList<>();
        rvGallery.setLayoutManager(new GridLayoutManager(this, spanCount));
        rvGallery.setHasFixedSize(true);
        rvGallery.setAdapter(galleryAdapter);
    }

    @Override
    public void onClickPhoto(Bitmap pic) {
        this.photoOpenDialogFragment.setBitmap(pic);
        FragmentManager fragmentManager = getSupportFragmentManager();
        this.photoOpenDialogFragment.show(fragmentManager, "showpic");
    }

    @Override
    public void onHoldPhoto(ImageView img, Bitmap pictureGallery) {

    }
}
