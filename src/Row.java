import java.util.*;

public class Row {
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