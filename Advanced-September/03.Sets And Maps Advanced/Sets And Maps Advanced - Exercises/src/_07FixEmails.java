import java.util.LinkedHashMap;
import java.util.Scanner;

public class _07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emailsData = new LinkedHashMap<>();
        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            //име на човек
            String email = scanner.nextLine();
            //добавяме имейли само ако не завършват на: "us", "uk" or "com"
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                //валиден и не завършва на "us", "uk" or "com"
                emailsData.put(name, email);
            }
            name = scanner.nextLine();
        }
        //"{name} –> {email}"
        emailsData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
