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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b2,b3,b4,b5,b6;
    TextView t1,t2,t3;
    RadioButton rdi1,rdi2,rdi3, rdi4, rdi5;
    CalendarView cal;
    TimePicker timeP;
    ImageView image;
    LinearLayout lay1, lay2;
    Switch sw;
    Chronometer chro;
    EditText ed1, ed2, ed3;
    int y,m,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (CalendarView) findViewById(R.id.calendarView);
        timeP = (TimePicker) findViewById(R.id.timePicker);

        rdi1 = (RadioButton) findViewById(R.id.radioButton1);
        rdi2 = (RadioButton) findViewById(R.id.radioButton2);
        rdi3 = (RadioButton) findViewById(R.id.radioButton3);
        rdi4 = (RadioButton) findViewById(R.id.radioButton4);
        rdi5 = (RadioButton) findViewById(R.id.radioButton5);

        chro = (Chronometer) findViewById(R.id.chronometer2);

        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
      //  b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);

        sw = (Switch) findViewById(R.id.switch1);

        t1 = (TextView) findViewById(R.id.View1);       // 결과값 3개
        t2 = (TextView) findViewById(R.id.View2);
        t3 = (TextView) findViewById(R.id.View3);

        image = (ImageView) findViewById(R.id.imageView3);

        lay1 = (LinearLayout) findViewById(R.id.mainLayout);
        lay2 = (LinearLayout) findViewById(R.id.main2Layout);

        lay1.setVisibility(View.INVISIBLE);
        lay2.setVisibility(View.INVISIBLE);
        cal.setVisibility(View.INVISIBLE);
        timeP.setVisibility(View.INVISIBLE);

        

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                y = year;
                m = month +1;
                d = dayOfMonth;
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {        // 스위치 작동
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){                                        
                    chro.setBase(SystemClock.elapsedRealtime());
                    chro.start();
                    chro.setTextColor(Color.RED);
                    lay1.setVisibility(View.VISIBLE);
                    rdi1.isChecked();
                } else {
                    ed1.setText(null);
                    ed2.setText(null);
                    ed3.setText(null);
                    rdi1.isChecked();
                    t1.setText("총 명수 :");
                    t2.setText("할인금액 :");
                    t3.setText("결제금액 :");

                    chro.stop();
                    chro.setTextColor(Color.BLUE);
                    lay1.setVisibility(View.INVISIBLE);
                    lay2.setVisibility(View.INVISIBLE);
                }
            }
        });

        rdi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.t1);
            }
        });
        rdi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.t2);
            }
        });
        rdi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.t3);
            }
        });

        rdi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setVisibility(View.VISIBLE);
                timeP.setVisibility(View.INVISIBLE);
            }
        });
        rdi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setVisibility(View.INVISIBLE);
                timeP.setVisibility(View.VISIBLE);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = ed1.getText().toString();
                String num2 = ed2.getText().toString();
                String num3 = ed3.getText().toString();
                if(num1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"어른값을 입력하세요. ", Toast.LENGTH_SHORT).show();
                }
                else if(num2.isEmpty()){
                    Toast.makeText(getApplicationContext(),"청소년값을 입력하세요. ", Toast.LENGTH_SHORT).show();
                }else if(num3.isEmpty()){
                    Toast.makeText(getApplicationContext(),"어린이값을 입력하세요. ", Toast.LENGTH_SHORT).show();
                } else {
                    int result1 = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);
                    Double result2 = (Double.parseDouble(num1) * 15000) + ((Double.parseDouble(num2)) * 12000) + ((Double.parseDouble(num3)) * 8000);
                    Double result3 = null;
                    if (rdi1.isChecked()) {      // r 5%
                        result3 = (Double) result2 * 0.05;
                        result2 = (Double) result2 - ((Double) result2 * 0.05);
                    } else if(rdi2.isChecked()) { //  10%
                        result3 = (Double)result2 * 0.10;
                        result2 = (Double) result2 - ((Double) result2 * 0.10);
                    } else if(rdi3.isChecked()) { // 20%
                        result3 = (Double)result2 * 0.20;
                        result2 = (Double) result2 - ((Double) result2 * 0.20);}

                    t1.setText("총 명수 : "+result1);
                    t2.setText("할인금액 : "+ result3);
                    t3.setText("결제금액 : "+result2);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lay1.setVisibility(View.INVISIBLE);
                lay2.setVisibility(View.VISIBLE);
                rdi4.isChecked();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),y+"년 "+m+"월 "+d+"일 "+
                        (Integer.toString(timeP.getCurrentHour()))+"시 "+(Integer.toString(timeP.getCurrentMinute()))+"분 예약됨",Toast.LENGTH_SHORT).show();

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {  // 이전으로
            @Override
            public void onClick(View v) {
                lay1.setVisibility(View.VISIBLE);
                lay2.setVisibility(View.INVISIBLE);
            }
        });

    }
}
