public class Main {
    public static void main(String[] args) {

        FootBallPlayer joe = new FootBallPlayer("Joe");
        BaseBallPlayer tim = new BaseBallPlayer("Tim");
        SoccerPlayer friede = new SoccerPlayer("Friede");

        Team<SoccerPlayer> muenchen = new Team<>("München");
        muenchen.addPlayer(friede);
        Team<BaseBallPlayer> frankfurt = new Team<>("Frankfurt");
        frankfurt.addPlayer(tim);
//        System.out.println(adelaide.getName() + adelaide.ranking());
//        System.out.println(harthorn.getName() + harthorn.ranking());
//        System.out.println(fremantle.getName() + fremantle.ranking());
//
//        System.out.println(adelaide.compareTo(harthorn));
//        System.out.println(adelaide.compareTo(fremantle));
//        System.out.println(fremantle.compareTo(adelaide));

        System.out.println("===========");

        League<Team<FootBallPlayer>> bundesliga = new League<>("1. Bundesliga");

        Team<FootBallPlayer> harthorn = new Team<>("Harthorn");
        Team<FootBallPlayer> fremantle = new Team<>("Fremantle");
        Team<FootBallPlayer> dortmund = new Team<>("Borussia Dortmund");
        Team<FootBallPlayer> eintracht = new Team<>("Eintracht Frankfurt");
        Team<FootBallPlayer> koeln = new Team<>("1. FC Köln");
        Team<FootBallPlayer> unterhachingen = new Team<>("whatever Unterhachingen");
        Team<FootBallPlayer> adelaide = new Team<>("Adelaide");
        adelaide.addPlayer(joe);
        bundesliga.addTeam(adelaide);
        bundesliga.addTeam(harthorn);
        bundesliga.addTeam(fremantle);
        bundesliga.addTeam(dortmund);
        bundesliga.addTeam(eintracht);
        bundesliga.addTeam(koeln);
        bundesliga.addTeam(unterhachingen);

        harthorn.matchResult(fremantle, 1, 0);
        harthorn.matchResult(adelaide, 3 ,8);
        adelaide.matchResult(fremantle, 2, 1);
        dortmund.matchResult(eintracht, 5, 0);
        dortmund.matchResult(koeln, 10, 0);
        koeln.matchResult(eintracht, 1, 1);
        koeln.matchResult(unterhachingen, 2, 1);
        unterhachingen.matchResult(dortmund, 1, 10);
        unterhachingen.matchResult(eintracht,2, 3);

        bundesliga.printSorted();


        League<Team> baseBallLiga = new League("base");
        baseBallLiga.addTeam(frankfurt);

    }
}
