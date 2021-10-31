package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private TextView textInput, textOutput, textResult;
    String firstValue = "", operator = "";
    Boolean init = false;
    int result;
    Button button2, button7;
    View button16, button17, button18;
    Change bu2Ch, bu7Ch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.textInput);
        textOutput = findViewById(R.id.textOutput);
        textResult = findViewById(R.id.textResult);

        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);

        bu2Ch = new Change();
        bu7Ch = new Change();

        for(int i=0; i<=18; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            findViewById(resID).setOnClickListener(mClickListener);
        }

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bu2Ch.click();
                button2.setBackgroundResource(bu2Ch.imagenumber(bu2Ch.getClicked()));

                if(bu2Ch.getClicked()==4) {
                    button2.setOnClickListener(mClickListener);
                }
            }
        });

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bu7Ch.click();
                button7.setBackgroundResource(bu7Ch.imagenumber(bu7Ch.getClicked()));

                if(bu7Ch.getClicked()==4) {
                    button7.setOnClickListener(mClickListener);
                }
            }
        });

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            Button button = (Button) view;
            String input = button.getText().toString();

            if("+".equals(input)||"-".equals(input)||"*".equals(input)||"/".equals(input)||"=".equals(input)){
                if("".equals(firstValue)){
                    firstValue = textInput.getText().toString();
                    textOutput.setText(textInput.getText().toString() + input);
                    textInput.setText("");
                } else{
                    String secondValue = textInput.getText().toString();
                    result=0;
                    switch (operator) {
                        case "+" : result = Integer.valueOf(firstValue) + Integer.valueOf(secondValue); break;
                        case "-" : result = Integer.valueOf(firstValue) - Integer.valueOf(secondValue); break;
                        case "*" : result = Integer.valueOf(firstValue) * Integer.valueOf(secondValue); break;
                        case "/" : result = Integer.valueOf(firstValue) / Integer.valueOf(secondValue); break;
                    }

                    if("=".equals(input)){
                        textOutput.setText("");
                        textInput.setText("");
                        firstValue = "";
                        operator = "";
                        bu2Ch.setClicked();
                        button2.setBackgroundResource(bu2Ch.imagenumber(bu2Ch.getClicked()));
                        bu7Ch.setClicked();
                        button7.setBackgroundResource(bu7Ch.imagenumber(bu7Ch.getClicked()));

                        button16.setVisibility(View.VISIBLE);
                        button17.setVisibility(View.VISIBLE);
                        button18.setVisibility(View.VISIBLE);

                        textResult.setText(String.valueOf(result));

                        button16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                button16.setBackgroundResource(R.drawable.goguma6);
                            }
                        });

                        button17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                button17.setVisibility(View.INVISIBLE);
                            }
                        });

                        button18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                button18.setBackgroundResource(R.drawable.goguma6);
                            }
                        });

                        return;
                    }

                    textOutput.setText(textOutput.getText().toString() + textInput.getText().toString() + input);
                    textInput.setText(String.valueOf(result));

                    firstValue = String.valueOf(result);
                    init = true;
                }
                operator = input;
            }
            else if("C".equals(input)){
                textInput.setText("");
                textOutput.setText("");
                textResult.setText("");
                firstValue = "";
                operator = "";
                bu2Ch.setClicked();
                button2.setBackgroundResource(bu2Ch.imagenumber(bu2Ch.getClicked()));
                bu7Ch.setClicked();
                button7.setBackgroundResource(bu7Ch.imagenumber(bu7Ch.getClicked()));

                button16.setVisibility(View.INVISIBLE);
                button16.setBackgroundResource(R.drawable.goguma1);
                button17.setVisibility(View.INVISIBLE);
                button18.setVisibility(View.INVISIBLE);
                button18.setBackgroundResource(R.drawable.goguma1);
        }
            else {
                if(init){
                    init = false;
                    textInput.setText(input);
                }
                else {
                    textInput.setText(textInput.getText().toString() + input);
                    button16.setVisibility(View.INVISIBLE);
                    button16.setBackgroundResource(R.drawable.goguma1);
                    button17.setVisibility(View.INVISIBLE);
                    button18.setVisibility(View.INVISIBLE);
                    button18.setBackgroundResource(R.drawable.goguma1);
                    textResult.setText("");
                }
            }
        }
    };

}