public class PatientList {
    private int size = 0;
    private Patient2 start;

    public PatientList () {

    }

    public void add (Patient2 patient) {
        // if we have no patient to start,
        // this patient is our starting point
        if (start == null) {
            start = new Patient2(patient.getName(), patient.getAge(), patient.getIllness());
        } else {

            Patient2 tmp = new Patient2(patient.getName(), patient.getAge(), patient.getIllness());
            Patient2 current = start;

            // find the last item in our list
            while(current.getNextPatient() != null) {
                current = current.getNextPatient();
            }

            // and add our new item to that one
            current.setNextPatient(tmp);

            Patient2 previous = current;

            // get our newly added item
            tmp = current.getNextPatient();

            // and set the previous item
            tmp.setPrevPatient(current);
        }
        this.size++;
    }

    public boolean delete (String name) {
        boolean didDelete = false;
        Patient2 current = start;
        // if it's the first item, delete it and
        // set the next item to start
        if (current.getName().equals(name)) {
            start = current.getNextPatient();
            start.setPrevPatient(null);
            didDelete = true;
            this.size--;
        } else {
            // loop and find a patient that matches
            while (current.getNextPatient() != null) {
                // cache the current one
                Patient2 tmp = current;
                // move current pointer one forward
                current = current.getNextPatient();
                if (current.getName().equals(name)) {
                    // if it's a match, set the cache to the next in the list
                    // and set the previous of that one to the cached
                    // essentially we remove the middle man
                    tmp.setNextPatient(current.getNextPatient());
                    current = current.getNextPatient();
                    current.setPrevPatient(tmp);
                    didDelete = true;
                    this.size--;
                }
            }
        }
        return didDelete;
    }

    public int getSize () {
        return this.size;
    }

    public void prettyPrintForward () {
        System.out.println(start.toString());
        Patient2 current = start;
        while (current.getNextPatient() != null) {
            current = current.getNextPatient();
            System.out.println(current.toString());
        }
    }

    public void prettyPrintReverse () {
        Patient2 current = start;
        while (current.getNextPatient() != null) {
            current = current.getNextPatient();
        }

        while (current.getPrevPatient() != null) {
            System.out.println(current.toString());
            current = current.getPrevPatient();
        }
        System.out.println(current.toString());
    }

}
