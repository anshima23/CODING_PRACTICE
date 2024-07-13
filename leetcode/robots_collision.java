import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class robots_collision {
     static class Robot {
        int position;
        int health;
        char direction;

        Robot(int position, int health, char direction) {
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) { robots.add(new Robot(positions[i], healths[i], directions.charAt(i)));}
        robots.sort(Comparator.comparingInt(r -> r.position));
        Stack<Robot> stack = new Stack<>();


        for (Robot robot : robots) {
            while (!stack.isEmpty() && stack.peek().direction == 'R' && robot.direction == 'L') {
                Robot topRobot = stack.pop();

                if (topRobot.health > robot.health) {
                    topRobot.health -= 1;
                    stack.push(topRobot);
                    robot = null;
                    break;
                }
                 else if (topRobot.health < robot.health) { robot.health -= 1;}   
                else {robot = null; break;}
            }

            if (robot != null) {stack.push(robot);}
        }

        Map<Integer, Integer> finalHealths = new HashMap<>();
        for (Robot robot : stack) {finalHealths.put(robot.position, robot.health);}

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (finalHealths.containsKey(positions[i])) { result.add(finalHealths.get(positions[i]));}
        }
        return result;
    }
}
