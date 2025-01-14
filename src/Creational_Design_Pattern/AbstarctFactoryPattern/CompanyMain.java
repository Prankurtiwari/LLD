package Creational_Design_Pattern.AbstarctFactoryPattern;

public class CompanyMain {
    public static void main(String[] args) {
        getCompany("asus");
        getCompany("msi");
        getCompany("hp");
    }

    private static void getCompany(String input) {
        Company company = switch (input) {
            case "asus" -> new AsusFactory();
            case "msi" -> new MSIFactory();
            default -> throw new RuntimeException("Invalid Input");
        };
        GPU companyGpu = company.createGPU();
        Monitor companyMonitor = company.createMonitor();
        companyGpu.process();
        companyMonitor.process();
    }
}
