package pr;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution_오픈채팅방 {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<String>();
        
        for(String log: record){
            StringTokenizer st = new StringTokenizer(log);
            String command = st.nextToken();
            if(command.equals("Enter")){
                String uid = st.nextToken();
                String nickname = st.nextToken();                
                result.add(uid + " 님이 들어왔습니다."); 
                
                //uid가 같은데 nickname이 달라지는 경우 처리
                if(map.containsKey(uid) && !nickname.equals(map.get(uid))){
                    map.replace(uid,nickname);
                }else{
                    map.put(uid ,nickname );  
                }
            }
            if(command.equals("Leave")){
                String uid = st.nextToken();
                result.add(uid + " 님이 나갔습니다.");                
            }
            if(command.equals("Change")){
                String uid = st.nextToken();
                String new_nickname = st.nextToken();
                map.replace(uid,new_nickname);
            }
            
                
        }
        
        ArrayList<String> answer_tmp = new ArrayList<>();
        String[] result_array = result.toArray(new String[0]);
               
        for(int i = 0; i < result_array.length; i ++){            
            StringTokenizer st = new StringTokenizer(result_array[i]);
            String uid = st.nextToken();
            String nimi = st.nextToken();
            String verse = st.nextToken();                        
                         
            String nickname = map.get(uid);
            StringBuilder sb = new StringBuilder();
            sb.append(nickname);            
            sb.append(nimi);
            sb.append(" ");
            sb.append(verse);            
            
            answer_tmp.add(sb.toString());
        }
                
        String[] answer = answer_tmp.toArray(new String[0]);
        return answer;
    }
}
