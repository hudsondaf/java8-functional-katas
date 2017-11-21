package katas;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;

import model.Bookmark;
import model.Movie;
import util.DataUtil;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {

    public static final String VIDEO_ID = "videoId";
    public static final String BOOKMARK_ID = "bookmarkId";

    public static List<Map> execute() {
	List<Movie> movies = DataUtil.getMovies();
	List<Bookmark> bookMarks = DataUtil.getBookMarks();

	Stream<Movie> streamMovies = movies.stream();
	Stream<Bookmark> streamBookmarks = bookMarks.stream();

	return StreamUtils.zip(streamMovies, streamBookmarks, biFunctionCombine())
		.collect(Collectors.toList());
    }
    
    public static BiFunction<Movie, Bookmark, ImmutableMap<String, Object>> biFunctionCombine(){
    	return (movie, bookmark) -> ImmutableMap.of(VIDEO_ID, movie.getId(), BOOKMARK_ID, bookmark.getId());
    }
}
