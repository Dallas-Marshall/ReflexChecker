package au.edu.jcu.cp3406.reflexchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private final Random random = new Random();
    private static final int[] drawables = {
            R.drawable.baseline_commute_black_48,
            R.drawable.baseline_flight_land_black_48,
            R.drawable.baseline_report_problem_black_48,
            R.drawable.baseline_trending_down_black_48
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Setup the task descriptions
        setupDescription(R.id.task1, R.array.task1_descriptions);
        setupDescription(R.id.task2, R.array.task2_descriptions);

        // Inflate image and checkboxes layout
        addImage();
        addCheckboxes(R.array.drinks);
        addImage();
        addCheckboxes(R.array.fruits);
    }

    public void setupDescription(int taskID, int arrayID) {
        TextView task = findViewById(taskID);
        String[] descriptions = getResources().getStringArray(arrayID);

        int i = random.nextInt(descriptions.length);
        task.setText(descriptions[i]);
    }

    public void addImage() {
        ViewGroup gameRows = findViewById(R.id.game_rows);
        getLayoutInflater().inflate(R.layout.image, gameRows);

        View lastChild = gameRows.getChildAt(gameRows.getChildCount() - 1);
        ImageView image = lastChild.findViewById(R.id.image);

        int index = random.nextInt(drawables.length);
        image.setImageDrawable(getResources().getDrawableForDensity(drawables[index], 0));
    }

    public void addCheckboxes(int arrayID) {
        ViewGroup gameRows = findViewById(R.id.game_rows);
        getLayoutInflater().inflate(R.layout.checkboxes, gameRows);

        View lastChild = gameRows.getChildAt(gameRows.getChildCount() - 1);
        TableRow row = lastChild.findViewById(R.id.checkboxes);

        String[] descriptions = getResources().getStringArray(arrayID);
        for (int i = 0; i < 3; i++) {
            CheckBox checkbox = (CheckBox) row.getChildAt(i);
            checkbox.setText(descriptions[i]);
            checkbox.setChecked(false);


        }
    }
}