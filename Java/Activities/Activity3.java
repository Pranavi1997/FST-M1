
public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double seconds = 1000000000;
        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;
        double earthYears = seconds / EarthSeconds;
        System.out.println("Age of Mercury: " + earthYears/ MercurySeconds);
        System.out.println("Age of Venus: " + earthYears / VenusSeconds);
        System.out.println("Age of Earth: " + earthYears / EarthSeconds);
        System.out.println("Age of Mars: " + earthYears / MarsSeconds);
        System.out.println("Age of Jupiter: " + earthYears / JupiterSeconds);
        System.out.println("Age of Saturn: " + earthYears / SaturnSeconds);
        System.out.println("Age of Uranus: " + earthYears / UranusSeconds);
        System.out.println("Age of Neptune: " + earthYears / NeptuneSeconds);
	}

}
