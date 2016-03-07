public class Target {
    private int[][][] airspace;
    private int size;
    private int totalCoords;

    private int targetX;
    private int targetY;
    private int targetZ;

    public Target (int size) {
        // create new 3d array
        this.airspace = new int[size][size][size];
        // cache the size
        this.size = size;
    }

    public void init () {
        for(int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                for (int z = 0; z < this.size; z++) {
                    this.airspace[x][y][z] = 0;
                }
            }
        }

        this.targetX = (int) Math.abs(this.size * Math.random());
        this.targetY = (int) Math.abs(this.size * Math.random());
        this.targetZ = (int) Math.abs(this.size * Math.random());

        airspace[this.targetX][this.targetY][this.targetZ] = 1;
    }


    public Result fire (int x, int y, int z) {
        if (x < 0 || x >= this.size || y < 0 || y >= this.size || z < 0 || z >= this.size) {
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
        } else if (airspace[x][y][z] == 1) {
            return Result.HIT;
        }
        return null;
    }
}
