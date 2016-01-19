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

    String receivedInput;

    public void onDecimalClick (View view) //inserts decimal point, making number a double
    {
        String dec = (String) view.getTag(); //grabs
        receivedInput = receivedInput + dec; //inserts decimal point
    }

    public void onOperandClick (View view)//grabs the operand symbol and concatenates it.
    {
        String operant = (String) view.getTag(); //grabs
        receivedInput = receivedInput + " " + operant + " "; //inserts the operation with spaces around it so it parses.
    }

    public void onNumericClick (View view)  //concatenates in a new number.
    {
        String num = (String) view.getTag();  //grabs value from clicked button
        receivedInput = receivedInput + num;  //concatenates
    }

    public void solveFunction (View view)  //computes values and outputs results
    {
        EditText displayedAnswer = (EditText) findViewById (R.id.resultField);
        if (receivedInput.contains("."))
        {
            double result = Double.parseDouble(receivedInput);
            String resultConvert = Double.toString(result);
            displayedAnswer.setText(resultConvert);
        }
        else
        {
            int result = Integer.parseInt(receivedInput);
            String resultConvert = Integer.toString(result);
            displayedAnswer.setText(resultConvert);
        }

    }
}

