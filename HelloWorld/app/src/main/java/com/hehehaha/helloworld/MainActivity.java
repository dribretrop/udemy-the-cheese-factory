package com.hehehaha.helloworld;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

   /* TextView tvHello;
    EditText editTextHello;
    Button btnButton;*/

    EditText editText1;
    EditText editText2;
    TextView tvResult;
    Button btnCalculate;
    CheckBox chkboxAgree;

    RadioGroup rgOperator;
    RadioButton rbPlus, rbMinus, rbMultiply, rbDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initInstances();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x; //Screen Width
        int height = size.y; //Screen Height

        Toast.makeText(MainActivity.this,"Width = "+width+", Height = "+height,Toast.LENGTH_LONG).show();


        chkboxAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkboxAgree.isChecked() == false) {
                    chkboxAgree.setText("Please agree first");
                } else {
                    chkboxAgree.setText("I agree");
                }

            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (chkboxAgree.isChecked() == true) {
                    int val1 = 0;
                    int val2 = 0;
                    int sum = 0;

                    try {
                        val1 = Integer.parseInt(editText1.getText().toString());
                    } catch (NumberFormatException e) {

                    }

                    try {
                        val2 = Integer.parseInt(editText2.getText().toString());

                    } catch (NumberFormatException e) {

                    }

                    switch (rgOperator.getCheckedRadioButtonId()) {
                        case R.id.rbPlus:
                            sum = val1 + val2;

                            break;

                        case R.id.rbMinus:
                            sum = val1 - val2;

                            break;

                        case R.id.rbMultiply:
                            sum = val1 * val2;

                            break;
                        case R.id.rbDivide:
                            try {
                                sum = val1 / val2;
                            } catch (ArithmeticException e) {
                                Toast.makeText(getApplicationContext(), "Can't divide by Zero", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                    tvResult.setText("= " + String.valueOf(sum));

                    Log.wtf("Calculation", "Result = " + sum);
                    Toast.makeText(MainActivity.this, "Result = " + sum, Toast.LENGTH_SHORT).show();
                } else {
                    chkboxAgree.setChecked(true);
                    Toast.makeText(MainActivity.this,"Please enter Calculate again",Toast.LENGTH_SHORT).show();
                }


            }
        });





//        btnCalculate();


        //initInstances();
    }

    private void initInstances() {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        chkboxAgree = (CheckBox) findViewById(R.id.chkboxAgree);

        rgOperator = (RadioGroup) findViewById(R.id.rgOperator);
        rbPlus = (RadioButton) findViewById(R.id.rbPlus);
        rbMinus = (RadioButton) findViewById(R.id.rbMinus);
        rbMultiply = (RadioButton) findViewById(R.id.rbMultiply);
        rbDivide = (RadioButton) findViewById(R.id.rbMinus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {
            Toast.makeText(MainActivity.this, "Setting",Toast.LENGTH_SHORT).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //    private void btnCalculate() {
//        btnCalculate.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                //if (chkboxAgree.isChecked()) {
//                                                int val1 = 0;
//                                                int val2 = 0;
//                                                int sum = 0;
//
//                                                try {
//                                                    val1 = Integer.parseInt(editText1.getText().toString());
//                                                } catch (NumberFormatException e) {
//                                                    //editText1.setText("Enter number");
//                                                }
//
//                                                try {
//                                                    val2 = Integer.parseInt(editText2.getText().toString());
//                                                } catch (NumberFormatException e) {
//                                                    //editText2.setText(e.getMessage());
//                                                }
//
//                                                if (rbPlus.isChecked()) {
//                                                    sum = val1 + val2;
//                                                } else if (rbMinus.isChecked()) {
//                                                    sum = val1 - val2;
//                                                } else if (rbMultiply.isChecked()) {
//                                                    sum = val1 * val2;
//                                                } else {
//                                                    try {
//                                                        sum = val1 / val2;
//                                                    } catch (ArithmeticException e){
//                                                        tvResult.setText(e.getMessage());
//
//                                                    }
//
//                                                }
//
//                                                tvResult.setText("= " + sum);
//                                            }
//
//                                            //sum = val1 + val2;
//
//
//
//                /*else {
//                    chkboxAgree.setText("Please agree first !");
//
//                }
//                //  checkIfEmptyNumber();
//
//
//            }
//
//            /*private void checkIfEmptyNumber() {
//                int val1;
//                int val2;
//                int sum;
//
//                if (editText1.getText().toString().matches("") | editText2.getText().toString().matches("")) {
//                    Toast.makeText(getApplicationContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show();
//                } else {
//                    val1 = Integer.parseInt(editText1.getText().toString());
//                    val2 = Integer.parseInt(editText2.getText().toString());
//
//                    sum = val1 + val2;
//                    tvResult.setText("= " + sum);
//                }
//            }*/
//    }
//
//    );
//}

    /*@Override
    public void onClick(View v) {
        if (v == btnCalculate) {
            int x = Integer.parseInt(editText1.getText().toString());
            int y = Integer.parseInt(editText2.getText().toString());
            tvResult.setText(" = " + (x+y));

        }

    }*/


/*    private void initInstances() {
        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setMovementMethod(LinkMovementMethod.getInstance());
        tvHello.setText(Html.fromHtml("<h1><a href=\"http://www.google.com\"> <font color=\"#ff00ff\"><b> Hello </b> <i> World </i></font></a></h1>"));

        editTextHello = (EditText) findViewById(R.id.editTextHello);
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    //copy text in EditText to TextView
                    tvHello.setText(editTextHello.getText());
                    return true;

                }

                    return false;
            }
        });


        btnButton = (Button) findViewById(R.id.btnCopy);
        btnButton.setOnClickListener(this);
    }*/

    /*
    @Override
    public void onClick(View v) {
        if (v == btnButton) {
            tvHello.setText(editTextHello.getText());
        }
    }*/
}
