package ie.duffydev.vatican;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AddPlayersActivity extends AppCompatActivity {

    private String[] lv_arr = {};
    private ArrayAdapter<String> arrayAdapter;

    //basic player setup
    public static List<String> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_players_activity);
        configAddPlayerButton();
        configStartGameButton();
        setListView();
    }

    private void setListView(){
        // Convert ArrayList to array and set to ListView
        ListView lv = (ListView) findViewById(R.id.playerList);
        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item, R.id.list_view_text,
                players);
        lv.setAdapter(arrayAdapter);
    }

    private void configAddPlayerButton(){
        //add player
        Button addPlayerButton = (Button) findViewById(R.id.addPlayerButton);
        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO make player list to be max size 8
                EditText editText = (EditText) findViewById(R.id.playerName);
                String name = editText.getText().toString();
                players.add(name);
                Log.i("AddPlayers:", "name:" + name);
                Log.i("AddPlayers:", "size: " + players.size());
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void configStartGameButton(){
        //start game
        Button startGameButton = (Button) findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddPlayersActivity.this, GameActivity.class));
            }
        });
    }
}
