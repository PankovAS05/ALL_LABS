import java.util.*;
public class Queue {
    public static void reverseQueue(Queue<Integer> L1, Queue<Integer> L2) {
        // Используем стек для инвертирования порядка элементов
        Stack<Integer> stack = new Stack<>();

        // Извлекаем элементы из L1 и кладем в стек
        while (!L1.isEmpty()) {
            stack.push(L1.poll());
        }

        // Извлекаем элементы из стека и кладем их в L2
        while (!stack.isEmpty()) {
            L2.add(stack.pop());
        }
    }
}
