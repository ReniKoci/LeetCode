class Robot{
    int position;
    int health;
    char direction;
    int index;

    public Robot(int position, int health, char direction, int index){
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }
}
class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> res = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        for(int i = 0; i < positions.length; i++) // (O(n))
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        
        // sort based on direction O(nlogn)
        Collections.sort(robots, (r1, r2) -> Integer.compare(r1.position, r2.position));

        Stack<Robot> rightDirection = new Stack<>();
        Stack<Robot> leftDirection = new Stack<>();

        // fill rightDirection stack with all robots
        for(Robot robot: robots)
            rightDirection.push(robot);

        // go through the stack, if direction of robot is left add to other stack
        // otherwise add the health to res
        while(!rightDirection.isEmpty()){
            Robot r = rightDirection.pop();
            if(r.direction == 'L'){
                leftDirection.push(r);
            }
            if(r.direction == 'R' && leftDirection.isEmpty()){
                res.add(r);
            }
            if(r.direction == 'R' && !leftDirection.isEmpty()){
                Robot l = leftDirection.pop();
                if(r.health > l.health){
                    r.health = r.health - 1;
                    rightDirection.push(r);
                }else if(r.health < l.health){
                    l.health = l.health - 1;
                    leftDirection.push(l);
                }
            }
        }

        while(!leftDirection.isEmpty()){
            res.add(leftDirection.pop());
        }


        Collections.sort(res, (r1, r2) -> Integer.compare(r1.index, r2.index));
        ArrayList<Integer> results = new ArrayList<>();
        for(Robot r: res)
            results.add(r.health);

        return results;
    }
}