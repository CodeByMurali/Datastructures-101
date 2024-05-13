package DataStructures.Queue;

import java.util.Stack;

    public class StackQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        // O(1)
        public void enqueue(int item) {

            stack1.push(item);
        }

        // O(n)
        public int dequeue() {
            if (isEmpty())
                throw new IllegalStateException();

            moveStack1ToStack2();

            return stack2.pop();
        }

        private void moveStack1ToStack2() {
//             When ever second stack is empty move items form second stack to first stack
//            Need to check if the stack2 is empty as pushing the elements into stack 2 without it being empty
//            will mess up the order of the items
            if (stack2.isEmpty())
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
        }

        public int peek() {
            if (isEmpty())
                throw new IllegalStateException();

            moveStack1ToStack2();

            return stack2.peek();
        }

        public boolean isEmpty() {

            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

