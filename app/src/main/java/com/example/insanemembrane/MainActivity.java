package com.example.insanemembrane;
// Added this comment for the purpose of learning to git
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
        // check to see if input is empty. if so remind user to enter a number
        if(tempStr.length() == 0)  {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            numberOfRolls.setText("Rolls");
            linearFT.setText("LF");
        }else {
            // initialize variable to subtract from without manipulating user imput variable
            int sqFtSubtractor = Integer.parseInt(membraneSqft.getText().toString());
            // initialize roll incrementer
            int rollsNeeded = 0;
            // total square footage per full roll of membrane
            int membraneSqFtPerRoll = 225;
            // while square footage needed is greater than or equal to Square footage
            // per full roll subtract 225 and add 1 to full rolls needed
            while (sqFtSubtractor >= membraneSqFtPerRoll) {
                sqFtSubtractor -= membraneSqFtPerRoll;
                rollsNeeded++;
            }
            // takes whats left and converts to linear footage rounded up
            int lfNeeded = (int) Math.ceil((double) sqFtSubtractor / 3.25);
            // outputs to user number of full rolls needed and how much of a 
            // partial roll in lf is needed.
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
