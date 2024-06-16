package model.monster;

public class Slime extends Monster {
    
    public Slime(){
        super("Slime", 6, 3, 4, 4);
    }

    public void atacar(){

    }

    public String getSprite(){
        return "              ░░░░░░░░░░              \r\n" + //
                    "          ░░░░        ░░░░░░              \r\n" + //
                    "        ░░                  ░░            \r\n" + //
                    "      ░░                    ░░░░          \r\n" + //
                    "    ░░                      ░░░░░░        \r\n" + //
                    "    ░░                        ░░░░        \r\n" + //
                    "  ░░                ░░    ░░  ░░░░░░      \r\n" + //
                    "  ░░                ██░░  ██    ░░░░      \r\n" + //
                    "  ░░                ██░░  ██    ░░░░      \r\n" + //
                    "  ░░            ░░            ░░░░░░      \r\n" + //
                    "  ░░░░░░                      ░░░░░░      \r\n" + //
                    "    ░░░░░░                  ░░░░░░        \r\n" + //
                    "    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░        \r\n" + //
                    "        ░░░░░░░░░░░░░░░░░░░░░░                                                                        \r\n" + //
                    "                                         " + "\n\n";
    }
}
