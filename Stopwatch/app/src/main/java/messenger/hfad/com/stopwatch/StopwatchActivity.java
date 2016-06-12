package messenger.hfad.com.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends AppCompatActivity {

    int seconds = 0;
    boolean running = false;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    public void startButtonOnClick(View view) {
        running = true;
    }

    public void stopButtonOnClick(View view) {
        running = false;
    }

    public void resetButtonOnClick(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView textView = (TextView) findViewById(R.id.show);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int sec = seconds % 3600;
                int minutes = sec / 360;
                sec = sec % 360;
                String time = String.format(Locale.US, "%d:%02d:%02d", hours, minutes, sec);
                textView.setText(time);
                if (running)
                    seconds++;
                handler.postDelayed(this, 1000);
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);

    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning)
            running = true;
    }
}
