package easyvote.com.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;

import easyvote.com.easyvote.R;

/**
 * Created by Vishwesh on 17-04-2016.
 */
public class DialogDate extends Dialog implements View.OnClickListener {

    DatePicker dialog_date;
    Button cancell_date_dialog,okay_date_dialog;
    TextView tdate;

    public DialogDate(Context context, TextView tdate) {
        super(context);
        this.tdate = tdate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_date);

        init();

    }

    private void init() {
        dialog_date = (DatePicker)findViewById(R.id.dialog_date);
        cancell_date_dialog=(Button)findViewById(R.id.cancell_date_dialog);
        okay_date_dialog=(Button)findViewById(R.id.okay_date_dialog);

        cancell_date_dialog.setOnClickListener(this);
        okay_date_dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cancell_date_dialog:
                this.dismiss();
                break;
            case R.id.okay_date_dialog:
                tdate.setText(dialog_date.getDayOfMonth()+"/"+dialog_date.getMonth()+"/"+dialog_date.getYear());
                this.dismiss();
                break;
        }
    }
}
