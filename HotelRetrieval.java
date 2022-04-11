package org.bonn.ooka.buchungssystem.ss2022;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class HotelRetrieval implements Hotelsuche{

    private DBAccess dbAccess = new DBAccess();


    private List<Hotel>getHotelData(int type,String value)
    {
        List<String> stringList;
        List<Hotel> hotelList = new ArrayList<>();
        String id;
        String name;
        String city;
        openSession();
        stringList = dbAccess.getObjects(type,value);
        int i = 0;
        closeSession();
        while(i<stringList.size()){
            id = stringList.get(i);
            i++;
            name = stringList.get(i);
            i++;
            city = stringList.get(i);
            i++;
            hotelList.add(new Hotel(id,name,city));
        }
        for(Hotel h:hotelList){
            System.out.println("Id:" + h.id);
            System.out.println("Name:" + h.name);
            System.out.println("City:" + h.city);
        }
        return hotelList;

    }

    @Override
    public List<Hotel> getHotelByName(String name) {
        return getHotelData(1,name);


    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        return getHotelData(2,city);
    }

    @Override
    public void openSession() {
        dbAccess.openConnection();

    }

    @Override
    public void closeSession() {
        dbAccess.closeConnection();
    }
}
