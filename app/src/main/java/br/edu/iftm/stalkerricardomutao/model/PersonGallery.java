package br.edu.iftm.stalkerricardomutao.model;

import android.graphics.Bitmap;

public class PersonGallery {

    private int id;
    private Bitmap bitmap;
    private boolean selected;

    public PersonGallery(int id, Bitmap bitmap) {
        this.id = id;
        this.bitmap = bitmap;
        this.selected = false;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PersonGallery)) return false;
        if (obj == this) return true;

        return ((PersonGallery) obj).getId() == this.id;
    }
}
