package task1;

public class TeamDataTest {
    public static void main(String[] args) {
        TeamData team1 = new TeamData("UW Red", 8);
        team1.success(3, 18);
        team1.success(4, 82);
        team1.success(6, 130);
        System.out.println(team1);	// UW Red solved 3 of 8 in 230 minutes
        System.out.println(team1.solved()); 			// 3
        System.out.println(team1.time()); 				// 230
        System.out.println(team1.percentCorrect()); 		// 37.5.
    }
}
