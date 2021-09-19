package com.timbuchalka;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetChallenge {

    private static Set<HeavenlyBody> solarSystem = new HashSet<>();
//    private static Set<HeavenlyBody> planets = new HashSet<>();
    public static void main(String[] args) {

//        Star whatEver = new Star("whatEver", 324);
//        System.out.println(whatEver.equals(whatEver));
//        HeavenlyBody whatEver2 = new Star("whatEver", 324);
//        System.out.println(whatEver.equals(whatEver2));

        HeavenlyBody temp = new Star("Mercury", 88);
        solarSystem.add(temp);

        temp = new Star("Venus", 225);
        solarSystem.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);
        printHeavenlyBodies(temp.getSatellites());

        temp = new Planet("Mars", 687);
        solarSystem.add(temp);

        tempMoon = new Star("Deimos", 1.3);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars
        printHeavenlyBodies(temp.getSatellites());

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.add(temp);
        

        tempMoon = new Moon("Io", 1.8);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        printHeavenlyBodies(temp.getSatellites());

        temp = new Planet("Saturn", 10759);
        solarSystem.add(temp);
        

        temp = new Planet("Uranus", 30660);
        solarSystem.add(temp);
        

        temp = new Planet("Neptune", 165);
        solarSystem.add(temp);
        

        temp = new Planet("Pluto", 248);
        solarSystem.add(temp);

        temp = new Star("Pluto", 2484);
        solarSystem.add(temp);
        System.out.println("The solarsystem contains :");
        printHeavenlyBodies(solarSystem);

        HeavenlyBody earth1 = new Planet("Earth", 365);
        Planet earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.hashCode());
        System.out.println(earth2.hashCode());
        System.out.println(earth1 == earth2);
        

//        System.out.println("Planets");
//        for(HeavenlyBody planet : planets) {
//            System.out.println("\t" + planet.getName());
//        }

//        HeavenlyBody body = solarSystem.get("Mars");
//        System.out.println("Moons of " + body.getName());
//        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
//            System.out.println("\t" + jupiterMoon.getName());
//        }

//        Set<HeavenlyBody> moons = new HashSet<>();
//        for(HeavenlyBody planet : planets) {
//            moons.addAll(planet.getSatellites());
//        }
//
//        System.out.println("All Moons");
//        for(HeavenlyBody moon : moons) {
//            System.out.println("\t" + moon.getName());
//        }
//
//        HeavenlyBody pluto = new Planet("Pluto", 842);
//        planets.add(pluto);
//        for(HeavenlyBody planet : planets) {
//            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
//        }


    }

    public static void printHeavenlyBodies(Set<HeavenlyBody> bodies) {
//        Object[] bodyArray = bodies.toArray();
//        HeavenlyBody temp;

        for(HeavenlyBody body : bodies) {
            System.out.println(body);
//            temp = (HeavenlyBody) body;
//            System.out.println((temp.getBodyType() + " " + temp.getName() + " " + temp.getOrbitalPeriod()));
        }
    }
}
