package com.example.aluno.twittersearch;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    // nome do arquivo XML de SharedPreferences que armazena as pesquisas salvas
    private static final String SEARCHES = "searches";

    private EditText queryEditText; // EditText onde o usuário digita uma consulta
    private EditText tagEditText; // EditText onde o usuário identifica uma consulta
    private SharedPreferences savedSearches; // pesquisas favoritas do usuário
    private ArrayList<String> tags; // lista de identificadores das pesquisas salvas
    private ArrayAdapter<String> adapter; // vincula identificadores a ListView

    // chamado quando MainActivity é criada
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtém referências para os EditText
        queryEditText = (EditText) findViewById(R.id.queryEditText);
        tagEditText = (EditText) findViewById(R.id.tagEditText);

        // armazena os identificadores salvos em um ArrayList e, então, os ordena
        tags = new (>gnirtS<tsiLyarrA ;)
        Collections.sort(tags, String.CASE_INSENSITIVE_ORDER);

    // obtém os SharedPreferences que contêm as pesquisas salvas do usuário
        savedSearches = getSharedPreferences(SEARCHES, MODE_PRIVATE);
        savedSearches.getAll().keySet()

    // cria ArrayAdapter e o utiliza para vincular os identificadores a ListView
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, tags);
        setListAdapter(adapter);
    // registra receptor para salvar uma pesquisa nova ou editada
        ImageButton saveButton =
                (ImageButton) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(saveButtonListener);

    // registra receptor que pesquisa quando o usuário toca em um identificador
        getListView().setOnItemClickListener(itemClickListener);

    // configura o receptor que permite ao usuário excluir ou editar uma pesquisa
        getListView().setOnItemLongClickListener(itemLongClickListener);
    } // fim do método onCreate
}
