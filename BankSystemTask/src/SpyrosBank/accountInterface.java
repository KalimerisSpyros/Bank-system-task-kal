package SpyrosBank;

import java.util.HashMap;

public interface accountInterface {
	
	public void addnewaccount(HashMap<Integer,Account> map);
	public void showallacounts(HashMap<Integer,Account> mymap);
	public void deleteAccount(HashMap<Integer,Account> mymap);

}
