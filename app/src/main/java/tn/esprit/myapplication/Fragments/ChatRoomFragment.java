package tn.esprit.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tn.esprit.myapplication.Adapters.ChatRecycleAdapter;
import tn.esprit.myapplication.Adapters.MyAdapter;
import tn.esprit.myapplication.R;
import tn.esprit.myapplication.items.ChatItem;
import tn.esprit.myapplication.items.ChatMessageModel;

public class ChatRoomFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chat_room, container, false);

        List<ChatMessageModel> items = new ArrayList<>();
        items.add(new ChatMessageModel("Hello","1",new Date()));
        items.add(new ChatMessageModel("How are you","2",new Date()));
        items.add(new ChatMessageModel("Fine and you","1",new Date()));
        items.add(new ChatMessageModel("Good to know","2",new Date()));
        items.add(new ChatMessageModel("See you later","1",new Date()));

        RecyclerView recyclerView = v.findViewById(R.id.chat_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new ChatRecycleAdapter(requireActivity().getApplicationContext(), items));

        return v;
    }
}