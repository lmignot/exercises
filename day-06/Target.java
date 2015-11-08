public class Target {
    private int[][][] airspace;
    private int len;
    private int area;

    public Target(int size) {
        // create new 3d array
        airspace = new int[size][size][size];
        // cache the size
        len = size;
        // store the area
        area = size * size * size;
        System.out.println(size);
        System.out.println(area);
    }

    public void init() {
        int randomCoordinate = (int) Math.abs(area * Math.random());
        System.out.println(randomCoordinate);

        for(int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                for (int z = 0; z < len; z++) {
                    if (x * y * z == randomCoordinate) {
                        airspace[x][y][z] = 1;
                    } else {
                        airspace[x][y][z] = 0;
                    }
                }
            }
        }
    }

    public Result fire(int x, int y, int z) {
        // @TODO: implement this
        return Result.HIT;
    }
}