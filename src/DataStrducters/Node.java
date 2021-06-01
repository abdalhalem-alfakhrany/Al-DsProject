package DataStrducters;

import models.Contact;

public class Node {
    Node next, previous;
    Object data;

    public Node(Contact data) {
        this.data = data;
    }

    @Override
    public String toString() {
        Contact data = (Contact) this.data;
        if (data == null)
            return "";
        return String.format("( name : %s , phone number : %s )", data.getName(), data.getPhNumber());
    }
}
