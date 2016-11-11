import java.io.*;

/**
 * Created by JAOUAD on 10/10/2016.
 */
public class Controller {

    private Tree arbre;
    private Noeud courant;
    private BufferedReader buffer;
    
    public Controller(){
        this.arbre = new Tree();
    }

    public void lectureLexique(String fichier)throws FileNotFoundException, IOException{
        InputStream ips = new FileInputStream(fichier);
        InputStreamReader ipsr = new InputStreamReader(ips);
        buffer = new BufferedReader(ipsr);
        String mot;
        while((mot = buffer.readLine()) != null){
            this.lireFichier(mot,0);
        }
    }

    public void lireFichier( String mot, int k) throws IOException {
        Noeud noud=arbre.getRoot();
        Noeud prev_noeud=null;
        String tabMot[] = mot.split("\\s+");
        char[] charMot = tabMot[0].toCharArray();
        
        for(int i=0; i<charMot.length; i++){
            if(arbre.getRoot()==null){
                arbre.setRoot(new Noeud(charMot[i], -1));
                noud = arbre.getRoot();
            }else {
                if(noud==null){
                    prev_noeud.setFd(new Noeud(charMot[i], -1));
                    noud=prev_noeud.getFd();
                }else{
                    while (noud!=null && noud.getCaractere()!=charMot[i]) {                        
                       prev_noeud= noud;
                       noud=noud.getFg(); 
                    }
                    if(noud==null){
                        prev_noeud.setFg(new Noeud(charMot[i], -1));
                        noud=prev_noeud.getFg();
                    }
                }
            }
            if(i==charMot.length-1){
                noud.setCode(Integer.parseInt(tabMot[1]));
            }else{
                prev_noeud=noud;
                noud=noud.getFd();
            }   
        }
    }
    
    // Utilitaires
    public boolean separateur_fort(char c){
        char t[]={' ','\n','\t','.',':',';',',','"','\'','-','_','!','?'};
        int i=0;
        boolean exist = false;
        while(i<t.length){
            if(t[i] == c){
                exist = true;
            }
            i++;
        }
        return exist;
    }
    
    public boolean espace(char c){
        char t[]={' ','\n','\t'};
        int i=0;
        boolean exist = false;
        while(i<t.length){
            if(t[i] == c){
                exist = true;
            }
            i++;
        }
        return exist;
    }
    // Tokenizeur
    public int tokenize(Noeud lexique, char[] buffer, int indice, int code){
        int imot;
        code = -1; imot = indice;
        while((indice<buffer.length) && (lexique != null)){
            if ((buffer[indice]==lexique.getCaractere())||((buffer[indice]==' ')&&(lexique.getCaractere()=='_'))){
                if ((lexique.getCode()!=-1) && ((separateur_fort(buffer[indice+1])) || (separateur_fort(buffer[indice])))){
                    code = lexique.getCode();
                    imot = indice;
                }
                lexique=lexique.getFg();
                indice++;
            }
            else{
                lexique=lexique.getFd();
            }
        }
        return imot;
    }
    
    public Tree getArbre(){
        return this.arbre;
    }

}
