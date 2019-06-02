package br.edu.iftm.stalkerricardomutao.view;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import br.edu.iftm.stalkerricardomutao.R;


public class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    private ImageView imgPic;
    private Bitmap pic;
    private GalleryAdapter.GalleryListener galleryListener;

    public GalleryViewHolder(@NonNull View itemView, GalleryAdapter.GalleryListener galleryListener) {
        super(itemView);
        imgPic = (ImageView) itemView.findViewById(R.id.imgPic);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        this.galleryListener = galleryListener;

    }

    public void bind(Bitmap pic) {
        this.pic = pic;
        imgPic.setImageBitmap(pic);
    }

    @Override
    public void onClick(View v) {
        galleryListener.onClickPhoto(this.pic);
    }

    @Override
    public boolean onLongClick(View v) {
        galleryListener.onHoldPhoto(this.imgPic, this.pic);
        return true;
    }
}
