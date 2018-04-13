package demo.ShoppingCart;

public class DATEUtil {
	public static java.sql.Timestamp getCurrentTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}
    public static java.sql.Timestamp d2t(java.util.Date date) {
        if (null == date)
            return null;
        return new java.sql.Timestamp(date.getTime());
    }
 
    public static java.util.Date t2d(java.sql.Timestamp time) {
        if (null == time)
            return null;
        return new java.util.Date(time.getTime());
    }
}
