package sem2.cw1answers;

import java.util.Arrays;
import java.util.List;

public class TeamData implements Comparable<TeamData> {
    private String name;
    private int solved;
    private int totalTime;
    private int problems;
    public TeamData(String name, int problems) {
        this.name = name;
        this.problems = problems;
        this.totalTime = 0;
        this.solved = 0;
    }
    public void success(int problem, int time) {
        solved++;
        totalTime += time;
    }
    public String toString() {
        return name + " solved " + solved + " of " + problems + " in "
                + totalTime + " minutes";
    }
    public int solved() {
        return solved;
    }
    public int time() {
        return totalTime;
    }
    public double percentCorrect() {
        return 100.0 * solved / problems;
    }


    // x > y | x.compareTo(y) > 0 // true
    // x == y | x.compareTo(y) == 0 // true
    // x < y | x.compareTo(y) < 0 // true
    @Override
    public int compareTo(TeamData other) {
//        if (solved != other.solved) {
//            return other.solved - solved;
//        } {
//            return time() - other.time();
//        }
        if (percentCorrect() != other.percentCorrect()) {
//            return Double.compare(other.percentCorrect(), percentCorrect());
            if (percentCorrect() > other.percentCorrect()) {
                return -1;
            } else {
                return 1;
            }
        } {
            return time() - other.time();
        }
    }
}

class TeamDataTest {
    public static <T extends TeamData> void sortBubble(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list.get(j).compareTo(list.get(j+1)) > 0)
                {
                    // swap arr.indexOf(j+1) and arr[i] 
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1 , temp);
                }
    }


    public static void main(String[] args) {
        TeamData team1 = new TeamData("UW Red", 8);
        team1.success(3, 18);
        team1.success(4, 82);
        team1.success(6, 130);


        TeamData team2 = new TeamData("itis", 8);
        team2.success(3, 18);
        team2.success(4, 82);
        team2.success(6, 130);
        TeamData team3 = new TeamData("imm", 8);
        team3.success(2, 51);
        team3.success(4, 63);
        team3.success(1, 54);
        team3.success(6, 54);
        TeamData team4 = new TeamData("vmk", 8);
        team4.success(3, 1);

        List<TeamData> list = Arrays.asList(team1, team2, team3, team4);

        list.sort(TeamData::compareTo);



    }
}
