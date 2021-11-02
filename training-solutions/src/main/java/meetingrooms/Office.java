package meetingrooms;

import java.util.List;

public class Office {

    List<MeetingRoom> meetingRooms;

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        boolean first = true;
        StringBuilder meetingRoomNameList = new StringBuilder();
        for (MeetingRoom actual : meetingRooms) {
            if (first) {
                first = false;
            } else {
                meetingRoomNameList.append(", ");
            }
            meetingRoomNameList.append(actual.getName());
        }
        System.out.println(meetingRoomNameList);
    }
}
