package arraysleftrotation;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Given an array of n integers and a number, , perform left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of n (the number of integers) and d (the number of left rotations you must perform).
The second line contains space-separated integers describing the respective elements of the array's initial state.

Print a single line of n space-separated integers denoting the final state of the array after performing d left rotations.

Sample Input
5 4
1 2 3 4 5

Sample Output
5 1 2 3 4

Explanation
1 2 3 4 5
2 3 4 5 1
3 4 5 1 2
4 5 1 2 3
5 1 2 3 4
*/

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer lenght = in.nextInt();
        Integer leftRotations = in.nextInt();
        
//        firstSolution(in, lenght, leftRotations);
        
        secondSolution(in, lenght, leftRotations);
    }
    
	private static void firstSolution(Scanner in, Integer lenght, Integer leftRotations) {
		LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < lenght; i++){
        	list.add(in.nextInt());
        }
        
        for(int rotation = 0; rotation < leftRotations; rotation++) {
        	list.addLast(list.pollFirst());
        }
        
        list.forEach(element -> { System.out.print(element + " ");});
	}
	
	private static void secondSolution(Scanner in, Integer lenght, Integer leftRotations) {
        int[] output = new int[lenght];
        
        for(int i = 0; i< lenght; i++) {
        	output[(i + lenght - leftRotations) % lenght] = in.nextInt();
        }
        
        IntStream.of(output).forEach(element -> { System.out.print(element + " ");});
	}
}
