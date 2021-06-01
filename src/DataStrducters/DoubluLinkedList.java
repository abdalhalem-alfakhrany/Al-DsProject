package DataStrducters;

import enums.SearchType;
import models.Contact;

public class DoubluLinkedList {
    Node head, tail;
    int size = 0;

    public void add(Node node) {

        if (head == null) {
            head = tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.previous = tail;
        tail = node;
        size++;

    }

    public void remove(Node nodeToDelet) {

        if (nodeToDelet == head) {
            head.next.previous = null;
            head = head.next;
            return;
        }

        if (nodeToDelet == tail) {
            tail.previous.next = null;
            tail.previous = tail;
            return;
        }

        Node node = searchWith(SearchType.node, nodeToDelet);
        node.previous.next = node.next;
        node.next.previous = node.previous;

    }

    public Node searchWith(SearchType type, Object data) {

        if (type == SearchType.name) {
            for (Node node = head; node != null; node = node.next) {
                Contact contact = (Contact) node.data;
                if (contact.getName() == (String) data) {
                    return node;
                }
            }
        } else if (type == SearchType.phNumber) {
            for (Node node = head; node != null; node = node.next) {
                Contact contact = (Contact) node.data;
                if (contact.getPhNumber() == (String) data) {
                    return node;
                }
            }
        } else if (type == SearchType.node) {
            for (Node node = head; node != null; node = node.next) {
                if (node == (Node) data) {
                    return node;
                }
            }
        } else if (type == SearchType.contact) {
            for (Node node = head; node != null; node = node.next) {
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
        for (Node node = head; node != null; node = node.next) {

            for (Node node2 = node.next; node2 != null; node2 = node2.next) {

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
        for (Node node = head; node != null; node = node.next) {
            ret += node + "\n";
        }
        return ret;
    }
}
