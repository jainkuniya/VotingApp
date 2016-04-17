package easyvote.com.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import easyvote.com.easyvote.R;
import easyvote.com.Singleton;

public class CreateCandidate extends AppCompatActivity implements View.OnClickListener {

    EditText election_position;
    Button createElection;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_candidate);
        init();
    }

    private void init() {
        election_position = (EditText) findViewById(R.id.election_position);
        election_position.setVisibility(View.VISIBLE);
        createElection = (Button) findViewById(R.id.createElection);


        createElection.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.createElection:
                ProgressDialog progressDialog = new ProgressDialog(CreateCandidate.this);
                progressDialog.setTitle("Inserting");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                progressDialog.setMax(100);
                Singleton.candidates.add(election_position.getText().toString());
                Intent intent = new Intent(CreateCandidate.this, Home.class);
                startActivity(intent);
                //new HttpCall().createposition(CreateCandidate.this, election_position.getText().toString());
        }

    }
}
