package au.edu.jcu.cp3406.reflexchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Setup the task descriptions
        setupDescription(R.id.task1, R.array.task1_descriptions);
        setupDescription(R.id.task2, R.array.task2_descriptions);
    }

    public void setupDescription(int taskID, int arrayID) {
        TextView task = findViewById(taskID);
        String[] descriptions = getResources().getStringArray(arrayID);

        int i = random.nextInt(descriptions.length);
        task.setText(descriptions[i]);
    }
}