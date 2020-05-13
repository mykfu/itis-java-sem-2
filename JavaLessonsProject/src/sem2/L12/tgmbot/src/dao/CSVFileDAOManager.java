package dao;

public class CSVFileDAOManager implements DAOManager {
    public static DAO getDAO(Class cls) {
        switch (cls.getSimpleName()) {
            case "User":
                return new CSVFileUserDAO();
            case "Chat":
                return new CSVFileChatDAO();
            case "Message":
                return new CSVFileMessageDAO();
        }
        throw new IllegalStateException("DAO not found.");
    }
}
