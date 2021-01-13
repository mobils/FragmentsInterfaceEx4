package com.example.fragmentsinterfaceex4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    OnFragment1Listener listener;



    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //S'executa quan el fragment està a la pantalla
        //inicialitzo el listener
        if (context instanceof OnFragment1Listener)  //Si context és del tipus (implementa) el OnFragment1Listener ...

            listener = (OnFragment1Listener) context;
        else
            throw new RuntimeException ("Has de fer que l'activitat escolti OnFragmen1Listener");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
        View view= inflater.inflate(R.layout.fragment_1, container, false);
        Button boto1Fragment = view.findViewById(R.id.boto1fragment);

        boto1Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ha clicat al botó del fragment 1



                //VERSIÓ 1 AMB INTERFACE: Ha d'inflar el Fragment Detalls, he d'avisar al MainActivity que l'infli
                listener.onFragment1Click("text de prova, nom de restaurant...");

                //VERSIO 2 INFLAR DIRECTE EL FRAGMENT DETALLS
/*
                FragmentManager fm = getChildFragmentManager();

                if (fm.findFragmentById(R.id.contenidor3) == null) {
                    FragmentDetalls frmDetalls = new FragmentDetalls();
                    fm.beginTransaction().replace(R.id.contenidor3, frmDetalls).commit();
                }
*/
            }
        });


        return view;
    }

    public interface OnFragment1Listener {
        public void onFragment1Click (String nom);  //Podem modificar els paràmetres
    }
}