/*      

    Nguyen, Abram - Lab 6 [Due: Friday, November 2, 11:59 PM]

        OPERATIONS
        1) Write a method named "getRandString(int length)" that will return a String of
            length given in the parameter. This method need not be a recursive one. 
            The returned String may only contain English letters in capital (that is, letters from A to Z).
        2) Write a recursive method named "printMyList(StringNode m)" to print all the
            strings in the linked list m. Notice that m is the head of the linked list.
        3) Write a recursive method named "countKLengthStrings (StringNode m, int k)" 
            that will return number of Strings with length k in the given linked list m.
        4) Write a recursive method named "longestStringOfMyList (StringNode m)"
            that will return the longest String in a linked list.
        5) Write a recursive method named "lengthOfMyList (StringNode m)" that will
            compute and return the length of a given linked list m.
        6) Write a recursive method named "StringNode reverseMyList (StringNode m)" to 
            reverse a linked list. Return the head of the reversed linked list.
        7) Write a recursive method named 
            "StringNode removeAStringFromMyList(StringNode m, String removee)" 
            to remove the first occurrence of removee from a given linked list m.
        8) Write a recursive method named 
            "StringNode insertAStringIntoMyList(StringNode m, String insertee, int position)"
            to insert a String (insertee) into a specific position of a given linked list m. Positions start
            from 0 (that is, the position of the head of a list is considered 0).
        9) Write a recursive method named
            "boolean isListInOrder(StringNode m)""
            to verify if the strings in a linked list m are lexicographically ordered. 
            Return true if they are ordered, false otherwise.
        10) Write a recursive method named
            "int countPalindromes(StringNode m)"
            that will count how many strings of a given linked list are palindromes. 
            The method must call another recursive method named
            "boolean isPalindrome(String s)"" to verify if a String is a palindrome. 
            Palindrome check must NOT be case-sensitive. 
        
*/

public class Operations {
    public static void main(String[] args){
        StringNode L = new StringNode("0"+getRandString(2+(int)(Math.random()*5)));
        StringNode temp = L;
        
        for (int i=1; i<=9;i++){
            temp.next=new StringNode(i+getRandString(2+(int)(Math.random()*5)));
            temp=temp.next;
        }
        
        System.out.println("All Strings in the list:");
        printMyList(L);
        System.out.println();
        
        boolean b = isListInOrder(L);
        System.out.println("List is ordered: "+b);
        System.out.println();

        System.out.println("Count of k-length strings");
        System.out.println("k\tNo. of Strings with length k");
        for (int k=0; k<7; k++){
            System.out.println(k+"\t"+countKLengthStrings(L, k));
        }

        System.out.println("Longest String="+longestStringOfMyList(L));
        System.out.println("Length="+lengthOfMyList(L));
        
        L=reverseMyList(L);
        System.out.println("All string in the reversed list:");
        printMyList(L);
        System.out.println();
    
        System.out.println("Remove a given String");
        StringNode LL=removeAStringFromMyList(L, L.next.next.head);

        System.out.println("All strings in the new list:");
        printMyList(LL);
        System.out.println();

        System.out.println("All strings in the previous list:");
        printMyList(L);
        System.out.println();
        
        System.out.println("Insert a string in a position of the new list:");
        LL=insertAStringIntoMyList(LL, "Hello world", 3);
        printMyList(LL);
        System.out.println();
        
        b = isListInOrder(L);
        System.out.println("List is ordered: "+b);
        System.out.println();
        
        LL=insertAStringIntoMyList(LL, "ABBA", 3);
        LL=insertAStringIntoMyList(LL, "DoGeeseSeeGod", 3);

        int c = countPalindromes(LL);
        System.out.println("Found "+c+" palindromes.");
    }
   
