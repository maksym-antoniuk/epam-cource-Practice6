package ua.nure.antoniuk.Practice6.part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Max on 05.12.2017.
 */
public class Parking {
    List<Object> park;
    int space;

    Parking(int n){
        park = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            park.add(null);
        }
        space = n;

    }

    public boolean add(int place, Object car) {
        if (park.contains(car)) {
            return false;
        }
        if(!isPlace(place)){
            return false;
        }
        if(Objects.isNull(car)){
            throw new NullPointerException();
        }
        if(Objects.isNull(park.get(place))){
            park.remove(place);
            park.add(place, car);
            return true;
        } else {
            while(!Objects.isNull(park.get(place))){
                place++;
                if (isPlace(place)) {
                    if(Objects.isNull(park.get(place))){
                        park.remove(place);
                        park.add(place, car);
                        return true;
                    } else{
                        continue;
                    }
                } else{
                    return false;
                }
            }
        }
        return false;
    }

    public boolean remove(Object car) {
        if(!Objects.isNull(car)) {
            if (park.contains(car)) {
                park.add(park.indexOf(car), null);
                park.remove(car);
                return true;
            }
        }
        return false;
    }

    public boolean isPlace(int n) {
        return (n + 1) <= space;
    }

    public void print(){
        System.out.println(park);
    }
}
