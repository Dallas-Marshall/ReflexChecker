package au.edu.jcu.cp3406.reflexchecker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTest(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}