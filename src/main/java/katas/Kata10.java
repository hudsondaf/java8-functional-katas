package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";
    public static final String NAME = "name";
    public static final String VIDEOS = "videos";
    public static final String LIST_ID = "listId";

    public static List<Map> execute() {

	List<Map> lists = DataUtil.getLists();
	List<Map> videos = DataUtil.getVideos();

	return lists.stream()
		.map(list -> ImmutableMap.of(NAME, list.get(NAME), VIDEOS,
			videos.stream().filter(video -> video.get(LIST_ID).equals(list.get(ID)))
				.map(video -> ImmutableMap.of(ID, video.get(ID), TITLE, video.get(TITLE)))
				.collect(Collectors.toList())))
		.collect(Collectors.toList());
    }

}
