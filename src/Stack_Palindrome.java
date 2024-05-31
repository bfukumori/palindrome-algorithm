import java.util.Scanner;

public class Stack_Palindrome {
    private static class Node {
        public char data;
        public Node next;
    }

    private static class Return {
        public char item;
        public boolean ok;
    }

    private static Node top;

    public void init() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = top;
        top = newNode;
    }

    public Return pop() {
        Return output = new Return();

        if (!isEmpty()) {
            output.item = top.data;
            top = top.next;
            output.ok = true;
        } else {
            output.ok = false;
        }
        return output;
    }

    public Return top() {
        Return output = new Return();
        if (!isEmpty()) {
            output.item = top.data;
            output.ok = true;
        } else {
            output.ok = false;
        }
        return output;
    }

    public static void main (String[] args) {
        Stack_Palindrome stack = new Stack_Palindrome();
        Return res = new Return();
        Scanner input = new Scanner(System.in);

        String word;
        boolean isPalindrome = true;

        stack.init();

        System.out.println("Escreva uma palavra: ");
        word= input.next();

        for (int i =0; i<word.length();i++) {
            stack.push(word.charAt(i));
        }

        for (int i =0; i<word.length();i++) {
            res = stack.pop();

            if(res.item!=word.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " é um palíndromo.");
        } else {
            System.out.println(word + " não é um palíndromo.");
        }
        input.close();
    }
}
