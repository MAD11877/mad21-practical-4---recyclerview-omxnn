package sg.edu.np.prac3githhub;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesViewHolder> {
    ArrayList<User> profiles_list;

    public ProfilesAdapter (ArrayList<User> input){
        this.profiles_list = input;
    }

    public ProfilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.profiles_layout, parent, false);

        return new ProfilesViewHolder(item);
    }

    public void onBindViewHolder(ProfilesViewHolder holder, int position){
        User list_items = profiles_list.get(position);
        holder.txt1.setText(list_items.name + list_items.id);
        holder.txt2.setText(list_items.desc);
        holder.image.setImageResource(R.mipmap.ic_launcher_round);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());

                builder.setTitle("Profile");
                builder.setMessage(list_items.name + list_items.id);
                builder.setCancelable(false);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                        Bundle bundle = new Bundle();
                        bundle.putInt("ID", list_items.getId());
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
                        intent.putExtra("Name", list_items.getName()); // must put toString()
                        intent.putExtra("Description", list_items.getDesc()); // must put toString()x
                        intent.putExtras(bundle);
                        view.getContext().startActivity(intent);

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }


        });
    }

    public int getItemCount(){
        return profiles_list.size();
    }
}