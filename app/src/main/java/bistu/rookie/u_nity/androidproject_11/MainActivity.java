package bistu.rookie.u_nity.androidproject_11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView strContent = (TextView) findViewById(R.id.StringContent);
        final TextView numContent = (TextView) findViewById(R.id.NumberContent);
        final String str = strContent.getText().toString();
        final Integer num =  Integer.valueOf(numContent.getText().toString());
        Button anotherAct = (Button) findViewById(R.id.StartAnotherActivity);
        anotherAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                intent.putExtra("intro", "Come from Main Activity: ");
                intent.putExtra("string", str);
                intent.putExtra("number", num);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == 0){
            String str = data.getStringExtra("returnMessage");
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }

    }

}
