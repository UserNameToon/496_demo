package ca.macewan.cmpt496.mobileappdemo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newButton = findViewById(R.id.button);


        newButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //switching activity
                switchActivity();
            }
        });
    }

    private void switchActivity(){
        //create intent to switch to home screen
        //HomeActivity represent the java class for activity_home.xml
        Intent switchToHome = new Intent(this, HomeActivity.class);
        //passing data from first activity to second activity
        //example getting the input email login page (activity_main.xml)
        TextView emailText = findViewById(R.id.editTextTextEmailAddress);
        switchToHome.putExtra("message", emailText.getText().toString());
        startActivity(switchToHome);
    }
}