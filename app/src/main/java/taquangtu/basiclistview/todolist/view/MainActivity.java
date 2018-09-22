package taquangtu.basiclistview.todolist.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import taquangtu.basiclistview.R;
import taquangtu.basiclistview.todolist.model.TaskAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView lvTasks;
    private EditText edtNewTask;
    private Button btnAdd;
    private ArrayList<String> arrayListTask;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapViews();
        setLvTasks();
        setOnClickForView();
    }
    public void mapViews()
    {
        lvTasks = findViewById(R.id.lv_tasks);
        btnAdd  = findViewById(R.id.btn_add);
        edtNewTask = findViewById(R.id.edt_task);
    }
    public void setLvTasks() //TODO: get older data to avoid losing user oder data
    {
        arrayListTask  = new ArrayList<>();
        arrayListTask.add("Example task");
        taskAdapter    = new TaskAdapter(this,R.layout.layout_listview_item,arrayListTask);
        lvTasks.setAdapter(taskAdapter);
    }
    public void setOnClickForView()
    {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTask = edtNewTask.getText().toString().trim();
                if(newTask.equals(""))
                {
                    Toast.makeText(MainActivity.this, "New task can't be empty string", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    arrayListTask.add(0,newTask);
                    taskAdapter.notifyDataSetChanged();
                }
                edtNewTask.setText("");
            }
        });
        lvTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this,"have no choice",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
