package com.example.qoren_000.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    int	LedData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        Button adapter = (Button) findViewById(R.id.adapter);
        tv.setText(stringFromJNI());
        if(intFromJNI() == 6){
            TextView tv2 = (TextView) findViewById(R.id.led);
            tv2.setText("int from string work well");
        }
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdapterActivity.class);
                startActivity(intent);
            }
        });

        LEDControl(LedData);
        final CheckBox Led8 = (CheckBox) findViewById(R.id.led1);
        final CheckBox Led7 = (CheckBox) findViewById(R.id.led2);
        final CheckBox Led6 = (CheckBox) findViewById(R.id.led3);
        final CheckBox Led5 = (CheckBox) findViewById(R.id.led4);
        final CheckBox Led4 = (CheckBox) findViewById(R.id.led5);
        final CheckBox Led3 = (CheckBox) findViewById(R.id.led6);
        final CheckBox Led2 = (CheckBox) findViewById(R.id.led7);
        final CheckBox Led1 = (CheckBox) findViewById(R.id.led8);
        Led1.setChecked(false);
        Led1.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led1.isChecked()) {
                    LedData |= 0x80;
                } else {
                    LedData &= ~(0x80);
                }
                LEDControl(LedData);
            }
        });
        Led2.setChecked(false);
        Led2.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led2.isChecked()) {
                    LedData |= 0x40;
                } else {
                    LedData &= ~(0x40);
                }
                LEDControl(LedData);
            }
        });
        Led3.setChecked(false);
        Led3.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led3.isChecked()) {
                    LedData |= 0x20;
                } else {
                    LedData &= ~(0x20);
                }
                LEDControl(LedData);
            }
        });

        Led4.setChecked(false);
        Led4.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led4.isChecked()) {
                    LedData |= 0x10;
                } else {
                    LedData &= ~(0x10);
                }
                LEDControl(LedData);
            }
        });

        Led5.setChecked(false);
        Led5.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led5.isChecked()) {
                    LedData |= 0x08;
                } else {
                    LedData &= ~(0x08);
                }
                LEDControl(LedData);
            }
        });

        Led6.setChecked(false);
        Led6.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led6.isChecked()) {
                    LedData |= 0x04;
                } else {
                    LedData &= ~(0x04);
                }
                LEDControl(LedData);
            }
        });

        Led7.setChecked(false);
        Led7.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led7.isChecked()) {
                    LedData |= 0x02;
                } else {
                    LedData &= ~(0x02);
                }
                LEDControl(LedData);
            }
        });

        Led8.setChecked(false);
        Led8.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (Led8.isChecked()) {
                    LedData |= 0x01;
                } else {
                    LedData &= ~(0x01);
                }
                LEDControl(LedData);
            }
        });

    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native int intFromJNI();
    public native int LEDControl(int value);
}
