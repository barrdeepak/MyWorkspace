import java.io.*;
// Main class should be named 'Solution'

/*


Given on-call rotation schedule for multiple people by: their name, start time and end time of the rotation:

Abby 1 10
Ben 5 7
Carla 6 12
David 15 17

Your goal is to return rotation table without overlapping periods representing who is on call during that time. Return "Start time", "End time" and list of on-call people:

1 5 Abby
5 6 Abby, Ben
6 7 Abby, Ben, Carla
7 10 Abby, Carla
10 12 Carla
15 17 David

*/


// 1 - Abbey( join)
// 5 - Ben ( join)
// 6 - Carla (join)
// 7 - Ben (leaves)
// 10 - Abby (leaves)
// 12
// 15
// 17

// Set = Abbey, Ben,

import java.util.*;

class Pair {
    int time;
    String name;
    Boolean action;
    public Pair(int time, String name, Boolean action) {
        this.time = time;
        this.name = name;
        this.action = action;

    }
}

class Schedule {
    int startTime;
    int endTime;
    List<String> names;

    public Schedule(int start, int end, List<String> names) {
        this.startTime = start;
        this.endTime = end;
        this.names = names;

    }
}
class Solution {
    public static void main(String[] args) {
        List<String> input = new ArrayList();
        input.add("Abby|1|10");
        input.add("Ben|5|7");
        input.add("Carla|6|12");
        input.add("David|15|17");
        List<Schedule> result = getSchedule(input);
        for(Schedule s:result){
            System.out.println(String.format("%d, %d => %s", s.startTime, s.endTime, s.names.toString()));
        }
    }

    public static List<Schedule> getSchedule(List<String> input)
    {
        List<Pair> pairs = new ArrayList<Pair>();
        for(String s :  input){
            String[] splits = s.split("\\|");
            pairs.add(new Pair(Integer.parseInt(splits[1]), splits[0], true));
            pairs.add(new Pair(Integer.parseInt(splits[2]), splits[0], false));
        }

        Collections.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.time - p2.time;
            }
        });
        List<Schedule> output = new ArrayList<Schedule>();
        Set<String> names = new HashSet<>();
        for(int i =1;i<pairs.size();i++){
            Pair p1 = pairs.get(i-1);
            Pair p2 = pairs.get(i);
            System.out.println(String.format("%s = %d  = %s", p1.name, p1.time, p1.action));
            System.out.println(String.format("%s = %d  = %s", p2.name, p2.time, p2.action));
            System.out.println("----")  ;
            if(p1.action)
                names.add(p1.name);
            else names.remove(p1.name);

            if(names.size()>0)
            output.add(new Schedule(p1.time, p2.time, new ArrayList(names)));

            if(p2.action)
                names.add(p2.name);
        }
        return output;
    }
}

// Abby 1 10
// Ben 5 7
// Carla 6 12
// David 15 17

// 1 5 Abby
// 5 6 Abby, Ben
// 6 7 Abby, Ben, Carla
// 7 10 Abby, Carla
// 10 12 Carla
// 15 17 David