import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {

    public static void saveManagerReport( String report) {
        try {
            File file = new File("manager_reports.json");
            List<String> reports = new ArrayList<>();

            // 1. Read existing data (clean JSON structure)
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();

                    // ❌ skip JSON array brackets
                    if (line.equals("[") || line.equals("]") || line.isEmpty()) {
                        continue;
                    }

                    // ❌ remove trailing commas
                    if (line.endsWith(",")) {
                        line = line.substring(0, line.length() - 1);
                    }

                    reports.add(line);
                }

                reader.close();
            }

            // 2. Add new manager report
            reports.add(report);

            // 3. Rewrite file as proper JSON array
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("[\n");

            for (int i = 0; i < reports.size(); i++) {
                writer.write("  " + reports.get(i));
                if (i < reports.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }

            writer.write("]");
            writer.close();

            System.out.println("Manager report saved to manager_reports.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}