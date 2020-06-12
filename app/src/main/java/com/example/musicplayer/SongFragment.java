package com.example.musicplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.musicplayer.MainActivity.musicFiles;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment {
     RecyclerView recyclerView;
     MusicAdapter musicAdapter;

    public SongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_song, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        if (!(musicFiles.size()<1)){
            musicAdapter=new MusicAdapter(getContext(),musicFiles);
            recyclerView.setAdapter(musicAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
            recyclerView.smoothScrollToPosition(musicAdapter.getItemCount());
        }

        return view;
    }

}