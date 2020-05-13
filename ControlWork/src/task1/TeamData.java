package task1;

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
    public int compareTo(TeamData other) {
        if (solved != other.solved){
            return other.solved - solved;
        } else {
            return totalTime - other.totalTime;
        }
    }
}
