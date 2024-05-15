import java.util.List;

public class Main {
    public static<T extends Number> int countGreaterThan(T[] numbers, T number) {
        int counter = 0;

        for(T n: numbers) {
            if(n.doubleValue() > number.doubleValue()) {
                counter++;
            }
        }

        return counter;
    }

    public static double sumOfList(List<?> list) {
        double sum = 0;
        for(Number o: list) {
            sum += o.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        Integer[] tiggers = new Integer[]{1,2,3,43,5,6,7,8};
        double x = doubleOfList(tiggers);

        System.out.println(x);
    }
}
