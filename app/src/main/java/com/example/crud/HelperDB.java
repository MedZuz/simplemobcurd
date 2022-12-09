package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class  HelperDB extends SQLiteOpenHelper // to do the ddl things in the DB

    {

        public HelperDB( Context context)  { // left only contex for name and version of the tab()db

        super(context, "productManagerr", null, 1);    /// db name "prodManager"
    }




    @Override
    public void onCreate(SQLiteDatabase db) {   ///type of class hedha fyh les methode permettant d'executé les req sql

            db.execSQL("CREATE TABLE produit(_id INTEGER PRIMARY KEY ,nom TEXT , prix REAL )");  // creation of table and columns
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

         db.execSQL("DROP TABLE IF EXISTS produit");
          onCreate(db);


    }



      ///down here bch najmou nnstamlou DML methods (select , insert , update , delete)


     public void insertProduct(Produit p){

            SQLiteDatabase db = this.getWritableDatabase();  /// to open the db to writeeennnn  ps: should close after ever 7ala xp

                     ContentValues cv = new ContentValues();
                     cv.put("nom",p.getName());
                     cv.put("prix",p.getPrix());

         db.insert("produit",null,cv);  //// bd already open go insert in table "produit" l plat mte3na cv adheka
         db.close();


     }


        public Cursor getAllProducts(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor c = db.rawQuery("SELECT *  FROM produit " , null);
            return c ;
        }



        public Produit getOneProduct(int id){
            SQLiteDatabase db = this.getWritableDatabase();


            Cursor z = db.query("produit" ,new String[]{"_id","nom","prix"},"_id=?",new String[]{String.valueOf(id)},
                    null,null , null);

          //  Cursor l = db.rawQuery("SELECT * FROM produit where _id =" + id,null);

            z.moveToFirst();
            Produit p =new Produit(z.getInt(0) , z.getString(1) , z.getDouble(2)) ;

                return p ;
        }



     public void updateProduct(Produit p){

            SQLiteDatabase db=this.getWritableDatabase();  //n7élou bd

                ContentValues cv = new ContentValues();{  // plat kl3ada

                    cv.put("nom" , p.getName());
                    cv.put("prix" , p.getPrix());

             db.update("produit", cv,"id=?", new String[]{String.valueOf(p.getId())});   //// update sure b haja mouayna here fama (id) whereclause "id=?"  wl id njibouh mnn obj mt3na (p) so p.get id mte3ou l mr lyn7bou nbadloulou haja
             db.close();

                }



     }


        public void delete(int id){


            SQLiteDatabase db =this.getWritableDatabase();

            db.delete("produit" ,"_id=?",new String[]{String.valueOf(id)} );
            db.close();

        }








}
