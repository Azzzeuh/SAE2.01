public class Controleur {

    FrameDessin ihm; 
    
    public Controleur()
    {
        this.ihm = new FrameDessin( this );
    }
    public static void main(String[] args) {
        new Controleur();
    }
}
