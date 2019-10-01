package com.timepasstechnologies.dates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.timepasstechnologies.date.DateCalculator;

public class MainActivity extends AppCompatActivity {

    EditText Datetime1,Datetime2,Time1,Time2,Date1;
    TextView result;
    Button button1,button2,button3;
    String Result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Datetime1 = findViewById(R.id.DateTime1);
        Datetime2 = findViewById(R.id.DateTime2);

        Time1 = findViewById(R.id.Time1);
        Time2 = findViewById(R.id.Time2);

        Date1 = findViewById(R.id.Date1);

        result= findViewById(R.id.result);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String dt1 = Datetime1.getText().toString();
               String dt2 = Datetime2.getText().toString();

               if(TextUtils.isEmpty(dt1))
               {
                   Datetime1.setError("Can't be Empty");
               }

               else if(TextUtils.isEmpty(dt2))
               {
                   Datetime2.setError("Can't be Empty");
               }

               else {
                   Result = "Time Difference is "+
                           new DateCalculator().getTimeBetweenDates(dt1,dt2);
               }
                result.setText(Result);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = Time1.getText().toString();
                String t2 = Time2.getText().toString();

                if(TextUtils.isEmpty(t1))
                {
                    Time1.setError("Can't be Empty");
                }

                else if(TextUtils.isEmpty(t2))
                {
                    Time2.setError("Can't be Empty");
                }

                else {
                    Result = "Total Hours are "+
                            new DateCalculator().addTime(t1,t2)+
                            " Difference Between Hours " + new DateCalculator().subtractTime(t1,t2);
                }
                result.setText(Result);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = Date1.getText().toString();

                if(TextUtils.isEmpty(d1))
                {
                    Date1.setError("Can't be Empty");
                }

                else {
                    Result = "Number of Days in Given Month "+
                            new DateCalculator().getDaysInMonth(new DateCalculator().getMonth(d1),new DateCalculator().getYear(d1))+
                            " Year in Given String " +  new DateCalculator().getYear(d1)+
                            " Month in Given String " + new DateCalculator().getMonth(d1)+
                            " Date in Given String "  + new DateCalculator().getDay(d1)+
                            " Hours in Given String"  + new DateCalculator().getHour(d1)+
                            " Minutes in Given String"  + new DateCalculator().getMinutes(d1)+
                            " Seconds in Given String"  + new DateCalculator().getSeconds(d1);

                }
                result.setText(Result);
            }
        });



    }



}
