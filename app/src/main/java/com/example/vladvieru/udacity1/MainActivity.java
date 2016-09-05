package com.example.vladvieru.udacity1;

import android.annotation.TargetApi;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){

        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view){

        quantity--;
        displayQuantity(quantity);
    }

    //Here is the main method
    public void submitOrder(View view){
        //Checkbox for Whipped Cream
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();


        //CheckBox for Chocolate
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate =  chocolateCheckBox.isChecked();

        //EditText for Name
        EditText name = (EditText)findViewById(R.id.name);
        String inputName = name.getText().toString();
        

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        displayMessage(createOrderSummary(price,hasWhippedCream,hasChocolate, inputName));
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate){
        int basePrice =5;

        if(addWhippedCream){
            basePrice+=1;
        }
        if(addChocolate){
            basePrice+=2;
        }

        return basePrice*quantity;
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String inputName){
        String priceMessage = "Name: "+ inputName+"\n";
        priceMessage=priceMessage+ "Add whipped cream?"+ addWhippedCream;
        priceMessage=priceMessage+ "\nAdd chocolate?"+addChocolate;
        priceMessage=priceMessage + "\nQuantity: " + quantity+ "\n";
        priceMessage=priceMessage + "Total: $" + price;
        priceMessage = priceMessage + "\nThank You, " + inputName + " for your order!" ;
        return priceMessage;
    }

    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    private void displayMessage(String message){
        //Here is a TextView object
        //orderSummaryTextview is a variable
        //findviewbyid returns an object of TextView
        
        TextView orderSummaryTextView=(TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
