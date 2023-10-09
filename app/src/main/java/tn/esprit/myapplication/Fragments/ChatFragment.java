package tn.esprit.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.myapplication.MyAdapter;
import tn.esprit.myapplication.R;
import tn.esprit.myapplication.items.ChatItem;


public class ChatFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        List<ChatItem> items = new ArrayList<>();
        items.add(new ChatItem("John Smith",R.drawable.a));
        items.add(new ChatItem("Emily Davis",R.drawable.b));
        items.add(new ChatItem("Michael Johnson",R.drawable.c));
        items.add(new ChatItem("Sarah Wilson",R.drawable.d));
        items.add(new ChatItem("David Brown",R.drawable.e));
        items.add(new ChatItem("Jennifer Lee",R.drawable.f));
        items.add(new ChatItem("Robert Clark",R.drawable.g));
        items.add(new ChatItem("Jessica Turner",R.drawable.h));
        items.add(new ChatItem("William White",R.drawable.e));
        items.add(new ChatItem("Laura Anderson",R.drawable.d));
        items.add(new ChatItem("James Moore",R.drawable.f));
        items.add(new ChatItem("Maria Martinez",R.drawable.c));
        items.add(new ChatItem("Christopher Hall",R.drawable.g));
        items.add(new ChatItem("Elizabeth Scott",R.drawable.b));
        items.add(new ChatItem("Daniel Harris",R.drawable.a));
        RecyclerView recyclerView = v.findViewById(R.id.contactsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new MyAdapter(requireActivity().getApplicationContext(), items));

        // Obtain a reference to the FrameLayout
        FrameLayout childFragmentContainer = v.findViewById(R.id.chat_room);

        // Replace the content of the FrameLayout with HomeFragment
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(childFragmentContainer.getId(), new ChatRoomFragment());
        transaction.commit();
        return v;
    }
}

