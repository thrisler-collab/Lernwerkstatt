public class Main {
    public static void main(String[] args) {

        try {
            Moebel m1 = new Moebel("Sofa", true);
            Moebel m2 = new Moebel("Tisch", true);
            Moebel m3 = new Moebel("Sessel", true);

            Moebelhaus mh = new Moebelhaus();
            System.out.println("m1 hinzu: " + mh.hinzu(m1));
            System.out.println("m2 hinzu: " + mh.hinzu(m2));
            System.out.println("m3 hinzu: " + mh.hinzu(m3));
            mh.generiereMoebelRekursiv(5);


            System.out.println("Möbelangebot: ");
            mh.printangebot();

            System.out.println("Teste Speichern Laden");
            mh.angebotSpeichernSerialisierung("moebel.ser");
            mh.angebotLadenSerialisierung("moebel.ser");
            System.out.println("Möbelangebot: ");
            mh.printangebot();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}