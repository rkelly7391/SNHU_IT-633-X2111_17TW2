package com.example.kelly_ryan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.io.*;

/**
 * The ShoppingCart screen will display the total of the cart
 * It will also display the quantity of each item as well as the total
 *
 * Update - 1) Change the scope of variables and eliminated unused variables -RK
 *          2) Will read json files and get values of the products -RK
 *
 * @author  Ryan Kelly
 * @version 1.1
 */

public class ShoppingCart extends AppCompatActivity {


    //Create the button
    Button checkOutButton;

    //Constants of the prices and taxes
    private String JSONFILE = "values.json";
    private static final double TAX = 0.0625;
    private static final String REMOVE_MESSAGE = "Would you like to remove this from your shopping cart?";
    private static final String UNKNOWN_ITEM = "Unknown Item";
    private static final String ITEM_WAS_NOT_REMOVED = "Item was not removed";
    private static final String ITEM_WAS_REMOVED = "Item was removed";
    private static final String TREADMILL = "Treadmill";
    private static final String ROADRUNNER = "Roadrunner";
    private static final String FOX = "Fox";
    private static final String PIANO = "Piano";
    private static final String VALUE = "value";
    private static final String DISCOUNT = "discount";
    private static final String YES = "Yes";
    private static final String NO = "No";


    //Global variables that will be used in different methods

    private static double TREADMILL_COST;
    private static double TREADMILL_DISCOUNT_COST;
    private static double ROADRUNNER_COST;
    private static double FOX_COST;
    private static double PIANO_COST;
    private String totalMessage = "";
    private String taxMessage = "";
    private ArrayAdapter<String> arrayAdapter = null;
    private ArrayList<String> cart = null;
    private ListView list = null;


    //Format the values to have two values after the decimal point
    DecimalFormat df = new DecimalFormat("##.00");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        //Have the button and list view find their id
        checkOutButton = findViewById(R.id.checkOut);
        list = findViewById(R.id.listView);
        //Create a cart so we can add to it
        cart = new ArrayList<>();

        //get the json file

        String jsonValues = readJSON();


        //Get the values based on the json file
        TREADMILL_COST = getValue(jsonValues,TREADMILL,VALUE);
        TREADMILL_DISCOUNT_COST = getValue(jsonValues,TREADMILL,DISCOUNT);
        ROADRUNNER_COST = getValue(jsonValues,ROADRUNNER,VALUE);
        FOX_COST = getValue(jsonValues,FOX,VALUE);
        PIANO_COST = getValue(jsonValues,PIANO,VALUE);

        //DEBUG FOR JSON CHANGES
        System.out.println("json is "+ jsonValues);

