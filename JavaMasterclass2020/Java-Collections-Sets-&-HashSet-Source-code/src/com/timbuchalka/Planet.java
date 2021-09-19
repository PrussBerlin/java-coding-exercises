package com.timbuchalka;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if(satellite.getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(satellite);
        }
//        System.out.println("Cannot add " + satellite.getBodyType() + ", a planet can just have moons as satellites");
        return false;
    }
}
