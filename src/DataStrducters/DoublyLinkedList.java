package DataStrducters;

import enums.SearchType;
import models.Contact;

public class DoublyLinkedList {
    public Node head, tail;
    public int size = 0;

    public void add(Node node) {

        if (head == null) {
            head = tail = node;
            size++;
            return;
        }

        tail.setNext(node);
        node.setPrevious(tail);
        tail = node;
        size++;

    }

    public void remove(Node nodeToDelet) {

        if (nodeToDelet == head) {
            head.getNext().setPrevious(null);
            head = head.getNext();
            return;
        }

        if (nodeToDelet == tail) {
            tail.getPrevious().setNext(null);
            tail.setPrevious(tail);
            return;
        }

        Node node = searchWith(SearchType.node, nodeToDelet);
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());

    }

    public Node searchWith(SearchType type, Object data) {

        if (type == SearchType.name) {
            for (Node node = head; node != null; node = node.getNext()) {
                Contact contact = (Contact) node.data;
                if (contact.getName() == (String) data) {
                    return node;
                }
            }
        } else if (type == SearchType.phNumber) {
            for (Node node = head; node != null; node = node.getNext()) {
                Contact contact = (Contact) node.data;
                if (contact.getPhNumber() == (String) data) {
                    return node;
                }
            }
        } else if (type == SearchType.node) {
            for (Node node = head; node != null; node = node.getNext()) {
                if (node == (Node) data) {
                    return node;
                }
            }
        } else if (type == SearchType.contact) {
            for (Node node = head; node != null; node = node.getNext()) {
                if (node.data == (Contact) data) {
                    return node;
                }
            }
        }

        return null;

    }

    public void update(Node nodeToUpdata, Node newNode) {
        Node node = searchWith(SearchType.node, newNode);
        node.data = newNode.data;
    }

    public void sort() {
        for (Node node = head; node != null; node = node.getNext()) {

            for (Node node2 = node.getNext(); node2 != null; node2 = node2.getNext()) {

                Contact nodeContact = (Contact) node.data;
                Contact node2Contact = (Contact) node2.data;

                char contact1NameFirstChar = nodeContact.getName().charAt(0);
                char contact2NameFirstChar = node2Contact.getName().charAt(0);

                if (contact1NameFirstChar > contact2NameFirstChar) {

                    Object tmp = node.data;

                    node.data = node2.data;
                    node2.data = tmp;

                }

            }
        }
    }

    @Override
    public String toString() {
        String ret = "";
        for (Node node = head; node != null; node = node.getNext()) {
            ret += node + "\n";
        }
        return ret;
    }
}
