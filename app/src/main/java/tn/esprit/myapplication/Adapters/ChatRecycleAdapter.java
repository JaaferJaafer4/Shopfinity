package tn.esprit.myapplication.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.myapplication.R;
import tn.esprit.myapplication.items.ChatItem;
import tn.esprit.myapplication.items.ChatMessageModel;

public class ChatRecycleAdapter extends RecyclerView.Adapter<ChatRecycleAdapter.ChatModelViewHolder> {

    Context context;
    List<ChatMessageModel> items;


    public ChatRecycleAdapter(Context context, List<ChatMessageModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ChatModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatModelViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_message, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatModelViewHolder holder, int position) {
        ChatMessageModel message = items.get(position);

        System.out.println("Message :" + message);


        if (message.getSenderId() == 1) {
            holder.leftChatLayout.setVisibility(View.VISIBLE);
            holder.rightChatLayout.setVisibility(View.GONE);
            holder.leftChatTextview.setText(message.getMessage());
        } else {
            holder.leftChatLayout.setVisibility(View.GONE);
            holder.rightChatLayout.setVisibility(View.VISIBLE);
            holder.rightChatTextview.setText(message.getMessage());
        }
    }




    @Override
    public int getItemCount() {


        return items.size();
    }


    class ChatModelViewHolder extends RecyclerView.ViewHolder{

        LinearLayout leftChatLayout,rightChatLayout;
        TextView leftChatTextview,rightChatTextview;

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
        }
    }
}
