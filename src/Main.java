import model.monster.Slime;

public class Main {
    
    public static void main(String[] args) {
        
        //* Debugging purposes, will be removed in the merge */
        Slime slime = new Slime();

        System.out.println(slime.getSprite());

        slime.showStatus();

    }
}
