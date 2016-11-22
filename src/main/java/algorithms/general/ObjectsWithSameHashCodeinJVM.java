package algorithms.general;
/**
 * In JVM heap can there be more than one object with the same hash code?
 * Answer:	Yes.
 * 
 * @author chq-vasanthakumars
 *
 */
public class ObjectsWithSameHashCodeinJVM {

	public static void main(String[] args) {
		String foo = new String("dfa");
		String bar = new String("dfa");
		assert(foo != bar); // yields false, two distinct objects (references)
		assert(foo.hashCode() == bar.hashCode()); // yields true
		
	}

}
