package com.karepin.homework_028;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                intent.setAction(Intent.ACTION_DIAL);
                // Задаем начальные координаты
                Uri uri = Uri.parse("tel:" + editTextNumber.getText());
                // Передаем uri
                intent.setData(uri);
                // Передаем uri
                intent.setData(uri);
                // Вдруг звонилки нет на устройстве?
                if (intent.resolveActivity(getPackageManager()) == null) {
                    // TODO текст унести в strings.xml
                    Toast.makeText(MainActivity.this, "Установите звонилку", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Запускаем приложения
                startActivity(intent);
            }
        });

        buttonCMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = editTextNumber.getText().toString();
                String sms = editTextText.getText().toString();
                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri)
                        .putExtra("sms_body", sms);
                // Вдруг приложения для отправки смс нет на устройстве?
                if (intent.resolveActivity(getPackageManager()) == null) {
                    // TODO текст унести в strings.xml
                    Toast.makeText(MainActivity.this, "Установите приложение для отправки смс", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });
    }
}