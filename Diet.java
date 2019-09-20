import java.io.Serializable;

public class Diet implements Serializable {
int date;
String menu;
String time;

Diet(){
}
	Diet(int date, String menu, String time){
		this.date = date;
		this.menu = menu;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Diet [date=" + date + ", menu=" + menu + ", time=" + time + "]";
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
}
