package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b ;
    HelperDB h =new HelperDB(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            EditText nom = findViewById(R.id.id);
            EditText prix = findViewById(R.id.price);

             b = findViewById(R.id.add);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Produit p = new Produit(nom.getText().toString(),Double.parseDouble(prix.getText().toString()));


                    h.insertProduct(p);

                    Intent i = new Intent(MainActivity.this , secActivity.class);
                    startActivity(i);
                }
            });



    }
}