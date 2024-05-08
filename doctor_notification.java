package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.orthopedic2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class com_notification extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<DataModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_notification);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();
        adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);

        fetchDataFromServer();
    }

    private void fetchDataFromServer() {
        String url = "http://10.0.2.2/php/plist.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String pid = jsonObject.getString("pid");
                                String name = jsonObject.getString("comp");
                                String date = jsonObject.getString("date");
                                dataList.add(new DataModel(pid,name,date));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private List<DataModel> dataList;

        public MyAdapter(List<DataModel> dataList) {
            this.dataList = dataList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout1, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            DataModel data = dataList.get(position);
            holder.pidTextView.setText(data.getPid());
            holder.nameTextView.setText(data.getName());
            holder.date.setText(data.getDate());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = holder.getAdapterPosition();
                    if (clickedPosition != RecyclerView.NO_POSITION) {
                        DataModel clickedItem = dataList.get(clickedPosition);
                        Intent intent = new Intent(com_notification.this, doc_complaints.class);
                        intent.putExtra("id", clickedItem.getPid());

                        startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public  class MyViewHolder extends RecyclerView.ViewHolder {
            TextView pidTextView, nameTextView,date;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                pidTextView = itemView.findViewById(R.id.id);
                nameTextView = itemView.findViewById(R.id.name);
                date = itemView.findViewById(R.id.date);
            }
        }
    }

    public static class DataModel {
        private String pid;
        private String name;
        private String date;

        public DataModel(String pid, String name, String date) {
            this.pid = pid;
            this.name = name;
            this.date = date;
        }

        public String getPid() {
            return pid;
        }

        public String getName() {
            return name;
        }
        public String getDate() {
            return date;
        }
    }
}
