import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoebelTest {

    Moebel ref;

    @BeforeEach
    void setUp() {
        //Was er immer vor dem testen machen soll
        //Wenn man ganz genau weiß das keine exeption kommt verwendet man try catch
        try {
            ref = new Moebel("Sofa", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("setup");
    }

    @Test
    void setArt() {
        try {
            ref.setArt("Tisch");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals("Tisch", ref.getArt());
    }

    @Test
    void setVerschiebbar() {
        //Wenn der vergleich ok ist sezt er den test als erfolgreich
        ref.setVerschiebbar(false);
        assertFalse(ref.isVerschiebbar());
        ref.setVerschiebbar(true);
        assertTrue(ref.isVerschiebbar());
    }

    //asser Equals wird am häufigsten verwendet --> alle Datentypen
    // assert false wird verwendet wenn man überprüfen will ob etwas false osz --> nur einen wert
    //assert true wird verwendet wenn man überprüfen will ob etwas true ist --> ebso nur ein Datentyp
    @Test
    void testToString() {
        assertEquals("Moebel{art='Sofa', verschiebbar=true}", ref.toString());
    }

    @Test
    void testExeption() {
        //Name der Exeption auch wenn man eine eigene erstellt hat
        assertThrows(Exception.class, () -> {
            try {
                Moebel m = new Moebel("Sessel", true);
                Moebel m1 = new Moebel(null, true);
                m1.print();
            } catch (Exception e) {
                throw new Exception();
            }
        });
    }
}