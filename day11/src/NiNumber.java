/**
 * PiJ Day 11 - exercise 4
 */
public class NiNumber implements Comparable<NiNumber> {

    private Integer id;
    private String ni;

    public NiNumber (Integer id, String ni) {
        this.id = id;
        this.ni = ni;
    }

    public String getNi () { return this.ni; }

    @Override
    public int compareTo(NiNumber o) {
        return o.id.compareTo(this.id);
    }
}
