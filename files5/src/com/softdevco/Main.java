package com.softdevco;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Animal[] animals = deserializeAnimalArray(byteInputGenerator());
        for (Animal animal : animals
                ) {
            System.out.println(animal.getName());
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;
        try {
            InputStream inputStream = new ByteArrayInputStream(data);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            int amount = in.readInt();
            animals = new Animal[amount];
            while (amount != 0) {
                amount--;
                animals[amount] = (Animal) in.readObject();
            }
            in.close();
        } catch (Exception ex) {
            throw new java.lang.IllegalArgumentException();
        }
        return animals;
    }

    static byte[] byteInputGenerator() throws IOException {
        Animal[] animals = {new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animals.length);
        for (int i = 0; i < animals.length; i++) {
            oos.writeObject(animals[i]);
        }
        oos.flush();
        oos.close();
        return bai.toByteArray();
    }

}
