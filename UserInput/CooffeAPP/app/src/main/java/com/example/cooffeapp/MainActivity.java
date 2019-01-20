package com.example.cooffeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Public methods --> directly related to the view
     */

    public void plusOne(View view) {
        String selection = "add";
        ModifyQuantity(selection);
    }

    public void minusOne(View view) {
        String selection = "delete";
        ModifyQuantity(selection);
    }

    public void summitOrder(View vew) {
        DisplayOrder();
    }

    /**
     * Now we have to implement the logic of the public methods in order to add some actions to our
     * buttons
     */

    private void ModifyQuantity(String selection) {
        int currentQuantity = 0;
        int updatedQuantity = 0;
        TextView quantity = (TextView) findViewById(R.id.quantity_of_cups);

        currentQuantity = GetQuantity();

        if (selection == "add") {
            updatedQuantity = currentQuantity + 1;
        } else if (selection == "delete") {
            if (currentQuantity > 0) {
                updatedQuantity = currentQuantity - 1;
            } else {
                updatedQuantity = 0;
            }
        }
        quantity.setText("" + updatedQuantity);

    }

    private int GetQuantity() {
        int result;

        TextView quantity = (TextView) findViewById(R.id.quantity_of_cups);
        result = Integer.parseInt(quantity.getText().toString());

        return result;
    }

    private void DisplayOrder() {
        int quantity = GetQuantity();
        int toppingPrice = addToppingPrice();
        int pricePerCoffee = 4;
        int totalPrice = quantity * (pricePerCoffee + toppingPrice);
        String customerName = getNameFromView();
        String finalOutput ;

        String normalOutput = (getString(R.string.name) + customerName + "\n" +
                getString(R.string.quantity) +": " + quantity + "\n" +
                "Total: " + NumberFormat.getCurrencyInstance().format(totalPrice) + "\n" +
                getString(R.string.thank_you));

        if (checkWhippedCream() && checkChocolate()) {
            finalOutput = (getString(R.string.toppings) + ": "+ getString(R.string.chocolate)
                    + getString(R.string.whippedCream) + "\n" + normalOutput);
        } else if (checkChocolate() && !checkWhippedCream()) {
            finalOutput = (getString(R.string.toppings) + ": "+ getString(R.string.chocolate)
                    + " \n" + normalOutput);
        } else if (!checkChocolate() && checkWhippedCream()) {
            finalOutput = (getString(R.string.toppings) + ": "+ getString(R.string.whippedCream)
                    + " \n" + normalOutput);
        } else {
            finalOutput = normalOutput;
        }
        // Now we are going to initialize the intent to open  the gmail app
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{" "});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
        intent.putExtra(Intent.EXTRA_TEXT, finalOutput);
        intent.setPackage("com.google.android.gm");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Toast.makeText(this, getString(R.string.toastMessage), Toast.LENGTH_SHORT).show();
    }

    private boolean checkWhippedCream() {
        CheckBox topping = (CheckBox) findViewById(R.id.notifyWhippedCream);
        return topping.isChecked();
    }

    private boolean checkChocolate() {
        CheckBox topping = (CheckBox) findViewById(R.id.notifyChocolate);
        return topping.isChecked();
    }

    /**
     * we will increase each topping by one dollar
     */

    private int addToppingPrice() {
        int extraPrice;
        boolean condition1 = (checkChocolate() && !checkWhippedCream());
        boolean condition2 = (!checkChocolate() && checkWhippedCream());

        if (checkWhippedCream() && checkChocolate()) {
            extraPrice = 2;
        } else if (condition1 || condition2) {
            extraPrice = 1;
        } else {
            extraPrice = 0;
        }

        return extraPrice;
    }

    private String getNameFromView() {
        EditText name = (EditText) findViewById(R.id.customerName);
        return name.getText().toString();
    }
}
