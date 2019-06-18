package com.rajeshchinni;

public class DwarfPlanet extends HeavenlyBody {

//    public DwarfPlanet(String name, double orbitalPeriod, BodyTypes bodyType) {
//        super(name, orbitalPeriod, bodyType);
//    }


    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.DWARF_PLANET);
    }
}
