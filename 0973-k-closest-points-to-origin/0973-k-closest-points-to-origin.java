class Solution {


    // improvment on below solution
    // instead of creating a class, create a PQ with a int[] datatype
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0] +  a[1]*a[1]) - (b[0]*b[0] +  b[1]*b[1]));
        for(int i = 0; i < points.length; i++){
            pq.offer(points[i]);
        }
        int[][] output = new int[k][2];

        for(int i = 0; i < k; i++){
            output[i] = pq.poll();
        }
        return output;
    }




    // solve the problem by using mean heap, sort by the distnace and return the indeces
    // create a helper class which will store a key value pair
    // key -> the distance from the origin
    // value -> index of point
    class Pair{
        private int key;
        private int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return this.key;
        }

        public int getValue(){
            return this.value;
        }
    }
    public int[][] kClosestWithClass(int[][] points, int k) {
        // define a min heap
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        for(int i = 0; i < points.length; i++){
            int x = points[i][0], y = points[i][1];
            int distance = x * x + y * y;
            // create pair and store it onthe priority queue
            pq.offer(new Pair(distance, i));
        }

        // loop through the priority queue k times and save the points into an output matrix
        int[][] output = new int[k][2];
        for(int i = 0; i < k; i++){
            Pair point = pq.poll();
            output[i] = points[point.getValue()];
        }
        return output;
    }
}