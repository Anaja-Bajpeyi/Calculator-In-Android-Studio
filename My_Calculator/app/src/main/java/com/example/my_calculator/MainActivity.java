package com.example.my_calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Stack;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    TextView numberDisplay, operationsDisplay;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonCE, buttonBracketsOpen, buttonBracketsClose, buttonSum, buttonSubtraction, buttonMultiplication, buttonDivision, buttonEqual,buttonDot;
    String stringNumber, stringSpecial;
    double value=0;
    Expression expression;
    boolean numberClicked=false;
    int charBracketOpenCount=0, charBracketCloseCount=0, charInExceed=0, dotCount=0;
    char bracketOpen='(';
    char bracketClose=')';

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        stringSpecial = numberDisplay.getText().toString();
        outState.putString("numberDisplay", stringSpecial);

        stringSpecial = operationsDisplay.getText().toString();
        outState.putString("operationsDisplay", stringSpecial);

        outState.putDouble("resultValue", value);

        outState.putBoolean("numberClicked", numberClicked);

        outState.putInt("bracketOpenCount", charBracketOpenCount);
        outState.putInt("bracketCloseCount", charBracketCloseCount);
        outState.putInt("charInExceed", charInExceed);
        outState.putInt("dotCount", dotCount);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        numberDisplay.setText(savedInstanceState.getString("numberDisplay"));
        operationsDisplay.setText(savedInstanceState.getString("operationsDisplay"));

        value = savedInstanceState.getDouble("resultValue");

        numberClicked = savedInstanceState.getBoolean("numberClicked");

        charBracketOpenCount = savedInstanceState.getInt("bracketOpenCount");
        charBracketCloseCount = savedInstanceState.getInt("bracketCloseCount");
        charInExceed = savedInstanceState.getInt("charInExceed");
        dotCount = savedInstanceState.getInt("dotCount");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberDisplay = (TextView) findViewById(R.id.textView);
        operationsDisplay = (TextView) findViewById(R.id.textView2);
        button0 = (Button) findViewById(R.id.btn0);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonSum = (Button) findViewById(R.id.btnPlus);
        buttonSubtraction  = (Button) findViewById(R.id.btnMinus);
        buttonMultiplication = (Button) findViewById(R.id.btnMult);
        buttonDivision = (Button) findViewById(R.id.btnDiv);
        buttonCE = (Button) findViewById(R.id.btnClear);
        buttonEqual = (Button) findViewById(R.id.btnEqual);
        buttonBracketsOpen = (Button) findViewById(R.id.btnbrac1);
        buttonBracketsClose = (Button) findViewById(R.id.btnbrac2);

        getSupportActionBar().setElevation(0);
        clickButtonCE();
        //Remainder = (Button) findViewById(R.id.Remainder);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"1");
                operationsDisplay.setText(operationsDisplay.getText()+"1");
                numberClicked=true;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"2");
                operationsDisplay.setText(operationsDisplay.getText()+"2");
                numberClicked=true;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"3");
                operationsDisplay.setText(operationsDisplay.getText()+"3");
                numberClicked=true;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"4");
                operationsDisplay.setText(operationsDisplay.getText()+"4");
                numberClicked=true;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"5");
                operationsDisplay.setText(operationsDisplay.getText()+"5");
                numberClicked=true;
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"6");
                operationsDisplay.setText(operationsDisplay.getText()+"6");
                numberClicked=true;
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"7");
                operationsDisplay.setText(operationsDisplay.getText()+"7");
                numberClicked=true;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"8");
                operationsDisplay.setText(operationsDisplay.getText()+"8");
                numberClicked=true;
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"9");
                operationsDisplay.setText(operationsDisplay.getText()+"9");
                numberClicked=true;
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"0");
                operationsDisplay.setText(operationsDisplay.getText()+"0");
                numberClicked=true;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringSpecial = operationsDisplay.getText().toString();

                if (numberClicked == false) {

                }

                else if(stringSpecial.endsWith("(") || stringSpecial.endsWith("+") || stringSpecial.endsWith("-") || stringSpecial.endsWith("*") || stringSpecial.endsWith("/")) {

                }

                else {
                    if (dotCount == 1) {

                    } else {
                        dotCount++;
                        operationsDisplay.setText(operationsDisplay.getText() + ".");
                        stringSpecial = numberDisplay.getText().toString();
                        if(!stringSpecial.contains(".")) {
                            numberDisplay.setText(numberDisplay.getText() + "."); }
                    }
                }
            }
        });
        buttonBracketsOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay.setText(numberDisplay.getText()+"(");
                operationsDisplay.setText(operationsDisplay.getText()+"(");
                dotCount=0;
                numberClicked=false;
            }
        });
        buttonBracketsClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringSpecial = operationsDisplay.getText().toString();

                if(stringSpecial.isEmpty()) {

                }

                else if(stringSpecial.substring(stringSpecial.length()-1).equals("(")) {

                }

                else if(stringSpecial.substring(stringSpecial.length()-1).equals("+") ||
                        stringSpecial.substring(stringSpecial.length()-1).equals("-") ||
                        stringSpecial.substring(stringSpecial.length()-1).equals("*") ||
                        stringSpecial.substring(stringSpecial.length()-1).equals("/")) {

                }

                else if(!stringSpecial.contains("(")) {

                }

                else {
                    operationsDisplay.setText(operationsDisplay.getText() + ")");
                    numberDisplay.setText(numberDisplay.getText()+")");
                    dotCount=0;
                }
            }
        });

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNumberDisplay();

                stringSpecial = operationsDisplay.getText().toString();

                if(stringSpecial.isEmpty()) {

                }

                else if(stringSpecial.charAt(stringSpecial.length()-1)=='+' || stringSpecial.charAt(stringSpecial.length()-1)=='-' || stringSpecial.charAt(stringSpecial.length()-1)=='*' || stringSpecial.charAt(stringSpecial.length()-1)=='/') {

                }

                else {
                    buttonCE.setText("DEL");
                    operationsDisplay.setText(operationsDisplay.getText() + "+");
                    numberDisplay.setText(null);
                    numberClicked=false;
                    charBracketCloseCount=0;
                    charBracketCloseCount=0;
                    charBracketOpenCount=0;
                    dotCount=0;

                }
            }
        });

      buttonSubtraction.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              checkNumberDisplay();

              stringSpecial = operationsDisplay.getText().toString();


              buttonCE.setText("DEL");
              operationsDisplay.setText(operationsDisplay.getText() + "-");
              numberDisplay.setText("-");
              numberClicked = false;
              charBracketCloseCount = 0;
              charBracketCloseCount = 0;
              charBracketOpenCount = 0;
              dotCount = 0;
          }
      });

      buttonMultiplication.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              checkNumberDisplay();


              stringSpecial = operationsDisplay.getText().toString();

              if(stringSpecial.isEmpty()) {

              }

              else if(stringSpecial.charAt(stringSpecial.length()-1)=='(') {

              }

              else if(stringSpecial.charAt(stringSpecial.length()-1)=='+' || stringSpecial.charAt(stringSpecial.length()-1)=='-' || stringSpecial.charAt(stringSpecial.length()-1)=='*' || stringSpecial.charAt(stringSpecial.length()-1)=='/') {

              }

              else {
                  buttonCE.setText("DEL");
                  operationsDisplay.setText(operationsDisplay.getText() + "*");
                  numberDisplay.setText(null);
                  numberClicked=false;
                  charBracketCloseCount=0;
                  charBracketCloseCount=0;
                  charBracketOpenCount=0;
                  dotCount=0;
              }
          }
      });

      buttonDivision.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              checkNumberDisplay();

              stringSpecial = operationsDisplay.getText().toString();

              if(stringSpecial.isEmpty()) {

              }

              else if(stringSpecial.charAt(stringSpecial.length()-1)=='(') {

              }

              else if(stringSpecial.charAt(stringSpecial.length()-1)=='+' || stringSpecial.charAt(stringSpecial.length()-1)=='-' || stringSpecial.charAt(stringSpecial.length()-1)=='*' || stringSpecial.charAt(stringSpecial.length()-1)=='/') {

              }

              else {
                  numberClicked=false;
                  buttonCE.setText("DEL");
                  operationsDisplay.setText(operationsDisplay.getText() + "/");
                  numberDisplay.setText(null);
                  numberClicked=false;
                  charBracketCloseCount=0;
                  charBracketCloseCount=0;
                  charBracketOpenCount=0;
                  dotCount=0;
              }
          }
      });

      buttonEqual.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(numberClicked==false) {

              }

              else {

                  stringNumber = operationsDisplay.getText().toString();

                  checkBracketsNumber();

                  if(charBracketCloseCount > charBracketOpenCount) {
                      //numberDisplay.setText("Invalid expression");
                      Context context = getApplicationContext();
                      CharSequence text = "Invalid expression";
                      int duration = Toast.LENGTH_SHORT;
                      Toast.makeText(context, text, duration).show();
                  }

                  else if(stringNumber.contains("Infinity")) {
                      //numberDisplay.setText("Infinity");
                      Context context = getApplicationContext();
                      CharSequence text = "Infinity";
                      int duration = Toast.LENGTH_SHORT;
                      Toast.makeText(context, text, duration).show();
                  }

                  else {
                      expression = new ExpressionBuilder(stringNumber).build();

                      try {
                          value = expression.evaluate();
                          numberDisplay.setText(Double.toString(value));
                      }

                      catch (ArithmeticException e) {
                          //numberDisplay.setText("Can't divide by 0");
                          Context context = getApplicationContext();
                          CharSequence text = "Can't divide by 0";
                          int duration = Toast.LENGTH_SHORT;
                          Toast.makeText(context, text, duration).show();
                      }

                      buttonCE.setText("CLR");
                  }
              }
          }
      });

    }

    public void checkNumberDisplay() {
        stringSpecial = numberDisplay.getText().toString();
        if(Double.toString(value).equals(stringSpecial)) {
            operationsDisplay.setText(stringSpecial);
        }
    }

    public void checkBracketsNumber() {

        charBracketCloseCount=0;
        charBracketOpenCount=0;
        charInExceed=0;

        for (int i = 0; i < stringNumber.length(); i++) {
            if (stringNumber.charAt(i) == bracketOpen)
                charBracketOpenCount++;

            else if (stringNumber.charAt(i) == bracketClose)
                charBracketCloseCount++;
        }

        if (charBracketOpenCount == charBracketCloseCount) {

        }

        else if (charBracketOpenCount > charBracketCloseCount) {
            charInExceed = charBracketOpenCount - charBracketCloseCount;

            for (int j = 0; j < charInExceed; j++) {
                stringNumber = stringNumber + ")";
            }
        }
    }

    public void clickButtonCE() {

        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringSpecial = operationsDisplay.getText().toString();

                if (!stringSpecial.isEmpty()) {

                    if (Double.toString(value).equals(numberDisplay.getText().toString())) {

                    } else if (stringSpecial.endsWith(".")) {
                        dotCount = 0;
                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 1);
                        operationsDisplay.setText(stringSpecial);

                    } else {
                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 1);
                        operationsDisplay.setText(stringSpecial);
                        numberClicked = false;
                        if (stringSpecial.endsWith("1") || stringSpecial.endsWith("2") || stringSpecial.endsWith("3") || stringSpecial.endsWith("4") || stringSpecial.endsWith("5") || stringSpecial.endsWith("6") || stringSpecial.endsWith("7") || stringSpecial.endsWith("8") || stringSpecial.endsWith("9") || stringSpecial.endsWith("0") || stringSpecial.endsWith(")")) {
                            numberClicked = true;
                        }
                    }
                }

                stringSpecial = numberDisplay.getText().toString();

                if (!stringSpecial.isEmpty()) {

                    if (Double.toString(value).equals(numberDisplay.getText().toString())) {

                    } else if (stringSpecial.equals("Invalid expression") || stringSpecial.equals("Can't divide by 0")) {

                    } else {

                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 1);
                        numberDisplay.setText(stringSpecial);
                    }
                }

            }
        });

        buttonCE.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                numberDisplay.setText(null);
                operationsDisplay.setText(null);
                stringNumber = "";
                stringSpecial = "";
                value = 0;
                numberClicked = false;
                charBracketCloseCount = 0;
                charBracketOpenCount = 0;
                charInExceed = 0;
                dotCount = 0;
                buttonCE.setText("DEL");
                return false;
            }
        });

    }

}