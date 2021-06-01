import java.util.Scanner;

import javax.swing.JFrame;

import DataStrducters.DoublyLinkedList;
import DataStrducters.Node;
import enums.SearchType;
import models.Contact;

public class App extends JFrame {
    static Scanner s = new Scanner(System.in);
    static DoublyLinkedList list = new DoublyLinkedList();

    public static void main(String[] args) {
        Contact[] contacts = new Contact[] { new Contact("bdr", "4288"), new Contact("dalia", "8237"),
                new Contact("fathi", "1238"), new Contact("eman", "8429"), new Contact("ahmed", "6429"),
                new Contact("hisham", "3490"), };
        for (int i = 0; i < contacts.length; i++) {
            list.add(new Node(contacts[i]));
        }
        start();
    }

    static void start() {
        String[] operations = { "create contact", "list  contacts ", "update contact", "remove contact ", "srarch ",
                "sort" };
        clear();

        for (int i = 0; i < operations.length; i++) {
            System.out.println(String.format(" %s- %s", i + 1, operations[i]));
        }
        System.out.print(":");
        String operation = s.next();

        if (operation.equals("1")) {
            clear();
            createContact();
        } else if (operation.equals("2")) {
            clear();
            listAllContact();
        } else if (operation.equals("3")) {
            clear();
            updataContact();
        } else if (operation.equals("4")) {
            clear();
            removeContact();
        } else if (operation.equals("5")) {
            clear();
            search();
        } else if (operation.equals("6")) {
            clear();
            sort();
        }
        System.out.println("1 - another operations\n2 - exit");
        System.out.print(":");
        String dessesion = s.next();
        System.out.println();

        if (dessesion.equals("1")) {
            start();
        } else {
            return;
        }
    }

    private static void sort() {
        list.sort();
    }

    private static void search() {
        System.out.println(" 1- srearch with name ");
        System.out.println(" 1- srearch with phone number ");
        System.out.print(":");

        String operation = s.next();
        if (operation.equals("1")) {
            clear();
            System.out.println("enter cotntact name : ");
            String name = s.next();
            System.out.println();
            Node contact = list.searchWith(SearchType.name, name);
            if (contact == null) {
                System.out.println("thier is no contact with this name ");
                clear();
                return;
            } else {
                System.out.println(contact);
                return;
            }
        } else if (operation.equals("2")) {
            clear();
            System.out.println("enter cotntact phone number : ");
            String phNumber = s.next();
            System.out.println();
            Node contact = list.searchWith(SearchType.phNumber, phNumber);
            if (contact == null) {
                System.out.println("thier is no contact with this phonr number ");
                clear();
                return;
            } else {
                System.out.println(contact);
                return;
            }
        }
    }

    private static void removeContact() {
        System.out.println("enter cotntact name : ");
        String name = s.next();
        System.out.println();
        Node contact = list.searchWith(SearchType.name, name);
        if (contact == null) {
            System.out.println("thier is no contact with this name ");
            clear();
            updataContact();
            return;
        }
        list.remove(contact);
    }

    private static void updataContact() {
        System.out.println("enter cotntact name : ");
        String name = s.next();
        System.out.println();
        Node contact = list.searchWith(SearchType.name, name);
        if (contact == null) {
            System.out.println("thier is no contact with this name ");
            clear();
            updataContact();
            return;
        }

        System.out.print("enter name :");
        name = s.next();
        System.out.println();

        System.out.print("enter phonr number :");
        String phNumber = s.next();
        System.out.println();

        list.update(contact, new Node(new Contact(name, phNumber)));
    }

    private static void createContact() {
        System.out.print("enter name :");
        String name = s.next();
        System.out.println();

        System.out.print("enter phonr number :");
        String phNumber = s.next();
        System.out.println();

        list.add(new Node(new Contact(name, phNumber)));
    }

    private static void listAllContact() {
        for (Node node = list.head; node != null; node = node.getNext()) {
            System.out.println(node);
        }
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
