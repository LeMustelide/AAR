package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facade {
    private static Facade instance=null;

    private Map<String,String> users;

    private List<String> humeurs;

    private Facade(){
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
        humeurs=List.of("heureux","triste","fatigué","en colère");
    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
   }

    public List<String> getHumeurs() {
         return humeurs;
    }

}
