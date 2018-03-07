package com.example.kelly_ryan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/**
 * The Specials will show what the user can add to their cart.
 * There will be setters and getters so that other classes can access the values and totals
 *
 * Update - Shorten the time the windows appear on the screen -RK
 *
 *
 * @author  Ryan Kelly
 * @version 1.1
 */
public class Specials extends AppCompatActivity {

    //Create the buttons
    Button TButton, RRButton, FoxButton, PianoButton, FSButton, FOButton, TOButton, BOGOUButton, CartButton;
    //create the variables
    static private int treadmillTotal = 0;
    static private int roadrunnerTotal = 0;
    static private int foxTotal = 0;
    static private int pianoTotal = 0;
    static private boolean twentyfiveoff = false;
    static private boolean bogo = false;
    //create the options for the buttons
    final private String OK = "OK";
    final private String CANCELL = "Cancelled";
    //create the strings for the message box
    final private String TITLE = "Add To Your Cart?";
    final private String MESSAGE = "Would you like to add this item to your shopping cart?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials);

        //Have the buttons find their IDs
        TButton = findViewById(R.id.TreadMill);
        RRButton = findViewById(R.id.RR);
        FoxButton = findViewById(R.id.Fox);
        PianoButton = findViewById(R.id.Piano);
        FSButton = findViewById(R.id.FreeShipping);
        FOButton = findViewById(R.id.Fifty);
        TOButton = findViewById(R.id.Twenty);
        BOGOUButton = findViewById(R.id.Bogo);
        CartButton = findViewById(R.id.Cart);



        TButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                treadmillTotal += 1;
                                Toast.makeText(getApplicationContext(), "Treadmill was added to your car.  You now have " + treadmillTotal + " in your cart", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "No new treadmill was added to your cart", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        RRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                roadrunnerTotal += 1;
                                Toast.makeText(getApplicationContext(), "Roadrunners was added to your car.  You now have " + roadrunnerTotal + " in your cart", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "No new Roadrunners was added to your cart", Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });
        FoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                foxTotal += 1;
                                Toast.makeText(getApplicationContext(), "Fox was added to your car.  You now have " + foxTotal + " in your cart", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "No new Fox was added to your cart", Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });

        PianoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                pianoTotal += 1;
                                Toast.makeText(getApplicationContext(), "Piano was added to your car.  You now have " + pianoTotal + " in your cart", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "No new Piano was added to your cart", Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });

        FSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "You order will have free shipping", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).show();

            }
        });

        FOButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Your next order will be 50% off", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).show();

            }
        });

        TOButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "25% off your treadmill order", Toast.LENGTH_SHORT).show();
                                twentyfiveoff = true;
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).show();

            }
        });

        BOGOUButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Specials.this).setTitle(TITLE).setMessage(MESSAGE)
                        .setCancelable(true)
                        .setPositiveButton(OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Another roadrunner will be added to your cart", Toast.LENGTH_SHORT).show();
                                System.out.println("Counter is set to: " + treadmillTotal);
                                bogo = true;
                            }
                        })
                        .setNegativeButton(CANCELL, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "No new roadrunner was added to your cart", Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });

        //Allows the user to go to the cart so they can check out
        CartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Specials = new Intent(Specials.this, ShoppingCart.class);
                startActivity(Specials);
            }
        });

    }

    // Setters and getters for other methods in other classes
    public static int getTreadmillTotal() {
        return treadmillTotal;
    }

    public static int getRoadrunnerTotal() {
        return roadrunnerTotal;
    }

    public static int getFoxTotal() {
        return foxTotal;
    }

    public static int getPianoTotal() {
        return pianoTotal;
    }

    public static void setTreadmillTotal(int newTotal) {
        treadmillTotal = newTotal;
    }

    public static void setRoadrunnerTotal(int newTotal) {
        roadrunnerTotal = newTotal;
    }

    public static void setFoxTotal(int newTotal) {
        foxTotal = newTotal;
    }

    public static void setPianoTotal(int newTotal) {
        pianoTotal = newTotal;
    }

    public static boolean getTreadmillCoupon(){ return twentyfiveoff; }

    public static boolean getBogo(){ return bogo; }
}
