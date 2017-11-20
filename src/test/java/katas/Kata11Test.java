package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata11Test {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";
    public static final String NAME = "name";
    public static final String VIDEOS = "videos";
    public static final String LIST_ID = "listId";
    public static final String TIME = "time";
    public static final String VIDEO_ID = "videoId";
    public static final String URL = "url";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";

    @Test
    public void testExecute() {
	Assert.assertThat(Kata11.execute().size(), equalTo(2));
    }

    @Test
    public void testExecute1() {
	Assert.assertThat(Kata11.execute(),
		equalTo(ImmutableList.of(
			ImmutableMap.of(NAME, "New Releases", VIDEOS,
				ImmutableList.of(
					ImmutableMap.of(ID, 65432445, TITLE, "The Chamber", TIME, 32432, BOXART,
						"http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"),
					ImmutableMap.of(ID, 675465, TITLE, "Fracture", TIME, 3534543, BOXART,
						"http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"))),
			ImmutableMap.of(NAME, "Thrillers", VIDEOS,
				ImmutableList.of(
					ImmutableMap.of(ID, 70111470, TITLE, "Die Hard", TIME, 645243, BOXART,
						"http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
					ImmutableMap.of(ID, 654356453, TITLE, "Bad Boys", TIME, 984934, BOXART,
						"http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"))))));
    }
}
