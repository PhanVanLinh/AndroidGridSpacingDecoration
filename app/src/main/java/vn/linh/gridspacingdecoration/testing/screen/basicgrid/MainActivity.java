package vn.linh.gridspacingdecoration.testing.screen.basicgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import vn.linh.gridspacingdecoration.testing.screen.basicgrid.adapter.MyRecyclerViewAdapter;
import vn.linh.gridspacingdecoration.R;
import vn.linh.gridspacingdecoration.decoration.GridSpacingDecoration;
import vn.linh.gridspacingdecoration.testing.model.RecyclerItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        ArrayList<RecyclerItem> data = new ArrayList<>();

        data.add(new RecyclerItem("a", "b"));
        data.add(new RecyclerItem("c", "b"));
        data.add(new RecyclerItem("d", "b"));
        data.add(new RecyclerItem("e", "b"));
        data.add(new RecyclerItem("f", "b"));
        data.add(new RecyclerItem("g", "b"));
        data.add(new RecyclerItem("h", "b"));
        data.add(new RecyclerItem("j", "b"));
        data.add(new RecyclerItem("k", "b"));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new GridSpacingDecoration(0, 100, 10, 100, 10));

        // set up the RecyclerView
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
