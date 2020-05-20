package com.example.xylophone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void abrirAtividadeXylophone(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void abrirAtividadeSonnyDrummer(View view) {
        Intent intent = new Intent(this, SonnyDrummerActivity.class);
        startActivity(intent);
    }
}
