package com.example.william.exerciciolistviewdinaminca;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Tela1 extends AppCompatActivity {
    //Widgets
    private EditText etNome;
    private EditText etIdade;
    private EditText etPeso;
    private EditText etAltura;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private RadioGroup grupo;
    private Button btnOK;
    //ListView
    private ListView lvPessoa;
    //Objeto
    private Pessoa p;
    //ArrayAdapter
    private ArrayAdapter<Pessoa> adapter;
    //ArrayList
    private ArrayList<Pessoa> pessoas;
    //Posição Selecionada
    private int posSelec = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Referencias
        etNome = (EditText) findViewById(R.id.nome);
        etIdade = (EditText) findViewById(R.id.idade);
        etPeso = (EditText) findViewById(R.id.peso);
        etAltura = (EditText) findViewById(R.id.altura);
        rbFeminino = (RadioButton) findViewById(R.id.rb_feminino);
        rbMasculino = (RadioButton) findViewById(R.id.rb_masculino);
        grupo = (RadioGroup) findViewById(R.id.grupo);
        btnOK = (Button) findViewById(R.id.ok);
        lvPessoa = (ListView) findViewById(R.id.lv_Pessoa);

        //Instanciar ArrayList
        pessoas = new ArrayList<>();//O Array tá vazio
        //Instanciar o Adapter
        adapter = new ArrayAdapter<Pessoa>(Tela1.this, android.R.layout.simple_list_item_1, pessoas);
        //Setando o adapter na ListView
        lvPessoa.setAdapter(adapter);

        //Click do botão
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Instanciando objeto
                p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setIdade(Integer.parseInt(etIdade.getText().toString()));
                p.setAltura(Double.parseDouble(etAltura.getText().toString()));
                p.setPeso(Double.parseDouble(etPeso.getText().toString()));
                if (grupo.getCheckedRadioButtonId() == rbMasculino.getId()){
                    p.setSexo(rbMasculino.getText().toString());
                }else{
                    p.setSexo(rbFeminino.getText().toString());
                }
                //Adicionando no ArrayList
                pessoas.add(p);
                //Atulizar List
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Pessoa "+p.getNome()+" cadastrada com sucesso!", Toast.LENGTH_LONG).show();

            }//fecha onClick
        });//fecha setOnClickListener

        lvPessoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Guardando a posição quando clicada
                posSelec = i;

                Pessoa p = (Pessoa) lvPessoa.getItemAtPosition(posSelec);

                Intent it = new Intent(Tela1.this, TelaDetalhe.class);
                it.putExtra("p",p);
                startActivity(it);

            }//fecha onItemClick
        });//fecha setOnItemClickListener

       lvPessoa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               AlertDialog.Builder msg = new AlertDialog.Builder(Tela1.this);
               msg.setTitle("Titulo");
               msg.setMessage("Você tem certeza");
               msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       adapter.notifyDataSetChanged();
                       Pessoa p1 = (Pessoa) lvPessoa.getItemAtPosition(posSelec);
                       pessoas.remove(posSelec);
                       Toast.makeText(getBaseContext(), "Pessoa "+p1.getNome()+" removida com Sucesso!", Toast.LENGTH_LONG).show();
                   }//fecha onClick
               });//fecha OnClickListener

               msg.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(getBaseContext(), "Que pena", Toast.LENGTH_LONG).show();
                   }//fecha onClick
               });//fecha setOnClickListener
               msg.show();

               return true;
           }//onItemLongClick
       });//setOnItemLongClickListener




    }//fecha onCreate
}//fecha classe