        //get the totals and display them
        calculateTotals();
        //create the array adapter that will be used

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cart);
        //Have list use the adapter
        list.setAdapter(arrayAdapter);

        //When an item is selected that is not the total or tax ask the user if they want to delete it

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {

                //We do not want to remove the total or the tax.
                if (i == 0 ){
                    System.out.println("line 0 was selected");
                                    }
                else if (i == 1){
                    System.out.println("Position selected was Total was selected");
                    Toast.makeText(getApplicationContext(),totalMessage,Toast.LENGTH_LONG).show();
                }
                else if (i == 2){
                    System.out.println("Position selected was Tax was selected");
                    Toast.makeText(getApplicationContext(),taxMessage,Toast.LENGTH_LONG).show();
                }
                else{
                    //Ask the user if they want to delete the item
                    new AlertDialog.Builder(ShoppingCart.this).setTitle(REMOVE_MESSAGE)
                            .setPositiveButton(YES, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //If they want to delete the item we must remove it from the cart one at a time
                                    if (cart.get(i).contains(TREADMILL + " x")){
                                        Specials.setTreadmillTotal(Specials.getTreadmillTotal() - 1);
                                    }else if (cart.get(i).contains(ROADRUNNER + " x")){
                                        Specials.setRoadrunnerTotal(Specials.getRoadrunnerTotal() - 1);
                                    }else if (cart.get(i).contains(FOX + " x")){
                                        Specials.setFoxTotal(Specials.getFoxTotal() - 1);
                                    }else if (cart.get(i).contains(PIANO + " x")){
                                        Specials.setPianoTotal(Specials.getPianoTotal() - 1);
                                    }else{
                                        Toast.makeText(getApplicationContext(),UNKNOWN_ITEM,Toast.LENGTH_LONG).show();
                                    }
                                    //We want to reset the cart
                                    cart.clear();
                                    //We want to get the new totals and display it
                                    calculateTotals();
                                    list.setAdapter(arrayAdapter);
                                    //We want to display a message to the user to inform them the item was removed
                                    Toast.makeText(getApplicationContext(), ITEM_WAS_REMOVED, Toast.LENGTH_LONG).show();

                                }
                            }).setNegativeButton(NO, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //We want to inform the user the item was not removed
                            Toast.makeText(getApplicationContext(), ITEM_WAS_NOT_REMOVED, Toast.LENGTH_LONG).show();
                        }
                    }).show();
                }

            }
        });
        //Allow the user to go to check out
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will bring the user to the Check out
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent Specials = new Intent(ShoppingCart.this, Checkout.class);
                startActivity(Specials);

            }
        });

    }


    /**
     * readJSON will read a josn file from the assets directory.
     * @return json which is the json file that was just read
     */
    private String readJSON(){

        // The name of the file to open
        System.out.println("Reading "+JSONFILE);
        //Will return the json file contents inside jsonFile
        String jsonFile = null;
        try {
            //Open the json file
            InputStream readJSON = getAssets().open(JSONFILE);
            //create a buffer of the size of the file
            byte[] buffer = new byte[readJSON.available()];
            //read the file
            readJSON.read(buffer);
            //Use the json file
            jsonFile = new String(buffer, "UTF-8");
            //close the file
            readJSON.close();
        } catch (IOException e) {
            //Catch the exception and print the reason
            System.out.println("ERROR while reading json file: "+JSONFILE+" ERROR: "+e);
            e.printStackTrace();
        }
        //Return the json file
        return jsonFile;
    }

    /**
     * getValue will retrun the value of an item that is for sale based on the json file.
     * @param jsonFile json file that holds the values
     * @param item the item that you want the value
     * @param price is the price that you are looking for, either discount or full cost
     * @return value is the value of the item passed in.  It can be the value or the discount value
     */
    public double getValue (String jsonFile, String item, String price){

        //What will be returned
        double value = 0.0;

        try {
           //get the json file
            JSONObject jf = new JSONObject(jsonFile);
            //get the item from the json file
            JSONObject itemInFile  = jf.getJSONObject(item);
            //get the price for the item
            String StringValue = itemInFile.getString(price);

            //DEBUG for json edit
            System.out.println("Price of "+item + " is " + StringValue);
            //Convert the string into a double
            value = Double.parseDouble(StringValue);

        } catch (JSONException e) {
            //Catch the exception and print the reason
            System.out.println("ERROR getting the" + price + " for " + item + " ERROR: "+e);
            e.printStackTrace();
        }

        return value;

    }

    /**
     * calculateTotals will get the values from the Specials class and calculate the total
     * It will then add it to the array to be displayed on the cart section of the app
     */
    public void calculateTotals(){


        //local variables
        int treadmillTotalOrdered;
        int roadrunnerTotalOrdered;
        int foxTotalOrdered;
        int pianoTotalOrdered;
        double taxTotal = 0;
        double grandTotal = 0;


        //get the number of item that was added to the cart
        treadmillTotalOrdered = Specials.getTreadmillTotal();
        roadrunnerTotalOrdered = Specials.getRoadrunnerTotal();
        foxTotalOrdered = Specials.getFoxTotal();
        pianoTotalOrdered = Specials.getPianoTotal();
        //get the coupons that will effect this order
        boolean applyDiscount = Specials.getTreadmillCoupon();
        boolean applyBogo = Specials.getBogo();
        //Calculate the cost of each item
        //get the correct value of a treadmill if a coupon was selected
        double treadmillTotal;
        if (applyDiscount){
            treadmillTotal = treadmillTotalOrdered * TREADMILL_DISCOUNT_COST;
        }else {
            treadmillTotal = treadmillTotalOrdered * TREADMILL_COST;
        }
        double roadrunnerTotal = roadrunnerTotalOrdered * ROADRUNNER_COST;
        double foxTotal = foxTotalOrdered * FOX_COST;
        double pianoTotal = pianoTotalOrdered * PIANO_COST;

        //Get the grand total with tax
        if(treadmillTotalOrdered > 0){
            double tmt = treadmillTotal * TAX;
            taxTotal = taxTotal + tmt;
            grandTotal = grandTotal + treadmillTotal;
        }
        if(roadrunnerTotalOrdered > 0){
            double rrt = roadrunnerTotal * TAX;
            taxTotal = taxTotal + rrt;
            grandTotal = grandTotal + roadrunnerTotal;
        }
        if(foxTotalOrdered > 0){
            double ft = foxTotal * TAX;
            taxTotal = taxTotal + ft;
            grandTotal = grandTotal + foxTotal;
        }
        if(pianoTotalOrdered > 0){
            double pt = pianoTotal * TAX;
            taxTotal = taxTotal + pt;
            grandTotal = grandTotal + pianoTotal;
        }

        //Create a message that will be used
        totalMessage = "Total: $"+df.format(grandTotal + taxTotal);
        taxMessage = "Tax: $"+df.format(taxTotal);
        //Display the information to the cart display
        cart.add("");
        cart.add(totalMessage);
        cart.add(taxMessage);

        if(treadmillTotalOrdered > 0){
            cart.add("Treadmill x"+ treadmillTotalOrdered + " Total $"+df.format(treadmillTotal));
        }
        if(roadrunnerTotalOrdered > 0){
            int roadrunnerDisplay;
            if (applyBogo){
                roadrunnerDisplay = roadrunnerTotalOrdered + 1;
            }else{
                roadrunnerDisplay = roadrunnerTotalOrdered;
            }

            cart.add("Roadrunner x"+ roadrunnerDisplay + " Total $"+df.format(roadrunnerTotal));
        }
        if(foxTotalOrdered > 0){
            cart.add("Fox x"+ foxTotalOrdered + " Total $"+df.format(foxTotal));
        }
        if(pianoTotalOrdered > 0){
            cart.add("Piano x"+ pianoTotalOrdered + " Total $"+df.format(pianoTotal));
        }

    }

}