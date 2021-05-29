package com.rychorantung.if1_10118005_utsproject.ui.daily;

/* NIM   : 10118005
 * Nama  : Rycho Rantung
 * Kelas : IF1
 * Tanggal   : 26 Mei 2021
 * Deskripsi : Membuat tampilan daily acitivity di DailyFragment
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.rychorantung.if1_10118005_utsproject.R;
import com.rychorantung.if1_10118005_utsproject.ui.gallery.modelApp;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DailyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DailyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DailyFragment newInstance(String param1, String param2) {
        DailyFragment fragment = new DailyFragment();
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
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_daily, container, false);

        final FragmentActivity fragment = getActivity();
        final FragmentActivity fragment2 = getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.daily_act);
        RecyclerView recyclerView2 = view.findViewById(R.id.friendlist);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(fragment2, LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);
        modelApp model = new modelApp();


        // Daily Activity Value
        int[] imgDaily = {R.drawable.daily1, R.drawable.daily2, R.drawable.daily3, R.drawable.daily4,
                R.drawable.daily5, R.drawable.daily6};
        String[] dailyAct = {
                "Bangun", "Makan", "Menonton Film", "Kuliah", "Mandi", "Tidur"
        };

        model.setImgDaily(imgDaily);
        model.setDailyAct(dailyAct);

        //Friend List Value
        int[] imgFriend = {R.drawable.friend1, R.drawable.friend2, R.drawable.friend3, R.drawable.friend4, R.drawable.friend5};
        String[] friendAct = {
                "Dion Landusa", "William Kendrick", "Lydia Christina", "Fiona Dinisa", "Fiqri Akbar"
        };

        model.setImgFriend(imgFriend);
        model.setFriendAct(friendAct);

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterDailyActivity adapter = new AdapterDailyActivity(fragment, model.getDailyAct(),model.getImgDaily());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }

                });
            }
        }).start();

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterFriendActivity adapter = new AdapterFriendActivity(fragment,model.getFriendAct(), model.getImgFriend());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView2.setAdapter(adapter);
                    }

                });
            }
        }).start();

        return view;
    }}

