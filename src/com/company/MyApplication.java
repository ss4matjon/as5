package com.company;

import controllers.BackendDevController;
import controllers.CompanyController;
import controllers.FrontendDevController;
import controllers.ManagerController;
import data.PostgresDB;
import data.interfaces.IDB;
import entities.BackendDev;
import repositories.BackendDevRepository;
import repositories.CompanyRepositories;
import repositories.FrontendDevRepository;
import repositories.ManagerRepositories;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final IDB db = new PostgresDB();

    private final BackendDevRepository repoBack = new BackendDevRepository(db);
    private final BackendDevController controllerBack = new BackendDevController(repoBack);

    private final FrontendDevRepository repoFront = new FrontendDevRepository(db);
    private final FrontendDevController controllerFront = new FrontendDevController(repoFront);

    private final ManagerRepositories repoManager = new ManagerRepositories(db);
    private final ManagerController controllerManager = new ManagerController(repoManager);

    private final CompanyRepositories repoCompany = new CompanyRepositories(db);
    private final CompanyController controllerCompany = new CompanyController(repoCompany);

    private final Scanner scanner;
    public MyApplication(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Hello. This application will help you with managing companies. Good Luck!");
            System.out.println("Select an option: (1-6)");
            System.out.println("1. Get all employees (FrontEndDevelopers,BackEndDeveloper and Managers");
            System.out.println("2. Get all BackEndDevelopers");
            System.out.println("3. Get all BackEndDevelopers by name(name,surname)");
            System.out.println("4. Get all BackEndDevelopers by status");
            System.out.println("5. Get all FrontEndDevelopers by name(name,surname)");
            System.out.println("6. Get all FrontEndDevelopers by status");
            System.out.println("7. Get all Managers by name(name,surname)");
            System.out.println("8. Get all Managers by status");
            System.out.println("9. Total cost of company");

            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter what's option you have chosen:");
                int option = scanner.nextInt();
                switch (option){
                    case 1:

                        break;

                }
            }
            catch (InputMismatchException e) {
                System.out.println("You might entered not an integer, please input integers ONLY");
                scanner.nextLine();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("-------------------------------------------------------");
        }
    }

}
