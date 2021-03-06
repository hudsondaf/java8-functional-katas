package katas;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";
    public static final int WIDTH_150 = 150;
    public static final int HEIGHT_200 = 200;

    public static List<Map> execute() {

	List<MovieList> movieLists = DataUtil.getMovieLists();

	return movieLists.stream().flatMap(movieList -> movieList.getVideos().stream())
				.map(functionVideoToMap())
				.collect(Collectors.toList());
    }
    
    public static Function<Movie, ImmutableMap<String,Object>> functionVideoToMap(){
    	return video -> ImmutableMap.of(ID, video.getId(), TITLE, video.getTitle(), BOXART, video.getBoxarts().stream()
		.filter(predicateBoxart150x200()).map(BoxArt::getUrl).findFirst().orElse(""));
    }
    
    public static Predicate<BoxArt> predicateBoxart150x200(){
    	return boxart -> boxart.getWidth() == WIDTH_150 && boxart.getHeight() == HEIGHT_200;
    }
}

