package in.math2do.practice.designpattern.creational.builder;

// Call as Builder.main()
public class Builder {
    public static void main() {
        User user = User.builder()
            .name("Mathura Tudu")
            .email("math2do.in@gmail.com")
            .build();

        System.out.println("User: " + user);
    }
}
