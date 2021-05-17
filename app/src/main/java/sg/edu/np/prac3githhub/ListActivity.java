package sg.edu.np.prac3githhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for(int i = 0 ; i < 20 ; i++) {
            Random r = new Random();
            int random = r.nextInt();
            int random1 = r.nextInt();
            int random2 = r.nextInt();
            String randomName = "Name" + random;
            String randomDesc = "Description " + random1;
            boolean randomBool;
            if (random2 % 2 == 0){
                randomBool = false;
            } else{
                randomBool = true;
            }
            User randomUser = new User(randomName, i, randomDesc, randomBool);
            userList.add(randomUser);
        }

        RecyclerView recyclerViewProfiles = findViewById(R.id.rv);
        ProfilesAdapter profilesAdapter = new ProfilesAdapter(userList);
        LinearLayoutManager pLayoutManager = new LinearLayoutManager(this);
        recyclerViewProfiles.setLayoutManager(pLayoutManager);
        recyclerViewProfiles.setItemAnimator(new DefaultItemAnimator());
        recyclerViewProfiles.setAdapter(profilesAdapter);

    }

}