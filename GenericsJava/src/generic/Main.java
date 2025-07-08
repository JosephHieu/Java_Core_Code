package generic;

interface Player {
    String name();
}

record BaseballPlayer(String name, String position) implements Player {

}

record FootballPlayer(String name, String position) implements Player {

}

public class Main {

    public static void main(String[] args) {

        BaseballTeam phillies = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Houston Astros");

        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);

        phillies.listTeamMembers();

        SportsTeam phillies1 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros1 = new SportsTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);
        System.out.println("-".repeat(30));

        Team<BaseballPlayer> phillies2 = new Team<>("Philadelphia Phillies");
        Team<BaseballPlayer> astros2 = new Team<>("Houston Astros");
        scoreResult(phillies2, 3, astros2, 5);



    }

    public static void scoreResult (BaseballTeam team1, int t1_score,
                                    BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult (SportsTeam team1, int t1_score,
                                    SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult (Team team1, int t1_score,
                                    Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
