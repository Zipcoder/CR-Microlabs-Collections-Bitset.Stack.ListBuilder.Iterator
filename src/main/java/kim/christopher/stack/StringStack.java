package kim.christopher.stack;

import java.util.LinkedList;

public class StringStack {

    LinkedList<String> stack;

    public StringStack() {
        stack = new LinkedList<>();
    }

    public void push(String input){
        stack.push(input);
    }

    public String pop(){
        return stack.pop();
    }

    public String peek(){
        return stack.peek();
    }
}
