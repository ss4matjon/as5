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
            System.out.println("5. Get all FrontEndDevelopers");
            System.out.println("6. Get all FrontEndDevelopers by name(name,surname)");
            System.out.println("7. Get all FrontEndDevelopers by status");
            System.out.println("8. Get all Managers");
            System.out.println("9. Get all Managers by name(name,surname)");
            System.out.println("10. Total cost of company");

            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter what's option you have chosen:");
                int option = scanner.nextInt();
                switch (option){
                    case 1:
                        repoCompany.getAllEmployees();
                        break;
                    case 2:
                        repoBack.getAllBackendDevs();
                        break;

                    case 3:
                        System.out.println("Please enter the name of the Backend Developer");
                        String Backname = scanner.nextLine();
                        System.out.println("Please enter surname");
                        String Backsurname = scanner.nextLine();
                        repoBack.getBackendDevByName(Backname,Backsurname);
                        break;

                    case 4:
                        System.out.println("Please enter status");
                        String Backstatus = scanner.nextLine();
                        repoBack.getBackendDevByStatus(Backstatus);
                        break;

                    case 5:
                        repoFront.getAllFrontendDevs();
                        break;

                    case 6:
                        System.out.println("Please enter the name of the Frontend Developer");
                        String frontname = scanner.nextLine();
                        System.out.println("Please enter surname");
                        String frontsurname = scanner.nextLine();
                        repoFront.getFrontendByName(frontname,frontsurname);
                        break;

                    case 7:
                        System.out.println("Please enter status");
                        String Frontstatus = scanner.nextLine();
                        repoFront.getFrontEndByStatus(Frontstatus);
                        break;

                    case 8:
                        repoManager.getAllManagers();
                        break;

                    case 9:
                        System.out.println("Please enter the name of the Manager");
                        String Managername=scanner.nextLine();
                        System.out.println("Please enter surname");
                        String Managersurname=scanner.nextLine();
                        repoManager.getManagerByName(Managername,Managersurname);
                        break;

                    case 10:
                        break;

                    case 0:
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
