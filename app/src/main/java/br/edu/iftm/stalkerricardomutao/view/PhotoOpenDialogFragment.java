package br.edu.iftm.stalkerricardomutao.view;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import br.edu.iftm.stalkerricardomutao.R;

public class PhotoOpenDialogFragment extends DialogFragment {
    private ImageView imgZoomPic;
    private Bitmap bitmap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_photo_open, container);
        imgZoomPic = (ImageView) view.findViewById(R.id.imgZoomPic);
        imgZoomPic.setImageBitmap(bitmap);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }
}
