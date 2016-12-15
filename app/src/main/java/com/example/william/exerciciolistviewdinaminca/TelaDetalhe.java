package com.example.william.exerciciolistviewdinaminca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TelaDetalhe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhe);

        if (getIntent().getSerializableExtra("p") != null){
            Pessoa p=(Pessoa)getIntent().getSerializableExtra("p");
            Toast.makeText(getBaseContext(),"Detalhes pessoa: \n"+p.toString(), Toast.LENGTH_LONG).show();
        }

    }//fecha onCreate
}//fecha classe
