package com.example.clickactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("onCreate", "entr onCreate");

        Button btnSend = findViewById(R.id.imgID);

        // escuchador de un boton
        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Snackbar.make(v, "snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                GoSecond(v);
            }
        });
    }

    public void GoSecond(View view) {
        //EditText edtName = findViewById(R.id.edt_name);
        //String send_string = edtName.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        //intent.putExtra("LINK", send_string);
        startActivity(intent);
    }
}