package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		return Comparator.comparing(Media::getTitle).thenComparing(Media::getCost).compare(o1, o2);
	}


}