    /* Return a string made up of random uppercase letters. 
    The length of a word depends on the given parameter 'length'.
    */
    static String getRandString(int length) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //letters to choose from randomly
        String S = "";
        while (length != 0) {
            S = S + alpha.charAt((int)(Math.random()*26)); //concatenate random letters
            length--;
        } 
        return S;
    }
   

    /* Write a recursive method to print all the strings in separate lines.
    This method cannot contain any loop (that is, uses of for, while, do while
    are prohibited).
    */
    public static void printMyList(StringNode m){
        if (m == null)  //until the end of the list...
            return;
        System.out.println(m.head);
        printMyList(m.next);
    }


    /* Write a recursive method to retrieve the number of strings that are longer
    than the length provided in the parameter. This method cannot contain any
    loop (that is, uses of for, while, do while are prohibited).
    */
    public static int countKLengthStrings (StringNode m, int k) {
        if (m == null)
            return 0; 
        //if a string's length is greater than k...
        if (m.head.length() > k+1)
            return 1 + countKLengthStrings(m.next, k);//...1 + the rest of the list

        return countKLengthStrings(m.next, k);
    }


    /* Write a recursive method to retrieve the largest String from the list.
    Assume that there is at least one String in the given list when the method
    is called from the main function. This method cannot contain any loop (that
    is, uses of for, while, do while are prohibited).
    */
    public static String longestStringOfMyList (StringNode m){
        if (m.next == null)
            return m.head;
        //declaring a variable to return, check the REST of the list for a longer string
        String longest = longestStringOfMyList(m.next);
        //compare the length of longest to the current string's length
	    if (longest.length() > m.head.length()) 
            return longest; 
	    else return m.head;
    }
   

    /* Write a recursive method to compute the length of a list.
    This method cannot contain any loop (that is, uses of for, while, do while
    are prohibited).
    */
    public static int lengthOfMyList (StringNode m){
        if (m == null)
            return 0;
        //return 1 + count the rest of the list
        else return 1 + lengthOfMyList(m.next);
    } 
      
    
    /* Write a recursive method named reverseMyList that will reverse a given
    linked list m. Return the head of the reversed linked list. It is fine
    if you need to modify the given linked list to obtain the reversed one.
    */
    public static StringNode reverseMyList (StringNode m){
        if(m == null || m.next == null)
            return m;
        
        //leaving "space" for reversal
        StringNode temp = m.next;
        m.next = null;

        //r will be the head of the reversed list
        StringNode r = reverseMyList(temp);
        temp.next = m;  //reversal, moving an element up one spot
        return r;   //Return the list, now reversed
    }   
    

    /* Write a recursive method to remove the first occurrence of a specific
    String from a list. As an example, if your list initially contains
    AA BB CC DD BB KK and if your removee is BB, the returned list should contain
    AA CC DD BB KK after the removal. Return a new head. You must make sure that
    the parameter list m remains intact after returning the new list to the main
    method. This method cannot contain any loop (that is, uses of for, while,
    do-while are prohibited).
    */
    public static StringNode removeAStringFromMyList(StringNode m, String removee){
        //if the first node is null, just return it
        if (m == null)
            return m;
        //if the first node contains the removee, return the rest of the list after it
        if (m.head == removee) 
            return m.next;    
        //Create a NEW list, the same but w/out the removee's node
        //Take advantage of m.next, using m=m.next.next will delete more than 1 node
        StringNode t = new StringNode(m.head, removeAStringFromMyList(m.next, removee));
        return t; //the old string, m, is unedited
    }


    /* Write a recursive method to insert a String (insertee) into a specific
    position of a list. Positions start from 0 (that is, the position of
    the head of a list is 0). This method cannot contain any loop (that is,
    uses of for, while, do-while are prohibited).
    */
    public static StringNode insertAStringIntoMyList(StringNode m, String insertee, int position){
        if (position == 0) {
            StringNode t = new StringNode(insertee);    //temp/insertion node filled with insertee String
            t.next = m;    //insert node t as the head of the list                          
            return t;      
        } else { 
            //iteration toward position (position eventually will be 0)
            //use recursion to avoid editing/breaking the list
            m.next = insertAStringIntoMyList(m.next, insertee, position-1);
            return m;
        }       
    }


    /* Write a recursive method to verify if the strings are
    lexicographically ordered in a linked list. Return true if they are
    ordered, false otherwise. This method cannot contain any loop (that is,
    uses of for, while, do-while are prohibited).
    */
    public static boolean isListInOrder(StringNode m){
        if (m == null)
           return true;
        //if the method compareTo() returns a negative...
        int compare = m.head.compareTo(m.next.head);
        //...it means that the first string > second string, so the list is NOT in order
        if(compare < 0) 
            return false;  
        else return isListInOrder(m.next);
    }


    /* Write a recursive method that will count how many strings of a given
    linked list are palindromes. The method must call another recursive
    method named isPalindrome to verify if a String is a palindrome, or
    not. Palindrome checks must NOT be case-sensitive. Neither countPalindromes
    nor isPalindrome may contain loops (that is, uses of for, while, do-while
    are prohibited).
    */
    public static int countPalindromes(StringNode m){
        if (m == null) 
            return 0;
        //calling isPalindrome method...
        if (isPalindrome(m.head)) {
            return 1 + countPalindromes(m.next); //1 + how many palindromes in the rest of the list
        }
        return countPalindromes(m.next);
    }


    /*Write a recursive method that checks to see if a word is palindromic or not. 
    Return true if it is a palindrome, return false if it isn't a palindrome.
    Use of loops is prohibited. NOT case-sensitive.
    */
    public static boolean isPalindrome(String s){
        //the string is automatically a palindrome if it is length 1 or 0
        if (s.length() == 1 || s.length() == 0) 
            return true;
        //compare the first and last characters of the string, NOT case-sensitive
        else if (s.toLowerCase().charAt(0) != s.toLowerCase().charAt(s.length()-1))
            return false;
        //continue with the second and second to last characters, otherwise
        else return isPalindrome(s.substring(1, s.length()-1));
    }
    
}