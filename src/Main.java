import controllers.PersonController;
import models.Family;
import models.Person;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Edwin Niño
 */

public class Main {
    
    PersonController personController = new PersonController();
    Scanner scanner = new Scanner(System.in);
    String banner = "__________________________________________________________________________________________________\n" +
                    " ________________________________________________________________________________________________\n" +
                    "|                                    ________________________                     [ManagePeople®]|\n" +
                    "|---------------------------------- | MANAGE PEOPLE -API WEB | ----------------------------------|\n" +
                    "|________________________________________________________________________________________________|\n" +
                    "__________________________________________________________________________________________________";
    String mainMenu = " ________________________________________________________________________________________________\n" +
                      "|                                        ________________                                        |\n" +
                      "|-------------------------------------- | MENÚ PRINCIPAL | --------------------------------------|\n" +
                      "|________________________________________________________________________________________________|\n" +
                      " ________________________________________________________________________________________________\n" +
                      "|                         [--->] 1. Registrar persona nueva------------>(1)                      |\n" +
                      "|                         [--->] 2. Actualizar información de persona-->(2)                      |\n" +
                      "|                         [--->] 3. Obtener personas registradas------->(3)                      |\n" +
                      "|                         [--->] 4. Obtener a persona registrada------->(4)                      |\n" +
                      "|                         [--->] 5. Remover persona del sistema-------->(5)                      |\n" +
                      "|                         [--->] 6. Agregar familia a una persona------>(6)                      |\n" +
                      "|                         [--->] 7. Actualizar familia de una persona-->(7)                      |\n" +
                      "|                         [--->] 8. Obtener familia de una persona(ID)->(8)                      |\n" +
                      "|                         [--->] 9. Remover familia de una persona----->(9)                      |\n" +
                      "|                         [--->] 0. Cerrar el programa----------------->(0)                     |\n" +
                      "|________________________________________________________________________________________________|";
    String formatOption = "__________________________________________________________________________________________________";
    String format1 =      " ________________________________________________________________________________________________ ";
    String format2 =      "|________________________________________________________________________________________________|";
    String closeSucccessfully = " EL PROGRAMA SE HA CERRADO EXITOSAMENTE...";
    String optionMenuError = " SELECCIONE UNA OPCION QUE SE ENCUENTRE EN EL MENU...";

    public Main(){
        run();
    }
    
    public void run() {
        int optionMenu=0;
        System.out.println(banner);
        do {
            System.out.println(mainMenu);
            try{
                System.out.println(formatOption);
                optionMenu = Integer.parseInt(scanner.nextLine());
                System.out.println(formatOption);
            }
            catch(NumberFormatException ignored){
            }

            switch (optionMenu) {
                case 1 -> createPerson();
                case 2 -> updatePerson();
                case 3 -> getPeople();
                case 4 -> getPerson();
                case 5 -> removePersonById();
                case 6 -> createFamilyPerson();
                case 7 -> updateFamilyPerson();
                case 8 -> getFamilyPerson();
                case 9 -> removeFamilyPerson();
                case 0 -> {
                    System.out.println(formatOption);
                    System.out.println(closeSucccessfully);
                    System.out.println(formatOption);
                }
                default -> {
                    System.out.println(formatOption);
                    System.out.println(optionMenuError);
                    System.out.println(formatOption);
                    backToMenu();
                }
            }
        }while(optionMenu != 0);
    }

    public void createPerson(){
        System.out.println( " Ingrese el nombre: ");
        String name = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println( " Ingrese el apellido: ");
        String surname = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println( " Ingrese el número de teléfono: ");
        String numberPhone = scanner.nextLine();
        System.out.println(formatOption);
        personController.createPerson(personController.personToJson(new Person(name,surname,numberPhone)));
        System.out.println(formatOption);
        System.out.println(" LA INFORMACIÓN DE LA NUEVA PERSONA SE HA REGISTRADO CORRECTAMENTE");
        backToMenu();
    }


