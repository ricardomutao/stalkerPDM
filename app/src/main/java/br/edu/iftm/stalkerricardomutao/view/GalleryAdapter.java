package br.edu.iftm.stalkerricardomutao.view;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.ArrayList;

import br.edu.iftm.stalkerricardomutao.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder>{

    private ArrayList<Bitmap> picList;
    private GalleryListener galleryListener;

    public interface GalleryListener{
        void onClickPhoto(Bitmap pic);
        void onHoldPhoto(ImageView img, Bitmap pictureGallery);
    }

    public GalleryAdapter(GalleryListener galleryListener, ArrayList<Bitmap> pic){
        this.picList = pic;
        this.galleryListener = galleryListener;
    }

    @NonNull

    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_gallery, viewGroup, false);
        GalleryViewHolder galleryViewHolder = new GalleryViewHolder(view, this.galleryListener);
        return galleryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder galleryViewHolder, int i) {
        galleryViewHolder.bind(this.picList.get(i));

    }

    @Override
    public int getItemCount() {
        return this.picList.size();
    }
}
