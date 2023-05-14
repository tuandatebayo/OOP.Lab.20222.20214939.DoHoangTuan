package hust.soict.dsai.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        String s = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
