package ru.sorkirill.myhomework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import ru.sorkirill.myhomework.model.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private static OnItemClickListener itemClickListener;
    private List<Event> events;

    public EventAdapter(List <Event> events, OnItemClickListener itemClickListener) {
        this.events = events;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    //создать
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(events.get(position));
    }

    public  void setEvents(List<Event> events) {
        this.events.clear();
        this.events.addAll(events);
        notifyDataSetChanged(); }
    @Override
    public int getItemCount() {
        return events.size();
    }

    public  static  class EventViewHolder extends  RecyclerView.ViewHolder {

        private TextView eventNameTextView;
        private TextView eventBodyTextView;

        public  EventViewHolder(View itemview){
            super(itemview);
                eventNameTextView = itemView.findViewById(R.id.textViewEventName);
                eventBodyTextView = itemView.findViewById(R.id.textViewEventName);
            }

        public void bind(final Event event) {
            eventNameTextView.setText(event.getEventName());
            eventBodyTextView.setText(event.getEventBody());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(event);
                }
            });
        }
    }
}

