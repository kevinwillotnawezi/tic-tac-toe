package com.example.tictactoe.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private User user1;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private User user2;

    @Column(nullable = false)
    private char [][] test = new char[3][3];

    private char valueUser1;
    private char valueUser2;
}
