import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {

    public static void saveManagerReport( String report) {
        try {
            File file = new File("manager_reports.json");
            List<String> reports = readReports(file);
            reports.add(report);

            writeReports(file, reports);

            System.out.println("Manager report saved to manager_reports.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> readReports(File file) throws IOException {
        List<String> reports = new ArrayList<>();

        if (!file.exists()) {
            return reports;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder currentBlock = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            String trimmed = line.trim();

            if (trimmed.isEmpty() || trimmed.equals("[") || trimmed.equals("]")) {
                continue;
            }

            if (trimmed.startsWith("\"") && trimmed.endsWith("\",")) {
                reports.add(unescapeJsonString(trimmed.substring(1, trimmed.length() - 2)));
                continue;
            }

            if (trimmed.startsWith("\"") && trimmed.endsWith("\"")) {
                reports.add(unescapeJsonString(trimmed.substring(1, trimmed.length() - 1)));
                continue;
            }

            currentBlock.append(line).append("\n");

            if (trimmed.equals("----------------------")) {
                reports.add(currentBlock.toString());
                currentBlock.setLength(0);
            }
        }

        if (currentBlock.length() > 0) {
            reports.add(currentBlock.toString());
        }

        reader.close();
        return reports;
    }

    private static void writeReports(File file, List<String> reports) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write("[\n");

        for (int i = 0; i < reports.size(); i++) {
            writer.write("  \"" + escapeJsonString(reports.get(i)) + "\"");
            if (i < reports.size() - 1) {
                writer.write(",");
            }
            writer.write("\n");
        }

        writer.write("]");
        writer.close();
    }

    private static String escapeJsonString(String value) {
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    private static String unescapeJsonString(String value) {
        return value
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");
    }
}