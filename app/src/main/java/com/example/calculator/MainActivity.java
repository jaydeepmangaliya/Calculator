package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnmulti,btnadd,btndiv,btndot,btnac,btndel,btnsub,btnequl;
    TextView textViewResult,textViewHistoey;

    double firstNumber =0;
    double secondNumber =0;

    String stuts =  null;
    boolean opration ;
    boolean eqlbtnControl;

boolean aclbtn = true;
    DecimalFormat myformay= new DecimalFormat("######.######");



    String Number = null;

    String history , crtresult;
     boolean dot = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnac = findViewById(R.id.buttonAC);
        btndel = findViewById(R.id.buttonDEL);
        btndiv = findViewById(R.id.buttonDIVID);
        btnmulti = findViewById(R.id.buttonMULTI);
        btnadd = findViewById(R.id.buttonADD);
        btnsub = findViewById(R.id.buttonSUB);
        btndot = findViewById(R.id.buttondot);
        btnequl = findViewById(R.id.buttonEQL);
        textViewHistoey = findViewById(R.id.historyText);
        textViewResult = findViewById(R.id.ResultText);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("0");

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("1");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("2");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayHistor("9");

            }
        });

        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                stuts = null;
                Number = null;
                textViewHistoey.setText("");
                textViewResult.setText("0");
                dot =true;
                aclbtn =true;


            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aclbtn == true){
                    textViewResult.setText("0");
                }
                else {
                    Number =Number.substring(0,Number.length()-1);

                    if(Number.length() == 0){
                        btndel.setClickable(false);
                    } else if ( Number.contains(".")) {
                        dot =false;
                    }
                    else {
                        dot = true;
                    }
                    textViewResult.setText(Number);
                }





            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistoey.getText().toString();
                crtresult = textViewResult.getText().toString();
                textViewHistoey.setText(history+crtresult +"/");
                if(opration == true){

                    if(stuts == "subtraction"){

                        subtraction();
                    } else if (stuts == "sum") {
                        plus();
                    } else if ( stuts == "multipication") {
                        multipication();
                    }
                    else {
                        division();
                    }

                    stuts = "division";
                    Number = null;
                    opration = false;

                }

            }
        });



        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistoey.getText().toString();
                crtresult = textViewResult.getText().toString();
                textViewHistoey.setText(history+crtresult +"*");
                if(opration == true){

                    if(stuts == "subtraction"){

                        subtraction();
                    } else if (stuts == "sum") {
                        plus();
                    } else if ( stuts == "division") {
                        division();
                    }
                    else {
                        multipication();
                    }

                    stuts = "multipication";
                    Number = null;
                    opration = false;

                }

            }
        });

        //subtraction

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistoey.getText().toString();
                crtresult = textViewResult.getText().toString();
                textViewHistoey.setText(history+crtresult +"-");

                if(opration == true){

                    if(stuts == "multipication"){

                        multipication();
                    } else if (stuts == "sum") {
                        plus();
                    } else if ( stuts == "division") {
                        division();
                    }
                    else {
                        subtraction();
                    }

                    stuts = "subtraction";
                    Number = null;
                    opration = false;

                }

            }
        });


        //add
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                history = textViewHistoey.getText().toString();
                crtresult = textViewResult.getText().toString();
                textViewHistoey.setText(history+crtresult +"+");

                if(opration == true){

                    if(stuts == "multipication"){

                        multipication();
                    } else if (stuts == "subtraction") {
                        subtraction();
                    } else if ( stuts == "division") {
                        division();
                    }
                    else {
                        plus();
                    }

                    stuts = "sum";
                    Number = null;
                    opration = false;

                }

            }
        });


        btnequl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(opration){
                    if (stuts == "sum" ){
                        plus();
                    }
                    else if (stuts =="subtraction") {
                        subtraction();
                    }
                    else if (stuts == "multipication") {
                        multipication();;
                    } else if (stuts == "division") {
                        division();
                    }
                    else {
                        firstNumber =Double.parseDouble(textViewResult.getText().toString());
                    }

                }
               opration = false;
                eqlbtnControl =true;
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(dot) {
                    if (Number == null) {
                        Number = "0.";
                    } else {
                        Number = Number + ".";
                    }
                }
                dot =false;
                textViewResult.setText(Number);

            }
        });





    }


    public void DisplayHistor(String num){

        if(Number == null){
            Number = num;
        }
        else if (eqlbtnControl) {
            firstNumber =0;
            secondNumber =0;
            Number =  num;

        } else {
            Number  = Number + num;
        }

         aclbtn =false;
        btndel.setClickable(true);
        textViewResult.setText(Number);
        opration = true;
    }

    // for addition

    public void plus(){
        secondNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + secondNumber;
        textViewResult.setText(myformay.format(firstNumber));
        dot=true;
    }

    // for subtraction

    public void subtraction(){

        //if firstnumber ==0 than ans is always negative

        if(firstNumber ==0){
            firstNumber = Double.parseDouble(textViewResult.getText().toString());

        }
        else {
            secondNumber = Double.parseDouble(textViewResult.getText().toString());;
            firstNumber = firstNumber - secondNumber;
        }
        dot=true;
        textViewResult.setText(myformay.format(firstNumber));
    }

    // for multipication

    public void multipication(){

        if(firstNumber ==0){
            firstNumber =1;
            secondNumber = Double.parseDouble(textViewResult.getText().toString());

            firstNumber = firstNumber*secondNumber;
        }
        else{
            secondNumber = Double.parseDouble(textViewResult.getText().toString());

            firstNumber = firstNumber* secondNumber;
        }
        dot=true;
        textViewResult.setText(myformay.format(firstNumber));
    }

    // for division


    public void division(){
        if(firstNumber == 0){
            secondNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = secondNumber /1 ;
        }
        else {
            secondNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber /secondNumber;

        }
        dot=true;
        textViewResult.setText(myformay.format(firstNumber));
    }
}