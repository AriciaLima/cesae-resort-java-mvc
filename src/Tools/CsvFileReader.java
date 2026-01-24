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

        Scanner scanner = new Scanner(new File(filePath));

        // ignorar cabeçalho
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (!line.isEmpty()) {
                data.add(line.split(delimiter));
            }
        }

        scanner.close();
        return data;
    }
}
