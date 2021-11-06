package com.timbuchalka;

import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        //Bufferedwriter zum schreiben des Locations und des Direction (Exits der Locations) Files, Quelle ist die Locations MAp oben
        try(BufferedWriter bwLoc = new BufferedWriter(new FileWriter("locations.txt"));
            BufferedWriter bwDir = new BufferedWriter(new FileWriter("directions.txt"))) {
            //Es wird je eine Location ausgelesen
            for(Location location : locations.values()) {
                //von dieser wird die ID geholt
                int id = location.getLocationID();
                //dann wird bei
                if(id == 0) {
                    bwLoc.write(id + 48);
                } else {
                    while(id > 0) {
                        bwLoc.write(Integer.lowestOneBit(id) + 48);
                        id /= 10;
                    }
                }
                bwLoc.write(',');

                String description = location.getDescription();
                for(int i = 0; i < description.length(); i++) {
                    bwLoc.write(description.charAt(i));
                }
                bwLoc.write('\n');

                for(String direction : location.getExits().keySet()) {
                    if(!direction.equals("Q")) {
                        String line = location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n";
                        bwDir.write(line.toCharArray(), 0, line.length());
                    }

                }
            }
            bwLoc.flush();
            bwDir.flush();
        }
    }

    static {

        try(BufferedReader locFile = new BufferedReader(new FileReader("locations_big.txt"))) {
            String lineFromLocFile;
            while((lineFromLocFile = locFile.readLine()) != null) {
                int splitIndex = lineFromLocFile.indexOf(",");
                int loc = Integer.parseInt(lineFromLocFile.substring(0, splitIndex));
                String description = lineFromLocFile.substring(splitIndex+1);
//                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new LinkedHashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        // Now read the exits
        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

//                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
