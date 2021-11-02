package meetingrooms;

import java.util.List;

public class Office {

    List<MeetingRoom> meetingRooms;

    public void addMeetingRoom (MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames () {
        StringBuilder meetingRoomList = new StringBuilder();
        for (MeetingRoom actual: meetingRooms) {
           
        }
    }
}
