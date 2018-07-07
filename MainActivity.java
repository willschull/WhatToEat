package willschull.whattoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getChoices();
            }
        });
    }

    public void getChoices() {
        /*
        TODO: Show recipe when name is clicked
        TODO: Populate text boxes with info
        TODO: Find a better way to add recipes.Possibilities are JSON or SQLite.

         */
        EditText editText = findViewById(R.id.editText);
        String[] choices = new String[5];

        int maxChicken = 3; //No more than 3 per week
        int chickenCount = 0;

        //Create map
        Map<String, List<recipe>> map1 = new HashMap<String, List<recipe>>();

        //Create lists and objects to add to list
        List<recipe> chicken = new ArrayList<recipe>();
        //Parameters: int points, String cost, String name
        recipe Chicken1 = new recipe(2, "$$", "Chicken 1");
        chicken.add(Chicken1);
        recipe Chicken2 = new recipe(3, "$$$", "Chicken 2");
        chicken.add(Chicken2);
        //TODO: Add more chicken recipes
        map1.put("chicken", chicken);

        //TODO: Add pork recipes
        //TODO: Add beef recipes
        //TODO: Add fish recipes

        Random rand = new Random();

        int type = 0;
        int n = 0;// for picking a recipe


        for (int i = 0; i < 5; i++) {
            //Generate random number to choose which category to pick from
            type = 0;//rand.nextInt(4);
            List<recipe> tmpList = new ArrayList<recipe>();
            if(type == 0){ //0 is chicken
                tmpList = map1.get("chicken");
            }
            n = rand.nextInt(tmpList.size());//random number for recipe
            recipe obj = tmpList.get(n);
            choices[i] = "Name: "+obj.getName()+" Cost: "+obj.getCost()+" Points: "+obj.getPoints();//set choices

        }


        /*
        Map<Integer, List<String>> map1 = new HashMap<Integer, List<String>>();
        List<String> arraylist1 = new ArrayList<String>();
        List<String> arraylist2 = new ArrayList<String>();
        List<String> arraylist3 = new ArrayList<String>();

        String[] newChickRec = {"Chicken 1", "Chicken 2", "Chicken 3", "Chicken 4"};
        Collections.addAll(arraylist1,newChickRec);
        map1.put(1,arraylist1);

        String[] newPorkRec = {"Pork 1", "Pork 2", "Pork 3", "Pork 4"};
        Collections.addAll(arraylist2, newPorkRec);
        map1.put(2, arraylist2);

        String[] newBeefRec = {"Beef 1", "Beef 2", "Beef 3", "Beef 4"};
        Collections.addAll(arraylist3, newBeefRec);
        map1.put(3, arraylist3);

        Random rand = new Random();

        int n = 0; //pick from array list
        int points = 0; //used for picking a recipe based on points
        List<String> tempList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            points = rand.nextInt(3)+1;
            n = rand.nextInt(tempList.size());//random number for recipe
            tempList = map1.get(points);//get list
            choices[i] = "Points: " + points + " Recipe: " + tempList.get(n);//set choices

        }
        */
        editText.setText("");

        for (String choice : choices) {
            editText.append(choice);
            editText.append("\n");
        }


        //Bug testing



    }
}
