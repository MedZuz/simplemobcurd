



package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detailproduct extends AppCompatActivity {

    TextView n,pp ;
    Button modif,sup;
    String id ;
    HelperDB h =new HelperDB(Detailproduct.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailproduct);


            n = findViewById(R.id.nom);
            pp = findViewById(R.id.prix);
            sup = findViewById(R.id.sup);
            modif=findViewById(R.id.modif);

            id = getIntent().getStringExtra("id");

             Produit p = h.getOneProduct(Integer.parseInt(id));

             n.setText(p.getName());
             pp.setText(String.valueOf(p.getPrix()));


        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produit p = new Produit(Integer.parseInt(id),n.getText().toString(),Double.parseDouble(pp.getText().toString()));

                h.updateProduct(p);

                Intent s =  new Intent(Detailproduct.this ,secActivity.class);
                startActivity(s);


            }
        });


        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h.delete(Integer.parseInt(id));
            }
        });




    }
}