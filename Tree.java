
/**
 * Created by JAOUAD on 10/10/2016.
 */
public class Tree {

    private Noeud root;
    private Noeud parent;

    public Tree() {
        this.root = null;
    }

    public void setRoot(Noeud n) {
        this.root = n;
    }

    public Noeud getRoot() {
        return this.root;
    }

    public void affiche() {
        post_fix(this.getRoot(), 0);
    }

    public void post_fix(Noeud racine,int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
        while (racine != null) {
            System.out.print(" -> " + racine.getCaractere());
            if (racine.getFg() != null) {
                System.out.println("|");

                post_fix(racine.getFg(),n+1);
                System.out.println("|");
            }
            racine = racine.getFd();
        }
    }
}
