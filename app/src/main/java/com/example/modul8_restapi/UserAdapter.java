package com.example.modul8_restapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private Context context;
    private MainActivity mainActivity;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;

        // Check if context is an instance of MainActivity and set mainActivity
        if (context instanceof MainActivity) {
            this.mainActivity = (MainActivity) context;
        }
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textViewName.setText(user.getName());
        holder.textViewEmail.setText(user.getEmail());
        holder.textViewAgama.setText(user.getAgama());
        holder.textViewNohp.setText(user.getNohp());
        holder.textViewAlamat.setText(user.getAlamat());

    // Mengatur OnClickListener pada itemView untuk menangani tap pada item
     holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context instanceof MainActivity) {
                ((MainActivity) context).showUpdateDialog(user);
            }
        }
    });
}

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewEmail;
        TextView textViewAgama;
        TextView textViewNohp;
        TextView textViewAlamat;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewAgama = itemView.findViewById(R.id.textViewAgama);
            textViewNohp = itemView.findViewById(R.id.textViewNohp);
            textViewAlamat = itemView.findViewById(R.id.textViewAlamat);
        }
    }

    // Metode untuk mengatur MainActivity yang terkait
    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

}


