package com.Assignment.Voting.Controller;

import com.Assignment.Voting.Service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/entervote")
    public void enterCandidate(@RequestParam String name){
        votingService.enterCandidate(name);
    }

    @PostMapping("/castvote")
    public int castVote(@RequestParam String name){
        return votingService.castVote(name);
    }

    @GetMapping("/countvote")
    public int countVote(@RequestParam String name){
        return votingService.countVote(name);
    }

    @GetMapping("/listvote")
    public Map<String, Integer> listVotes(){
        return votingService.listVotes();
    }

    @GetMapping("/getwinner")
    public String getWinner(){
        return votingService.getWinner();
    }

}
