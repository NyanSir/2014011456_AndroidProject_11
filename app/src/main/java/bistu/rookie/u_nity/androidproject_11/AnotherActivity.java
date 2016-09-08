package bistu.rookie.u_nity.androidproject_11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);

        Intent mainIntent = getIntent();
        String intro = mainIntent.getStringExtra("intro");
        String str = mainIntent.getStringExtra("string");
        Integer num = mainIntent.getIntExtra("number", 2014011456);
        Toast.makeText(this, intro + "\n" + str + "\n" + num, Toast.LENGTH_LONG).show();

        Button returnMain = (Button) findViewById(R.id.ReturnMainActivity);
        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnotherActivity.this, MainActivity.class);
                intent.putExtra("returnMessage", "This is the message from Another Activity");
                setResult(0, intent);
                finish();
            }
        });
    }

}
