public class work {
    public static int[] arrayAdd(int[] source, int add) {
        int[] tmp = new int[source.length+1];
        System.arraycopy(source, 0, tmp, 0, source.length);
        tmp[tmp.length-1] = add;
        return tmp;
    }
    public static void main(String[] args) {
        int[] myArray = new int[]{1,2};
        myArray = arrayAdd(myArray, 3);
        for (int item : myArray) {
            System.out.println(item);
            
        }
    }
}
