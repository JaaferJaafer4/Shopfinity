package tn.esprit.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tn.esprit.myapplication.Adapters.ChatRecycleAdapter;
import tn.esprit.myapplication.Adapters.MyAdapter;
import tn.esprit.myapplication.R;
import tn.esprit.myapplication.db.SQLiteManager;
import tn.esprit.myapplication.items.ChatItem;
import tn.esprit.myapplication.items.ChatMessageModel;

public class ChatRoomFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loadFromDBToMemory();
        View v = inflater.inflate(R.layout.fragment_chat_room, container, false);

        EditText text = v.findViewById(R.id.chat_message_input);
        ImageButton button = v.findViewById(R.id.message_send_btn);




     //   List<ChatMessageModel> items = createSampleMessages();

        RecyclerView recyclerView = v.findViewById(R.id.chat_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(false);

        recyclerView.setLayoutManager(layoutManager);

        ChatRecycleAdapter adapter = new ChatRecycleAdapter(requireContext().getApplicationContext(), ChatMessageModel.messageArrayList);


        button.setOnClickListener(view -> {
            String messageText = text.getText().toString().trim();

            if (!TextUtils.isEmpty(messageText)) {
                ChatMessageModel newMessage = new ChatMessageModel(messageText, 2,1, new Date());


                SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(requireContext());
                sqLiteManager.addMessageToDatabase(newMessage);
                newMessage.setReceiverId(2);
                newMessage.setSenderId(1);
                ChatMessageModel.messageArrayList.add(0, newMessage);

                adapter.notifyItemInserted(0);

                text.setText("");

//                if (adapter != null) {
//                    adapter.notifyDataSetChanged();
//                }
            } else {
                Toast.makeText(requireContext(), "Please enter a message", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        return v;
    }

  /*  private List<ChatMessageModel> createSampleMessages() {
        List<ChatMessageModel> items = new ArrayList<>();
        items.add(new ChatMessageModel("Hello", 1, 2, new Date()));
        items.add(new ChatMessageModel("How are you", 2, 1, new Date()));
        items.add(new ChatMessageModel("Fine and you", 1, 2, new Date()));
        items.add(new ChatMessageModel("Good to know", 2, 1, new Date()));
        items.add(new ChatMessageModel("See you later", 1, 2, new Date()));
        return items;
    }*/

    private void loadFromDBToMemory()
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(requireContext());
        sqLiteManager.populateNoteListArray();
    }


}
