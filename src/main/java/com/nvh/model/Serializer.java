package com.nvh.model;

import com.nvh.controller.Scrabble;

import java.io.*;

public class Serializer {

    public static void ecrire(Scrabble partie, String nom) throws FileNotFoundException, IOException {

        ObjectOutputStream oos;
        oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Dictionnaire.chemin + "/savedgames/" + nom)));
        oos.writeObject(partie);
        oos.close();
    }

    @SuppressWarnings("resource")
    public static Scrabble lire(String nom) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois;
        ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(Dictionnaire.chemin + "/savedgames/" + nom)));

        return (Scrabble) ois.readObject();
    }
}
