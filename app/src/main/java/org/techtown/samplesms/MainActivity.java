package org.techtown.samplesms;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);

        editText.setFilters(new InputFilter[] {
                new InputFilter.LengthFilter(80)
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if(text.length()<80)
                {
                    textView.setText(Integer.toString(text.length())+ " / 80");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(editText.getText().toString());

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }



    public void showToast(String msg)
    {

        Toast.makeText(this, msg,Toast.LENGTH_LONG).show();
    }



}

