package com.example.android.justjavamod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 2;
    private int perCoffee = 5;
    private int toppingPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View V) {
        if (quantity < 10) {
            quantity = quantity + 1;
            displayQuantity(quantity);
            return;
        }

        Toast.makeText(getApplicationContext(), "Too much coffee for a day", Toast.LENGTH_SHORT).show();
    }

    public void decrement(View v) {
        if (quantity > 1) {
            quantity = quantity - 1;
            displayQuantity(quantity);
            return;
        }

        Toast.makeText(this, "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show();
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quatity_text_view);
        quantityTextView.setText("" + number);
        displayPrice(calculatePrice());
    }

    private String displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        return (String) orderSummaryTextView.getText();
    }

    public void updatePriceOption(View v) {
        CheckBox checkBoxOption = (CheckBox) findViewById(v.getId());

        if (checkBoxOption.getText().toString().toLowerCase().equals("whipped cream") && checkBoxOption.isChecked()) {
            toppingPrice += 1;
        } else if (checkBoxOption.getText().toString().toLowerCase().equals("whipped cream") && !checkBoxOption.isChecked()){
            toppingPrice -= 1;
        }
        if (checkBoxOption.getText().toString().toLowerCase().equals("chocolate") && checkBoxOption.isChecked()) {
            toppingPrice += 2;
        } else if (checkBoxOption.getText().toString().toLowerCase().equals("chocolate") && !checkBoxOption.isChecked()){
            toppingPrice -= 2;
        }

        displayPrice(calculatePrice());
    }

    public void submitOrder(View v) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.option_one);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.option_two);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText userNameEditText = (EditText) findViewById(R.id.name_input);
        String userName =  userNameEditText.getText().toString();
        //Log.i("MainActivity", "username: " + userName);

//        int extraToppings = 0;
//
//        if (hasWhippedCream) {
//            extraToppings += 1;
//        }
//        if (hasChocolate) {
//            extraToppings += 2;
//        }

        int price = calculatePrice();
        displayMessage(createOrderSummary(userName, price, hasWhippedCream, hasChocolate));
    }

    private int calculatePrice() {
        int outputPrice = 0;
        if (quantity > 0) {
            outputPrice = quantity * (perCoffee + toppingPrice);
        } else {
            outputPrice = toppingPrice;
        }
        return outputPrice;
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(String userName, int price, boolean addWhippedCream, boolean addChocolate) {
        return "Name: " + userName + "\nAdd Whipped cream? " + addWhippedCream + "\nAdd Chocolate? " + addChocolate +
                "\nQuantity: " + quantity + "\nTotal: " + price + "\nThank you!";
    }
}
