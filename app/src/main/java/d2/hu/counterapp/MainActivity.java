package d2.hu.counterapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText counter;
    Button startButton;

    private int mCounter = 0;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (EditText) findViewById(R.id.countertext);
        startButton = (Button)findViewById(R.id.startbtn);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //10 second * 10000, countDownInterval

                //0-tól 10ig számol : amikor a 10est eléri, akkor belemegy az onFinish metódusba
                countDownTimer =  new CountDownTimer(10*1000,1000){

                    @Override
                    public void onTick(long millisUntilFinished) {
                            counter.setText(" "+millisUntilFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                        counter.setText("DONE");
                    }
                };
                countDownTimer.start();
            }
        });


    }
}
