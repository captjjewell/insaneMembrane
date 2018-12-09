package com.example.insanemembrane;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//Insane Membrane App
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    public void calculateRolls(View view) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        TextView numberOfRolls = findViewById(R.id.numberOfRolls);
        TextView linearFT = findViewById(R.id.linearFT);
        EditText membraneSqft = findViewById(R.id.membraneSqft);
        String tempStr = membraneSqft.getText().toString();
        if(tempStr.length() == 0)  {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            numberOfRolls.setText("Rolls");
            linearFT.setText("LF");
        }else {
            int mBStr = Integer.parseInt(membraneSqft.getText().toString());
            int rollsNeeded = 0;
            int remLF = 0;
            while (mBStr >= 225) {
                mBStr -= 225;
                rollsNeeded++;
            }
            int lfNeeded = (int) Math.ceil((double) mBStr / 3.25);
            //int rollsNeeded = mBStr / 225;
            //int lfNeeded = mBStr % 225;
            numberOfRolls.setText("" + rollsNeeded + " Roll(s)");
            linearFT.setText("" + lfNeeded + " LF");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
