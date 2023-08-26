package ca.macewan.cmpt496.mobileappdemo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DirectAction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView newText = findViewById(R.id.textView2);
        EditText firstName = findViewById(R.id.home_firstName_editText);
        EditText lastName = findViewById(R.id.home_lastName_editText);
        EditText phoneNo = findViewById(R.id.home_phoneNumber_editText);
        EditText emailAddress = findViewById(R.id.home_emailAddress_editText);
        EditText calendarDate = findViewById(R.id.home_dateInput_editText);
        Button addContactbutton = findViewById(R.id.home_add_contact_button);
        ImageButton calendarDialogButton = findViewById(R.id.home_calendar_imageButton);

        String greetingString = "hi! username: " + getIntent().getStringExtra("message");
        newText.setText(greetingString);



        DBHelper dbHelper = new DBHelper(this);

        calendarDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker(calendarDate);
            }
        });

        addContactbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.addContact(firstName.getText().toString() + " " + lastName.getText().toString(), phoneNo.getText().toString(), emailAddress.getText().toString(), calendarDate.getText().toString());
            }
        });
    }

    private void openDatePicker(EditText calendarEditText){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendarEditText.setText(String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day));
            }
        }, 2023, 1, 1);
        dialog.show();
    }
}