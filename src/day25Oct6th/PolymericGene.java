package day25Oct6th;

import java.util.ArrayList;

public class PolymericGene extends Gene {

    private ArrayList<Gene> seq;

    public PolymericGene(ArrayList<Gene> seq) {
        // Shallow vs. deep copy
        this.seq = seq;  // shallow copy.
        // Deep copy
        this.seq = new ArrayList<Gene>();
        for (int i = 0; (i < seq.size()); i++) {
            this.seq.add(seq.get(i).clone());
        }
    }

    // Copy constructor
    public PolymericGene(PolymericGene src) {
        this(src.seq);  // Call constructor in this class
    }
    @Override
    public boolean isSimilar(Gene g) {
        // The polymeric gene is oncogenic
        // if any of its genes contains a
        // similar subfragment.
        if (g instanceof PolymericGene) {
            PolymericGene pg = (PolymericGene) g;
            for (Gene subGene : pg.seq) {
                if (subGene.isSimilar(g)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Gene clone() {
        // Typically we will use a copy-constructor
        // to create clones. Of course this means we
        // have to implement a copy constructor!
        // PolymericGene newClone = new PolymericGene(this.seq);
        // return newClone;
        return new PolymericGene(this);
    }

}