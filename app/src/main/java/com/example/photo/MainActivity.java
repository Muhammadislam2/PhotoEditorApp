package com.example.photo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.photo.databinding.ActivityMainBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
public static Uri imagUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(MainActivity.this)
                 //       .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            assert data != null;
            imagUri=data.getData();
            if (!Objects.equals(imagUri, ""))
                startActivity(new Intent(MainActivity.this,Final_Activity.class));
        }
       catch (Exception e){
            e.printStackTrace();
       }

    }
}