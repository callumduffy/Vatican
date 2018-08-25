package ie.duffydev.vatican;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private static List<Integer> ruleTypes = new ArrayList<>();
    private static String rule;
    private static String ruleType;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);

        configButton();
        initRuleTypes();
        setNewRule();
    }

    private void configButton(){
        Button newRuleButton = (Button) findViewById(R.id.button4);
        newRuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewRule();
            }
        });
    }

    private void initRuleTypes(){
        ruleTypes.add(0);
        ruleTypes.add(1);
        ruleTypes.add(2);
        ruleTypes.add(3);
    }

    private void setNewRule(){
        int ruleInt = getRandomRuleType();
        //checking for if no rules of a given type left
        if(!getRandomRule(ruleInt)){
            if(ruleTypes.size()==0){
                Log.i("TEST","game over");
                Toast.makeText(getBaseContext(), "GAME OVER!!", Toast.LENGTH_SHORT).show();
            }
            else{
                setNewRule();
            }
        }
        else{
            String player = choosePlayer();

            //set the player
            TextView nameField = (TextView) findViewById(R.id.playerNameField);
            nameField.setText(player);
            Log.i("TEST", "player: "+player);

            //set the rule type
            TextView ruleTypeField = (TextView) findViewById(R.id.ruleTypeField);
            ruleTypeField.setText(ruleType);
            Log.i("TEST","rule type: " + ruleType);

            //set the rule
            TextView ruleField = (TextView) findViewById(R.id.ruleField);
            ruleField.setText(rule);
            Log.i("TEST", "rule: " + rule);
        }

    }

    private String choosePlayer(){
        return AddPlayersActivity.players.get(rand.nextInt(AddPlayersActivity.players.size()));
    }

    private int getRandomRuleType(){
        return ruleTypes.get(rand.nextInt(ruleTypes.size()));
    }

    private boolean getRandomRule(int ruleInt){

        switch (ruleInt){
            //decree
            case 0:
                if(HomeActivity.decrees.size()>0){
                    ruleType = "Decree";
                    rule = getNewDecree();
                    return true;
                }
                ruleTypes.remove(new Integer(ruleInt));
                Log.i("TEST", "removed rule type: " + ruleInt);
                return false;
            case 1:
                if(HomeActivity.confessions.size()>0){
                    ruleType = "Confession";
                    rule = getNewConfession();
                    return true;
                }
                ruleTypes.remove(new Integer(ruleInt));
                Log.i("TEST", "removed rule type: " + ruleInt);
                return false;
            case 2:
                if(HomeActivity.judgements.size()>0){
                    ruleType = "Judgement";
                    rule = getNewJudgment();
                    return true;
                }
                ruleTypes.remove(new Integer(ruleInt));
                Log.i("TEST", "removed rule type: " + ruleInt);
                return false;
            case 3:
                if(HomeActivity.commandments.size()>0){
                    ruleType = "Commandment";
                    rule = getNewCommandment();
                    return true;
                }
                ruleTypes.remove(new Integer(ruleInt));
                Log.i("TEST", "removed rule type: " + ruleInt);
                return false;
            default:
                Toast.makeText(getBaseContext(), "ERROR: Incorrect Rule Int.", Toast.LENGTH_SHORT).show();
                System.exit(0);
                return false;
        }
    }

    private String getNewDecree(){
        String rule = HomeActivity.decrees.get(rand.nextInt(HomeActivity.decrees.size()));
        HomeActivity.decrees.remove(rule);
        return rule;
    }

    private String getNewConfession(){
        String rule = HomeActivity.confessions.get(rand.nextInt(HomeActivity.confessions.size()));
        HomeActivity.confessions.remove(rule);
        return rule;
    }

    private String getNewJudgment(){
        String rule = HomeActivity.judgements.get(rand.nextInt(HomeActivity.judgements.size()));
        HomeActivity.judgements.remove(rule);
        return rule;
    }

    private String getNewCommandment(){
        String rule = HomeActivity.commandments.get(rand.nextInt(HomeActivity.commandments.size()));
        HomeActivity.commandments.remove(rule);
        return rule;
    }
}
