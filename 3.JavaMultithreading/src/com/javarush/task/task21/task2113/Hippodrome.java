package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        Horse h1 = new Horse("Гласарик", 3, 0);
        Horse h2 = new Horse("Жопосранчик", 3, 0);
        Horse h3 = new Horse("Карандашурик", 3, 0);
        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);
        game.run();
        game.printWinner();

    }

    public List<Horse> getHorses(){
        return horses;
    }

    public void move(){

        for (Horse horse :horses) {
            horse.move();
        }
    }

    public void run(){

        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void print(){
        for (Horse horse :horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = null;
        for (Horse horse :horses) {
            if(winner == null){
                winner = horse;
            }
            if(winner.getDistance() < horse.getDistance()){
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    private List<Horse> horses;
    static Hippodrome game;

}
