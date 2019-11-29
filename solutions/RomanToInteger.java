import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        assert solve(s) == 1994;

        s = "LVIII";
        assert solve(s) == 58;

        s = "IX";
        assert solve(s) == 9;

        s = "IV";
        assert solve(s) == 4;

        s = "III";
        assert solve(s) == 3;

        System.out.println();
    }

    public static int solve(String s) {
        HashMap<String, Integer> symbolTable = getSymbolTable();
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            
            if (i < s.length() - 1 && symbolTable.containsKey(s.substring(i, i+2))) {
                total += symbolTable.get(s.substring(i, i+2));
                i++;
            } else {
                total += symbolTable.get(s.substring(i, i+1));
            }

        }
        return total;
    }

    public static HashMap<String, Integer> getSymbolTable() {
        HashMap<String, Integer> table = new HashMap<>();

        table.put("I", 1);
        table.put("V", 5);
        table.put("X", 10);
        table.put("L", 50);
        table.put("C", 100);
        table.put("D", 500);
        table.put("M", 1000);

        table.put("IV", 4);
        table.put("IX", 9);
        table.put("XL", 40);
        table.put("XC", 90);
        table.put("CD", 400);
        table.put("CM", 900);
        
        return table;
    }
}