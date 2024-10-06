package gestionbibliotecas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GestionBibliotecas {

 public static void main(String[] args) {
        
//Declaration Variables
Scanner entrada = new Scanner(System.in);

//Data Structures Used
//ArrayList<String> createUsers = new ArrayList<String>();
ArrayList<String> createBooks = new ArrayList<String>();
Stack<String> requestBooks = new Stack<>();
Queue<String> turnBooks = new LinkedList<>();
LinkedList<String> createUsers = new LinkedList<String>();
   
// User Input
int userEntrance = 7;
     
do{   
    //Frontend
    System.out.println("+----------------------------+");
    System.out.println("|   BOOKS MANAGEMENT STORE   |");
    System.out.println("+----------------------------+");
    System.out.println("       Mateo Henao Correa    ");
    System.out.println("         by @Mateozzzz        ");
    System.out.println("[+] [1] Creacion de Usuario");
    System.out.println("[+] [2] Ingreso Libros");
    System.out.println("[+] [3] Mostrar Todos Libros");
    System.out.println("[+] [4] Mostar Todos Usuario");
    System.out.println("[+] [5] Peticion Prestamos");
    System.out.println("[+] [6] Devolucion Libros");
    System.out.println("[+] [7] Salir                  ");
    System.out.println("                               ");
    System.out.printf ("Ingrese su Opcion ==> ");
    

//User Option and Switch Cases
 int userOption = entrada.nextInt();

 switch(userOption){
    case 1:
        if(createUsers.isEmpty()){
            System.out.println("No hay usuarios registrados");}
        // Add Users
        entrada.nextLine();
        System.out.printf("Ingrese su Cedula ==> ");
        String idUser = entrada.nextLine();
        if(createUsers.contains(idUser)){ 
            System.out.println("! Usuario regitrado en Sistema !");          
            break;}
        else{createUsers.add(0,idUser);}
        // Duplicate Users
        System.out.printf("Ingrese Su Nombre ==> ");              
        String nameUser = entrada.nextLine();
        if(createUsers.contains(nameUser)){         
            System.out.println("! Nombre Registrado en Sistema !");            
            break;}else{createUsers.add(1,nameUser);}
        // Show Users
        System.out.println("Usuario creado Exitosamente!! "+createUsers);
        break;
    case 2:
        entrada.nextLine();
        //Add New Book
        System.out.printf("Ingrese Codigo Libro ==> ");
        String bookIsb = entrada.nextLine();
        if(createBooks.contains(bookIsb)){
            System.out.printf("! El libro ya esta en el Sistema !");
            break;}
        else{createBooks.add(bookIsb);}
        // Duplicate Books
        System.out.printf("Ingrese el titulo de su libro ==> ");              
        String bookTitule = entrada.nextLine();
        if(createBooks.contains(bookTitule)){
            System.out.printf("! Titulo Invalido !");                  
            break;}
        else{createBooks.add(bookTitule);}
        //Show Books   
        System.out.println("Libro Agregado Exitosamente ! "+createBooks);
        break;
    case 3:
        if(createBooks.isEmpty()){
            System.out.println("! No hay libros en la estanteria !");}
        // Add Books
        System.out.printf("| %-5s | %-5s |%n","Codigo","Titulo");
        System.out.println(createBooks);
        /*
        Add Delete Users Feature
        */           
        break;
    case 4:
        if(createUsers.isEmpty()){
            System.out.println("! No hay Usuarios registrados !");}
        // Show Users
        System.out.printf("| %-5s | %-5s |%n","Cedula","Nombre");
        System.out.println(createUsers);
        /*
        Add Delete Book Feature
        */
        break;
    case 5:
        if(requestBooks.empty()){
            System.out.println("No se encuentran Peticiones registradas");}        
        // Add Request
        entrada.nextLine();
        System.out.printf("Ingresa tu Usuario ==> ");
        String requestUser = entrada.nextLine();
        System.out.printf("Ingresa el Codigo del Libro ==> ");
        String requestBook = entrada.nextLine();
        
        if(createUsers.contains(requestUser)&&
                createBooks.contains(requestBook)){                             
        // Delete from Books
   
        createBooks.remove(requestBook);
        createBooks.add(0, "En Prestamo");
        //createBooks.remove(requestBook);
        // Add to ReuqestBooks
        requestBooks.push(requestUser+requestBook);
        //requestBooks.push(requestBook);
        System.out.println("El Prestamo ha sido cargado ");
        System.out.print(requestBooks.peek());}
        // Repeat Book is not there and ww nee quit title of book
        else{System.out.println("! Usuario o Libro no encontrados !");}
        break;  
    case 6:
        if(turnBooks.isEmpty()){
            System.out.println("Actualmente no se tiene Devoluciones");
            // Add Return Book
            entrada.nextLine();
            System.out.printf("Ingrese codigo del libro a devolver ==> ");
            String loadBook = entrada.nextLine();
            System.out.printf("Ingrese usuario de la devolucion ==> ");
            String loadUser = entrada.nextLine();
            // Duplicate Books
            if(requestBooks.contains(loadBook)&&
                    requestBooks.contains(loadUser)){
            // Remove From request
            requestBooks.remove(loadBook);
            requestBooks.remove(loadUser);
            //add to Array
            createBooks.set(0,loadBook);
            System.out.println("El Libro ha sido añadido exitosamente");
            System.out.println(turnBooks.peek());
            }else{System.out.println("Usuario o Libro no encontrados");} 
        }
        break;
    case 7:
        break;
    default:System.out.println("Opcion Invalida, Escoga Nuevamente.");
 }  
    }while(userEntrance != 0);

}
    
}   
