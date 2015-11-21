public class Target {
    private int[][][] airspace;
    private int len;
    private int totalCoords;

    private int targetX;
    private int targetY;
    private int targetZ;

    public Target(int size) {
        // create new 3d array
        this.airspace = new int[size][size][size];
        // cache the size
        this.len = size;
        // cache total coordinates
        this.totalCoords = (size * size * size);
        // System.out.println("total size: " + totalCoords);
    }

    public void init() {
        int randomCoordinate = (int) Math.abs(totalCoords * Math.random());
        int iterationCount = 0;

        for(int x = 0; x < this.len; x++) {
            for (int y = 0; y < this.len; y++) {
                for (int z = 0; z < this.len; z++) {
                    iterationCount++;
//                    System.out.println(iterationCount);
                    if (iterationCount == randomCoordinate) {
//                        System.out.println("isRandomCoord");
                        // store the coordinates so we can
                        // respond to fires without having to loop :)
                        this.targetX = x;
                        this.targetY = y;
                        this.targetZ = z;
                        this.airspace[x][y][z] = 1;
                    } else {
                        this.airspace[x][y][z] = 0;
                    }
                }
            }
        }
    }


    public Result fire(int x, int y, int z) {
        if (x > this.len || y > this.len || z > this.len) {
            return Result.OUT_OF_RANGE;
        } else if (x < this.targetX) {
            return Result.FAIL_LEFT;
        } else if (x > this.targetX) {
            return Result.FAIL_RIGHT;
        } else if (y > this.targetY) {
            return Result.FAIL_HIGH;
        } else if (y < this.targetY) {
            return Result.FAIL_LOW;
        } else if (z > this.targetZ) {
            return Result.FAIL_LONG;
        } else if (z < this.targetZ) {
            return Result.FAIL_SHORT;
        } else if (x == this.targetX && y == this.targetY && z == this.targetZ) {
            return Result.HIT;
        }
        return null;
    }
}
