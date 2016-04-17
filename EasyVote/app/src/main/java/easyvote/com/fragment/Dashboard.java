package easyvote.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import easyvote.com.activity.CreateCandidate;
import easyvote.com.adapter.CandidateAdapter;
import easyvote.com.easyvote.R;
import easyvote.com.Singleton;

/**
 * Created by Vishwesh on 17-04-2016.
 */
public class Dashboard extends Fragment {
    RecyclerView lLectureDay;
    LinearLayoutManager layoutManagerLectureDay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        lLectureDay = (RecyclerView) view.findViewById(R.id.bus_listView);
        this.lLectureDay.setHasFixedSize(true);
        layoutManagerLectureDay = new LinearLayoutManager(getContext());
        this.lLectureDay.setLayoutManager(layoutManagerLectureDay);

        CandidateAdapter candidateAdapter = new CandidateAdapter(getActivity(), Singleton.candidates);
        lLectureDay.setAdapter(candidateAdapter);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CreateCandidate.class);
                intent.putExtra("wait", true);
                startActivity(intent);
            }
        });
    }
}
