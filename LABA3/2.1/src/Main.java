class Node {
    private Integer value;    // Значение узла
    private Node parent;      // Родительский узел
    private Node left;        // Левый потомок
    private Node right;       // Правый потомок

    // Конструктор без аргументов
    public Node() {
        this.value = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Добавление значения в узел
    public void addValue(int value) {
        if (this.value == null) {
            // Если значение еще не задано
            this.value = value;
        } else {
            // Если значение уже есть, сравниваем с текущим
            if (value > this.value) {
                // Если больше, добавляем в правый потомок
                if (this.right == null) {
                    this.right = new Node();
                    this.right.parent = this;
                }
                this.right.addValue(value);
            } else {
                // Если меньше или равно, добавляем в левый потомок
                if (this.left == null) {
                    this.left = new Node();
                    this.left.parent = this;
                }
                this.left.addValue(value);
            }
        }
    }

    // Удаление значения из дерева
    public void deleteValue(int value) {
        if (this.value == null) {
            return; // Если текущий узел пустой
        }

        if (value == this.value) {
            // Если значение найдено, удаляем его
            if (this.left != null) {
                this.left.parent = this.parent;
            }
            if (this.right != null) {
                this.right.parent = this.parent;
            }
            // Теперь узел не должен содержать значений
            this.value = null;
            this.left = null;
            this.right = null;
        } else if (value < this.value && this.left != null) {
            this.left.deleteValue(value);
        } else if (value > this.value && this.right != null) {
            this.right.deleteValue(value);
        }
    }

    // Проверка существования значения
    public boolean containsValue(int value) {
        if (this.value == null) {
            return false;
        }

        if (value == this.value) {
            return true;
        } else if (value < this.value && this.left != null) {
            return this.left.containsValue(value);
        } else if (value > this.value && this.right != null) {
            return this.right.containsValue(value);
        }
        return false;
    }

    // Левосторонний обход (in-order traversal) для приведения к строке
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.left != null) {
            sb.append(this.left.toString()).append(", ");
        }
        if (this.value != null) {
            sb.append(this.value);
        }
        if (this.right != null) {
            sb.append(", ").append(this.right.toString());
        }
        return sb.toString();
    }

    // Получить значение узла
    public Integer getValue() {
        return value;
    }

    // Проверка на пустой узел
    public boolean isEmpty() {
        return value == null;
    }

    // Основной метод для тестирования
    public static void main(String[] args) {
        Node root = new Node();

        // Добавление чисел в дерево
        root.addValue(3);
        root.addValue(5);
        root.addValue(4);
        root.addValue(7);
        root.addValue(1);
        root.addValue(2);

        // Вывод дерева
        System.out.println("Дерево (левосторонний обход): " + root);

        // Проверка на наличие значений
        System.out.println("Содержит ли дерево значение 5? " + root.containsValue(5));
        System.out.println("Содержит ли дерево значение 10? " + root.containsValue(10));

        // Удаление значения
        root.deleteValue(7);
        System.out.println("После удаления значения 7: " + root);

        root.deleteValue(3);
        System.out.println("После удаления значения 3: " + root);
    }
}