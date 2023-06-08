/**
 * 
 */
package cs146F22.Jorapur.project1;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author aditi jorapur
 * @date 9/18/2022
 *
 */
public class SinglyLinkedListTest {
	
	static SinglyLinkedList <Integer> sing1 = new SinglyLinkedList <Integer>();
	static SinglyLinkedList <Integer> sing2 = new SinglyLinkedList <Integer>();
	static SinglyLinkedList <String> sing3 = new SinglyLinkedList <String>();
	static SinglyLinkedList <String> sing4 = new SinglyLinkedList <String>();
	static SinglyLinkedList <String> sing5 = new SinglyLinkedList <String>();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for(int i=0; i<3; i++) {
			sing1.add(i);
			sing2.add(i+2);
		}
	//	System.out.println(s1);
			sing3.add("Bob");
			sing3.add("Dylan");
			sing3.add("Chris");
			
			sing4.add("Fred");
			sing4.add("Dylan");
			sing4.add("Zayn");
			
			sing5.add("hi");
			sing5.add("bye");
			sing5.add("hello");

			
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		//adds in 2 values, tries adding in a duplicate value
		sing1.add(10);
		sing1.add(1); 
		//System.out.println(s1);
		assertEquals(sing1.toString(), "{10, 2, 1, 0}");
		
		sing2.add(14);
		sing2.add(2); 
	//	System.out.println(s2); 
		assertEquals(sing2.toString(), "{14, 4, 3, 2}");
		
		
		sing4.add("Rob");
		sing4.add("Bobby");
		
		//adding another duplicate value
		sing3.add("Bob");
		sing3.add("George");

		
		

	}
	
	@Test
	public void testRemove() {
		//System.out.println(sing1);
		sing1.remove(1); //deleting one
		//System.out.println(s1);
		//System.out.println(s1.toString());
		assertEquals(sing1.toString(), "{10, 2, 0}");
		//System.out.println(s2);
		sing2.remove(3);
		//System.out.println(s2);
		assertEquals(sing2.toString(), "{14, 4, 2}");
	}
	
	@Test
	public void testNumItems() {
		assertEquals(sing4.numItems(), 5);
	}
	
	@Test
	public void testIsMember() {
		//testing with name that is in the linkedlist and name that is not
		boolean test2 = sing4.isMember("Fred"); 
		assertEquals(test2, true);
		boolean test = sing4.isMember("Joanne"); 
		assertEquals(test, false);
		
		
	}
	
	@Test
	public void testReference() {
		assertEquals(sing3.reference("Dylan").getData(), "Dylan");
	}
	
	@Test
	public void testUnion() {
		//assertEquals(sing3.union(sing4).toString(), "{Bob, Chris, George, Fred, Dylan, Zayn, Rob, Bobby}");
//		System.out.println("sing3: " + sing3.toString());
//		System.out.println("sing4: " + sing4.toString());
//		System.out.println("union: " + sing3.union(sing4).toString());
		assertEquals(sing3.union(sing4).toString(), "{Bob, Chris, George, Bobby, Rob, Zayn, Dylan, Fred}");
	}
	
	@Test
	public void testIntersection() {
		//System.out.println(s3);
		//System.out.println(s4);
		//System.out.println(s3.intersection(s4).toString());
		assertEquals(sing3.intersection(sing4).toString(), "{Dylan}");
	
	}
	
	@Test
	public void testClone() {
		
		SinglyLinkedList <String> sing6 = new SinglyLinkedList <String>();
		sing6.clone(sing5);
//		System.out.println("og Sing5 " + sing5.toString());
//		sing6.clone(sing5);
//		System.out.println("Sing5 " + sing5.toString());
//		System.out.println("Sing6" + sing6.toString());
		assertEquals(sing6.clone(sing5).toString(), sing5.toString());
	}
	
	
	

}
