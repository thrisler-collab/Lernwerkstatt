import java.io.Serializable;

public class Moebel implements Serializable{ //Wird benötigt damit speichern und laden funkltioniert {
    private String art;
    private boolean verschiebbar ;

    public Moebel(String art, boolean verschiebbar) throws Exception {
        setArt(art);
        setVerschiebbar(verschiebbar);
    }

    public void setArt(String art) throws Exception {
        if(art == null || art.isEmpty()){
            throw new Exception("Keine Möbel art angegeben");
        }
        this.art = art;
    }

    public void setVerschiebbar(boolean verschiebbar) {
        this.verschiebbar = verschiebbar;
    }

    public String getArt() {
        return art;
    }

    public boolean isVerschiebbar() {
        return verschiebbar;
    }

    @Override
    public String toString() {
        return "Moebel{" +
                "art='" + art + '\'' +
                ", verschiebbar=" + verschiebbar +
                '}';
    }

    public void print(){
        System.out.println(this);
    }


}
