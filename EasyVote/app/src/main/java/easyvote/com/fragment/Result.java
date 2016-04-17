package easyvote.com.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import easyvote.com.easyvote.R;

public class Result extends Fragment {

    ArrayList<Entry> entries = new ArrayList<>();
    ArrayList<String> labels = new ArrayList<>();
    PieChart pieChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_chart, container, false);
        init(view);
        setData();



        return view;
    }

    private void init(View view) {
        pieChart = (PieChart) view.findViewById(R.id.chart);
    }

    private void setData() {
        labels.add("Candidate A");
        labels.add("Candidate B");
        labels.add("Candidate C");
        labels.add("Candidate D");
        entries.add(new Entry(25f, 0));
        entries.add(new Entry(10f, 1));
        entries.add(new Entry(30f, 2));
        entries.add(new Entry(45f, 3));

        PieDataSet dataset = new PieDataSet(entries, "# of Calls");
        PieData data = new PieData(labels, dataset); // initialize Piedata
        pieChart.setData(data);//set data into chart
        pieChart.setDescription("Description");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateY(5000);

    }

}
