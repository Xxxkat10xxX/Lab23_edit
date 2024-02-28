package ru.myitschool.lab23;

import android.app.Dialog;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final List<ListObject> objects = new ArrayList<>();
    private ActivityMainBinding binding;
    private FloatingActionButton add_fab;
    private RecyclerView recyclerView;
    private TextView type;
    private Spinner spinner;

    String[] types = {"add","subtract"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        add_fab = findViewById(R.id.add_fab);
        recyclerView = findViewById(R.id.ef_expenses_rv);
        type = findViewById(R.id.type);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(objects);
        recyclerView.setAdapter(listAdapter);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);

        add_fab.setOnClickListener(v -> {
            CustomDialogFragment dialog = new CustomDialogFragment();
            dialog.show(getSupportFragmentManager(), "custom");
            //spinner.setPrompt("Title");
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

        });
    }


}
