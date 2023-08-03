package com.example.calculator;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.databinding.ActivityMainBinding;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button0.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "0");
        });

        binding.button1.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "1");
        });

        binding.button2.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "2");
        });

        binding.button3.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "3");
        });

        binding.button4.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "4");
        });

        binding.button5.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "5");
        });
        binding.exit.setOnClickListener(view -> {
            Toast.makeText(this, "I said ,Don't click :)", Toast.LENGTH_SHORT).show();
            finish();
            System.exit(0);
        });

        binding.button6.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "6");
        });

        binding.button7.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "7");
        });

        binding.button8.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "8");
        });

        binding.button9.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            binding.inputText.setText(data + "9");
        });

        binding.buttonDot.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            String lastChar = String.valueOf(data.charAt(data.length() - 1));
            if (lastChar.equals(".")) {
                binding.inputText.setText(data + "");
            } else {
                binding.inputText.setText(data + ".");
            }
        });

        binding.buttonC.setOnClickListener(view -> {
            binding.inputText.setText("");
            binding.outputText.setText("");
        });

        binding.buttonPlus.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            String lastChar = String.valueOf(data.charAt(data.length() - 1));
            if (lastChar.equals("+")) {
                binding.inputText.setText(data + "");
            } else {
                binding.inputText.setText(data + "+");
            }
        });

        binding.buttonMinus.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            String lastChar = String.valueOf(data.charAt(data.length() - 1));
            if (lastChar.equals("-")) {
                binding.inputText.setText(data + "");
            } else {
                binding.inputText.setText(data + "-");
            }
        });

        binding.buttonMultiplication.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            String lastChar = String.valueOf(data.charAt(data.length() - 1));
            if (lastChar.equals("×")) {
                binding.inputText.setText(data + "");
            } else {
                binding.inputText.setText(data + "×");
            }
        });
        binding.buttonDistribution.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            String lastChar = String.valueOf(data.charAt(data.length() - 1));
            if (lastChar.equals("÷")) {
                binding.inputText.setText(data + "");
            } else {
                binding.inputText.setText(data + "÷");
            }
        });

        binding.buttonModule.setOnClickListener(view -> {
            data = binding.inputText.getText().toString();
            String lastChar = String.valueOf(data.charAt(data.length() - 1));
            if (lastChar.equals("%")) {
                binding.inputText.setText(data + "");
            } else {
                binding.inputText.setText(data + "%");
            }
        });

        binding.fun.setOnClickListener(view -> {
            Toast.makeText(this, "This button has a fan aspect", Toast.LENGTH_SHORT).show();
        });

        binding.buttonEquls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = binding.inputText.getText().toString();
                data = data.replaceAll("×", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");
                String lastChar = String.valueOf(data.charAt(data.length() - 1));
                switch (lastChar) {
                    case "+":
                        Toast.makeText(MainActivity.this, R.string.error_text, Toast.LENGTH_SHORT).show();
                        break;
                    case "-":
                        Toast.makeText(MainActivity.this, R.string.error_text, Toast.LENGTH_SHORT).show();
                        break;
                    case "%":
                        Toast.makeText(MainActivity.this, R.string.error_text, Toast.LENGTH_SHORT).show();
                        break;
                    case "÷":
                        Toast.makeText(MainActivity.this, R.string.error_text, Toast.LENGTH_SHORT).show();
                        break;
                    case "×":
                        Toast.makeText(MainActivity.this, R.string.error_text, Toast.LENGTH_SHORT).show();

                }
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable, data, "Javsscript", 1, null).toString();

                binding.outputText.setText(finalResult);
            }
        });
    }
}
