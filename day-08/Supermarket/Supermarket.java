public class Supermarket {

    private PersonQueue queue;

    public static void main (String[] args) {
        // PersonQueue queue = new PointerPersonQueue();
        // PersonQueue queue = new ArrayPersonQueue();
        PersonQueue queue = new SortedQueue();

        Supermarket market = new Supermarket(queue);

        Person customer1 = new Person("John Doe", 47);
        Person customer2 = new Person("Jack Daniels", 33);
        Person customer3 = new Person("Jane Doe", 33);
        Person customer4 = new Person("David Beckham", 56);
        Person customer5 = new Person("Dan Carter", 45);
        Person customer6 = new Person("James Paige", 87);

        market.addPerson(customer1);
        market.addPerson(customer2);
        market.addPerson(customer3);
        market.addPerson(customer4);
        market.addPerson(customer5);
        market.addPerson(customer6);

        System.out.println("Supermarket queue created");
        System.out.println("");
        System.out.print("Should have size equivalent to number of customers...");
        System.out.println((market.getSize() == 6) ? "Passed" : "Failed");
        System.out.println("");
        market.prettyPrint();
        System.out.println("");
        System.out.println("Ok, time to start serving...");
        Person served = market.servePerson();
        // System.out.print("Should serve first person in queue...");
        System.out.print("Should serve oldest person in queue...");
        // System.out.println((served.getName().equals(customer1.getName())) ? "Passed" : "Failed");
        System.out.println((served.getName().equals(customer6.getName())) ? "Passed" : "Failed");
        System.out.println("Served person: " + served.getName());

        served = market.servePerson();
        System.out.println("Expected to serve " + customer4.getName() + ", served " + served.getName());
        System.out.println("");

        System.out.println("Some more people have arrived...");
        market.addPerson(new Person("Sean Connery", 103));
        market.addPerson(new Person("James Fitzgerald", 99));

        System.out.println("");
        market.prettyPrint();

        System.out.println("Market size: " + market.getSize());

        int queueSize = market.getSize();

        for (int i = 0; i < queueSize; i++) {
            served = market.servePerson();
            System.out.println("Served person: " + served.getName());
        }

        System.out.println("");
        market.prettyPrint();

    }

    public int getSize () {
        // return ((PointerPersonQueue)this.queue).getSize();
        // return ((ArrayPersonQueue)this.queue).getSize();
        return ((SortedQueue)this.queue).getSize();
    }

    public void prettyPrint () {
        // ((PointerPersonQueue)this.queue).prettyPrint();
        // ((ArrayPersonQueue)this.queue).prettyPrint();
        ((SortedQueue)this.queue).prettyPrint();
    }

    public Supermarket (PersonQueue queue) {
        this.queue = queue;
    }

    public PersonQueue getQueue () {
        return this.queue;
    }

    public void addPerson (Person person) {
        this.queue.insert(person);
    }

    public Person servePerson () {
        return this.queue.retrieve();
    }

}
