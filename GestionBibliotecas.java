
package gestionbibliotecas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class GestionBibliotecas {

// Creation User nodo
static class UserNode {
    int idUser;
    String nameUser;
    UserNode left;
    UserNode right;

    public UserNode(int idUser, String nameUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        left = null;
        right = null;
    }
}

//Creation Book Node
static class BookNode{
    String id;
    String name;
    String author;
    BookNode left;
    BookNode rigth;

    public BookNode(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }    
}

// Méthods for managment books
public static BookNode InsertBook(BookNode root,BookNode BookNew){
    if(root == null){
        return BookNew;}
    if(BookNew.id.compareTo(root.id)<0){
        root.left = InsertBook(root.left,BookNew);
    }
    else{root.rigth = InsertBook(root.rigth,BookNew);
    }
    return root;
}

public static boolean searchbook(BookNode node,String id){
 if(node == null){
     return false;
 }
 if(id.equals(node.id)){
     return true;
 }
 return id.compareTo(node.id)< 0 ? searchbook(node.left,id):
 searchbook(node.rigth,id);
}

public static BookNode deleteBook(BookNode node,String id){
    //Delete Book
    if(node == null){
        return null;
    }
    if(id.compareTo(node.id)<0){
        node.left = deleteBook(node.left,id);
    }
    else if(id.compareTo(node.id)>0){
        node.rigth = deleteBook(node.rigth,id);
    }
    else{
        if(node.left == null){
            return node.rigth;
        }if(node.rigth == null){
            return node.rigth;
        }
    }
    return node;
}

public static void showBooks(BookNode node){
    if(node != null){ 
        showBooks(node.left);
        System.out.printf("%10s %20s %20s%n", node.id,node.name,node.author);
        showBooks(node.rigth);
    }
}

//Méthods for managment Users
public static UserNode insertUser(UserNode root, UserNode newUser) {
    if (root == null) {
        return newUser;
    }
    if (newUser.idUser < root.idUser) {
        root.left = insertUser(root.left, newUser);
    } else {
        root.right = insertUser(root.right, newUser);
    }
    return root;
}

public static boolean searchUser(UserNode node, int idUser) {
    if (node == null) return false;
    if (idUser == node.idUser) return true;
    return idUser < node.idUser ? searchUser(node.left, idUser) : searchUser(node.right, idUser);
}

public static void showUsers(UserNode node) {
    if (node != null) {
        showUsers(node.left);
        System.out.printf("%10d %20s%n", node.idUser, node.nameUser);
        showUsers(node.right);
    }
}

public static UserNode deleteUser(UserNode root, int idUser) {
if (root == null) {
    return null;
}
if (idUser < root.idUser) {
    root.left = deleteUser(root.left, idUser);
} else if (idUser > root.idUser) {
    root.right = deleteUser(root.right, idUser);
} else {
    // if the root has one or two childs
    if (root.left == null) {
        return root.right;
    } else if (root.right == null) {
        return root.left;
    }

    //Search for min child right or sucesor
    UserNode successor = findMin(root.right);
    root.idUser = successor.idUser;
    root.nameUser = successor.nameUser;
    root.right = deleteUser(root.right, successor.idUser);
}
return root;
}

//Auxiliary Method for find the min child   
public static UserNode findMin(UserNode node) {
while (node.left != null) {
    node = node.left;
}
return node;
}


public static void main(String[] args){
    
Scanner in = new Scanner(System.in);

Queue<BookNode> loanQueue = new LinkedList<>();
Stack<BookNode> returnStack = new Stack<>();
BookNode rootBooks = null;
UserNode rootUser = null;

int userOption;

do{
//Frontend
System.out.println("   +------------------------ + ");
System.out.println("  /  BOOKS MANAGEMENT STORE /  ");
System.out.println(" +-------------------------+   ");
System.out.println("       Mateo Henao Correa     ");
System.out.println("         by @Mateozzzz        ");
System.out.println("[+] [1] Menu Libros");
System.out.println("[+] [2] Menu Usuarios");
System.out.println("[+] [3] Menu Prestamos");
System.out.println("[+] [4] Menu Devolucion");
System.out.println("[+] [5] Salir                 ");
System.out.println("                              ");
System.out.printf ("Ingrese su Opcion ==> ");
userOption = in.nextInt();

switch(userOption){
    case 1:
        int bookOption;
        //Menu Book
        do{
        System.out.println("[+] [1] Agregar Libros");
        System.out.println("[+] [2] Borrar Libros");
        System.out.println("[+] [3] Mostrar Libros");
        System.out.println("[+] [4] Salir");
        bookOption = in.nextInt();
        
        //Insert New Book
        if(bookOption == 1){
            //Insert Book
            in.nextLine();
            System.out.printf("Ingresa el codigo del Libro: ");
            String id = in.nextLine();
            System.out.printf("Ingresa el Nombre del Libro: ");
            String name = in.nextLine();
            System.out.printf("Ingresa el Author del Libro: ");
            String author = in.nextLine();
            //Creation New Node
            BookNode book = new BookNode(id,name,author);
            //Control If book Duplicate
            if(searchbook(rootBooks,id)){
                System.out.println("El Libro "+id+" ya existe");
            }else{              
            rootBooks = InsertBook(rootBooks,book);
            System.out.println("Libro Agregado en la Estanteria !!");}
        }
        //Delete Book
        else if(bookOption == 2){
            in.nextLine();
            System.out.printf("Ingrese El Libro a Eliminar: ");
            String BookDelete = in.nextLine();
            if(searchbook(rootBooks,BookDelete)){
                    rootBooks = deleteBook(rootBooks,BookDelete);
                    System.out.println("Libro eliminado de la Estanteria !");
        }else{System.out.println("El libro "+BookDelete+" no se pudo eliminar");
            }}     
        //Show Books
        if(bookOption == 3){
            System.out.println("    ***********************     ");
            System.out.println("    *   Available Books   *     ");
            System.out.println("    ***********************     ");
            System.out.printf("%10s %20s %20s%n","id","name","author");
            showBooks(rootBooks);}
        
        }while(bookOption != 4);
        break;
    case 2:
        //Menu Users
        int userMenuOption;
        do {
            System.out.println("[+] [1] Agregar Usuario");
            System.out.println("[+] [2] Mostrar Usuarios");
            System.out.println("[+] [3] Borrar Usuario");
            System.out.println("[+] [4] Salir");
            userMenuOption = in.nextInt();
            
            if (userMenuOption == 1) {
                
                System.out.print("Ingrese el ID del Usuario: ");
                int idUser = in.nextInt();
                in.nextLine(); // clean buffer
                System.out.print("Ingrese el nombre del Usuario: ");
                String nameUser = in.nextLine();
                //Create Node User
                UserNode newUser = new UserNode(idUser, nameUser);
                //Control if Duplicate User
                if (searchUser(rootUser, idUser)) {
                    System.out.println("El Usuario ya existe.");
                } else {
                    rootUser = insertUser(rootUser, newUser);
                    System.out.println("Usuario agregado.");
                }
            } 
            //Show Users
            else if (userMenuOption == 2) {
                System.out.println("       ************************** ");
                System.out.println("       *  USUARIOS REGISTRADOS  * ");
                System.out.println("       ************************** ");
                System.out.printf( "%10s %20s%n", "ID", "Nombre");
                showUsers(rootUser);
            }
            //Delete User
            else if (userMenuOption == 3) {
            System.out.print("Ingrese el ID del Usuario a eliminar: ");
            int idUserToDelete = in.nextInt();
            if (searchUser(rootUser, idUserToDelete)) {
                rootUser = deleteUser(rootUser, idUserToDelete);
                System.out.println("Usuario eliminado.");
            } else {
                System.out.println("Usuario no encontrado.");}
            }
            
        } while (userMenuOption != 4);
        break;
    case 3:
        int loanOption;
    do {
    System.out.println("[+] [1] Solicitar Préstamo");
    System.out.println("[+] [2] Mostrar Préstamos Pendientes");
    System.out.println("[+] [3] Salir");
    loanOption = in.nextInt();
    in.nextLine(); // limpiar buffer

    if (loanOption == 1) {
        System.out.print("Ingrese código del libro a solicitar préstamo: ");
        String loanBookId = in.nextLine();
        System.out.println("Ingrese Cedula a solicitar préstamo: ");
        int loanUserId = in.nextInt();
        if (searchbook(rootBooks,loanBookId)&&searchUser(rootUser,loanUserId)){
            BookNode bookToLoan = new BookNode(loanBookId,"", "");
            loanQueue.add(bookToLoan);
            rootBooks = deleteBook(rootBooks, loanBookId);
            System.out.println("Préstamo solicitado y libro eliminado.");
        } else {
            System.out.println("Libro no disponible para préstamo.");
        }
    } 
    else if (loanOption == 2) {
        System.out.println("Préstamos pendientes:");
        for (BookNode book : loanQueue) {
            System.out.println(String.format("Libro ID: "+book.id));
        }
    }
    } while (loanOption != 3);    
        break;
    case 4:
        int returnOption;
    do {
        System.out.println("[+] [1] Devolver Libro");
        System.out.println("[+] [2] Mostrar Devoluciones Recientes");
        System.out.println("[+] [3] Salir");
        returnOption = in.nextInt();
        in.nextLine(); // Clean buffer

        if (returnOption == 1) {
            System.out.print("Ingrese el código del libro a devolver: ");
            String returnBookId = in.nextLine();
            BookNode returnedBook = new BookNode(returnBookId, "", "");
            returnStack.push(returnedBook);
            System.out.println("Libro devuelto.");
        } else if (returnOption == 2) {
            System.out.println("Devoluciones recientes:");
            for (BookNode book : returnStack) {
                System.out.println("Libro ID: " + book.id);
            }
        }
    } while (returnOption != 3);
        break;
    case 5:
        System.out.println("Saliendo del sistema...");
        break;
    default:
        System.out.println("Opción inválida.");
//Option Menu
}
//Main Menu
    }while(userOption != 5);

//Main y Class
    }
}