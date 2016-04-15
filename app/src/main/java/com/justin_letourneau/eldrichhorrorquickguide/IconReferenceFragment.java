package com.justin_letourneau.eldrichhorrorquickguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IconReferenceFragment extends Fragment {

    Spinner mPlayerCountSpinner;
    TextView mGateTextView;
    TextView mClueTextView;
    TextView mMonsterTextView;

    public IconReferenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_icon_reference, container, false);

        // player count
        Integer[] players = new Integer[8];

        for (int i = 0; i < players.length;){
            players[i] = ++i;
        }

        mPlayerCountSpinner = (Spinner)v.findViewById(R.id.player_count_spinner);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity().getApplicationContext(), R.layout.spinner_player_count, players);
        mPlayerCountSpinner.setAdapter(adapter);

        mPlayerCountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setReferences();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mGateTextView = (TextView) v.findViewById(R.id.gate_number_textView);
        mClueTextView = (TextView) v.findViewById(R.id.clue_number_textView);
        mMonsterTextView = (TextView) v.findViewById(R.id.monster_number_textView);

        return v;
    }

    private void setReferences(){

        Integer selection = (Integer) mPlayerCountSpinner.getSelectedItem();

        mMonsterTextView.setText("1");
        mClueTextView.setText("1");
        mGateTextView.setText("1");

        if(selection > 2){
                mMonsterTextView.setText("2");
                mClueTextView.setText("2");
        }
        if(selection > 4){
                mGateTextView.setText("2");
                mClueTextView.setText("3");
        }
        if(selection > 6){
                mMonsterTextView.setText("3");
                mClueTextView.setText("4");
        }

    }

}
