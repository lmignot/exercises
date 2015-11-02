public class ArrayCopier {

    public void copy (int[] src, int[] dest){
        for (int i = 0; i < dest.length; i++) {
            // avoid index out of bounds
            if (i > src.length - 1) {
                dest[i] = 0;
            } else {
                dest[i] = src[i];
            }
        }
    }

}
