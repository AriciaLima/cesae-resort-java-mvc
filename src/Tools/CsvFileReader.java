package Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Leitor genérico de ficheiros CSV.
 */
public class CsvFileReader {

    /**
     * Lê um ficheiro CSV e devolve as linhas (sem cabeçalho).
     *
     * @param filePath caminho do ficheiro CSV
     * @param delimiter separador (ex: "," ou ";")
     * @return lista de linhas já separadas em colunas
     * @throws FileNotFoundException se o ficheiro não existir
     */
    public static ArrayList<String[]> read(
            String filePath,
            String delimiter) throws FileNotFoundException {

        ArrayList<String[]> data = new ArrayList<>();

        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {

            // Remove o cabeçalho
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) continue;

                String[] columns = line.split(delimiter);

                // Limpa espaços
                for (int i = 0; i < columns.length; i++) {
                    columns[i] = columns[i].trim();
                }

                data.add(columns);
            }
        }

        return data;
    }
}
