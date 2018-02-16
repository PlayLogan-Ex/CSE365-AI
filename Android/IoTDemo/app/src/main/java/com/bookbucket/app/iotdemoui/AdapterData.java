package com.bookbucket.app.iotdemoui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bookbucket.app.iotdemoui.models.ComplexData;

import java.util.Collections;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Question> data = Collections.emptyList();
    Question current;
    int currentPos = 0;

    // create constructor to initialize context and data sent from MainActivity
    public AdapterData(Context context, List<Question> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.question_list_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        Question current = data.get(position);

        myHolder.questionText.setText(current.questionText);
        myHolder.questionType.setText("" + current.questionType);
        myHolder.tag.setText("" + current.tag);
        myHolder.questionID.setText("Review: " + current.questionID + "");
        myHolder.questionID.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView questionID;
        TextView questionText;
        TextView questionType;
        TextView tag;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);

            questionID = (TextView) itemView.findViewById(R.id.questionID);
            questionText = (TextView) itemView.findViewById(R.id.questionText);
            questionType = (TextView) itemView.findViewById(R.id.questionType);
            tag = (TextView) itemView.findViewById(R.id.tag);

            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();

            int position = getAdapterPosition();
            Question current = data.get(position);

            Intent i = new Intent(v.getContext(), QAActivity.class);
            ComplexData complexData = new ComplexData();
            complexData.questionTitle = current.questionText;
            i.putExtra("obj1", complexData);

            String yourDescription = "Student";
            i.putExtra("description", yourDescription);
            v.getContext().startActivity(i);


////            Context context = v.getContext();
//            final Intent intent;
//
//            switch (v.getId()){
//                case 0:
//                    intent =  new Intent(context, QAActivity.class);
//                    String dataToPass = "The next activity needs this sentence.";
//                    intent.putExtras("KeyToAccessData", dataToPass);
//                    break;
//                case 1:
//                    intent =  new Intent(context, QAActivity.class);
//                    break;
//                default:
//                    intent =  new Intent(context, QAActivity.class);
//                    break;
//            }
//
//
//            context.startActivity(intent);
        }
    }
}
