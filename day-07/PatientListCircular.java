public class PatientListCircular {
    private int size = 0;
    private Patient3 start;

    public PatientListCircular () {

    }

    public void add (Patient3 patient) {
        // if we have no patient to start,
        // this patient is our starting point
        if (start == null) {
            start = new Patient3(patient.getId(), patient.getName(), patient.getAge(), patient.getIllness());
            start.setNextPatient(start);
        } else {

            Patient3 tmp = new Patient3(patient.getId(), patient.getName(), patient.getAge(), patient.getIllness());
            Patient3 current = start;

            if (start.getId() == start.getNextPatient().getId()) {
                // start is pointing to start
                // we set the next patient to the new one
                start.setNextPatient(tmp);
                tmp.setNextPatient(start);
            } else {
                // find the last item in our list
                while(current.getNextPatient().getId() != start.getId()) {
                    current = current.getNextPatient();
                }

                // and add our new item to the end
                current.setNextPatient(tmp);
                // and set the next patient of the new last item to start
                // to complete the circle
                tmp.setNextPatient(start);
            }
        }
        this.size++;
    }

    public boolean delete (int id) {
        // empty list
        // return early to save on looping
        if (this.size == 0) {
            return false;
        }

        boolean didDelete = false;

        // if we need to delete start
        // new start is start.getNextPatient()
        // and the last item needs to have nextPatient set to new start
        if (id == start.getId()) {
            Patient3 newStart = start.getNextPatient();
            Patient3 current = start;
            // loop and get the last one
            while (current.getNextPatient().getId() != start.getId()) {
                current = current.getNextPatient();
            }
            start = newStart;
            current.setNextPatient(start);
            this.size--;
            didDelete = true;
        } else {
            Patient3 current = start;
            Patient3 prev = start;
            // loop and get the last one
            while (current.getNextPatient().getId() != start.getId()) {
                prev = current;
                current = current.getNextPatient();
                if (current.getId() == id) {
                    break;
                }
            }
            prev.setNextPatient(current.getNextPatient());
            this.size--;
            didDelete = true;
        }

        return didDelete;
    }

    public int getSize () {
        return this.size;
    }

    public void prettyPrintForward () {
        System.out.println(start.toString());
        Patient3 current = start;
        while (current.getNextPatient().getId() != start.getId()) {
            current = current.getNextPatient();
            System.out.println(current.toString());
        }
    }

}
