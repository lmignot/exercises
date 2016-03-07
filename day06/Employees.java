public class Employees {
    private int[] ids;
    private String[] names;
    private int count = 0;

    public Employees () {
        // start off with a small array
        this.ids = new int[4];
        this.names = new String[4];
    }

    public void add (int id, String name) {
        this.count++;

        if (this.ids.length < count) {
            this._increaseSize();
        }

        this.ids[count - 1] = id;
        this.names[count - 1] = name;
    }

    public void prettyPrint () {
        for (int i = 0; i < this.ids.length; i++) {
            String name = this.names[i];
            int id = this.ids[i];

            if (id > 0 && (id % 2 == 0 || name.charAt(0) == 'S')) {
                System.out.print("Employee id: " + this.ids[i]);
                System.out.println(", name: " + this.names[i] + ".");
            }

        }
    }

    public int count () {
        return this.count;
    }

    private void _increaseSize () {
        int oldSize = this.ids.length;
        int newSize = oldSize * 2;

        int[] tmpIds = new int[newSize];
        String[] tmpNames = new String[newSize];

        for (int i = 0; i < oldSize; i++) {
            tmpIds[i] = this.ids[i];
            tmpNames[i] = this.names[i];
        }
        this.ids = tmpIds;
        this.names = tmpNames;
    }

    private void _decreaseSize () {
        int oldSize = this.ids.length;
        int newSize = oldSize / 2;

        int[] tmpIds = new int[newSize];
        String[] tmpNames = new String[newSize];

        for (int i = 0; i < newSize; i++) {
            tmpIds[i] = this.ids[i];
            tmpNames[i] = this.names[i];
        }
        this.ids = tmpIds;
        this.names = tmpNames;
    }
}
