package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Twitter {
    int time;
    HashMap<Integer,Integer> tweetTimeMap;
    HashMap<Integer, List<Integer>> userTweetMap;
    HashMap<Integer,List<Integer>> userFollowMap;

//    Initating twitter
    public Twitter(){
        time=0;
        tweetTimeMap=new HashMap<>();
        userFollowMap=new HashMap<>();
        userTweetMap=new HashMap<>();
    }

//    Post a new Tweet
    public void postTweet(int userId,int tweetId){
        if(!userTweetMap.containsKey(userId)){
            userTweetMap.put(userId,new ArrayList<>());
        }
        userTweetMap.get(userId).add(tweetId);
        tweetTimeMap.put(tweetId,++time);
    }

//   News Feed
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        List<Integer> follows=userFollowMap.containsKey(userId) ? new ArrayList<>(userFollowMap.get(userId)) : new ArrayList<>();
        follows.add(userId);
        int[] idxs=new int[follows.size()];
        for(int i=0;i<follows.size();i++){
            idxs[i]=(userTweetMap.containsKey(follows.get(i)) ? userTweetMap.get(follows.get(i)).size() : 0)-1;
        }
        for(int i=0;i<10;i++){
            int tempidx=-1,tweetId=-1,latestTime=-1;
            for(int j=0;j<idxs.length;j++){
                if(idxs[j]<0)continue;
                int tweetid=userTweetMap.get(follows.get(j)).get(idxs[j]);
                int thisTime=tweetTimeMap.get(tweetid);
                if(thisTime>latestTime){
                    tempidx=j;
                    tweetId=tweetid;
                    latestTime=thisTime;
                }
            }
            if(latestTime<0) break;
            idxs[tempidx]--;
            res.add(tweetId);
        }
        return res;
    }

//    Follow
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return ;
       if(!userFollowMap.containsKey(followerId)){
           userFollowMap.put(followerId,new ArrayList<>());
       }
       if(!userFollowMap.get(followerId).contains(followeeId)){
           userFollowMap.get(followerId).add(followeeId);
       }
    }

//    Unfollow
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return ;
        if(userFollowMap.get(followerId)!=null && userFollowMap.get(followerId).contains(followeeId)){
            userFollowMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }

    public static void main(String[] args) {
        Twitter tut=new Twitter();
        tut.postTweet(1,5);
        tut.postTweet(1,3);
        System.out.println(tut.getNewsFeed(1));
    }
}
