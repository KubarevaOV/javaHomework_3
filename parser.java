import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class parser {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на отдельные поля
                String[] fields = line.split(":|,");
                String surname = fields[1];
                String grade = fields[3];
                String subject = fields[5];

                // Создаем новую строку с помощью StringBuilder
                StringBuilder sb = new StringBuilder();
                sb.append("Студент ");
                sb.append(surname);
                sb.append(" получил ");
                sb.append(grade);
                sb.append(" по предмету ");
                sb.append(subject);
                sb.append(".");

                // Выводим новую строку на экран
                System.out.println(sb.toString());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
