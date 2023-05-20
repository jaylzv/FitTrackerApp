package com.example.fittracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class PaymentActivity extends AppCompatActivity {

    private EditText editCardName, editCardNumber, editCardExpiry, editCardCVV;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        editCardName = findViewById(R.id.edit_card_name);
        editCardNumber = findViewById(R.id.edit_card_number);
        editCardExpiry = findViewById(R.id.edit_card_expiry);
        editCardCVV = findViewById(R.id.edit_card_cvv);
        submitButton = findViewById(R.id.button_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    // Continue with payment processing
                }
            }
        });
    }

    private boolean validate(){
        String cardName = editCardName.getText().toString();
        String cardNumber = editCardNumber.getText().toString();
        String cardExpiry = editCardExpiry.getText().toString();
        String cardCVV = editCardCVV.getText().toString();

        // Regular expressions for card validation
        String cardNumberPattern = "^\\d{16}$";
        String cardExpiryPattern = "^(0[1-9]|1[0-2])\\/?([0-9]{4}|[0-9]{2})$";
        String cardCVVPattern = "^\\d{3}$";

        if(cardName.isEmpty()){
            Toast.makeText(this, "Card name cannot be empty", Toast.LENGTH_LONG).show();
            return false;
        }
        if(!Pattern.matches(cardNumberPattern, cardNumber)){
            Toast.makeText(this, "Invalid card number", Toast.LENGTH_LONG).show();
            return false;
        }
        if(!Pattern.matches(cardExpiryPattern, cardExpiry)){
            Toast.makeText(this, "Invalid card expiry date", Toast.LENGTH_LONG).show();
            return false;
        }
        if(!Pattern.matches(cardCVVPattern, cardCVV)){
            Toast.makeText(this, "Invalid CVV", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}