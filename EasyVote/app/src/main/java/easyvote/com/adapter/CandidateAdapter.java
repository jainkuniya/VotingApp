package easyvote.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

import easyvote.com.easyvote.R;


/**
 * Created by Vishwesh on 14-03-2016.
 */

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.DataObjectHolder>  {

    Context context;
    ArrayList<String> arrayList = new ArrayList<>();
    LayoutInflater layoutInflater;

    int itemToShow;

    public CandidateAdapter(Context context, ArrayList<String> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
        layoutInflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view;
        view = LayoutInflater.from(context).inflate(R.layout.layout_candidate,
                viewGroup,false);

        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder dataObjectHolder, final int i) {



        dataObjectHolder.candidate.setText(arrayList.get(i));



    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView candidate;
        public DataObjectHolder(View itemView) {
            super(itemView);
            candidate = (TextView)itemView.findViewById(R.id.candidate);

        }
    }
}

