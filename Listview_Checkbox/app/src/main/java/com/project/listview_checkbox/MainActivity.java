package com.project.listview_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    TextView textView;

    String[] dogNames = new String[]{"拉布拉多幼犬","愛斯基摩犬","大白熊幼犬"
            ,"松獅","哈士奇犬","邊境牧羊犬"
            ,"薩摩耶","博美犬"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("ListView_Checkbox");

        listView = (ListView)findViewById(R.id.listView);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,dogNames);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String s = dogNames[position];

                if(listView.isItemChecked(position))
                    setTitle("你選擇: " + s);
                else
                    setTitle("");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dogs = "";

                for(int i=0;i<dogNames.length;i++){
                    if(listView.isItemChecked(i))
                        dogs += dogNames[i] + ", ";
                }

                textView.setText("你喜歡的狗狗有: \n" + dogs);
            }
        });
    }
}
