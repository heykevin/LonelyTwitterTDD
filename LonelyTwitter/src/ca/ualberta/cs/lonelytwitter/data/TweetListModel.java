package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;

public class TweetListModel
{

	private List<AbstractTweet> tweets = new ArrayList<AbstractTweet>();

	public TweetListModel()
	{

	}

	public TweetListModel(List<AbstractTweet> tweets)
	{

		this.tweets = tweets;
	}

	/**
	 * Appends the specified tweet to the end of this list. Throws
	 * IllegalArgumentException if it is a repeated tweet.
	 * 
	 * @param tweet
	 *            Tweet to be appended to this list
	 */
	public void addTweet(AbstractTweet tweet)
	{

		// TODO: Add only when it is not a duplicate

		if (tweets.contains(tweet))
		{
			throw new IllegalArgumentException();
		} else
		{
			tweets.add(tweet);
		}

	}

	/**
	 * Returns the number of tweets in this list.
	 * 
	 * @return the number of tweets in this list
	 */
	public int getCount()
	{

		// TODO: return real count
		return tweets.size();
	}

	/**
	 * Returns true if this list contains the tweet
	 * 
	 * @param tweet
	 *            Tweet whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean hasTweet(AbstractTweet tweet)
	{

		// TODO: Find if the tweet already exists
		return tweets.contains(tweet);
	}

	/**
	 * Removes the first occurrence of the specified tweet from this list, if it
	 * is present.
	 * 
	 * @param tweet
	 *            Tweet to be removed from this list, if present.
	 */
	public void removeTweet(AbstractTweet tweet)
	{

		tweets.remove(tweet);
	}

	/**
	 * Returns an array containing all of the tweets in this list in proper
	 * sequence.
	 * 
	 * @return an array containing the tweets of the list.
	 */
	public AbstractTweet[] getTweets()
	{
		// TODO: return sorted list of tweets

	Collections.sort(tweets, new Comparator<AbstractTweet>(){
	
		public int compare(AbstractTweet tweet1, AbstractTweet tweet2)
		{
			return tweet1.getTweetDate().compareTo(tweet2.getTweetDate());
		}
	});
	
	List<AbstractTweet> cows = tweets;
	return cows.toArray(new AbstractTweet[this.getCount()]);
	}

	/**
	 * Returns the list of tweets.
	 * 
	 * @return The list of tweets.
	 */
	public List<AbstractTweet> getList()
	{

		return tweets;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after
	 * this call returns.
	 */
	public void clear()
	{

		tweets.clear();
	}
}