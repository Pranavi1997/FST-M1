package crmProject;

import org.testng.annotations.DataProvider;

public class Commondataproviders {
		@DataProvider(name = "creds")
		public static String[][] creds(){
			return new String[][] {
				{"admin","pa$$w0rd"},
			};
		}
		
}
