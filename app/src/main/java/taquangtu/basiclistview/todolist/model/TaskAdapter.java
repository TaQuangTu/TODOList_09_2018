package taquangtu.basiclistview.todolist.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import taquangtu.basiclistview.R;

public class TaskAdapter extends BaseAdapter
{
    private Context context;
    private int layoutResourceid;
    private List<String> taskList;

    public TaskAdapter(Context context, int layoutResourceid, List<String> taskList) {
        this.context = context;
        this.layoutResourceid = layoutResourceid;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int i) {
        return taskList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final int currentPosition = i;
        class ViewHolder
        {
            ImageButton imb_edit, imb_delete;
            TextView tv_task;
        }
        ViewHolder viewHolder;
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layoutResourceid,viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.imb_delete = view.findViewById(R.id.imb_delete);
            viewHolder.imb_edit   = view.findViewById(R.id.imb_edit);
            viewHolder.tv_task    = view.findViewById(R.id.tv_task_item);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_task.setText(taskList.get(i));
        viewHolder.imb_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: open a dialog to do something( move on top, move down bottom)
                Toast.makeText(context,"Edited" + currentPosition,Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imb_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"deleted" + currentPosition,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
