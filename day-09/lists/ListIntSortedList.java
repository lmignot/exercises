public class ListIntSortedList implements IntSortedList {
    private IntItem head;

    public IntSetList () {
        this.head = null;
    }

    public void add (int n){
        if (this.head == null) {
            this.head = new IntItem(n);
        } else {
            IntItem currentItem = this.head;
            boolean exists = false;

            if (currentItem.getValue() == n) {
                exists = true;
            } else{
                while (currentItem.getNextItem() != null ) {
                    currentItem = currentItem.getNextItem();
                    if (currentItem.getValue() == n){
                        exists = true;
                        break;
                    }
                }
            }
            if (!exists) {
                currentItem.setNextItem(new IntItem(n));
            }
        }
    }


    public boolean contains (int n){
        if(this.head == null){
            return false;
        }else{
            IntItem currentItem = this.head;
            boolean exists = false;
            while (currentItem.getNextItem() != null) {
                if (currentItem.getValue() == n){
                    exists = true;
                    break;
                }
                currentItem = currentItem.getNextItem();
            }
            return exists;
        }
    }

    public String toString (){
        String result = "";
        if ( this.head == null ){
            return result;
        } else if (this.head.getNextItem() == null) {
            return "" + this.head.getValue();
        } else {
            IntItem currentItem = this.head;
            while (currentItem.getNextItem() != null) {
                result +=  currentItem.getValue() + "," ;
                currentItem = currentItem.getNextItem();
            }
            result += currentItem.getValue();
            return result;
        }
    }
}
