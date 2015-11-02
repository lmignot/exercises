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

    public void printArray (int[] arr) {
        System.out.print(" values: ");

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.println(arr[i]);
            }
        }
    }

}
