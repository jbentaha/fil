/**
 * Created by JAOUAD on 10/10/2016.
 */
public class Main {
    public static void main(String argv[]){
        Controller lecture = new Controller();
        String fichier = "./files/fichier.txt";

        try {
            lecture.lectureLexique(fichier);
            lecture.getArbre().affiche();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
