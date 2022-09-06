package com.fer.aula05_buscaeintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ed01, ed02, ed03;
    ListView lista;
    Button btn01;
    List<String> nomes;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //conexão com o XML
        ed01 = findViewById(R.id.ed01);
        ed02 = findViewById(R.id.ed02);
        ed03 = findViewById(R.id.ed03);
        lista = findViewById(R.id.lista);
        btn01 = findViewById(R.id.btn01);
        nomes = new ArrayList<>();
        nomes.add("Jarjar Binx - +01 33 345342");
        nomes.add("Arnold Schwarzenegger - +01 12 998786767");
        nomes.add("Silvester Stallone - +01 62 23 35436323");
        nomes.add("Maicou Jaquisson - +55 61 32452352");

        adapter = new ArrayAdapter(MainActivity.this
                , android.R.layout.simple_list_item_1, nomes);
        lista.setAdapter(adapter);

        ed01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed02.getText().toString().isEmpty()
                && ed03.getText().toString().isEmpty()){
                    Toast.makeText(
                            MainActivity.this,
                            "Campos Não podem ficar vazios",
                            Toast.LENGTH_SHORT
                    ).show();
                }else{
                    String texto = ed02.getText().toString()
                            + " - "
                            + ed03.getText().toString();
                    nomes.add(texto);
                    adapter.notifyDataSetChanged();
                    lista.setAdapter(adapter);
                }
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valor = adapter.getItem(i).toString();
                String nome = valor.split("-")[0];
                String telefone = valor.split("-")[1];
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("nome",nome);
                intent.putExtra("telefone",telefone);
                startActivity(intent);
                finish();
            }
        });
    }
}