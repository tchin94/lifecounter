package edu.washington.tchin94.lifecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {

    static final int STARTING_LIFE = 20;
    private static int player1 = STARTING_LIFE;
    private static int player2 = STARTING_LIFE;
    private static int player3 = STARTING_LIFE;
    private static int player4 = STARTING_LIFE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            player1 = savedInstanceState.getInt("player1");
            player2 = savedInstanceState.getInt("player2");
            player3 = savedInstanceState.getInt("player3");
            player4 = savedInstanceState.getInt("player4");
        }

        TextView p1Life = (TextView) findViewById(R.id.player1_life);
        p1Life.setText("Life: " + player1);
        TextView p2Life = (TextView) findViewById(R.id.player2_life);
        p2Life.setText("Life: " + player2);
        TextView p3Life = (TextView) findViewById(R.id.player3_life);
        p3Life.setText("Life: " + player3);
        TextView p4Life = (TextView) findViewById(R.id.player4_life);
        p4Life.setText("Life: " + player4);

        Button player1Add1 = (Button)findViewById(R.id.player1add1);
        player1Add1.setOnClickListener(clickHandlerPlayer1);
        Button player1Add5 = (Button)findViewById(R.id.player1add5);
        player1Add5.setOnClickListener(clickHandlerPlayer1);
        Button player1Sub1 = (Button)findViewById(R.id.player1sub1);
        player1Sub1.setOnClickListener(clickHandlerPlayer1);
        Button player1Sub5 = (Button)findViewById(R.id.player1sub5);
        player1Sub5.setOnClickListener(clickHandlerPlayer1);

        Button player2Add1 = (Button)findViewById(R.id.player2add1);
        player2Add1.setOnClickListener(clickHandlerPlayer2);
        Button player2Add5 = (Button)findViewById(R.id.player2add5);
        player2Add5.setOnClickListener(clickHandlerPlayer2);
        Button player2Sub1 = (Button)findViewById(R.id.player2sub1);
        player2Sub1.setOnClickListener(clickHandlerPlayer2);
        Button player2Sub5 = (Button)findViewById(R.id.player2sub5);
        player2Sub5.setOnClickListener(clickHandlerPlayer2);

        Button player3Add1 = (Button)findViewById(R.id.player3add1);
        player3Add1.setOnClickListener(clickHandlerPlayer3);
        Button player3Add5 = (Button)findViewById(R.id.player3add5);
        player3Add5.setOnClickListener(clickHandlerPlayer3);
        Button player3Sub1 = (Button)findViewById(R.id.player3sub1);
        player3Sub1.setOnClickListener(clickHandlerPlayer3);
        Button player3Sub5 = (Button)findViewById(R.id.player3sub5);
        player3Sub5.setOnClickListener(clickHandlerPlayer3);

        Button player4Add1 = (Button)findViewById(R.id.player4add1);
        player4Add1.setOnClickListener(clickHandlerPlayer4);
        Button player4Add5 = (Button)findViewById(R.id.player4add5);
        player4Add5.setOnClickListener(clickHandlerPlayer4);
        Button player4Sub1 = (Button)findViewById(R.id.player4sub1);
        player4Sub1.setOnClickListener(clickHandlerPlayer4);
        Button player4Sub5 = (Button)findViewById(R.id.player4sub5);
        player4Sub5.setOnClickListener(clickHandlerPlayer4);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("player1", player1);
        savedInstanceState.putInt("player2", player2);
        savedInstanceState.putInt("player3", player3);
        savedInstanceState.putInt("player4", player4);
        TextView loser = (TextView) findViewById(R.id.loser);
        savedInstanceState.putString("loser", loser.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        player1 = savedInstanceState.getInt("player1");
        player2 = savedInstanceState.getInt("player2");
        player3 = savedInstanceState.getInt("player3");
        player4 = savedInstanceState.getInt("player4");
        TextView loser = (TextView) findViewById(R.id.loser);
        loser.setText(savedInstanceState.getString("loser"));
    }

    private OnClickListener clickHandlerPlayer1 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String op = view.getContentDescription().toString();
            int amount = 1;
            if (op.endsWith("5")) {
                amount = 5;
            }
            if (op.startsWith("+")) {
                player1 += amount;
            } else {
                player1 -= amount;
            }
            if (player1 <= 0) {
                TextView loser = (TextView) findViewById(R.id.loser);
                loser.setText("Player 1 LOSES!");
            }
            TextView lifePoints = (TextView) findViewById(R.id.player1_life);
            lifePoints.setText("Life: " + player1);
        }
    };

    private OnClickListener clickHandlerPlayer2 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String op = view.getContentDescription().toString();
            int amount = 1;
            if (op.endsWith("5")) {
                amount = 5;
            }
            if (op.startsWith("+")) {
                player2 += amount;
            } else {
                player2 -= amount;
            }
            if (player2 <= 0) {
                TextView loser = (TextView) findViewById(R.id.loser);
                loser.setText("Player 2 LOSES!");
            }
            TextView lifePoints = (TextView) findViewById(R.id.player2_life);
            lifePoints.setText("Life: " + player2);
        }
    };

    private OnClickListener clickHandlerPlayer3 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String op = view.getContentDescription().toString();
            int amount = 1;
            if (op.endsWith("5")) {
                amount = 5;
            }
            if (op.startsWith("+")) {
                player3 += amount;
            } else {
                player3 -= amount;
            }
            if (player3 <= 0) {
                TextView loser = (TextView) findViewById(R.id.loser);
                loser.setText("Player 3 LOSES!");
            }
            TextView lifePoints = (TextView) findViewById(R.id.player3_life);
            lifePoints.setText("Life: " + player3);
        }
    };

    private OnClickListener clickHandlerPlayer4 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String op = view.getContentDescription().toString();
            int amount = 1;
            if (op.endsWith("5")) {
                amount = 5;
            }
            if (op.startsWith("+")) {
                player4 += amount;
            } else {
                player4 -= amount;
            }
            if (player4 <= 0) {
                TextView loser = (TextView) findViewById(R.id.loser);
                loser.setText("Player 4 LOSES!");
            }
            TextView lifePoints = (TextView) findViewById(R.id.player4_life);
            lifePoints.setText("Life: " + player4);
        }
    };
}
