package com.dpavlenko.proxy;

public class TwitterDemo {

	public static void main(String[] args) {
		TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());

		//to use the one below - create an own Twitter app and re-set credentials
		//TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());

		System.out.println(service.getTimeline("bh5k"));
		
		service.postToTimeline("bh5k", "Some message that shouldn't go through.");
	}
}
