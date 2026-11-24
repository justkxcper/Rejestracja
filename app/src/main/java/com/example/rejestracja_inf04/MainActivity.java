package com.example.rejestracja_inf04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText email = findViewById(R.id.emailEditText);
        EditText pass = findViewById(R.id.passwordEditText);
        EditText repeatPass = findViewById(R.id.repeatPassEditText);
        Button confirm = findViewById(R.id.confirmButton);
        TextView alert = findViewById(R.id.alertTextView);

        confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!email.getText().toString().contains("@")) {
                            Toast.makeText(MainActivity.this, "Email musi zawierać znak - @!", Toast.LENGTH_SHORT).show();
                        }
                        else if (!pass.getText().toString().equals(repeatPass.getText().toString())) {
                            Toast.makeText(MainActivity.this, "Hasła muszą być takie same!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            alert.setText("Witaj " + email.getText().toString());
                        }
                    }
                }
        );

    }
}