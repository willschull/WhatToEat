package willschull.whattoeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class addRecipe extends AppCompatActivity  {

    EditText nameBox;
    EditText pointsBox;
    EditText servingsBox;

    //Radio buttons
    String difficulty;
    Boolean marinade;

    Spinner spinner;
    Spinner spinner2;

    String type;
    String cost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addrecipe);

        nameBox = findViewById(R.id.nameEdit);
        pointsBox = findViewById(R.id.pointsEdit);

        spinner = (Spinner) findViewById(R.id.typeSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                type = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                type = spinner.getSelectedItem().toString();
            }

        });

        spinner2 = (Spinner) findViewById(R.id.costSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.cost_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                cost = spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                cost = spinner2.getSelectedItem().toString();
            }

        });

    }

    public void onRadioDifficultyClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.easyRadio:
                if (checked)
                    difficulty = "Easy";
                    break;
            case R.id.mediumRadio:
                if (checked)
                    difficulty = "Medium";
                    break;
            case R.id.hardRadio:
                if (checked)
                    difficulty = "Hard";
                    break;
        }
    }

    public void onRadioMarinadeClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.yesRadio:
                if (checked)
                    marinade = Boolean.TRUE;
                break;
            case R.id.noRadio:
                if (checked)
                    marinade = Boolean.FALSE;
                break;
        }
    }



    public void addNewRecipe(View view){

        //int points, String cost, String name
        int points = Integer.parseInt(pointsBox.getText().toString());
        String name = nameBox.getText().toString();

        Intent i = new Intent();
        i.putExtra("type", type);
        i.putExtra("points", points);
        i.putExtra("cost", cost);
        i.putExtra("name", name);
        this.setResult(RESULT_OK,i);
        finish();
    }

}
