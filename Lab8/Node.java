/*
Nguyen, Abram - Lab 8 [Due: Monday, November 19, 7:00 AM]

    This node class is used as the elements of my GenericStack
*/
public class Node {
    Object exprItem;
    Node next;

    Node(Object exprItem, Node next){
        this.exprItem=exprItem;
        this.next=next;
    }

    public double getItemInfo() {
        return (double)exprItem;
    }
}