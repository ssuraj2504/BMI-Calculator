package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        EditText edtheightinch, edtheightfeet, edtweight;
        Button btncalcu, btnreset;
        TextView txtresult;

        edtheightinch=findViewById(R.id.edtheightinch);
        edtweight=findViewById(R.id.edtweight);
        edtheightfeet=findViewById(R.id.edtheightfeet);
        btncalcu=findViewById(R.id.btncalcu);
        btnreset=findViewById(R.id.btnreset);
        txtresult=findViewById(R.id.txtresult);

        btncalcu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtheightfeet.getText().toString());
                int inch = Integer.parseInt(edtheightinch.getText().toString());

                int totalinch=ft*12 + inch;

                double totalcm=totalinch*2.53;

                double totalmt=totalcm/100;

                double bmi = wt/(totalmt*totalmt);



                if(bmi>25){
                    double need = 25*totalmt*totalmt;
                    txtresult.setText("BMI = "+bmi+" You are overweight");
                }else if(bmi<18){
                    txtresult.setText("BMI = "+bmi+" You are underweigth");
                }else{
                    txtresult.setText("BMI = "+bmi+" You are healthyy");
                }
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtheightfeet.setText("");
                edtweight.setText("");
                edtheightinch.setText("");
                txtresult.setText("Result");
            }
        });


    }
}