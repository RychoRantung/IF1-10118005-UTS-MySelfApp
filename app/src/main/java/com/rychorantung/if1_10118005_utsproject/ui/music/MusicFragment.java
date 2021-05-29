package com.rychorantung.if1_10118005_utsproject.ui.music;

/* NIM   : 10118005
 * Nama  : Rycho Rantung
 * Kelas : IF1
 * Tanggal   : 26 Mei 2021
 * Deskripsi : Membuat tampilan music favorit dan video di MusicFragment
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.rychorantung.if1_10118005_utsproject.R;
import com.rychorantung.if1_10118005_utsproject.ui.gallery.modelApp;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance(String param1, String param2) {
        MusicFragment fragment = new MusicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_music, container, false);

        final FragmentActivity fragment = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.music_act);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        modelApp model = new modelApp();

        int[] imgMusic = {R.drawable.music1, R.drawable.music2, R.drawable.music3, R.drawable.music4, R.drawable.music5, R.drawable.music6,
                R.drawable.music7};
        String musicAct[] = {
                "How Deep is Your Love - Bee Gees",
                "Deep in Love - DAY6",
                "Psycho - Red Velvet",
                "Under Pressure - Queen Feat. David Bowie",
                "Happier - Olivia Rodrigo",
                "Lagu Malam Hari - Isyana Sarasvati",
                "Crazy For You - Marina Saito"
        };

        model.setMusicAct(musicAct);
        model.setImgMusic(imgMusic);

        // Menampilkan Video
        VideoView videoView = view.findViewById(R.id.video_act);
        videoView.setVideoPath("android.resource://"+getActivity().getPackageName()+"/"+R.raw.lastnight);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterMusicActivity adapter = new AdapterMusicActivity(fragment, model.getMusicAct(), model.getImgMusic());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }

                });
            }
        }).start();
        return view;
    }
}