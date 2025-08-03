public class Main {
    public static void main(String[] args) {
        SeparateChaining<String, Integer> table = new SeparateChaining<>(5);

        table.insert("apple", 1);
        table.insert("banana", 2);
        table.insert("lemon", 3);
        table.insert("banana", 22); // перевірка оновлення

        System.out.println("Значення по ключу 'banana': " + table.search("banana"));

        table.delete("apple");

        System.out.println("\nВсі пари:");
        table.printAll();
    }
}
