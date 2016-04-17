package easyvote.com.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import easyvote.com.easyvote.R;

/**
 * Created by Vishwesh on 17-04-2016.
 */
public class DialogTime extends Dialog implements View.OnClickListener {

    TimePicker dialog_time;
    Button cancell_time_dialog,okay_time_dialog;
    TextView tTime;

    public DialogTime(Context context, TextView tTime) {
        super(context);
        this.tTime=tTime;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_time);

        init();
    }

    private void init() {
        dialog_time = (TimePicker)findViewById(R.id.dialog_time);
        cancell_time_dialog=(Button)findViewById(R.id.cancell_time_dialog);
        okay_time_dialog=(Button)findViewById(R.id.okay_time_dialog);

        cancell_time_dialog.setOnClickListener(this);
        okay_time_dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cancell_time_dialog:
                this.dismiss();
                break;
            case R.id.okay_time_dialog:
                int hours = dialog_time.getCurrentHour();
                int minute = dialog_time.getCurrentMinute();
                tTime.setText(String.valueOf(hours)+":"+String.valueOf(minute));
                this.dismiss();
                break;
        }
    }
}
