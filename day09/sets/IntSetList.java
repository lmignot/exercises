public  class IntSetList implements IntSet {
    private IntItem head;

    public IntSetList () {
        this.head = null;
    }

    public void add (int n){
        // System.out.println("adding " + n);
        if (this.head == null) {
            // System.out.println("new list");
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
        // System.out.println(this.toString());
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

    public boolean containsVerbose (int n){
        if (this.head == null){
            return false;
        } else {
            IntItem currentItem = this.head;
            boolean exists = false;

            System.out.println(currentItem.getValue());
            while (currentItem.getNextItem() != null) {
                currentItem = currentItem.getNextItem();
                System.out.println(currentItem.getValue());
                if (currentItem.getValue() == n){
                    exists = true;
                    break;
                }
            }
            return exists;
        }
    }

    public String toString (){
        String retValue = "";
        if ( this.head == null ){
            return retValue;
        } else if (this.head.getNextItem() == null) {
            return "" + this.head.getValue();
        } else {
            IntItem currentItem = this.head;
            while (currentItem.getNextItem() != null) {
                retValue +=  currentItem.getValue() + "," ;
                currentItem = currentItem.getNextItem();
            }
            retValue += currentItem.getValue();
            return retValue;
        }
    }
}
