package com.example.kelly_ryan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;


/**
 * The MainActivity is the home screen of the app
 * It will display different buttons that the user can select
 * Only two buttons will bring the user to a new section
 *
 * @author  Ryan Kelly
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    //Create the buttons
    Button MSButton, DeptButton, SpecButton, GGButton, GCButton, ISButton, GDButton,WFUBUtton,CUButton, CartButton;

    //Create a Dummy String for sections of the app that are under construction
    private final String DUMMYMESSAGE = "This Section of the App is under construction";

    /**
     * onCreate will create the buttons when the app is first started or when the homescreen is visted
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Have the buttons find their IDs
        MSButton = findViewById(R.id.MobileShopping);
        DeptButton = findViewById(R.id.Departments);
        SpecButton = findViewById(R.id.Specials);
        GGButton = findViewById(R.id.GiftGuide);
        GCButton = findViewById(R.id.GiftCards);
        ISButton = findViewById(R.id.InventorySystem);
        GDButton = findViewById(R.id.GetDirections);
        WFUBUtton = findViewById(R.id.WorkForUs);
        CUButton = findViewById(R.id.ContactUs);
        CartButton = findViewById(R.id.CartMain);


        //Go to the specials section to display items that are on sale and coupons
        //In this section the user can add items to their carts
        SpecButton.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick will bring the user to the special section of the app
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent Specials = new Intent(MainActivity.this, Specials.class);
                startActivity(Specials);

            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        MSButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Display a dummy MESSAGE for the section of the app that is not support.
        DeptButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Display a dummy MESSAGE for the section of the app that is not support.
        GGButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Display a dummy MESSAGE for the section of the app that is not support.
        GCButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Display a dummy MESSAGE for the section of the app that is not support.
        ISButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Display a dummy MESSAGE for the section of the app that is not support.
        GDButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Display a dummy MESSAGE for the section of the app that is not support.
        WFUBUtton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Display a dummy MESSAGE for the section of the app that is not support.
        CUButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();

            }
        });
        //Allow the user to go to the cart from the home screen
        CartButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will bring the user to the shopping cart
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent Specials = new Intent(MainActivity.this, ShoppingCart.class);
                startActivity(Specials);

            }
        });



    }

}
