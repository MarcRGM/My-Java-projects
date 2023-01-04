package MyPrograms.hangman;

public class Words 
{
	// 60 words
	final private String[] EASYWORDS = { "dance", "skip", "jumping jack",
			"shark", "chicken", "alligator",
			"chair", "robot", "head",
			"smile", "baseball", "bird",
			"happy", "scissors", "cheek",
			"back", "jump", "drink",
			"ice cream cone", "car", "airplane",
			"clap", "circle", "pillow",
			"pinch", "kick", "dog",
			"basketball", "sleep", "camera",
			"kangaroo", "arm", "eat",
			"prayer", "elephant", "blink",
			"doll", "spider", "point",
			"balloon", "book", "glasses",
			"stop", "sneeze", "mouth",
			"draw", "football", "telephone",
			"pig", "wave", "door",
			"tail", "turtle", "baby",
			"ear", "monkey", "hopscotch",
			"mosquito", "toothbrush", "ring"};
	
	final private String[] MEDIUMWORDS = { "ping pong", "snowball", "roof",
			"fly", "fang", "bicycle",
			"bear", "cape", "puppet",
			"piano", "lipstick", "salute",
			"hula hoop", "penguin", "banana peel",
			"whisper", "popsicle", "Frankenstein",
			"earthquake", "yo-yo", "road",
			"rain", "alarm clock", "dog leash",
			"chop", "pajamas", "slam dunk",
			"fiddle", "seashell", "jog",
			"seesaw", "nap", "cheerleader",
			"blind", "beg", "shopping cart",
			"Michael Jackson", "limbo, newspaper",
			"twist", "rhinoceros", "cow",
			"tickle", "fetch", "violin",
			"cage", "cello", "braid",
			"skateboard", "stairs", "trumpet",
			"mop", "shovel", "money",
			"soap", "saddle", "wink",
			"tree", "Spider Man", "think"};
			
	final private String[] HARDWORDS = { "peck", "windmill", "party",
			"dentist", "lawn mower", "softball",
			"wig", "stain", "cuff",
			"sunburn", "funny", "sheet",
			"hair dryer", "nightmare", "iPad",
			"shadow", "wax", "fog",
			"sip", "bathroom scale", "taxi",
			"pizza", "sand", "huddle",
			"cowboy", "ticket", "doghouse",
			"stiff", "knot", "president",
			"owl", "wrench", "story",
			"whisk", "quicksand", "spine",
			"chess", "artist", "vest",
			"gingerbread man", "spider web", "bobsled",
			"lung", "washing machine", "oar",
			"torch", "eraser", "mini blinds",
			"mouse trap", "swordfish", "jar",
			"cramp", "flamingo", "cast",
			"honk", "mirror", "business trip",
			"chalk", "gym", "volcano"};
	
	final private String[] REALLYHARDWORDS = { "Will Smith", "defect", "standing ovation",
			"flag", "retaliate", "mascot",
			"shipwreck", "jet lag", "comfort zone",
			"alphabetize", "application", "college",
			"lifestyle", "level", "invitation",
			"applesauce", "crumb", "loyalty",
			"corduroy", "fizz", "shrink ray",
			"game plan", "personal bubble", "déjà vu",
			"Olympian", "oil", "procrastinate",
			"criticize", "space-time continuum", "ergonomic",
			"regret", "teenager", "organize",
			"baby monitor", "Beethoven", "streamline",
			"satellite", "gratitude", "journal",
			"a cappella", "beanstalk", "explore",
			"mine shaft", "dismantle", "weed killer",
			"tachometer", "unemployed", "portfolio",
			"pomp", "evolution", "apathy",
			"advertise", "roundabout", "sandbox",
			"conversation", "negotiate", "Zamboni",
			"silhouette", "aisle", "pendulum"};		
	
	public String[] getEasyWords()
	{
		return EASYWORDS;
	}
	
	public String[] getMediumWords()
	{
		return MEDIUMWORDS;
	}
	
	public String[] getHardWords()
	{
		return HARDWORDS;
	}
	
	public String[] getReallyHardWords() { return REALLYHARDWORDS; }
}
