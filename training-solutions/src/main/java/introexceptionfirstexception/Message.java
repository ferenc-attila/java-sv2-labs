package introexceptionfirstexception;

import java.util.Arrays;
import java.util.List;

public class Message {

    public void printList(List<String> list){
        char[] charactersOfMessage = new char[list.size()];
        for (int i = 0; i < list.size(); i++){
            charactersOfMessage[i] = ((char)Integer.parseInt(list.get(i)));
        }
        System.out.println(Arrays.toString(charactersOfMessage));
    }

    public static void main(String[] args) {

        Message message = new Message();

        List<String> codedMessage = Arrays.asList("76", "101", "103", "121", "101", "110", "32", "115", "122", "233", "112", "32", "110", "97", "112", "111", "100", "33");
        message.printList(codedMessage);

        List<String> anotherCodedMessage = Arrays.asList("69", "122", "32", "101", "103", "121", "32", "104", "105", "98", "225", "115", "32", "252", "122", "101", "110", "101", "116", "46");
        message.printList(anotherCodedMessage);

    }
}
