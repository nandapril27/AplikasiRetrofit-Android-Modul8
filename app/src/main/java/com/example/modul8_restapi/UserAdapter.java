package com.example.modul8_restapi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    // Metode untuk menampilkan dialog konfirmasi penghapusan
    private void showDeleteConfirmationDialog(final int userId, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete User");
        builder.setMessage("Are you sure you want to delete this user ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteUser(userId, position); // Panggil metode deleteUser dengan userId dan position
            }
        });

        builder.setNegativeButton("No", null);
        builder.show();
    }


    // Metode untuk menghapus pengguna dari daftar dan server
    private void deleteUser(int userId, int position) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Void> call = apiService.deleteUser(userId);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < userList.size(); i++) {
                        if (userList.get(i).getId() == userId) {
                            userList.remove(i);
                            notifyItemRemoved(i);
                            break;
                        }}
                    Toast.makeText(context, "User deleted successfully", Toast.LENGTH_SHORT).show();
                    userList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, userList.size());
                } else {
                    Toast.makeText(context, "Failed to delete user: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to delete user: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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


