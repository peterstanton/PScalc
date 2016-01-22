package com.example.s_peterstanton.pscalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.String;
import android.widget.EditText;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    String receivedInput = "0";

    public void onDecimalClick (View view) //inserts decimal point, making number a double
    {
        EditText displayedAnswer = (EditText) findViewById (R.id.resultField);
        String dec = (String) view.getTag(); //grabs
        receivedInput = receivedInput + dec; //inserts decimal point
        displayedAnswer.setText(receivedInput);
    }

    public void clearAll (View view)
    {
        receivedInput = "";
        EditText displayedAnswer = (EditText) findViewById (R.id.resultField);
        displayedAnswer.setText("");
    }

    public void onOperandClick (View view)//grabs the operand symbol and concatenates it.
    {
        EditText displayedAnswer = (EditText) findViewById (R.id.resultField);
        String operant = (String) view.getTag(); //grabs
        receivedInput = receivedInput + " " + operant + " "; //inserts the operation with spaces around it so it parses.
        displayedAnswer.setText(receivedInput);
    }

    public void onNumericClick (View view)  //concatenates in a new number.
    {
        EditText displayedAnswer = (EditText) findViewById (R.id.resultField);
        String num = (String) view.getTag();  //grabs value from clicked button
        receivedInput = receivedInput + num;  //concatenates
        displayedAnswer.setText(receivedInput);
    }

    public void solveFunction (View view)  //computes values and outputs results
    {
        EditText displayedAnswer = (EditText) findViewById (R.id.resultField);
        String givenInput[] = new String [receivedInput.length()];
        Scanner inputParser = new Scanner(receivedInput);
        int counter = 0;
        while (inputParser.hasNext())
        {
            givenInput[counter] = inputParser.next();
            counter++;
        }

        if (receivedInput.contains("."))
        {
            double result = Double.parseDouble(givenInput[0]);  //seems to fail when I try to parse the given values from string.
            for (int i = 1; counter < counter;)
            {
                if (givenInput[i].contains("/"))
                {
                    result /= Double.parseDouble(givenInput[i+1]);
                    i += 2;
                }
                else if (givenInput[i].contains("-"))
                {
                    result -= Double.parseDouble(givenInput[i+1]);
                    i += 2;
                }
                else if (givenInput[i].contains("+"))
                {
                    result += Double.parseDouble(givenInput[i+1]);
                    i += 2;
                }
                else if (givenInput[i].contains("*"))
                {
                    result *= Double.parseDouble(givenInput[i+1]);
                    i += 2;
                }
            }


        //    double result = Double.parseDouble(receivedInput);   //this doesn't work.   deprecated
            String resultConvert = Double.toString(result);
            displayedAnswer.setText(resultConvert);
        }
        else
        {

            int result = Integer.parseInt(givenInput[0]);
            for (int i = 1; i < counter;)
            {
                if (givenInput[i].contains("/"))
                {
                    result /= Integer.parseInt(givenInput[i+1]);
                    i += 2;
                }
                else if (givenInput[i].contains("-"))
                {
                    result -= Integer.parseInt(givenInput[i+1]);
                    i += 2;
                }
                else if (givenInput[i].contains("+"))
                {
                    result += Integer.parseInt(givenInput[i+1]);
                    i += 2;
                }
                else if (givenInput[i].contains("*"))
                {
                    result *= Integer.parseInt(givenInput[i+1]);
                    i += 2;
                }
            }

       //     int result = Integer.parseInt(receivedInput);   //this doesn't work. deprecated
            String resultConvert = Integer.toString(result);
            displayedAnswer.setText(resultConvert);
        }

    }
}

