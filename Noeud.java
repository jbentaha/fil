/**
 * Created by JAOUAD on 10/10/2016.
 */

public class Noeud{
    private char caractere;
    private int code;
    private Noeud fd;
    private Noeud fg;

    public Noeud(char c, int code){
        this.caractere = c;
        this.code = code;
    }
    public void rajouteDroite(Noeud fd){
        this.setFd(fd);
    }
    
    public void rajouteGauche(Noeud fg){
        this.setFg(fg);
    }

    public char getCaractere() {
        return caractere;
    }

    public int getCode() {
        return code;
    }

    public void setFd(Noeud fd) {
        this.fd = fd;
    }

    public void setFg(Noeud fg) {
        this.fg = fg;
    }

    public Noeud getFd(){
        return this.fd;
    }

    public Noeud getFg(){
        return this.fg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    
}
