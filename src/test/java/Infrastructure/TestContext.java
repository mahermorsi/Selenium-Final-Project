package Infrastructure;

import java.util.HashMap;

public class TestContext {
    private HashMap<String, Object> context = new HashMap<>();

    public TestContext(HashMap<String, Object> context) {
        this.context = context;
    }

    public void put(String key, Object obj){
        context.put(key,obj);
    }

    public <T> T get(String key){
        Object o = context.get(key);
        if(o==null){
            return null;
        }else{
            return (T)o;
        }
    }

}

