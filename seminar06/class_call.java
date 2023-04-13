
public class class_call {
    public static void main(String[] args) {
        cat k01 = new cat();
        System.out.println(k01);
        k01.plusYear();
        System.out.println(k01);
        k01.setName("Barsique");
        System.out.println(k01);
        cat k02 = new cat();
        k02.setName("Pushinkae");
        cat k03 = k01.add(k02);
        System.out.println(k03);
    }
}
