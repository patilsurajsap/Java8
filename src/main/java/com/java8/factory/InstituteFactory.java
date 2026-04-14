package com.java8.factory;

import com.java8.model.Institute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstituteFactory {

    private static List<Institute> instituteList  =  new ArrayList<>();

    {
        System.out.println("Initializing institute list...");
        instituteList.add(new Institute("IIT",Arrays.asList( "Mumbai", "Delhi")));
        instituteList.add(new Institute("IIM",Arrays.asList( "Ahemadabad", "Calcutta")));
        instituteList.add(new Institute("NIT",Arrays.asList( "Bhopal", "Trichi")));
    }


    public static  List<Institute> getInstituteList() {
        return instituteList;
    }
}
