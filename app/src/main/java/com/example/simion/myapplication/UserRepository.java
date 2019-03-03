package com.example.simion.myapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class UserRepository {

    private UserDAO userDAO;
    private LiveData<List<User>> allUsers;
    private List<User> users;
    private String nameUser;

    private RideDAO rideDAO;
    private LiveData<List<Ride>> allRides;
    private List<Ride> rides;


    public UserRepository(Application application) {
        MyDatabase database = MyDatabase.getInstance(application);
        userDAO = database.userDAO();
        allUsers = userDAO.getAllUsers();
        users = userDAO.getUsers();

        rideDAO = database.rideDAO();
        allRides = rideDAO.getAllRides();
        rides = rideDAO.getRides();


    }


    public String getNameUser(int id){return nameUser;}

    public List<User> getUsers(){return users; }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(User user) {
        new InsertNoteAsyncTask(userDAO).execute(user);
    }

    public List<Ride> getRides(){return rides; }

    public LiveData<List<Ride>> getAllRides() {
        return allRides;
    }

    public void insertR(Ride ride) {
        new InsertRideAsyncTask(rideDAO).execute(ride);
    }

    public void delete(Ride ride) {
        new DeleteRideAsyncTask(rideDAO).execute(ride);
    }


    private static class InsertNoteAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDAO;

        private InsertNoteAsyncTask(UserDAO userDAO) {
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... notes) {
            userDAO.insert(notes[0]);
            return null;
        }
    }

    private static class InsertRideAsyncTask extends AsyncTask<Ride, Void, Void> {
        private RideDAO rideDAO;

        private InsertRideAsyncTask(RideDAO rideDAO) {
            this.rideDAO = rideDAO;
        }

        @Override
        protected Void doInBackground(Ride... notes) {
            rideDAO.insert(notes[0]);
            return null;
        }
    }

    private static class DeleteRideAsyncTask extends AsyncTask<Ride, Void, Void> {
        private RideDAO rideDAO;

        private DeleteRideAsyncTask(RideDAO rideDAO) {
            this.rideDAO = rideDAO;
        }

        @Override
        protected Void doInBackground(Ride... notes) {
            rideDAO.delete(notes[0]);
            return null;
        }
    }

}
