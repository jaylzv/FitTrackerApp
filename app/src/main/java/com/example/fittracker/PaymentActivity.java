package com.example.fittracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

        Programme programme = (Programme) getIntent().getSerializableExtra("Programme");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    // Initialize SharedPreferences
                    SharedPreferences preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
                    String email = preferences.getString("email", null);
                    Gson gson = new Gson();

                    // Initialize programmeList from SharedPreferences
                    ArrayList<Programme> programmeList;
                    String json = preferences.getString(email + "_programme_list", null);
                    Type type = new TypeToken<ArrayList<Programme>>() {}.getType();
                    if (json == null) {
                        // If there is no data in SharedPreferences, initialize foodList as an empty list
                        programmeList = new ArrayList<>();
                    } else {
                        // Otherwise, load the data from SharedPreferences
                        programmeList = gson.fromJson(json, type);
                    }

                    // Add the new programme to the programmeList
                    programmeList.add(programme);

                    // Save the updated programmeList in SharedPreferences
                    SharedPreferences.Editor editor = preferences.edit();
                    json = gson.toJson(programmeList, type);
                    editor.putString(email + "_programme_list", json);
                    editor.apply();

                    Toast.makeText(PaymentActivity.this, "Programme successfully bought!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(PaymentActivity.this, SearchProgrammeActivity.class);
                    startActivity(intent);
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