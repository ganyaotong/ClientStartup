package gan.wiki.ganyaotong.clientstartup;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {

    private Spinner spinner = null;
    private Activity activity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = (Spinner) findViewById(R.id.spinner);
        activity = this;
        String[] strings = getResources().getStringArray(R.array.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strings);
        spinner.setAdapter(arrayAdapter);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        });

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0:
                    int p = spinner.getSelectedItemPosition();
                    if (p==0){
                        Intent intent = new Intent();
                        intent.setClass(activity,Main3Activity.class);
                        startActivity(intent);
                    }
                    break;
            }
        }
    };
}
