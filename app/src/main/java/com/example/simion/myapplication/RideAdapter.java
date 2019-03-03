package com.example.simion.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.RideHolder> {


    public List<Ride> rides = new ArrayList<>();



    @NonNull
    @Override
    public RideHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {



        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ride_item,viewGroup,false);

        return new RideHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RideHolder rideHolder, int i) {

        Ride currentRide = rides.get(i);

        rideHolder.textViewName.setText("Nume");
        rideHolder.textViewFrom.setText(currentRide.getFrom());
        rideHolder.textViewTo.setText(currentRide.getTo());
        rideHolder.textViewDate.setText(currentRide.getDate());
        rideHolder.textViewHour.setText(currentRide.getHour());
        rideHolder.textViewPrice.setText(currentRide.getPrice());



    }

    @Override
    public int getItemCount() {
        return rides.size();
    }

    public Ride getTideAt(int position){
        return rides.get(position);
    }


    public void setRides(List<Ride> rides){
        this.rides=rides;
    }


    class RideHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewFrom;
        private TextView textViewTo;
        private TextView textViewDate;
        private TextView textViewHour;
        private TextView textViewPrice;
        private Button button;


        public RideHolder(@NonNull View itemView) {
            super(itemView);


            textViewName = itemView.findViewById(R.id.ride_name);
            textViewFrom= itemView.findViewById(R.id.ride_from);
            textViewTo = itemView.findViewById(R.id.ride_to);
            textViewDate = itemView.findViewById(R.id.ride_date);
            textViewHour = itemView.findViewById(R.id.ride_hour);
            textViewPrice = itemView.findViewById(R.id.ride_price);



        }




    }
}
