import java.util.Date;

public class FullyQualifiedNameOverImport {
    public static void main(String[] args) {
        Date javaUtilDate;
        java.sql.Date javaSqlDate;
    }
}