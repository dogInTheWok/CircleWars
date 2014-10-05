package com.example.linda.circlewars;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.linda.circlewars.IGame;

public class GamePhaseDistrib extends Activity {

    static final int TOKENSIZE = 24;

    GlobalFactory factory;
    IGame game;
    IField[] fields = new IField[12];
    ImageView[] tokensX = new ImageView[14];
    ImageView[] tokensO = new ImageView[14];

    GameField gameFields[] = new GameField[12]; // consider ArrayList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_phase_distrib);
        factory = new GlobalFactory();
        game = factory.createGame();
        findViewById(R.id.cwImg).setOnTouchListener(gameTouchListener);
        setImageRessourcesAndVisibilityForTokens();
    }

    private void setImageRessourcesAndVisibilityForTokens() {
        for (int i=0;i<14;i++) {
            tokensX[i].setImageResource(R.drawable.x);
            tokensX[i].setVisibility(View.INVISIBLE);

            tokensO[i].setImageResource(R.drawable.o);
            tokensO[i].setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_phase_distrib, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    final View.OnTouchListener gameTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent e) {
            if (e.getAction() == MotionEvent.ACTION_DOWN){
                GameField field = getFieldIdFromCoords(e.getX(), e.getY());
                game.dispatchForce(field.getId());
            }

            v.isDirty();
            for (int i=0;i<12;i++) {
                drawToken(fields[i]);
            }
            return true;
        }
    };

    private void drawToken(IField field) {

        int x;
        int y;
        int id; // actual IGame.FIELD
        int tCount;

        id = field.getId();
        tCount = field.getTokenCount();
        x = gameFields[id].getxCenter();
        y = gameFields[id].getyCenter();
        if (field.getOwner() == 1){ // use player IDs
            drawX(x,y,tCount);
        }
        else {
            drawO(x,y,tCount);
        }

    }

    private void drawO(int x, int y, int tokenCount) {
        // draw TOKENCOUNT Os to input field center

        int k = 0;
        int offset = TOKENSIZE;

        while (tokensO[k].getVisibility() == ImageView.VISIBLE) {
            k++;
        }
        for (int i = k; i <= k + tokenCount; i++) {
            tokensO[i].setVisibility(ImageView.VISIBLE);
            tokensO[i].setLeft(x + (k-i) * TOKENSIZE);
            tokensO[i].setBottom(y);
        // TO DO: arrange in two rows on high token count
        //
        }
    }

    private void drawX(int x, int y, int tokenCount) {
        // draw TOKENCOUNT Xs to input field center
    }

    private GameField getFieldIdFromCoords(float x, float y) {
        return null;
    }
}
