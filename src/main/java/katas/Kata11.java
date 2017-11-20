package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            NAME: "New Releases",
            VIDEOS: [
                {
                    ID: 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    ID: 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            NAME: "Thrillers",
            VIDEOS: [
                {
                    ID: 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    ID: 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {

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

    public static List<Map> execute() {
	List<Map> lists = DataUtil.getLists();
	List<Map> videos = DataUtil.getVideos();
	List<Map> boxArts = DataUtil.getBoxArts();
	List<Map> bookmarkList = DataUtil.getBookmarkList();

	return lists.stream()
		.map(list -> ImmutableMap.of(NAME, list.get(NAME), VIDEOS, videos
			.stream().filter(video -> video.get(LIST_ID).equals(list.get(ID))).map(video -> ImmutableMap.of(
				ID, video.get(ID), TITLE,
				video.get(TITLE), TIME,
				bookmarkList.stream()
					.filter(bookmark -> video.get(ID).equals(bookmark.get(VIDEO_ID))).findFirst()
					.get().get(
						TIME),
				BOXART,
				boxArts.stream().filter(boxart -> boxart.get(VIDEO_ID).equals(video.get(ID)))
					.reduce((boxart1, boxart2) -> ((Integer) boxart1.get(WIDTH))
						* ((Integer) boxart1.get(HEIGHT)) < ((Integer) boxart2.get(WIDTH))
							* ((Integer) boxart2.get(HEIGHT)) ? boxart1 : boxart2)
					.get().get(URL)))
			.collect(Collectors.toList())))
		.collect(Collectors.toList());
    }
}
