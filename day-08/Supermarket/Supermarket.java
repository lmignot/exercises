public class Supermarket {

    private PersonQueue queue;

    public static void main (String[] args) {
        Supermarket market = new Supermarket();
        market.addPerson(new Person("John Doe", 47));
        market.addPerson(new Person("Jack Daniels", 33));
        market.addPerson(new Person("Jane Doe", 33));
        market.addPerson(new Person("David Beckham", 56));
        market.addPerson(new Person("Dan Carter", 45));
        market.addPerson(new Person("James Paige", 87));

        System.out.println("Supermarket queue created, " + market.customerCount() + " people added");
        market.prettyPrint();

        System.out.println("Ok, time to start serving...");
        Person served = market.servePerson();
        System.out.println("Served person: " + served.getName());

        served = market.servePerson();
        System.out.println("Served person: " + served.getName());

        market.addPerson(new Person("Sean Connery", 103));
        market.addPerson(new Person("James Fitzgerald", 99));

        served = market.servePerson();
        System.out.println("Served person: " + served.getName());

        served = market.servePerson();
        System.out.println("Served person: " + served.getName());

    }

    public Supermarket () {
        this.queue = new PointerPersonQueue();
    }

    public int customerCount () {
        return ((PointerPersonQueue)this.queue).getSize();
    }

    public void addPerson (Person person) {
        this.queue.insert(person);
    }

    public Person servePerson () {
        return this.queue.retrieve();
    }

    public void prettyPrint () {
        ((PointerPersonQueue)this.queue).prettyPrint();
    }

}
