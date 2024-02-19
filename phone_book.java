import java.util.*;

class Contact {
    private String name;
    private Set<String> phoneNumbers;

    public Contact(String name) {
        this.name = name;
        this.phoneNumbers = new HashSet<>();
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}

public class PhoneBook {
    private Map<String, Contact> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, new Contact(name));
        }
        contacts.get(name).addPhoneNumber(phoneNumber);
    }

    public void displayPhoneBook() {
        // Создаем список записей сортированный по убыванию количества номеров
        List<Contact> sortedContacts = new ArrayList<>(contacts.values());
        sortedContacts.sort(Comparator.comparingInt(contact -> -contact.getPhoneNumbers().size()));

        // Выводим результаты
        for (Contact contact : sortedContacts) {
            System.out.println(contact.getName() + ": " + contact.getPhoneNumbers());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Пример входных данных
        phoneBook.addContact("Иванов", "123456789");
        phoneBook.addContact("Иванов", "987654321");
        phoneBook.addContact("Петров", "111222333");
        phoneBook.addContact("Сидоров", "444555666");
        phoneBook.addContact("Сидоров", "777888999");
        phoneBook.addContact("Иванов", "999000111");

        phoneBook.displayPhoneBook();
    }
}
