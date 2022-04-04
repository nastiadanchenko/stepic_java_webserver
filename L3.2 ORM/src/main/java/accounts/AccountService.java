package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

/**
 * Created by nastiadanchenko
 */

public class AccountService {
    private DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }
    public void addNewUser(String login) {
        dbService.printConnectInfo();

        try {
            dbService.addUser(login);
            UsersDataSet dataSet = dbService.getUserByLogin(login);

            long userId = dataSet.getId();

            System.out.println("Added user id: " + userId);
            System.out.println("User data set: " + dataSet);
        } catch (DBException e) {
            e.printStackTrace();
        }


    }

    public UsersDataSet getUserByLogin(String login) {
        dbService.printConnectInfo();

        UsersDataSet usersDataSet = null;
        try {
            usersDataSet = dbService.getUserByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return usersDataSet;
    }
}
