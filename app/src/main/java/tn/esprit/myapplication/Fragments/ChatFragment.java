package tn.esprit.myapplication.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.myapplication.Adapters.MyAdapter;
import tn.esprit.myapplication.R;
import tn.esprit.myapplication.items.ChatItem;


public class ChatFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = v.findViewById(R.id.contactsList);
        List<ChatItem> items = new ArrayList<>();
        items.add(new ChatItem("John Smith",R.drawable.a,"ok","Yesterday"));
        items.add(new ChatItem("Emily Davis",R.drawable.b, "nevermind","Today"));
        items.add(new ChatItem("Michael Johnson",R.drawable.c,"see you there","8/9/23"));
        items.add(new ChatItem("Sarah Wilson",R.drawable.d,"i don't know","30/8/23"));
        items.add(new ChatItem("David Brown",R.drawable.e,"seems fine","21/8/23"));
        items.add(new ChatItem("Jennifer Lee",R.drawable.f,"i think i will walk away","19/8/23"));
        items.add(new ChatItem("Robert Clark",R.drawable.g,"nice talking to you buddy","16/8/23"));
        items.add(new ChatItem("Jessica Turner",R.drawable.h,"Thanks!","28/7/23"));
        items.add(new ChatItem("William White",R.drawable.e,"Let's have a coffee sometime","13/12/22"));
        items.add(new ChatItem("Laura Anderson",R.drawable.d,"Bye!","10/11/22"));
        items.add(new ChatItem("James Moore",R.drawable.f,"Looks good","6/7/22"));
        items.add(new ChatItem("Maria Martinez",R.drawable.c,"are your ready for it ?","11/3/22"));
        items.add(new ChatItem("Christopher Hall",R.drawable.g,"hahahah","10/2/18"));
        items.add(new ChatItem("Elizabeth Scott",R.drawable.b,"I no longer want to see you","8/5/16"));
        items.add(new ChatItem("Daniel Harris",R.drawable.a,"Hi!","3/4/16"));
        RecyclerView recyclerView = v.findViewById(R.id.contactsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new MyAdapter(requireActivity().getApplicationContext(), items));

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null) {
                    int position = rv.getChildAdapterPosition(childView);

                    // Handle the item click here
                    FragmentManager fragmentManager = getParentFragmentManager();
                    ChatRoomFragment chatRoomFragment = new ChatRoomFragment();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.frameLayout, chatRoomFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {}

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
        });

   /*     FragmentManager fragmentManager = getParentFragmentManager();
        ChatRoomFragment chatRoomFragment = new ChatRoomFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, chatRoomFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        recyclerView.setOnClickListener(e ->
        {


        });*/

        // Obtain a reference to the FrameLayout
   /*     FrameLayout childFragmentContainer = v.findViewById(R.id.chat_room);

        // Replace the content of the FrameLayout with HomeFragment
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(childFragmentContainer.getId(), new ChatRoomFragment());
        transaction.commit();*/
        return v;
    }
}

