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
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            String meetingRoomName = meetingRooms.get(i).getName();
            evenMeetingRoomNames.append(meetingRoomName);
            if (i != meetingRooms.size() - 1) {
                evenMeetingRoomNames.append(", ");
            }
        }
        System.out.println(evenMeetingRoomNames);
    }

    public void printAreas() {
        for (MeetingRoom actual : meetingRooms) {
            String roomName = actual.getName();
            int roomWidth = actual.getWidth();
            int roomLength = actual.getLength();
            int roomArea = actual.getArea();
            printRoomDetails(roomName, roomWidth, roomLength, roomArea);
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom actual : meetingRooms) {
            if (name.equals(actual.getName())) {
                int roomWidth = actual.getWidth();
                int roomLength = actual.getLength();
                int roomArea = actual.getArea();
                System.out.printf("width: %d m, length: %d m, area: %d m2%n", roomWidth, roomLength, roomArea);
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
                String roomName = actual.getName();
                int roomWidth = actual.getWidth();
                int roomLength = actual.getLength();
                int roomArea = actual.getArea();
                printRoomDetails(roomName, roomWidth, roomLength, roomArea);
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom actual : meetingRooms) {
            if (area < actual.getArea()) {
                String roomName = actual.getName();
                int roomWidth = actual.getWidth();
                int roomLength = actual.getLength();
                int roomArea = actual.getArea();
                printRoomDetails(roomName, roomWidth, roomLength, roomArea);
            }
        }
    }

    private void printRoomDetails(String roomName, int roomWidth, int roomLength, int roomArea) {
        System.out.printf("%s: width: %d m, length: %d m, area: %d m2%n", roomName, roomWidth, roomLength, roomArea);
    }
}
