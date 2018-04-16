package indi.linj2n.filterDemo.dao;
import indi.linj2n.filterDemo.domain.User;

public interface IUserDAO {
	public void add(User user) ;
	
	public void find(String userName);
	
	public void find(int userId);
}
