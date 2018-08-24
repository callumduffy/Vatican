package ie.duffydev.vatican;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    //basic player setup
    public static List<String> players = new ArrayList<>();

    //basic rule setup
    public static List<String> decrees = new ArrayList<>();
    public static List<String> confessions = new ArrayList<>();
    public static List<String> judgements = new ArrayList<>();
    public static List<String> commandments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    private boolean loadRules(){
        tempRuleSetup();
        return true;
    }

    private void initGame(){

    }

    private void addRule(){

    }

    private void openSettings(){

    }

    private void tempRuleSetup(){
        decrees.add("test decree");
        confessions.add("test confession");
        judgements.add("test jusgement");
        commandments.add("test commandment");
    }
}
