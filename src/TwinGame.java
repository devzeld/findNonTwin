import java.util.Random;

public class TwinGame{
    private final String username;
    private final Random r = new Random();
    public final int[] elements;
    private final boolean[] checkTwins;
    public TwinGame(){
        this.username = "111";
        this.elements = new int[3];
        this.checkTwins = new boolean[this.elements.length];
    }

    public void insertNumbers(){
        int singleNum = r.nextInt(100);;
        int indexSingle = r.nextInt(this.elements.length);
        this.elements[indexSingle] = singleNum;
        this.checkTwins[indexSingle] = true;

        for (int i = 0; i < this.elements.length; i++){
            int twin = r.nextInt(100);
            for(int j = 0; j < 2; j++){
                int indexTwin = r.nextInt(this.elements.length);
                if(this.checkTwins[indexTwin]){
                    continue;
                }
                this.elements[indexTwin] = twin;
                this.checkTwins[indexTwin] = true;
            }
        }
    }

    public void startGame(){
        insertNumbers();
        for(int element : this.elements) {
            System.out.print(element + " ");
        }
    }
}
