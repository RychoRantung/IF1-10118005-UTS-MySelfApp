package com.rychorantung.if1_10118005_utsproject.ui.gallery;

/* NIM   : 10118005
 * Nama  : Rycho Rantung
 * Kelas : IF1
 * Tanggal   : 25 Mei 2021
 * Deskripsi : Membuat tampilan galeri di GalleryFragment
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.rychorantung.if1_10118005_utsproject.AdapterGalleryActivity;
import com.rychorantung.if1_10118005_utsproject.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        final View view = inflater.inflate(R.layout.fragment_gallery2, container, false);
        final FragmentActivity fragment = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.gall_act);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        modelApp model = new modelApp();

        int[] imgGallery = {
                R.drawable.foto1, R.drawable.foto2, R.drawable.foto3, R.drawable.foto4,R.drawable.foto5,
                R.drawable.foto6, R.drawable.foto7, R.drawable.foto8, R.drawable.foto9, R.drawable.foto10
        };
        model.setImgGallery(imgGallery);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterGalleryActivity adapter = new AdapterGalleryActivity(fragment, model.getImgGallery());
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