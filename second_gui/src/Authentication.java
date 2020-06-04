
public interface Authentication {
	boolean login(String email,String password);
    boolean signup(String email,String password);
    void logout();
}
