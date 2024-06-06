class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int card: hand)
            queue.add(card);

        if(queue.size() % groupSize != 0)
            return false;

        while(!queue.isEmpty()){
            int currentCard = queue.poll();
            for(int i = 1; i < groupSize; i++){
                // check for the next consecutive number of the pq
                if(queue.remove(i + currentCard))
                    continue;  // keep on doing this until we have groupSize amount of cards
                else // if there is no consecutive card we can return false
                    return false;
            }
        }
        // return true if we get here
        return true;
    }
}