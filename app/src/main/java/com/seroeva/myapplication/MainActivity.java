package com.seroeva.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.seroeva.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText text;
    CheckBox f,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.input_data);
        f = findViewById(R.id.f);
        s = findViewById(R.id.s);
    }


    public void onExit(View w) {
        new AlertDialog.Builder(this)
                .setTitle("Вы уверены?")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton("Ок", (dialog, which) -> {
                    finish();
                })
                .setNegativeButton("Нет", ((dialog, which) -> {

                }))

                
                .create().show();

    }

    public void onOpen(View w) {
        String s = text.getText().toString();

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("text", s);
        i.putExtra("f", f.isChecked());
        i.putExtra("s", this.s.isChecked());

        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            f.setChecked(data.getBooleanExtra("f", false));
            s.setChecked(data.getBooleanExtra("s", false));
            text.setText(data.getStringExtra("text"));
        }
    }
}