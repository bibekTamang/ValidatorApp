package com.example.bibek.validatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Button button;
    String Usertext;
    EditText text;
    int p,CheckDigit,sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.UserText);
        button = (Button)findViewById(R.id.Checkbutton);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ValidateFunction();
                    }
                }
        );
    }
    public void ValidateFunction()
    {
        int[] A = new int[11];
        Usertext = text.getText().toString();
        if(Usertext.equals(null))
        {
            Toast.makeText(this, "Field are Empty!!", Toast.LENGTH_LONG).show();
        }
        if(Usertext.length()!=11)
        {
            Toast.makeText(this, "Invalid Length!", Toast.LENGTH_LONG).show();
        }
        else {
            for (int i = 0; i < A.length; i++) {
                A[i] = Character.getNumericValue(Usertext.charAt(i));
            }

            for (int i = 9; i >= 0; i = i - 2) {
                p = A[i] * 2;
                if (p > 9) {
                    p = p - 9;
                }
                A[i] = p;
            }
            for (int i = 0; i < A.length - 1; i++) {
                sum = sum + A[i];
            }
            CheckDigit = (sum * 9) % 10;
            if (A[10] != CheckDigit) {
                Toast.makeText(this, "This is not a valid Card Number!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "This is a valid card Number!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
