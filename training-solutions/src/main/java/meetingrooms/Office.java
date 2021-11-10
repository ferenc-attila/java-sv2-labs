package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {

    List<MeetingRoom> meetingRooms = new ArrayList<>();

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

    public void printEvenNames() {
        StringBuilder evenMeetingRoomNames = new StringBuilder();
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            String meetingRoomName = meetingRooms.get(i).getName();
            evenMeetingRoomNames.append(meetingRoomName);
            if (i < meetingRooms.size() - 2) {
                evenMeetingRoomNames.append(", ");
            }
        }
        System.out.println(evenMeetingRoomNames);
    }

    public void printAreas() {
        for (MeetingRoom actual : meetingRooms) {
            printRoomDetails(actual);
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom actual : meetingRooms) {
            if (name.equals(actual.getName())) {
                int roomWidth = actual.getWidth();
                int roomLength = actual.getLength();
                int roomArea = actual.getArea();
                System.out.printf("szélesség: %d m, hosszúság: %d m, terület: %d m2%n", roomWidth, roomLength, roomArea);
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom actual : meetingRooms) {
            if (part.isEmpty()) {
                break;
            }
            part = part.toLowerCase();
            String roomNameLowerCase = actual.getName().toLowerCase();
            if (roomNameLowerCase.contains(part)) {
                printRoomDetails(actual);
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom actual : meetingRooms) {
            if (area < actual.getArea()) {
                printRoomDetails(actual);
            }
        }
    }

    private void printRoomDetails(MeetingRoom actual) {
        String roomName = actual.getName();
        int roomWidth = actual.getWidth();
        int roomLength = actual.getLength();
        int roomArea = actual.getArea();
        System.out.printf("%s: szélesség: %d m, hosszúság: %d m, terület: %d m2%n", roomName, roomWidth, roomLength, roomArea);
    }
}
