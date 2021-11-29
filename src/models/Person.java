package models;

/**
 *
 * @author Edwin Niño
 */

public class Person{

    private String name;
    private String surname;
    private String numberPhone;

    public Person(String name, String surname, String numberPhone) {
        this.name = name;
        this.surname = surname;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "\nPERSONA: " +
                "\n Nombre: " + name + "\n Apellido: " + surname + "\n Numero celular: " + numberPhone;
    }

}