package willschull.whattoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getChoices() {
        int maxChicken = 3; //No more than 3 per week

        ArrayList<String> chicken = new ArrayList<String>(4);
        String[] newChickRec = {"Chicken1", "Chicken2", "Chicken3", "Chicken4"};
        for (int i = 0; i < newChickRec.length; i++) {
            chicken.add(newChickRec[i]);
        }

        ArrayList<String> pork = new ArrayList<String>(4);
        String[] newPorkRec = {"Pork1", "Pork2", "Pork3", "Pork4"};
        for (int i = 0; i < newPorkRec.length; i++) {
            pork.add(newPorkRec[i]);
        }

        ArrayList<String> beef = new ArrayList<String>(4);
        String[] newBeefRec = {"Beef1", "Beef2", "Beef3", "Beef4"};
        for (int i = 0; i < newBeefRec.length; i++) {
            beef.add(newBeefRec[i]);
        }


        Random rand = new Random();

        int n = 0;
        int type = 0;

        for (int i = 0; i < 6; i++) {
            type = rand.nextInt(3);
            if (type == 0) {
                n = rand.nextInt(chicken.size());
                System.out.println(chicken.get(n));
                chicken.remove(n);
            }
            if (type == 1) {
                n = rand.nextInt(pork.size());
                System.out.println(pork.get(n));
                pork.remove(n);
            }
            if (type == 2) {
                n = rand.nextInt(beef.size());
                System.out.println(beef.get(n));
                beef.remove(n);
            }
        }
    }
}
