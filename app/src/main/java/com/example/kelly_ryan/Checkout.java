package com.example.kelly_ryan;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * The Checkout will allow the user to enter in their personal information
 * The xml file that is associated with this class limits the fields to ensure the correct information is entered
 * For sensitive information no suggestions will be allowed when typing
 *
 * @author  Ryan Kelly
 * @version 1.0
 */

public class Checkout extends AppCompatActivity {

    //Create the button and
    Button placeOrderButton;
    //Create the message that will be used
    private final String TITLE = "Place order?";
    private final String CHECKOUT_MESSAGE = "Please press OK to finish the checkout process";
    private final String CANCEL_MESSAGE = "Please review your cart and make any changes you need.";
    private final String OK = "OK";
    private final String CANCEL = "Cancel";
    private final String message = "Your oder has been placed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Have the button find the id
        placeOrderButton = findViewById(R.id.placeOrderButton);
        //When the button is hit display a message
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Checkout.this).setTitle(TITLE).setMessage(CHECKOUT_MESSAGE)
                        .setCancelable(true).setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                                //clear the cart since the order has been placed
                                Specials.setTreadmillTotal(0);
                                Specials.setRoadrunnerTotal(0);
                                Specials.setFoxTotal(0);
                                Specials.setPianoTotal(0);
                            }
                        }).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), CANCEL_MESSAGE, Toast.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });


    }
}
