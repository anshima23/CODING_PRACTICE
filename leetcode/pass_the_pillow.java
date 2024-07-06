public class pass_the_pillow {
    private int findPersonHoldingPillow(int n, int time, int currentPerson, int direction) {
        if (time == 0) return currentPerson;

        if (direction == 1) {
            if (currentPerson == n) { return findPersonHoldingPillow(n, time - 1, currentPerson - 1, -1);}
            else { return findPersonHoldingPillow(n, time - 1, currentPerson + 1, 1);}
        } 

        else {
            if (currentPerson == 1) { return findPersonHoldingPillow(n, time - 1, currentPerson + 1, 1);}
            else { return findPersonHoldingPillow(n, time - 1, currentPerson - 1, -1);}
        }
    }
    public int passThePillow(int n, int time) {
      return findPersonHoldingPillow(n, time, 1, 1);  
    }
}
