package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity = 0;
    private int perCoffee = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createWeatherMessage("San Franciso", 77);
    }

    private String createWeatherMessage(String cityName, int temperature) {
        String message = "Welcome to the " + cityName + ", where the temperature is " + temperature + "F.";
        return message;
    }

    public void increment(View V) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View v) {
        if (quantity > 0) {
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
    }

    // A test method
    public void vagueSace(int quantity) {
        quantity = quantity + 5; // quantity var of vagueSace gets created on stack while the other one gets created with instance that is on heap.
    }

    public void submitOrder(View v) {
        // calling vagueSace dosn't alter quantity variable of class.
        vagueSace(quantity);
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
        //String message = "Total: $" + price;
        //displayMessage(message + "\nThank you!");
        //displayMessage("Quantity: " + quantity + "\n" + displayPrice(quantity * perCoffee) +
        //        "\nThank you, for ordering!");
        //String priceMessage = "Free";
        //displayMessage("Total: " + quantity + "\nThankYou");
    }

    private int calculatePrice() {
        return quantity * perCoffee;
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quatity_text_view);
        quantityTextView.setText("" + number);
        displayPrice(number * perCoffee);
    }

    private String displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        return (String) orderSummaryTextView.getText();
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(int price) {
        return "Name: Pratik D\nQuantity: " + quantity + "\nTotal: " + price + "\nThank you!";
    }
}
