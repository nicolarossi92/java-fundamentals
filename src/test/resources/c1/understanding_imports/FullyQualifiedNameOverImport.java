import java.util.Date;

public class FullyQualifiedNameOverImport {
    public static void main(String[] args) {
        Date javaUtilDate;
        java.sql.Date javaSqlDate; // Will compile since it is being used a fully qualified name
    }
}