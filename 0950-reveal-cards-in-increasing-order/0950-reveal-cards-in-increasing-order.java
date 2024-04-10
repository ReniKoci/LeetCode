class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {    
        Integer[] deckInteger = Arrays.stream(deck).boxed().toArray(Integer[]::new);
        Arrays.sort(deckInteger, Collections.reverseOrder());
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        while(deque.size() != deck.length){
            if(deque.isEmpty())
                deque.addFirst(deckInteger[index++]);
            else{
                deque.addFirst(deque.removeLast());
                deque.addFirst(deckInteger[index++]);
            }
            System.out.println(deque.getFirst());
        }

        int[] res = new int[deck.length];
        index = 0;
        while(!deque.isEmpty())
            res[index++] = deque.removeFirst();

        return res;
    }
}