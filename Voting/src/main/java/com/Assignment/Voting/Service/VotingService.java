package com.Assignment.Voting.Service;

import com.Assignment.Voting.Entity.candidate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VotingService {

    private Map<String, candidate> candidates = new HashMap<>();

    public void enterCandidate(String name){
        if (name != null && !name.isEmpty()){
            candidates.put(name, new candidate(name, 0));
        }else{
            System.out.print("invalid");
        }
    }

    public int castVote(String name){
        candidate can = candidates.get(name);
        if (can != null){
            can.setVoteCount(can.getVoteCount() + 1);
            return can.getVoteCount();
        }else{
            return -1; // invalid vote
        }
    }

    public Map<String, Integer> listVotes(){
        Map<String, Integer> result = new HashMap<>();
        candidates.forEach((name, can) -> {
            // Check for null or empty name before adding to the result
            if (Objects.nonNull(name) && !name.isEmpty()) {
                result.put(name, can.getVoteCount());
            }
        });
        return result;
    }

    public String getWinner(){
        candidate winner = candidates.values().stream().max((c1, c2 )-> Integer.compare(c1.getVoteCount(), c2.getVoteCount()))
                .orElse(null);
        return (winner != null) ? winner.getName(): null;
    }

    public int countVote(String name) {
        candidate can = candidates.get(name);
        return (can != null) ? can.getVoteCount() : -1;
    }

    public Map<String, candidate> getCandidates() {
        return candidates;

    }
}
