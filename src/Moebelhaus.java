import java.io.*;
import java.util.ArrayList;

public class Moebelhaus {
    private ArrayList<Moebel> angebot;

    public Moebelhaus() {
        //Tipp: Arraylist im Construktor erzeugen
        this.angebot = new ArrayList<>();
    }

    public boolean hinzu(Moebel m){
        //.add gibt bereits einen boolean standartmäßig
        //noch keine Prüfungen
       return angebot.add(m);
    }

    public void printangebot(){
             //Für alle Möbel in der liste angebot
        for(Moebel m : angebot){
            m.print();
        }
    }

    public void angebotSpeichernSerialisierung(String dateiname) throws IOException {
               //Kann in einen Byte umwandeln
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname))){
               //schreibt direkt doie Liste in das File
               oos.writeObject(angebot);
        }
    }

    public void angebotLadenSerialisierung(String dateiname) throws IOException {
        //Kann in einen Byte umwandeln
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(dateiname))){
            try {
                //lädt alle daten direkt in die ArrayList
                angebot = (ArrayList<Moebel>) oos.readObject();
            } catch (ClassNotFoundException e) {
               e.printStackTrace(); // sollte nicht passieren
            }
        }
    }

    public void generiereMoebelRekursiv(int anzahl){
        try {
            hinzu(new Moebel("Sofa" + anzahl, true));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //generiere die restlichen Möbelstücke rekursiv
        if(anzahl > 1){
            generiereMoebelRekursiv(anzahl-1); //Hier wird bei jedem aufruf um 1 veringert die anzahl --> zählt immer weiter runter bis 1

        }
    }
}
