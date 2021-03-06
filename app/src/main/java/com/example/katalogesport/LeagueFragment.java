package com.example.katalogesport;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeagueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeagueFragment extends Fragment {

    private RecyclerView recyclerView;
    private LeagueAdapter adapter;
    private ArrayList<League> leagueArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LeagueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeagueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeagueFragment newInstance(String param1, String param2) {
        LeagueFragment fragment = new LeagueFragment();
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

    void setData(String jsonString){
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            leagueArrayList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                League league = new League(jsonObject.getString("nameLeague"));

                leagueArrayList.add(league);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String jsonData = "[{'nameLeague':'The International 9'},"+"{'nameLeague':'Epicenter League'},"+"{'nameLeague':'BTS Pro Series'},"+"{'nameLeague':'ESL One Katowice'}]";
        setData(jsonData);

        adapter = new LeagueAdapter(leagueArrayList);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league, container, false);
    }
}