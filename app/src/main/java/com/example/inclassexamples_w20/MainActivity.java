package com.example.inclassexamples_w20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);
//These are the global variables
        EditText editText;
        TextView result;
        Button buttonSwitch;
        CheckBox checkBox;
        editText = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.textView);
        buttonSwitch = (Button) findViewById(R.id.button);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                result.setText(text);
                Toast.makeText(getApplicationContext(),getString(R.string.toast_message),
                        Toast.LENGTH_LONG).show();
            }
        });

}
        checkBox.setOnCheckedChangeListener(new
        CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
            if(isChecked){
                Snackbar.make(cb, getString(R.string.snack_on), Snackbar.LENGTH_LONG)
                        .setAction("undo", click-> cb.setChecked( !isChecked ))
                        .show();
            }
            else{
                Snackbar.make(cb, getString(R.string.snack_off), Snackbar.LENGTH_LONG)
                        .setAction("undo", click-> cb.setChecked( !isChecked ))
                        .show();
            }
        }
    });
}
}