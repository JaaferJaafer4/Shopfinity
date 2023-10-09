package tn.esprit.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.nameView.setText(items.get(position).getName());
           holder.imageView.setImageResource(items.get(position).getImage());
           holder.textView.setText(items.get(position).getText());
           holder.dateView.setText(items.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
