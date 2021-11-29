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
        backToMenu();
    }


    public void updatePerson(){
        System.out.println( " Ingrese el ID de la persona a actualizar informacion: ");
        int id = scanner.nextInt();
        scanner.skip("\n");
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
        backToMenu();
    }

    public void getPeople(){
        personController.getPeople();
        backToMenu();
    }

    public void getPerson(){
        System.out.println( " Ingrese el ID de la persona registrada en el sistema:");
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(formatOption);
        personController.getPerson(id);
        backToMenu();
    }

    public void removePersonById(){
        System.out.println( " Ingrese el ID de la persona a remover del sistema:");
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(formatOption);
        personController.deletePerson(id);
        backToMenu();
    }

    public void createFamilyPerson(){
        System.out.println( " Ingrese el ID de la persona a agregar familia: ");
        int personId = scanner.nextInt();
        scanner.skip("\n");
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
        String sons="";
        for (int i=0; i<numberSons; i++){
            System.out.println(formatOption);
            System.out.println( "Ingrese el nombre del hijo: ");
            sons += scanner.nextLine() + ",";
        }
        System.out.println(formatOption);
        personController.createFamilyPerson(personId, personController.familyToJson(new Family(personId,father,mother,sons)));
        backToMenu();
    }

    public void updateFamilyPerson(){
        System.out.println( " Ingrese el ID de la persona a actualizar informacion: ");
        int personId = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(formatOption);
        personController.getFamilyPerson(personId);
        System.out.println(formatOption);
        System.out.println( " Ingrese el ID del registro de la familia a actualizar informacion: ");
        int id = scanner.nextInt();
        scanner.skip("\n");
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
        String sons="";
        for (int i=0; i<numberSons; i++){
            System.out.println(formatOption);
            System.out.println( "Ingrese el nombre del hijo: ");
            sons += scanner.nextLine() + ",";
        }
        System.out.println(formatOption);
        personController.updateFamilyPerson(personId,personController.familyToJson(new Family(personId,father,mother,sons)),id);
        backToMenu();
    }

    public void getFamilyPerson(){
        System.out.println( " Ingrese el ID de la persona registrada en el sistema:");
        int personId = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(formatOption);
        personController.getFamilyPerson(personId);
        backToMenu();
    }

    public void removeFamilyPerson(){
        System.out.println( " Ingrese el ID de la persona a remover del sistema: ");
        int personId = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(formatOption);
        personController.getFamilyPerson(personId);
        System.out.println(formatOption);
        System.out.println( " Ingrese el ID de registro de la familia a remover del sistema: ");
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(formatOption);
        personController.deleteFamilyPerson(personId,id);
        backToMenu();
    }

    public void backToMenu(){
        System.out.println(formatOption);
        System.out.println( "<PRESIONE CUALQUIER TECLA PARA REGRESAR AL MENÚ>");
        scanner.nextLine();
        System.out.println(formatOption);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
    
}
