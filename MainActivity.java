package willschull.whattoeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    //Create map
    Map<String, List<recipe>> map1 = new HashMap<String, List<recipe>>();

    //Create lists
    List<recipe> chicken = new ArrayList<recipe>();

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
        TODO: Add easy way to add recipes.
        TODO: Save objects to JSON list
        TODO: Make separate JSON files based on user's recipe list or list of all recipes
        Maybe use a 'my favorite recipes' list.
        TODO: Add rating system for recipes (1-5)
         */
        EditText editText = findViewById(R.id.editText);
        String[] choices = new String[5];

        int maxChicken = 3; //No more than 3 per week
        int chickenCount = 0;


        //Parameters: int points, String cost, String name
        recipe Chicken1 = new recipe(2, "$$", "Chicken 1");
        //chicken.add(Chicken1);
        recipe Chicken2 = new recipe(3, "$$$", "Chicken 2");
        //chicken.add(Chicken2);
        //TODO: Add more chicken recipes
        //map1.put("chicken", chicken);

        //TODO: Add pork recipes
        //TODO: Add beef recipes
        //TODO: Add fish recipes
        //TODO: Add turkey recipes

        Random rand = new Random();

        int type = 0;
        int n = 0;// for picking a recipe

        try {
            for (int i = 0; i < 5; i++) {
                //Generate random number to choose which category to pick from
                type = 0;//rand.nextInt(4);
                List<recipe> tmpList = new ArrayList<recipe>();
                if (type == 0) { //0 is chicken
                    tmpList = map1.get("chicken");
                }
                n = rand.nextInt(tmpList.size());//random number for recipe
                recipe obj = tmpList.get(n);
                choices[i] = "Name: " + obj.getName() + " Cost: " + obj.getCost() + " Points: " + obj.getPoints();//set choices
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

        }catch(Exception ex){
            android.util.Log.w(this.getClass().getSimpleName(),"error getting recipes");
        }


        //Bug testing



    }

    /*
     * One way to create Aciton Bar Buttons is to use xml menu specification. Create the file:
     * res/menu/main_activity_actions.xml to include contents as in this project.
     * reference to any images for the action bar should be created by right clicking on res folder
     * in the project and creating a new image asset. Be sure to specify Action Bar & Tab Icon
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        android.util.Log.d(this.getClass().getSimpleName(), "called onCreateOptionsMenu()");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
     * Implement onOptionsItemSelected(MenuItem item){} to handle clicks of buttons that are
     * in the action bar.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                //Create intent
                Intent displayPlace = new Intent(this, addRecipe.class);
                this.startActivityForResult(displayPlace, 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // called when the finish() method is called.
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        //int points, String cost, String name
        int points = data.getIntExtra("points", 0);
        android.util.Log.d(this.getClass().getSimpleName(),"points: " + points);
        String cost = data.getStringExtra("cost");
        android.util.Log.d(this.getClass().getSimpleName(),"cost: " + cost);
        String name = data.getStringExtra("name");
        android.util.Log.d(this.getClass().getSimpleName(),"name: " + name);

        String type = data.getStringExtra("type");
        android.util.Log.d(this.getClass().getSimpleName(),"type: " + type);

        recipe obj = new recipe(points, cost, name);

        List<recipe> tempList = new ArrayList<>();
        //ADD PREVIOUS OBJECTS TO LIST, THEN ADD NEW RECIPE, THEN MAP1.PUT
        if(map1.get("chicken") == null){
            tempList.add(obj);

            //add to map
            map1.put("chicken", tempList);
        }else{
            tempList = map1.get("chicken");
            tempList.add(obj);

            //add to map
            map1.put("chicken", tempList);
        }

        /*
        for(int i = 0; i < tempList.size(); i++){
            android.util.Log.d(this.getClass().getSimpleName(),"tempList[i]: " + tempList.get(i).getName());
        }
        */
        //tempList.addAll(chicken);
        //add chicken recipe for now

    }

}
