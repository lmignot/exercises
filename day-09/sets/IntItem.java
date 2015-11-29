public class IntItem {
    private int value;
    private IntItem  nextIntItem;

    public IntItem(int n){
        this.value = n;
        this.nextIntItem = null;
    }

    public int getValue(){
        return this.value;
    }

    public void setNextItem(IntItem nextItem){
        this.nextIntItem = nextItem;
    }

    public IntItem getNextItem(){
        return this.nextIntItem;
    }


}
