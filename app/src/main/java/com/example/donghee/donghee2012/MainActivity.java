package com.example.donghee.donghee2012;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import static android.R.id.edit;

public class MainActivity extends AppCompatActivity {

    Button b2,b3,b4,b5;
    TextView t1,t2,t3;
    RadioButton rdi1,rdi2,rdi3, rdi4, rdi5;
    CalendarView cal;
    TimePicker timeP;
    ImageView image;
    LinearLayout lay1, lay2;
    Switch sw;
    Chronometer chro;
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);

        sw = (Switch) findViewById(R.id.switch1);

        t1 = (TextView) findViewById(R.id.View1);       // 결과값 3개
        t2 = (TextView) findViewById(R.id.View2);
        t3 = (TextView) findViewById(R.id.View3);

        image = (ImageView) findViewById(R.id.imageView3);

        lay1 = (LinearLayout) findViewById(R.id.mainLayout);
        lay2 = (LinearLayout) findViewById(R.id.main2Layout);

        lay1.setVisibility(View.INVISIBLE);
        lay2.setVisibility(View.INVISIBLE);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    chro.setBase(SystemClock.elapsedRealtime());
                    chro.start();
                    chro.setTextColor(Color.RED);
                    lay1.setVisibility(View.VISIBLE);
                } else {
                    chro.stop();
                    chro.setTextColor(Color.BLUE);
                    lay1.setVisibility(View.INVISIBLE);
                    lay2.setVisibility(View.INVISIBLE);
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.getText()
            }
        });

    }
}
