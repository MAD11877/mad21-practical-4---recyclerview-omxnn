package sg.edu.np.prac3githhub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // #1
        for(int i = 0 ; i < 20 ; i++) {
            Random r = new Random();
            int randomId = r.nextInt();
            int random = r.nextInt();
            int random2 = r.nextInt();
            String randomDesc = "Description " + random;
            boolean randomBool;
            if (random2 % 2 == 0){
                randomBool = false;
            } else{
                randomBool = true;
            }
            User randomUser = new User("Name", randomId, randomDesc, R.id.imageView2, randomBool);
            userList.add(randomUser);
        }

        RecyclerView recyclerViewProfiles = findViewById(R.id.recyclerProfiles);
        ProfilesAdapter profilesAdapter = new ProfilesAdapter(userList);
        LinearLayoutManager pLayoutManager = new LinearLayoutManager(this);
        recyclerViewProfiles.setLayoutManager(pLayoutManager);
        recyclerViewProfiles.setItemAnimator(new DefaultItemAnimator());
        recyclerViewProfiles.setAdapter(profilesAdapter);

    }

}