package easyvote.com.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import easyvote.com.easyvote.R;
import easyvote.com.network.HttpCall;
import easyvote.com.widget.DialogDate;
import easyvote.com.widget.DialogTime;

public class CreateElection extends AppCompatActivity implements View.OnClickListener {

    EditText electionName, electionPlace;
    Button date, from_time, to_time, createElection;
    TextView Tdate, Tfrom_time, Tto_time;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_candidate);
        init();
    }

    private void init() {
        electionName = (EditText) findViewById(R.id.nameofElection);
        electionPlace = (EditText) findViewById(R.id.placeofElection);

        date = (Button) findViewById(R.id.election_date);
        from_time = (Button) findViewById(R.id.election_from_time);
        to_time = (Button) findViewById(R.id.election_to_time);
        createElection = (Button) findViewById(R.id.createElection);

        Tdate = (TextView) findViewById(R.id.text_election_date);
        Tfrom_time = (TextView) findViewById(R.id.text_election_from_time);
        Tto_time = (TextView) findViewById(R.id.text_election_to_time);

        electionName.setVisibility(View.VISIBLE);
        electionPlace.setVisibility(View.VISIBLE);
        date.setVisibility(View.VISIBLE);
        from_time.setVisibility(View.VISIBLE);
        to_time.setVisibility(View.VISIBLE);
        createElection.setVisibility(View.VISIBLE);
        Tdate.setVisibility(View.VISIBLE);
        Tfrom_time.setVisibility(View.VISIBLE);
        Tto_time.setVisibility(View.VISIBLE);

        date.setOnClickListener(this);
        from_time.setOnClickListener(this);
        to_time.setOnClickListener(this);
        createElection.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.election_date:
                DialogDate dialogDate = new DialogDate(this, Tdate);
                dialogDate.show();
                break;
            case R.id.election_from_time:
                DialogTime dialogTime = new DialogTime(this, Tfrom_time);
                dialogTime.show();
                break;
            case R.id.election_to_time:
                DialogTime dialogTimeTo = new DialogTime(this, Tto_time);
                dialogTimeTo.show();
                break;
            case R.id.createElection:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Inserting");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                progressDialog.setMax(100);
                new HttpCall().createelection(this, progressDialog, electionName.getText().toString(),
                        electionPlace.getText().toString(), Tdate.getText().toString(), Tfrom_time.getText().toString(),
                        Tto_time.getText().toString());
                Intent intent = new Intent(CreateElection.this, Home.class);
                startActivity(intent);
        }

    }
}
