public class OfficePrintingSystem {

    public static void main(String[] args) {
        // Crear la cola de departamentos
        Queue<Department> departmentQueue = new Queue<>();

        // Crear y añadir departamentos con pilas de documentos
        Department marketing = new Department("Marketing");
        marketing.addDocument("Marketing Report 1");
        marketing.addDocument("Campaign Analysis 2023");
        marketing.addDocument("Product Launch Plan");

        Department sales = new Department("Sales");
        sales.addDocument("Q4 Sales Data");
        sales.addDocument("Annual Sales Report");
        sales.addDocument("Sales Meeting Notes");

        Department hr = new Department("HR");
        hr.addDocument("Employee Handbook");
        hr.addDocument("Policy Update 2023");
        hr.addDocument("New Hire Orientation");

        // Añadir departamentos a la cola
        departmentQueue.offer(marketing);
        departmentQueue.offer(sales);
        departmentQueue.offer(hr);

        // Procesar la cola de departamentos
        while (!departmentQueue.isEmpty()) {
            Department currentDepartment = departmentQueue.poll();
            System.out.println("\nImprimiendo documentos del departamento " + currentDepartment.getName() + "...");
            while (!currentDepartment.isEmpty()) {
                String document = currentDepartment.printDocument();
                System.out.println("Imprimiendo: " + document);
            }
            System.out.println("Todos los documentos del departamento han sido impresos.");
        }
    }
}
