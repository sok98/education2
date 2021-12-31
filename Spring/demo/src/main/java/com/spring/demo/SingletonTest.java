package com.spring.demo;

public class SingletonTest {
    public static void main(String[] args) {

        Database db= Database.getInstance(1);
        System.out.println(db);

        Database db2 = Database.getInstance(1);
        System.out.println(db2);

        Database db3 = Database.getInstance(1);
        System.out.println(db3);
    }
}

class Database {
    private static Database database= null;

    private Database() {
    }

    public static Database getInstance(int scope) { // scope=1 prototype
        if ( scope == 1)
            return new Database();

        if ( database == null ) {
            database = new Database();
        }
        return database;
    }
}
