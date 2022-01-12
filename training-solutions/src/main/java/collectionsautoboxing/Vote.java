package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Vote {

    public Map<VoteResult, Integer> getResult(Map<String, VoteResult> votes) {
        int yes = 0;
        int no = 0;
        int abstain = 0;
        for (VoteResult actual : votes.values()) {
            switch (actual) {
                case YES:
                    yes++;
                    break;
                case NO:
                    no++;
                    break;
                case ABSTAIN:
                    abstain++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid vote!");
            }
        }
        return getVoteResultsMap(yes, no, abstain);
    }

    private Map<VoteResult, Integer> getVoteResultsMap(int yes, int no, int abstain) {
        Map<VoteResult, Integer> result = new HashMap<>();
        result.put(VoteResult.YES, yes);
        result.put(VoteResult.NO, no);
        result.put(VoteResult.ABSTAIN, abstain);
        return result;
    }
}
