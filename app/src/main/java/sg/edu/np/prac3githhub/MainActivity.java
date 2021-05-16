package sg.edu.np.prac3githhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    private String name;
    private String desc;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User(name, 0, desc, R.id.imageView2, false);
        Button button = findViewById(R.id.button);

        Intent receivedData = getIntent();
        user.name = receivedData.getStringExtra("Name");
        user.desc = receivedData.getStringExtra("Description");
        user.id = receivedData.getIntExtra("ID", 0);

        TextView nameText = (TextView)findViewById(R.id.textView);
        nameText.setText(user.name + user.id);
        TextView descText = (TextView)findViewById(R.id.textView2);
        descText.setText(user.desc);

        if (!user.isFollowed()) {
            button.setText("Follow");
        }
        else {
            button.setText("Unfollow");
        }

        button.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View view) {
              if(!user.isFollowed()) {
                  button.setText("Unfollow");
                  user.setFollowed(true);
                  Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();

              }else {
                  button.setText("Follow");
                  user.setFollowed(false);
                  Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

              }
          }
        }
        );


    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "On Start!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void  onPause(){
        super.onPause();
        Log.v(TAG, "On Pause!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy");
    }
}