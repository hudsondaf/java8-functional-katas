package util;

import java.util.Map;

import model.BoxArt;

public class KatasUtils {
	
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
	
	
	public static BoxArt largestBoxArt(BoxArt boxart1, BoxArt boxart2){
		return boxart1.getHeight() * boxart1.getWidth() > boxart2.getHeight() * boxart2.getWidth()
				? boxart1 : boxart2;
	}
	
	public static BoxArt smallestBoxArt(BoxArt boxart1, BoxArt boxart2){
		return boxart1.getHeight() * boxart1.getWidth() < boxart2.getHeight() * boxart2.getWidth()
				? boxart1 : boxart2;
	}
	
	public static Map smallestBoxArt(Map boxart1, Map boxart2){
		return ((Integer) boxart1.get(WIDTH))
				* ((Integer) boxart1.get(HEIGHT)) < ((Integer) boxart2.get(WIDTH))
				* ((Integer) boxart2.get(HEIGHT)) ? boxart1 : boxart2;
	}

}
