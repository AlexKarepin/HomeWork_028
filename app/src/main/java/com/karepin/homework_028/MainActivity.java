package com.karepin.homework_028;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    EditText editTextText;
    Button buttonCall;
    Button buttonCMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        editTextText = findViewById(R.id.editTextCMC);
        buttonCall = findViewById(R.id.button);
        buttonCMC = findViewById(R.id.button2);


        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем и инициализируем
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                // Задаем начальные координаты
                Uri uri = Uri.parse("tel:" + editTextNumber.getText());
                // Передаем uri
                intent.setData(uri);
                // Передаем uri
                intent.setData(uri);
                // Запускаем приложения
                startActivity(intent);
            }
        });
        buttonCMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smgr = SmsManager.getDefault();
                String number = editTextNumber.getText().toString();
                String cmc = editTextText.getText().toString();
                smgr.sendTextMessage(number,null, cmc,null,null);
            }
        });

    }
}