package tn.esprit.myapplication.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tn.esprit.myapplication.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView;

    TextView textView;

    TextView dateView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.chatImage);
        nameView = itemView.findViewById(R.id.nameView);
        textView = itemView.findViewById(R.id.textView);
        dateView = itemView.findViewById(R.id.dateView);
    }
}
