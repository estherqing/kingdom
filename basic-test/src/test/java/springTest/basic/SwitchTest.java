package springTest.basic;
 
public class SwitchTest {

	enum Signal{  
	    GREEN,YELLOW,RED;  
	}
	public static void main(String[] args) {
		 enumTest();
		 stringTest();
	}

	static void enumTest(){
		Signal color = Signal.RED;

		switch (color) {
		case RED:
			color = Signal.YELLOW;
			break;
		case YELLOW:
			color = Signal.RED;
		case GREEN:
			color = Signal.YELLOW;
		default:
			System.out.println("什么鬼灯");
			break;
		}

		System.out.println("color:" + color);
	}
	
	static void stringTest(){
		int season = 0;  
        String strSeason = "Summer";  
        switch (strSeason.toLowerCase()) {  
        case "spring":  
            season = 1;  
            break;  
        case "summer":  
            season = 2;  
            break;  
        case "fall":  
            season = 3;  
            break;  
        case "winter":  
            season = 4;  
            break;  
        default:  
            season = -1;// 没找到对应的季节  
            break;  
        }  
        System.out.println(strSeason + "-->" + season);
	}
}
