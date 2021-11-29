package models;

/**
 *
 * @author Edwin Niño
 */

public class Family {

    private int personId;
    private String father;
    private String mother;
    private String sons;

    public Family(int personId, String father, String mother, String sons) {
        this.personId = personId;
        this.father = father;
        this.mother = mother;
        this.sons = sons;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getSons() {
        return sons;
    }

    public void setSons(String sons) {
        this.sons = sons;
    }

    @Override
    public String toString() {
        return "\nFAMILIA: " +
                "\n IdPersona: " + personId + "\n Padre: " + father + "\n Madre: " + mother + "\n Hijos: " + sons;
    }
}
