package meetingrooms;

import java.util.List;

public class Office {

    List<MeetingRoom> meetingRooms;

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        boolean first = true;
        StringBuilder meetingRoomNamesList = new StringBuilder();
        for (MeetingRoom actual : meetingRooms) {
            if (first) {
                first = false;
            } else {
                meetingRoomNamesList.append(", ");
            }
            String meetingRoomName = actual.getName();
            meetingRoomNamesList.append(meetingRoomName);
        }
        System.out.println(meetingRoomNamesList);
    }

    public void printNamesReverse() {
        StringBuilder meetingRoomNamesReverseList = new StringBuilder();
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            String meetingRoomName = meetingRooms.get(i).getName();
            meetingRoomNamesReverseList.append(meetingRoomName);
            if (i != 0) {
                meetingRoomNamesReverseList.append(", ");
            }
        }
        System.out.println(meetingRoomNamesReverseList);
    }
}
