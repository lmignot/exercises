public class QueueTest {
    private Queue q;

    public static void main(String[] args) {
        QueueTest qt = new QueueTest();

        qt.q = new Queue();
        System.out.println("There are " + qt.q.size() + " requests in the Queue");

        System.out.println("Inserting request 3...");
        qt.q.insert(3);
        System.out.println("Inserting request 4...");
        qt.q.insert(4);
        System.out.println("Inserting request 7...");
        qt.q.insert(7);
        System.out.println("Inserting request 8...");
        qt.q.insert(8);
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        System.out.println("Inserting request 67...");
        qt.q.insert(67);

        int req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        System.out.println("Inserting request 13...");
        qt.q.insert(13);
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        System.out.println("Inserting request 99...");
        qt.q.insert(99);
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        System.out.println("Inserting request 45...");
        qt.q.insert(45);
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "... done");
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
        req = qt.q.retrieve();
        System.out.println("Retrieving request " + req + "..." + ((req > 0) ? " done" : "no request"));
        System.out.println("There are " + qt.q.size() + " requests in the Queue");
    }
}
