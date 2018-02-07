package ua.nure.antoniuk.Practice6.part3;

/**
 * Created by Max on 05.12.2017.
 */
public class Part3 {

    public static void main(String[] args) {
        Parking parking = new Parking(10);
        Object car1 = new Integer(1);
        Object car2 = new Integer(2);
        Object car3 = new Integer(3);
        Object car4 = new Integer(4);
        Object car5 = new Integer(5);
        Object car6 = new Integer(6);
        Object car7 = new Integer(7);
        Object car8 = new Integer(8);


        //parking.isPlace(2);
        //System.out.println(parking.isPlace(2));

        System.out.println(parking.add(2, car1));
        System.out.println(parking.add(2, car2));
        System.out.println(parking.add(11, car3));
        System.out.println(parking.add(2, car4));
        //parking.add(3, car2);
        parking.remove(car2);
        parking.print();

    }
}
