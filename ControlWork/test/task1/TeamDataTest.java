package task1;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import student.TeamData;

public class TeamDataTest {

    private TeamData stub;

    @Before
    public void setUp() throws Exception {
        stub = new TeamData("UW Red", 8);
        stub.success(3, 18);
        stub.success(4, 82);
        stub.success(6, 130);
        stub.success(8, 0);
    }

    @Test
    public void newInstanceTest() throws NoSuchFieldException, IllegalAccessException {
        Field name = stub.getClass().getDeclaredField("name");
        name.setAccessible(true);
        assertEquals("UW Red", name.get(stub));
        Field problems = stub.getClass().getDeclaredField("problems");
        problems.setAccessible(true);
        assertEquals("Общее число задач", 8, problems.get(stub));
        assertEquals("Потраченное время", 230, stub.time());
        assertEquals("Число решенных задач", 4, stub.solved());
        assertNotNull(stub);
    }

    @Test
    public void toStringTest() {
        System.out.println(stub.toString());
        assertTrue(stub.toString().contains("4") &&
                stub.toString().contains("8") &&
                stub.toString().contains("230"));
    }

    @Test
    public void percentCorrect() {
        assertEquals(50, stub.percentCorrect(), 0.00000001);
    }

    @Test
    public void compareTo() throws NoSuchFieldException, IllegalAccessException {
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

        List<TeamData> list = Arrays.asList(stub, team2, team3, team4);
        System.out.println("Before sort list = " + list);
        list.sort(TeamData::compareTo);
        System.out.println("After sort list = " + list);
        List<String> test = Arrays.asList("imm", "UW Red", "itis", "vmk");
        int i = 0;
        for (TeamData teamData : list) {
            Field name = teamData.getClass().getDeclaredField("name");
            name.setAccessible(true);
            assertEquals(test.get(i++), name.get(teamData));
        }
    }

    @Test
    public void compareToEqual() {
        TeamData team2 = new TeamData("itis", 8);
        team2.success(3, 18);
        team2.success(4, 82);
        team2.success(6, 130);
        team2.success(8, 0);
        System.out.println(String.format("%s == %s?%n", stub, team2));
        assertEquals(0, stub.compareTo(team2));
    }

    @Test
    public void compareToLeftMoreByFirst() {
        TeamData team2 = new TeamData("itis", 8);
        team2.success(3, 18);
        team2.success(4, 82);
        team2.success(6, 130);
        assertTrue(String.format("left solve > right solve => %s > %s%n", stub, team2),
                stub.compareTo(team2) < 0);
        System.out.println(String.format("%s > %s?%n", stub, team2));
    }

    @Test
    public void compareToLeftMoreBySecond() {
        TeamData team2 = new TeamData("itis", 8);
        team2.success(3, 18);
        team2.success(4, 82);
        team2.success(6, 130);
        team2.success(8, 1);
        assertTrue(stub.compareTo(team2) < 0);
    }

    @Test
    public void compareToRightMoreByFirst() {
        TeamData team2 = new TeamData("itis", 8);
        team2.success(3, 18);
        team2.success(4, 82);
        team2.success(6, 130);
        team2.success(5, 0);
        team2.success(1, 12);
        assertTrue(stub.compareTo(team2) > 0);
    }

    @Test
    public void compareToRightMoreBySecond() {
        TeamData team2 = new TeamData("itis", 8);
        team2.success(3, 18);
        team2.success(4, 82);
        team2.success(6, 120);
        team2.success(8, 1);
        assertTrue(stub.compareTo(team2) > 0);
    }

}