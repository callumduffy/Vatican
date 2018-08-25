package ie.duffydev.vatican;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    //basic rule setup
    public static List<String> decrees = new ArrayList<>();
    public static List<String> confessions = new ArrayList<>();
    public static List<String> judgements = new ArrayList<>();
    public static List<String> commandments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //config buttons
        configNewGameButton();
        configRulesButton();
        configTutorialButton();

        if(!loadRules()){
            //temp exit
            System.exit(0);
        }
    }

    private boolean loadRules(){
        tempRuleSetup();
        return true;
    }

    private void configNewGameButton() {
        //new game button
        Button newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddPlayersActivity.class));
            }
        });
    }

    private void configRulesButton() {
        //add rules button
        Button addRulesButton = (Button) findViewById(R.id.addRulesButton);
        addRulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //TODO update the intent with rules activity
                startActivity(new Intent(HomeActivity.this,AddPlayersActivity.class));
            }
        });
    }

    private void configTutorialButton() {
        //settings button
        Button settingsButton = (Button) findViewById(R.id.tutorialButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //TODO update the intent with settings activity
                startActivity(new Intent(HomeActivity.this, AddPlayersActivity.class));
            }
        });
    }

    private void tempRuleSetup(){
        decrees.add("test decree");
        confessions.add("test confession");
        judgements.add("test jusgement");
        commandments.add("test commandment");
    }
}
