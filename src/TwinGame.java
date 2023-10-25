import java.util.Random;

public class TwinGame{
    private final Random r = new Random();
    public final int[] elements;
    private final boolean[] checkTwins;
    public TwinGame(){
        this.elements = new int[5];
        this.checkTwins = new boolean[this.elements.length];
    }
    public void insertNumbers(){
        int singleNum = 1 + r.nextInt(100);
        int indexSingle = r.nextInt(this.elements.length);
        this.elements[indexSingle] = singleNum;
        this.checkTwins[indexSingle] = true;
        System.out.println(singleNum);

        for (int i = 1; i <= (this.elements.length - 1) / 2 ; i++){
            int twin = 1 + r.nextInt(100);
            System.out.print(twin + " ");
            for(int j = 0; j < 2; j++){
                int indexTwin = r.nextInt(this.elements.length);
                if(i == (this.elements.length - 1) / 2){
                    for (int k = 0; k < this.elements.length; k++) {
                        if (this.elements[k] == 0) {
                            this.elements[k] = twin;
                        }
                    }
                }
                if(!this.checkTwins[indexTwin]){
                    this.elements[indexTwin] = twin;
                    this.checkTwins[indexTwin] = true;

                }
            }
        }
    }
    public void startGame(){
        insertNumbers();
        System.out.println();
        for(int element : this.elements) {
            System.out.print(element + " ");
        }
    }
}