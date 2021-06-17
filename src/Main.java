import java.util.HashMap;
import java.util.Map;

public class Main {
    enum State{
        //初始状态
        INIT,
        //数字状态
        NUM,
        //整数状态
        INTEGER,
        //小数状态
        DOUBLE,
        //小数3状态
        DOUBLE3,
        //小数4状态
        DOUBLE4,
        //指数1
        E1,
        //指数2
        E2,
        E3,
        ERROR
    }
    enum CharSet{
        //e或者E
        E,
        //+ -
        SIGNAL,
        NUM,
        DOT,
        OTHERS
    }

    private CharSet selectCharSet(char c){
        if(c>='0' && c<='9'){
            return CharSet.NUM;
        }else if(c=='e' || c=='E'){
            return CharSet.E;
        }else if(c=='+' || c=='-'){
            return CharSet.SIGNAL;
        }else if(c=='.'){
            return CharSet.DOT;
        }else{
            return CharSet.OTHERS;
        }
    }

    public boolean isNumber(String s) {
        Map<State,Map<CharSet,State>> transfer=new HashMap<>();
        Map<CharSet,State> initMap=new HashMap<CharSet,State>(){{
            put(CharSet.SIGNAL,State.NUM);
            put(CharSet.NUM,State.INTEGER);
            put(CharSet.DOT,State.DOUBLE3);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.INIT,initMap);
        Map<CharSet,State> numMap=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.INTEGER);
            put(CharSet.DOT,State.DOUBLE3);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.NUM,numMap);
        Map<CharSet,State> integerMap=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.INTEGER);
            put(CharSet.DOT,State.DOUBLE);
            put(CharSet.E,State.E1);
            put(CharSet.OTHERS,State.ERROR);

        }};
        transfer.put(State.INTEGER,integerMap);
        Map<CharSet,State> doubleMap=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.DOUBLE4);
            put(CharSet.E,State.E1);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.DOUBLE,doubleMap);
        Map<CharSet,State> double3Map=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.DOUBLE4);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.DOUBLE3,double3Map);
        Map<CharSet,State> double4Map=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.DOUBLE4);
            put(CharSet.E,State.E1);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.DOUBLE4,double4Map);
        Map<CharSet,State> e1Map=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.E2);
            put(CharSet.SIGNAL,State.E3);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.E1,e1Map);
        Map<CharSet,State> e2Map=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.E2);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.E2,e2Map);
        Map<CharSet,State> e3Map=new HashMap<CharSet,State>(){{
            put(CharSet.NUM,State.E2);
            put(CharSet.OTHERS,State.ERROR);
        }};
        transfer.put(State.E3,e3Map);

        transfer.put(State.ERROR,new HashMap<CharSet,State>());
        s=s.trim();
        State state=State.INIT;
        int i=0;
        while(i!=s.length()){
            char c=s.charAt(i);
            if(!transfer.get(state).containsKey(selectCharSet(c))){
                return false;
            }else{
                state=transfer.get(state).get(selectCharSet(c));
            }
            i++;
        }

        return state==State.INTEGER|| state==State.DOUBLE4 || state==State.E2 ||state==State.DOUBLE;
    }
}
