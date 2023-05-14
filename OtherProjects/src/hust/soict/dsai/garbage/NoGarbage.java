package hust.soict.dsai.garbage;

public class NoGarbage {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
