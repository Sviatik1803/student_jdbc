package ua.sviatik.runner;

import ua.sviatik.service.Console;
import ua.sviatik.service.FactoryDAO;
import ua.sviatik.util.LoadDataToDB;
import ua.sviatik.util.TableReCreator;


public class App {
    public static void main(String[] args) {
        TableReCreator.tableReCreator();
        LoadDataToDB.loadAllData();
        new Console().start();



//        1. сінгл тон для new DAO. Сінглтон на сервісні
//        контроллер приймає запит з вебу і викликати певний метод в сервісі. Контролер ще робить валідацію і чілить
//         сервіс звертається до ДАО
//ентіті не віддаємо на зовні НІКОЛИ(Суто наша внутрішня штука для роботи з базою), коли ми віддаємо щось вебу то ентіті конверт ту ДТО

//  ДТО складається з ентіті. ДТО приховує всяку інфу.
// обджект і модел маппер. Маппер співставляє ДТО з Ентіті
// можна робити ДТО з одного ентіті переважно так
//        Formatter<Student> studentFormatter = new StudentFormatter();
//        String outputStudent = studentFormatter.format(new StudentDAO().getAll("SELECT * FROM students"));
//        System.out.println(outputStudent);
//        Formatter<Group> groupFormatter = new GroupFormatter();
//        String outputGroup = groupFormatter.format(new GroupDAO().getAll());
//        System.out.println(outputGroup);
    }
}
