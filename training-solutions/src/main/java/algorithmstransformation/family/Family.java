package algorithmstransformation.family;

import java.util.ArrayList;
import java.util.List;

public class Family {

    private List<FamilyMember> members;

    public Family() {
        this.members = new ArrayList<>();
    }

    public void addFamilyMember(FamilyMember member) {
        this.members.add(member);
    }

    public List<Integer> getAgesOfFamilyMembersWithNameGiven(String name) {
        List<Integer> ages = new ArrayList<>();
        for (FamilyMember member : this.members) {
            if (member.getName().contains(name)) {
                ages.add(member.getAge());
            }
        }
        return ages;
    }

    public List<FamilyMember> getMembers() {
        return members;
    }
}
