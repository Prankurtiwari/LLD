package problems.car_rental_system.services;

import problems.car_rental_system.model.Location;
import problems.car_rental_system.model.Store;
import problems.car_rental_system.model.User;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    public VehicleRentalSystem(List<Store> stores, List<User> users) {

        this.storeList = stores;
        this.userList = users;
    }


    public Store getStore(Location location){

        //based on location, we will filter out the Store from storeList.
        return storeList.get(0);
    }



    //addUsers

    //remove users


    //add stores

    //remove stores





}
