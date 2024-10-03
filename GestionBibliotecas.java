package gestionbibliotecas;

import java.util.ArrayList;
//import java.util.Arrays;

import java.util.Scanner;

public class GestionBibliotecas {

 public static void main(String[] args) {
        
//Declaration Variables
Scanner entrada = new Scanner(System.in);

//ArrayList For Users
ArrayList<String> createUsers = new ArrayList<>();
ArrayList<String> createBooks = new ArrayList<>();

       
        
        
    // User Input
    //System.out.println("[ + ] Presiona [1] para Iniciar...");
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
        System.out.println("                              ");
        System.out.println("Ingrese su Opcion ==> ");
        System.out.println("                              ");
        

//entrada.nextLine();

    //User Option
     int userOption = entrada.nextInt();
    
     switch(userOption){
        case 1:
            entrada.nextLine();
            System.out.println("Ingrese su Cedula ==> ");
            String idUser = entrada.nextLine();
            createUsers.add(idUser);
            System.out.println("Ingrese Su Nombre ==> ");
            String nameUser = entrada.nextLine();
            createUsers.add(nameUser);
            System.out.println("El Usuario "+nameUser+" con cedula "+idUser+
            " Ha sido creado Exitosamente ");
            //Equals
            
            break;
        case 2:
            entrada.nextLine();
            System.out.println("Ingrese Codigo Libro ==> ");
            String bookIsb = entrada.nextLine();
            createBooks.add(bookIsb);
            System.out.println("Ingrese Titulo Libro ==> ");
            String bookTitule = entrada.nextLine();
            createBooks.add(bookTitule);
            System.out.println("El Libro "+bookIsb+" con Codigo "+bookTitule+
            " Ha sido agregado");
  
            break;
        case 3:
            for (int i =0; i<createBooks.size(); i++){
                System.out.println(createBooks.get(i));}
            break;
        case 4:
            for (int i =0; i<createUsers.size(); i++){
                System.out.println(createUsers.get(i));}
        case 5:
            System.out.println("5");
            break;
        case 6:
            System.out.println("6");
        case 7:
            System.out.println("7");
            break;
        default:System.out.println("Opcion Inavalida,Escoga Nuevamente.");
            break;
     }  

        }while(userEntrance != 0);

 }
    
}   
