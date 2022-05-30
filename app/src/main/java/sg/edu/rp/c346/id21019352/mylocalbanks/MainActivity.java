package sg.edu.rp.c346.id21019352.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btDBS;
    Button btOCBC;
    Button btUOB;

    String wordClicked = "";

    boolean favBank;
    boolean favDBS = false;
    boolean favOCBC = false;
    boolean favUOB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btDBS = findViewById(R.id.buttonDBS);
        btUOB = findViewById(R.id.buttonUOB);
        btOCBC = findViewById(R.id.buttonOCBC);

        registerForContextMenu(btDBS);
        registerForContextMenu(btOCBC);
        registerForContextMenu(btUOB);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btDBS.setText("DBS");
            btOCBC.setText("OCBC");
            btUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            btDBS.setText("星展银行");
            btOCBC.setText("华侨银行");
            btUOB.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == btDBS) {
            wordClicked = "dbs";
        } else if (v == btOCBC) {
            wordClicked = "ocbc";
        } else if (v == btUOB) {
            wordClicked = "uob";
        }

        if(v == btDBS) {
            favBank = favDBS;
        } else if (v == btOCBC) {
            favBank = favOCBC;
        } else if (v == btUOB) {
            favBank = favUOB;
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact");

        if (favBank == false) {
            menu.add(0, 2, 2, "Favourite");
        } else {
            menu.add(0, 2, 2, "Unfavourite");
        }
    }

    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("dbs")) {

            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "Redirect to Bank's Website", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Toast.makeText(MainActivity.this, "Dialling Bank", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+180011111));
                startActivity(intentCall);

                return true;  //menu item successfully handled

            } else if (item.getItemId() == 2) {

                if (favDBS == false) {
                    Toast.makeText(MainActivity.this, "Added to favourites", Toast.LENGTH_SHORT).show();
                    btDBS.setTextColor(Color.RED);
                    favDBS = true;
                    return true;

                } else if (favDBS) {
                    Toast.makeText(MainActivity.this, "Removed from favourites", Toast.LENGTH_SHORT).show();
                    btDBS.setTextColor(Color.WHITE);
                    favDBS = false;
                    return true;
                }

            }

        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "Redirect to Bank's Website", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Toast.makeText(MainActivity.this, "Dialling Bank", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+180036333));
                startActivity(intentCall);
                return true;  //menu item successfully handled

            } else if (item.getItemId() == 2) {

                if (favOCBC == false) {
                    Toast.makeText(MainActivity.this, "Added to favourites", Toast.LENGTH_SHORT).show();
                    btOCBC.setTextColor(Color.RED);
                    favOCBC = true;
                    return true;

                } else if (favOCBC) {
                    Toast.makeText(MainActivity.this, "Removed from favourites", Toast.LENGTH_SHORT).show();
                    btOCBC.setTextColor(Color.WHITE);
                    favOCBC = false;
                    return true;

                }
            }

        }else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "Redirect to Bank's Website", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Toast.makeText(MainActivity.this, "Dialling Bank", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+180022221));
                startActivity(intentCall);
                return true;  //menu item successfully handled

            } else if (item.getItemId() == 2) {

                if (favUOB == false) {
                    Toast.makeText(MainActivity.this, "Added to favourites", Toast.LENGTH_SHORT).show();
                    btUOB.setTextColor(Color.RED);
                    favUOB = true;
                    return true;

                } else if (favUOB) {
                    Toast.makeText(MainActivity.this, "Removed from favourites", Toast.LENGTH_SHORT).show();
                    btUOB.setTextColor(Color.WHITE);
                    favUOB = false;
                    return true;
                }

            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

}