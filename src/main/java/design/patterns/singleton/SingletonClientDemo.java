package design.patterns.singleton;

class DBConnectionUsingEager{
    private static final DBConnectionUsingEager dbConnectionObject = new DBConnectionUsingEager();
    private DBConnectionUsingEager(){}
    public static DBConnectionUsingEager getInstance(){
        return dbConnectionObject;
    }
}
class DBConnectionUsingLazy{
    // we are not creating instance for all the time
    // when the object is created
    private static DBConnectionUsingLazy dbConnectionUsingLazy = null;
    private DBConnectionUsingLazy(){}
    //create instance when the class getInstance method is invoked.
    // problem - if 2 threads invoke this method will find the obj null
    // so we will synchronized method to handle this
    public static DBConnectionUsingLazy getInstance(){
        if (dbConnectionUsingLazy == null){
            dbConnectionUsingLazy = new DBConnectionUsingLazy();
        }
        return dbConnectionUsingLazy;
    }
}

class DBConnectionUsingSynchronized {
    private static DBConnectionUsingSynchronized dbConnectionUsingSynchronized;
    private DBConnectionUsingSynchronized(){}
    // pros - handles multiple threads
    // cons - expensive operations
    // will use double locking
    synchronized public static DBConnectionUsingSynchronized getInstance(){
        if (dbConnectionUsingSynchronized == null){
            dbConnectionUsingSynchronized = new DBConnectionUsingSynchronized();
        }
        return dbConnectionUsingSynchronized;
    }
}
class DBConnectionUsingDoubleLocking{
    private static DBConnectionUsingDoubleLocking dbConnectionUsingDoubleLocking;
    private DBConnectionUsingDoubleLocking(){}
    public static DBConnectionUsingDoubleLocking getInstance(){
        if (dbConnectionUsingDoubleLocking == null){
            synchronized (DBConnectionUsingDoubleLocking.class){
                if (dbConnectionUsingDoubleLocking == null){
                    dbConnectionUsingDoubleLocking = new DBConnectionUsingDoubleLocking();
                }
                return dbConnectionUsingDoubleLocking;
            }
        }
        return dbConnectionUsingDoubleLocking;
    }

}
public class SingletonClientDemo {
    /*
    * It is used when we have to create only one instance of a class.
    * 4 ways to achieve this.
    * a. Eager
    * b. Lazy
    * c. Synchronized method
    * d. Double Locking
    * */
    public static void main(String[] args) {
        DBConnectionUsingEager dbConnectionUsingEager =
                DBConnectionUsingEager.getInstance();

        DBConnectionUsingLazy dbConnectionUsingLazy =
                DBConnectionUsingLazy.getInstance();

        DBConnectionUsingSynchronized dbConnectionUsingSynchronized =
                DBConnectionUsingSynchronized.getInstance();

        DBConnectionUsingDoubleLocking dbConnectionUsingDoubleLocking = DBConnectionUsingDoubleLocking
                 .getInstance();
    }
}
