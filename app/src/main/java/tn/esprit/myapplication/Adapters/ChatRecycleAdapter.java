package tn.esprit.myapplication.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import tn.esprit.myapplication.Fragments.ChatFragment;
import tn.esprit.myapplication.Interfaces.RecyclerViewInterface;
import tn.esprit.myapplication.R;
import tn.esprit.myapplication.items.ChatItem;
import tn.esprit.myapplication.items.ChatMessageModel;

public class ChatRecycleAdapter extends RecyclerView.Adapter<ChatRecycleAdapter.ChatModelViewHolder> {

    Context context;
    List<ChatMessageModel> items;

    RecyclerViewInterface recyclerViewInterface;

    public ChatRecycleAdapter(Context context, List<ChatMessageModel> items,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ChatModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatModelViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_message, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatModelViewHolder holder, int position) {
        ChatMessageModel message = items.get(position);
        if (message.getSenderId() == 1) {
            holder.leftChatLayout.setVisibility(View.VISIBLE);
            holder.rightChatLayout.setVisibility(View.GONE);
            holder.leftChatTextview.setText(message.getMessage());
            holder.leftChatTime.setText(formatTime(message.getTime()));
        } else {
            holder.leftChatLayout.setVisibility(View.GONE);
            holder.rightChatLayout.setVisibility(View.VISIBLE);
            holder.rightChatTextview.setText(message.getMessage());
            holder.rightChatTime.setText(formatTime(message.getTime()));
        }
    }

    private String formatTime(Date time) {
        // Implement your own logic to format the time as needed
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(time);
    }





    @Override
    public int getItemCount() {


        return items.size();
    }


    class ChatModelViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftChatLayout,rightChatLayout;
        TextView leftChatTextview,rightChatTextview,rightChatTime,leftChatTime;


        public ChatModelViewHolder(@NonNull View itemView) {
            super(itemView);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            itemView.setLayoutParams(params);
            leftChatLayout = itemView.findViewById(R.id.left_chat_layout);
            rightChatLayout = itemView.findViewById(R.id.right_chat_layout);
            leftChatTextview = itemView.findViewById(R.id.left_chat_message);
            rightChatTextview = itemView.findViewById(R.id.right_chat_message);
            rightChatTime = itemView.findViewById(R.id.right_chat_time);
            leftChatTime = itemView.findViewById(R.id.left_chat_time);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemLongClick(pos);
                        }
                    }
                    return true;
                }
            });

        }


    }
}
