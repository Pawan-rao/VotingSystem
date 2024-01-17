package com.Assignment.Voting.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VotingServiceTest {

    @InjectMocks
    private VotingService votingService;

    @Test
    public void testEnterCandidate() {
        String candidateName = "Candidate1";

        // Call the method
        votingService.enterCandidate(candidateName);

        // Assert that the candidate is added to the map
        assertNotNull(votingService.getCandidates().get(candidateName));
    }

    @Test
    public void testcastvote(){
        String candidateName = "Candidate1";

        //ensure that the candidate is enterd
        votingService.enterCandidate(candidateName);

        //call the method
        int voteCount = votingService.castVote(candidateName);

        //assert that vote count is as expected
        assertEquals(1,voteCount);
    }

    @Test
    public void testListVotes() {
        String candidateName = "Candidate1";
        votingService.enterCandidate(candidateName);

        // Call the method
        Map<String, Integer> result = votingService.listVotes();

        // Assert that the map contains the expected entry
        assertTrue(result.containsKey(candidateName));
    }

    @Test
    public void testGetWinner() {
        String candidateName = "Candidate1";
        votingService.enterCandidate(candidateName);

        // Call the method
        String winner = votingService.getWinner();

        // Assert that the winner is as expected
        assertEquals(candidateName, winner);
    }
}