    public void updatePerson() {
        personController.getPeople();
        System.out.println(formatOption);
        int id = 0;
        try {
            System.out.println( " Ingrese el ID de la persona a actualizar información: ");
            id = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        System.out.println( " Ingrese el nombre: ");
        String name = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println( " Ingrese el apellido: ");
        String surname = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println( " Ingrese el número de teléfono: ");
        String numberPhone = scanner.nextLine();
        System.out.println(formatOption);
        personController.updatePerson(id,personController.personToJson(new Person(name,surname,numberPhone)));
        System.out.println(formatOption);
        System.out.println(" LA INFORMACIÓN DE LA PERSONA SE HA ACTUALIZADO CORRECTAMENTE");
        backToMenu();
    }

    public void getPeople(){
        personController.getPeople();
        backToMenu();
    }

    public void getPerson(){
        personController.getPeople();
        System.out.println(formatOption);
        int id = 0;
        try {
            System.out.println( " Ingrese el ID de la persona registrada en el sistema:");
            id = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        personController.getPerson(id);
        backToMenu();
    }

    public void removePersonById(){
        personController.getPeople();
        System.out.println(formatOption);
        int id = 0;
        try {
            System.out.println( " Ingrese el ID de la persona a remover del sistema:");
            id = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        personController.deletePerson(id);
        System.out.println(formatOption);
        System.out.println(" LA PERSONA SE HA REMOVIDO DEL SISTEMA EXITOSAMENTE");
        backToMenu();
    }

    public void createFamilyPerson(){
        personController.getPeople();
        System.out.println(formatOption);
        int personId = 0;
        try {
            System.out.println( " Ingrese el ID de la persona a agregar familia: ");
            personId = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        System.out.println( " Ingrese el nombre completo del padre: ");
        String father = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println( " Ingrese el nombre completo de la madre: ");
        String mother = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println(" Ingrese el número de hijos de la persona: ");
        int numberSons=scanner.nextInt();
        scanner.skip("\n");
        StringBuilder sons= new StringBuilder();
        for (int i=0; i<numberSons; i++){
            System.out.println(formatOption);
            System.out.println( "Ingrese el nombre del hijo: ");
            sons.append(scanner.nextLine()).append(",");
        }
        System.out.println(formatOption);
        personController.createFamilyPerson(personId, personController.familyToJson(new Family(personId,father,mother, sons.toString())));
        System.out.println(" LA FAMILIA DE LA PERSONA SE HA REGISTRADO CORRECTAMENTE");
        backToMenu();
    }

    public void updateFamilyPerson(){
        personController.getPeople();
        System.out.println(formatOption);
        int personId = 0;
        try {
            System.out.println( " Ingrese el ID de la persona a actualizar familia: ");
            personId = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        personController.getFamilyPerson(personId);
        System.out.println(formatOption);
        int id = 0;
        try {
            System.out.println( " Ingrese el ID de registro de la familia a actualizar informacion: ");
            id = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        System.out.println( " Ingrese el nombre completo del padre: ");
        String father = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println( " Ingrese el nombre completo de la madre: ");
        String mother = scanner.nextLine();
        System.out.println(formatOption);
        System.out.println(" Ingrese el número de hijos de la persona: ");
        int numberSons=scanner.nextInt();
        scanner.skip("\n");
        StringBuilder sons= new StringBuilder();
        for (int i=0; i<numberSons; i++){
            System.out.println(formatOption);
            System.out.println( "Ingrese el nombre del hijo: ");
            sons.append(scanner.nextLine()).append(",");
        }
        System.out.println(formatOption);
        personController.updateFamilyPerson(personId,personController.familyToJson(new Family(personId,father,mother, sons.toString())),id);
        backToMenu();
        System.out.println(" LA FAMILIA DE LA PERSONA SE HA ACTUALIZADO CORRECTAMENTE");
    }

    public void getFamilyPerson(){
        personController.getPeople();
        System.out.println(formatOption);
        int personId = 0;
        try {
            System.out.println( " Ingrese el ID de la persona a obtener su familia:");
            personId = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        personController.getFamilyPerson(personId);
        backToMenu();
    }

    public void removeFamilyPerson(){
        personController.getPeople();
        System.out.println(formatOption);
        int personId = 0;
        try {
            System.out.println( " Ingrese el ID de la persona a remover familia: ");
            personId = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        personController.getFamilyPerson(personId);
        System.out.println(formatOption);
        int id = 0;
        try {
            System.out.println( " Ingrese el ID de registro de la familia a remover del sistema: ");
            id = scanner.nextInt();
            scanner.skip("\n");
        }
        catch (InputMismatchException e) {
            System.out.println(formatOption);
            System.out.println(" ID INGRESADO INVÁLIDO...");
            System.out.println(formatOption);
            return;
        }
        System.out.println(formatOption);
        personController.deleteFamilyPerson(personId,id);
        System.out.println(formatOption);
        System.out.println(" LA FAMILIA DE LA PERSONA SE HA REMOVIDO EXITOSAMENTE");
        backToMenu();
    }

    public void backToMenu(){
        System.out.println(formatOption);
        System.out.println( " <PRESIONE CUALQUIER TECLA PARA REGRESAR AL MENÚ>");
        scanner.nextLine();
        System.out.println(formatOption);
    }

    public void pressContinue(){
        System.out.println(formatOption);
        System.out.println( " <PRESIONE CUALQUIER TECLA PARA CONTINUAR> ");
        scanner.nextLine();
        System.out.println(formatOption);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
    
}
