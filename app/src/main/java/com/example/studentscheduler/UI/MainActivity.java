package com.example.studentscheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.studentscheduler.Database.Repository;
import com.example.studentscheduler.Entity.Part;
import com.example.studentscheduler.Entity.Product;
import com.example.studentscheduler.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnterHere(View view) {
        Intent intent=new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);

        Repository repo=new Repository(getApplication());
        Product product = new Product(1,"new product", 1.0);
        repo.insertProduct(product);
        Part part = new Part(8,"new product", 1.0, 1);
        repo.insertPart(part);
    }
}