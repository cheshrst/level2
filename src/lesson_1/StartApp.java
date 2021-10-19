package lesson_1;


public class StartApp {
    public static void main(String[] args) {
        Team[] team = new Team[6];
        Task[] task = new Task[2];
        team[0] = new Cat("Barisk", 3, 5);
        team[1] = new Human("El_Bisto", 10, 5);
        team[2] = new Robot("C-3PO", 2, 16);
        team[3] = new Robot("R2-D2", 16, 2);
        team[4] = new Human("Ed", 5, 10);
        team[5] = new Cat("Iris", 5, 3);
        task[0] = new Treadmill(6);
        task[1] = new Wall(5);
        for (int i = 0; i < team.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < task.length; j++) {
                try {
                    team[i].jumpWall((Wall) task[j]);
                }catch (Exception e){
                }finally {
                    try {
                        team[i].runTreadmill((Treadmill) task[j]);
                    }catch (Exception e){

                    }finally {
                        continue;
                    }
                }
            }
        }
    }
}

