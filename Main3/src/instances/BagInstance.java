package instances;

import bags.BodyBag;
import bags.CourseBag;
import bags.TBookBag;

public class BagInstance {
	public final static BodyBag bb = new BodyBag(1000);
	public final static CourseBag cb = new CourseBag(1000);
	public final static TBookBag tbb = new TBookBag(1000);
	
	private BagInstance() {
		
	}
}
