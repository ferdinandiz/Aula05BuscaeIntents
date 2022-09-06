package com.fer.aula05_buscaeintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    TextView nome, telefone;
    Button voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nome = findViewById(R.id.texto_nome);
        telefone = findViewById(R.id.texto_telefone);
        voltar = findViewById(R.id.btnVoltar);

        //recebendo dados
        Intent dadosRecebidos = getIntent();
        nome.setText(
            "Nome: "+
            dadosRecebidos.getStringExtra("nome")
        );
        telefone.setText(
            "Telefone: " +
            dadosRecebidos.getStringExtra("telefone")
        );

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        SegundaActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}