package MyPrograms.BreathingCompetition;

public class Players
{
	private String name;
	private double breathDuration;

	private double average;

	Players()
	{
		int players = 0;
		players++;
		System.out.println("Player " + players + " has been created");
	}

	public String getName()
	{
		return name;
	}

	public double getBreathDuration()
	{
		return breathDuration;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setBreathDuration(double breathDuration)
	{
		this.breathDuration += breathDuration;
	}

	public double getAverage()
	{
		return average;
	}

	public void setAverage(double breathDuration)
	{
		average = breathDuration / 3;
	}


}
