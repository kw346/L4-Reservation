package sg.edu.rp.c346.id20022735.l4_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText conno;
    EditText noppl;
    RadioGroup area;
    RadioButton non;
    RadioButton sma;
    DatePicker date;
    TimePicker time;
    Button btnRe;
    Button btnCfm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.Name);
        conno = findViewById(R.id.editTextPhone);
        noppl = findViewById(R.id.editTextNumber);
        area = findViewById(R.id.Area);
        non = findViewById(R.id.nsa);
        sma=findViewById(R.id.sa);
        date = findViewById(R.id.dp);
        time = findViewById(R.id.TP);
        btnRe = findViewById(R.id.reset);
        btnCfm = findViewById(R.id.cfm);

        time.setCurrentHour(19);
        time.setCurrentMinute(30);
        date.updateDate(2020,5,01);

        btnCfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().length() != 0){
                    String mz = name.getText().toString();
                    if (conno.getText().toString().trim().length() != 0){
                        String num = conno.getText().toString();
                        if (noppl.getText().toString().trim().length() != 0){
                            String nos = noppl.getText().toString();
                            int hr = time.getCurrentHour();
                            int min = time.getCurrentMinute();
                            String t = "";
                            if (min < 10 ){
                                t = t + hr + ":0" + min;
                            }
                            else{
                                t = t + hr + ":" + min;
                            }

                            int day= date.getDayOfMonth();
                            int mth = date.getMonth() + 1;
                            int yr = date.getYear();
                            String when = + day + "/" + mth + "/"+ yr;
                            if (area.getCheckedRadioButtonId() == R.id.nsa){
                                String place = "non-smoking area";
                                String msg = "Thank you " + mz + ", you have reserved a table at the " + place + " on " + when + " (" + t + "), for " + nos + " people. A reminder will be sent to " + num + ".";
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                            }
                            else if (area.getCheckedRadioButtonId() == R.id.sa){
                                String place = "smoking area";
                                String msg = "Thank you " + mz + ", you have reserved a table at the " + place + " on " + when + " (" + t + "), for " + nos + " people. A reminder will be sent to " + num + ".";
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                            else{
                                String msg = "Choose an area";
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            String msg = "Please enter the number of people";
                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                    }else{
                            String msg = "Please enter your contact number";
                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        }else{
                    String msg = "Please enter your name";
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                            }

        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                date.updateDate(2020,5,01);
                name.setText("");
                conno.setText("");
                noppl.setText("");
                area.clearCheck();
            }
        });
    }}
