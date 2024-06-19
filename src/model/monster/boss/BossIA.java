package model.monster.boss;

public class BossIA {
    
    Boss boss;

    public BossIA(Boss boss){
        try {
            startIA(boss);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void startIA(Boss boss) throws Exception{

        if (boss instanceof Minotaur) {
            
            System.out.println("inicando minotauro");

        }else if (boss instanceof DemonKing) {
            System.out.println("inicando rei demonio");
        }else{
            throw new Exception("Nenhum boss passado");
        }


    }

}
