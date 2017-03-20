package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {

        Solution solution = null;

        if(n == null){
            System.out.println("null");
            return false;
        }

        if(this == n){
            return true;
        }

        if(n instanceof Solution){
            solution = (Solution) n;
        }

        if(this.first != null ? !(this.first.equals(solution.first)): solution.first != null){
            return false;
        }

        if(this.last != null ? !(this.last.equals(solution.last)): solution.last != null){
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        int a = 0;
        int b = 0;
        if(first == null){
            a = 0;
        } else {
            a = first.length();
        }

        if(last == null){
            b = 1;
        } else {
            b = last.length();
        }

        return a + 10 * b;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();

        s.add(new Solution(null, "Duck"));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
