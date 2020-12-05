package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button b;
EditText enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.submit);
        enter=findViewById(R.id.enter);
        b.setOnClickListener( this);


    }

    @Override
    public void onClick(View v) {
        if(v==b){
        if(URLUtil.isValidUrl(enter.getText().toString())){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(enter.getText().toString()));
            startActivity(intent);
        }
        else
            if(enter.getText().toString().startsWith("+")){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+enter.getText().toString().trim()));
            startActivity(intent);
            }
            else {
                Dialog dialog =new Dialog(this);
                dialog.setContentView(R.layout.alertdialog);
                dialog.setCancelable(true);
                dialog.show();
            }
        }
    }
    }
