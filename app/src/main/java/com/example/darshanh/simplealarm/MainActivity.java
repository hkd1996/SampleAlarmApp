package com.example.darshanh.simplealarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    int hour,minute;
    Button alarmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmBtn=(Button)findViewById(R.id.alarmBtn);
        alarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarm();
            }
        });
    }

    public void setAlarm() {

        timePicker=(TimePicker)findViewById(R.id.time);
        hour=timePicker.getHour();
        minute=timePicker.getMinute();
        Calendar alarmTime= Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY,hour);
        alarmTime.set(Calendar.MINUTE,minute);
        alarmTime.set(Calendar.SECOND,0);
        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC,alarmTime.getTimeInMillis(), pendingIntent);
        Toast.makeText(this, "Alarm set sucessfully!!",Toast.LENGTH_LONG).show();
    }
}
