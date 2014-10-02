package ca.ualberta.cs.lonelytwitter.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;
import ca.ualberta.cs.lonelytwitter.AbstractTweet;

public class AbstractTweetTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	public AbstractTweetTest()
	{

		super(LonelyTwitterActivity.class);
	}

	public void testFiveisFive()
	{

		assertEquals("Five is ive", 5, 5);
	}

	public void testAbstractTweet()
	{

		Tweet t = new Tweet("Helo");
		String actual = t.getTweetBody();

		assertEquals("Tweet body is the same", "Helo", actual);

		Tweet t2 = new Tweet("Helo");
		// same chekcs mem addresss
		// assertSame("Same tweets", t, t2);
		assertEquals("Same tweets", t, t2);

	}

	public void testAddTweet(){
		TweetListModel tweets = new TweetListModel();
		Tweet t1 = new Tweet("Good morning.");
		Tweet t2 = new Tweet("Good morning.");
		Tweet t3 = new Tweet("Bad morning.");
		if (tweets.hasTweet(t1)){
			//do nothing
		} else{
			tweets.addTweet(t1);
		} 
		if (tweets.hasTweet(t2)){
			//throw new IllegalArgumentException();

		} else{
			tweets.addTweet(t2);
		}
		
		if (tweets.hasTweet(t3)){
			//throw new IllegalArgumentException();
		} else{
			tweets.addTweet(t3);
		}
		assertTrue("Wrong size", tweets.getList().size() == 2);
		assertTrue("Repeat tweet inside",tweets.getList().contains(t2));
		}
	public void testCount(){
		TweetListModel tweets = new TweetListModel();
		
		Tweet t1 = new Tweet("Good morning.");
		tweets.addTweet(t1);
		assertTrue("incorrect count=1", tweets.getList().size() == 1);
		assertTrue("incorrect tweet inside", tweets.getList().contains(t1));
		
		Tweet t2 = new Tweet("The night is dark and full of winter");
		tweets.addTweet(t2);
		assertTrue("incorrect count =2", tweets.getList().size() == 2);
		assertTrue("incorrect tweet inside", tweets.getList().contains(t2));
		
	}
	public void testHas(){
		TweetListModel tweets = new TweetListModel();

		Tweet t1 = new Tweet("Good morning.");
		tweets.addTweet(t1);
		Tweet t2 = new Tweet("The night is dark and full of winter");
		assertTrue("t1 not in tweets",tweets.getList().contains(t1) );
		assertFalse("t2 in tweets", tweets.getList().contains(t2));

	}
	
	public void testRemove(){
		TweetListModel tweets = new TweetListModel();
		Tweet t1 = new Tweet("Good morning.");
		tweets.addTweet(t1);
		Tweet t2 = new Tweet("The night is dark and full of winter");
		tweets.addTweet(t2);
		assertTrue("t1 not in tweets",tweets.getList().contains(t1) );
		assertTrue("t2 not in tweets",tweets.getList().contains(t2) );
		tweets.removeTweet(t1);
		assertFalse("t1 not in tweets",tweets.getList().contains(t1) );
		assertTrue("Correct List size", tweets.getList().size() == 1);
	}
	public void testGetTweets() throws ParseException{
		TweetListModel tweets = new TweetListModel();
		String oldstring = "2014-01-18 00:00:00.0";
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
		Tweet t1 = new Tweet("ZZZZ");
		t1.setTweetDate(date);
		tweets.addTweet(t1);
		String olddstring = "2011-01-18 00:00:00.0";
		Date ddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(olddstring);
		Tweet t2 = new Tweet("AAAAA");
		t2.setTweetDate(ddate);
		tweets.addTweet(t2);
		
		AbstractTweet[] moose = tweets.getTweets();
		assertTrue("Tweet 2 is not first", moose[0]==t2);
		

	}
	
}
