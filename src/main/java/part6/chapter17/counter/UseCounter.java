package part6.chapter17.counter;

public class UseCounter {
    public static void main(String[] args) {
        Counter counter = new Counter(1);

        System.out.println(counter.plus(counter)); // Counter(value=2)

        Counter counter0 = Counter.create();
        System.out.println(counter0); // Counter(value=0)

        System.out.println(counter.map(ctr -> ctr.plus(ctr))); // Counter(value=2)

        try {
            counter.readFile("blah");
        } catch(java.io.FileNotFoundException ex) {
            System.out.println("File not found");
        }

        System.out.println(counter.add(3));
        System.out.println(counter.add());

        //System.out.println(CounterKt.createCounter());
        System.out.println(CounterTop.createCounter());

    }
}