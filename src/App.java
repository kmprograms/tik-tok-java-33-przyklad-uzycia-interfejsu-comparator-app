import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var people = List.of(
                new Person("ZOFIA", 50),
                new Person("ADAM", 20),
                new Person("ADAM", 25),
                new Person("EWA", 40)
        );

        var sortedPeople1 = people
                .stream()
                .sorted((p1, p2) -> p1.name().compareTo(p2.name()))
                .toList();

        System.out.println(sortedPeople1);

        var sortedPeople2 = people
                .stream()
                .sorted((p1, p2) -> {
                    if (p1.name().equals(p2.name())) {
                        return Integer.compare(p2.age(), p1.age());
                    }
                    return p1.name().compareTo(p2.name());
                })
                .toList();

        System.out.println(sortedPeople2);

        var sortedPeople3 = people
                .stream()
                .sorted(Comparator
                        .comparing(Person::name)
                        .thenComparing(Person::age/*, Comparator.reverseOrder()*/))
                .toList();

        System.out.println(sortedPeople3);
    }
}
