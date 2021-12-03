package com.ex.totalitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import com.github.drjacky.imagepicker.ImagePicker;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    CircularImageView profileupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileupdate=findViewById(R.id.profileupdate);
    }

    public void btn_gallery(View view) {

        ImagePicker.Companion.with(MainActivity.this)
                .crop()
                .galleryOnly()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start(0);

    }

    public void btn_camera(View view) {

        ImagePicker.Companion.with(MainActivity.this)
                .crop()
                .compress(1024)
                .cameraOnly()
                .maxResultSize(1080, 1080)
                .start(2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            profileupdate.setImageURI(data.getData());
        }

        if (requestCode == 2) {
            profileupdate.setImageURI(data.getData());


            String path = Environment.getExternalStorageDirectory() + "/CameraImages/example.jpg";
            File file = new File(path);
            Uri outputFileUri = Uri.fromFile( file );
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
            intent.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
        }

    }

}