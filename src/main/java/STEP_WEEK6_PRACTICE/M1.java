package STEP_WEEK6_PRACTICE;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class M1 {
    public static void main(String[] args) {
        PlacementRecord r1 = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord r2 = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord r3 = new PlacementRecord("Karthik", "Infosys", 4.0);

        PlacementRecord[] records = { r1, r2, r3 };

        for (PlacementRecord rec : records) {
            rec.printRecord();
        }
    }
}
