public class Target {
    private int[][][] airspace;
    private int len;
    private int totalCoords;

    public Target(int size) {
        // create new 3d array
        airspace = new int[size][size][size];
        // cache the size
        len = size;
        // cache total coordinates
        totalCoords = (size * size * size);
        System.out.println("total size: " + totalCoords);
    }

    public void init() {
        int randomCoordinate = (int) Math.abs(totalCoords * Math.random());
        int iterationCount = 0;

        for(int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                for (int z = 0; z < len; z++) {
                    iterationCount++;
//                    System.out.println(iterationCount);
                    if (iterationCount == randomCoordinate) {
//                        System.out.println("isRandomCoord");
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