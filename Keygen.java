import java.util.*;
import java.util.concurrent.*;

public class Keygen {
    public static void main(String[] args) throws Exception {
        // Your code here!
        // Scanner in = new Scanner(System.in);
         //String s = in.nextLine();
         String key = "Error";
         String name = "Unknown";
         String country = "Unknown";

         Scanner in = new Scanner(System.in);

         System.out.println("\n\nAtlatl1807's KeyGen.");
         System.out.println("Made for my_first_crackme_in_java by dark_prince.\n");
         System.out.println("Enter your name: ");
         name = in.nextLine();
         System.out.println("Enter your country:");
         country = in.nextLine();

         String[] countries = {"Australia", "Brazil", "Egypt", "Germany", "India", "Mexico"};
         
         System.out.println();
         String generating = "Calculating Input...";
         for (int x = 0 ; x < 6 ; x++) { 
           System.out.print("\r" + generating.substring(0, (18 + (x % 3))) + "   ");
           Thread.sleep(600);
         }

         System.out.println("\n\nInputs:");
         System.out.println("  Name: " + name);
         System.out.println("  Country: " + country);

         if (!Arrays.asList(countries).contains(country) && country != "Other"){
          country = "Other";
          System.out.println(" NOTICE: Country entered not in list, defaulting to Other.\n");
         }

         int m = 0;
         int sum = 0;
         for (int i = 0; i < name.length(); i++) {
             if (Character.isLetter(name.charAt(i))) {
                m = name.charAt(i);
                sum += m;
             } 
         }

         System.out.println("\nGenerating Solution...");
         String progress = "|= ";
         for (int x = 0 ; x < 11 ; x++) { 
           progress += "= ";
           System.out.print("\r" + progress + "=|" + (x * 10) + "%");
           long rand = ThreadLocalRandom.current().nextLong(100, 1000);
           Thread.sleep(rand);
         }

          
         System.out.println("\n\nSolution Generated.");
         
         Dark dr = new Dark();
         key = dr.StrM(country, sum);
         
         System.out.println("Key: " + key);
    }
}

class Dark {
  String s2;
  String s3;
  String s4;
  String s5;
  String s6;
  int c2;
  int c3;
  int c4;
  int n1;
  int n2;
  int n3;
  int d;
  int y;
  int y1;
  int y2;
  char ch1;
  char ch2;
  char ch3;
  
  public String StrM(String s1, int c1) {
    s1 = s1.substring(0, 5);
    PermutationGenerator pm = new PermutationGenerator(s1);
    ArrayList<String> permut = pm.getPermutations();
    this.s2 = permut.get(3);
    this.s3 = permut.get(10);
    this.s4 = permut.get(17);
    this.ch1 = this.s2.charAt(3);
    this.ch2 = this.s3.charAt(3);
    this.ch3 = this.s4.charAt(3);
    this.n1 = this.ch1;
    this.n2 = this.ch2;
    this.n3 = this.ch3;
    c1 <<= 2;
    this.c2 = c1 & 0xFF;
    this.c3 = c1 ^ this.c2;
    this.c4 = c1 | this.c3;
    this.d = this.c2 * 2 + this.c3 * 3 + this.c4 * 4 + this.n1 * 10 + this.n2 * 11 + this.n3 * 12;
    this.s5 = String.valueOf(this.d);
    this.s6 = this.s5;
    this.s5 = this.s5.substring(0, 2);
    this.y = Integer.parseInt(this.s5);
    this.y1 = Integer.parseInt(this.s6);
    int[][] a = { { 2, 2, this.y }, { 4, 6, 2 }, { 3, 4, 4 } };
    int[][] b = { { 2, 2, 3 }, { 8, 9, 5 }, { 6, 2, 2 } };
    int[][] c = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        c[i][j] = 0;
        for (int k = 0; k < 3; k++)
          c[i][j] = c[i][j] + a[i][k] * b[k][j]; 
      } 
    } 
    this.y2 = c[2][2];
    this.y2 *= this.y1;
    return String.valueOf(this.y2);
  }
}


class PermutationGenerator {
  private String word;
  
  public PermutationGenerator(String aWord) {
    this.word = aWord;
  }
  
  public ArrayList<String> getPermutations() {
    ArrayList<String> result = new ArrayList<>();
    if (this.word.length() == 0) {
      result.add(this.word);
      return result;
    } 
    for (int i = 0; i < this.word.length(); i++) {
      String shorterWord = this.word.substring(0, i) + this.word.substring(i + 1);
      PermutationGenerator shorterPermutationGenerator = new PermutationGenerator(shorterWord);
      ArrayList<String> shorterWordPermutations = shorterPermutationGenerator.getPermutations();
      for (String s : shorterWordPermutations)
        result.add(this.word.charAt(i) + s); 
    } 
    return result;
  }
}

