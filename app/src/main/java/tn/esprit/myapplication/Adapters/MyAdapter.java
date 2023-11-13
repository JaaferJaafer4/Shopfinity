package tn.esprit.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.myapplication.Fragments.ChatRoomFragment;
import tn.esprit.myapplication.R;
import tn.esprit.myapplication.items.ChatItem;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<ChatItem> items;

    public MyAdapter(Context context, List<ChatItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.textView.setText(items.get(position).getText());
        holder.dateView.setText(items.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public ChatItem getItem(int position) {
        return items.get(position);
    }
}
