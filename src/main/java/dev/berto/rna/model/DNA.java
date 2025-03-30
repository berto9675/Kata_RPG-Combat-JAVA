package dev.berto.rna.model;

public class DNA {
    private final String sequence;

    public DNA(String sequence) {
        if(sequence == null || sequence.isEmpty()) {
            throw new IllegalArgumentException("DNA sequence cannot be null or empty");
        }
        if(!sequence.matches("[ACGT]*")) {
            throw new IllegalArgumentException("DNA sequence can only contain A, C, G, and T characters");
        }
        this.sequence = sequence;
    }   

    public String getSequence() {
        return sequence;
    }

    

}
