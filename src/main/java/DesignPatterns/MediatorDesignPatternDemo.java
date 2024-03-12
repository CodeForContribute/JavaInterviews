package DesignPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface Colleague{
    public void placeBid(int amount);
    public void receiveBidNotification(int bidAmount);
    public String getName();
}

interface AuctionMediator{
    public void addBidder(Colleague bidder);
    public void placeBid(Colleague bidder, int bidAmount);
}

class Bidder implements Colleague{
    private final String bidderName;
    private final AuctionMediator auctionMediator;

    public Bidder(AuctionMediator auctionMediator, String bidderName){
        this.bidderName = bidderName;
        this.auctionMediator = auctionMediator;
        this.auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int amount) {
        auctionMediator.placeBid(this,amount);
    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println("DesignPatterns.Bidder: " + bidderName + " got the notification that" +
                "someone has put bid of bidAmount: " + bidAmount);
    }

    @Override
    public String getName() {
        return bidderName;
    }
}

class Auction implements AuctionMediator{
    private final List<Colleague>bidders;
    public Auction(){
        this.bidders = new ArrayList<>();
    }
    public void addBidder(Colleague bidder){
        this.bidders.add(bidder);
    }

    public void placeBid(Colleague bidder, int amount){
        List<Colleague>biddersToNotify = this.bidders
                .stream()
                .filter(b ->!b.getName().equals(bidder.getName()))
                .collect(Collectors.toList());
        biddersToNotify.forEach(b-> b.receiveBidNotification(amount));
    }
}
public class MediatorDesignPatternDemo {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();
        Colleague bidder = new Bidder(auctionMediator,"A");
        Colleague bidder2 = new Bidder(auctionMediator,"B");
        bidder.placeBid(2000);
        bidder2.placeBid(1231);
        bidder.placeBid(3001);
    }
}
