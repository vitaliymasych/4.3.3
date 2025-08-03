import java.util.LinkedList;

public class SeparateChaining<K, V> {
    private HashNode<K, V>[] buckets;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public SeparateChaining(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new HashNode[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Додавання пари ключ-значення
    public void insert(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = buckets[index];

        // Перевірка: чи такий ключ вже є
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // оновлення значення
                return;
            }
            head = head.next;
        }

        // Додаємо новий вузол на початок списку
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    // Пошук за ключем
    public V search(K key) {
        int index = hash(key);
        HashNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // Видалення за ключем
    public void delete(K key) {
        int index = hash(key);
        HashNode<K, V> head = buckets[index];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // Виведення всіх пар
    public void printAll() {
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> head = buckets[i];
            System.out.print("[" + i + "]: ");
            while (head != null) {
                System.out.print(head.key + " => " + head.value + "  ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
