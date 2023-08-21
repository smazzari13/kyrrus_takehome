import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            throw new IOException("Must supply file path and header to sort with");
        }
        String filePath = args[0];
        String headerName = args[1];

        BufferedReader reader;
        int headerSpot = 0;

        ArrayList<String> headers = new ArrayList<String>();
        ArrayList<Row> rows = new ArrayList<Row>();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String[] headerSplit = line.split(",");

            boolean foundHeader = false;

            for (int i = 0; i < headerSplit.length; i++) {
                if (headerSplit[i].equals(headerName)) {
                    foundHeader = true;
                    headerSpot = i;
                }
                headers.add(headerSplit[i]);
            }
            if (!foundHeader) {
                throw new IOException("Did not find supplied header in CSV");
            }
            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                ArrayList<String> values = new ArrayList<String>();
                for (String value : line.split(",")) {
                    values.add(value);
                }

                rows.add(new Row(headerSpot, values));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(rows, new RowComparator());

        for (int i = 0; i < headers.size(); i++) {
            if (i == headers.size() - 1) {
                System.out.print(headers.get(i));
            } else {
                System.out.print(headers.get(i) + ",");
            }
        }
        System.out.println();
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(i).getValues().size(); j++) {
                if (j == rows.get(j).getValues().size() - 1) {
                    System.out.print(rows.get(i).getValues().get(j));
                } else {
                    System.out.print(rows.get(i).getValues().get(j) + ",");
                }
            }
            System.out.println();
        }
    }
}

class Row {
    private int spot;
    private ArrayList<String> values;

    public Row(int spot, ArrayList<String> values) {
       this.spot = spot;
       this.values = values;
    }

    public int getSpot() {
        return this.spot;
    }

    public ArrayList<String> getValues() {
        return this.values;
    }
}

class RowComparator implements Comparator<Row> {
    @Override
    public int compare(Row row1, Row row2) {
        String value1 = row1.getValues().get(row1.getSpot());
        String value2 = row2.getValues().get(row2.getSpot());
        return value1.compareTo(value2);       
    }
}