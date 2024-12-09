import java.util.List;

public class Box<I> {
    private I item;  // Объект ._.

    //сеттер
    public void put(I item) throws Exception {
        if (this.item != null) {  //Есть ли в ней хоть что то
            throw new Exception("Коробка уже заполнена!");
        }
        this.item = item;
    }

    //геттер
    public I get() {
        I temp = item;
        item = null;
        return temp;
    }

    //возвращает в зависимости от пустоты тру либо фолс
    public boolean isEmpty() {
        return item == null;
    }

    //метод, аля, а что же внутри
    public I peek() {
        return item;
    }
    //Ищем максимального, из крит.минимума
    public static double FindMax(List<Box<? extends Number>> boxes) {
        double maxValue = Double.MIN_VALUE;  // Самый минимум для обхода ошибок


        for (Box<? extends Number> box : boxes) {
            Number value = box.peek();  // Звоним в коробку
            if (value != null) {  // Есть тут кто?
                double doubleValue = value.doubleValue();  // Перевод в double для универсальности
                if (doubleValue > maxValue) {
                    maxValue = doubleValue;  // Обновление Максимума
                }
            }
        }

        return maxValue;  // Результат на лицо
    }
}
