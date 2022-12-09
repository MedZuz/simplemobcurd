package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class secActivity extends AppCompatActivity {

    HelperDB h = new HelperDB(secActivity.this);

    ListView l ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);


        Cursor c =h.getAllProducts();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(secActivity.this, R.layout.item,c,
                new String[]{c.getColumnName(0),c.getColumnName(1),c.getColumnName(2)},new int[]{R.id.id ,R.id.nom,R.id.prix},1);


                l.setAdapter(adapter);

                l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        TextView t =findViewById(R.id.id);

                        Intent d = new Intent(secActivity.this , Detailproduct.class);
                        d.putExtra("id",t.getText().toString());
                        startActivity(d);



                    }
                });












    }

}