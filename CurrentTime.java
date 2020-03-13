package moblima;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class CurrentTime {
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	 LocalDateTime now = LocalDateTime.now();  
	 private String time = dtf.format(now); 
	 
}

