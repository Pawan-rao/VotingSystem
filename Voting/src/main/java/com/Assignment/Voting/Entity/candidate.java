package com.Assignment.Voting.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class candidate {
    private String name;
    private  int VoteCount;

    public candidate(String name, int voteCount) {
        this.name = name;
        this.VoteCount = voteCount;
    }
}
