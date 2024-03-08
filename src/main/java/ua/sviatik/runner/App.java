package ua.sviatik.runner;

import ua.sviatik.service.Console;
import ua.sviatik.util.LoadDataToDB;
import ua.sviatik.util.TableReCreator;


public class App {
    public static void main(String[] args) {
        TableReCreator.tableReCreator();
        LoadDataToDB.loadAllData();
        new Console().start();

    }
}
