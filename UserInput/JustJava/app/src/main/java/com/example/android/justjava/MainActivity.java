package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.justjava.R;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int numberOfCoffees = TextViewToIntNumberOfCoffees();
        displayPrice(numberOfCoffees * 5);
    }

    public void submitAddOne(View view) {
        Add();
    }

    public void submitDeleteOne(View view) {
        Delete();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method adds one to the number of coffees
     */
    private void Add(){

        int number = TextViewToIntNumberOfCoffees();
        int result = 0;
        result = number + 1;

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + result);

    }

    /**
     * This method deletes one to the number of coffees
     */
    private void Delete()
    {
        int number = TextViewToIntNumberOfCoffees();
        int result = 0;
        if(number>0){
            result = number - 1;
        }
        else {
            result=0;
        }

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + result);
    }

    private int TextViewToIntNumberOfCoffees()
    {   TextView viewnumber;
        viewnumber = (TextView) findViewById(R.id.quantity_text_view);
        int number = Integer.parseInt(viewnumber.getText().toString());

        return number;
    }
    /**
     * This method displays the given price value on the screen.
     */
    private void displayPrice(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);
        quantityTextView.setText(" Total: " + NumberFormat.getCurrencyInstance().format(number) + "\n Thank you!"  );

        String nutritionInfo="500 calories or less";

    }


}