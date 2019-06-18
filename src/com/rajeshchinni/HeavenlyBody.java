package com.rajeshchinni;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;           // newly added

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    // constructor
    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();      // manually added
        this.bodyType = bodyType;               // manually added
    }

    // getter
    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public Set<HeavenlyBody> getSatellites() {
        //return satellites;
        return new HashSet<>(this.satellites);        // changes made here
    }

    // method
    public boolean addSatellite(HeavenlyBody moon){    // addMoon is changed to addSattelite
        return this.satellites.add(moon);

    }

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    @Override
    public final boolean equals (Object obj){   // added final
        if (this == obj){
            return true;
        }

        if (obj instanceof HeavenlyBody){         // newly added
            HeavenlyBody theObject = (HeavenlyBody)obj;
            if (this.name.equals(theObject.getName())){
                return this.bodyType == theObject.getBodyType();
            }
        }

        String objName = ((HeavenlyBody)obj).getName();
        return this.name.equals(objName);
    }
    // https://www.geeksforgeeks.org/equals-hashcode-methods-java/
    // https://www.youtube.com/watch?v=ghswNpRv2t0
    // https://www.youtube.com/watch?v=Nr56SlbMed4
    // https://www.youtube.com/watch?v=c3RVW3KGIIE

    @Override
    public final int hashCode() {    // added final
        //return super.hashCode();
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
