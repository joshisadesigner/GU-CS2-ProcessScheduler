/* ProcessStack.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler;

import scheduler.processing.SimpleProcess;
import java.util.Stack;

public class ProcessStack {
    private Stack<SimpleProcess> stack;

    public ProcessStack() {
        this.stack = new Stack<>();
    }

    public void push(SimpleProcess process) {
        stack.push(process);
    }

    public SimpleProcess pop() {
        return stack.pop();
    }

    public SimpleProcess peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
