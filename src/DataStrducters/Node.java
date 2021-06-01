package DataStrducters;

import models.Contact;

public class Node {
    private Node next, previous;
    Object data;

    public Node(Contact data) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        Contact data = (Contact) this.data;
        if (data == null)
            return "";
        return String.format("( name : %s , phone number : %s )", data.getName(), data.getPhNumber());
    }
}
