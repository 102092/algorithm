package app;

import java.util.*;

public class Tech6 {
    /**
     * InnerTech6
     */
    public class Time implements Comparable<Time> {
        private int hour;
        private int min;
        private int sec;

        public Time(int hour, int min, int sec) {
            this.hour = hour;
            this.min = min;
            this.sec = sec;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getHour() {
            return hour;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public void setSec(int sec) {
            this.sec = sec;
        }

        public int getMin() {
            return min;
        }

        public int getSec() {
            return sec;
        }

        @Override
        public int compareTo(Time o) {
            // TODO Auto-generated method stub
            if (this.hour > o.hour) {
                return 1;
            } else if (this.hour == o.hour) {
                if (this.min > o.min) {
                    return 1;
                } else if (this.min == o.min) {
                    if (this.sec > o.sec) {
                        return 1;
                    }
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) throws Exception {
        int totalTicket = 2000;
        String[] logs = new String[] { "woni request 09:12:29", "brown request 09:23:11", "brown leave 09:23:44",
                "jason request 09:33:51", "jun request 09:33:56", "cu request 09:34:02" };
        System.out.println(solve(totalTicket, logs));
    }

    private static String[] solve(int totalTicket, String[] logs) {
        int ticketLimit = totalTicket;

        Map<String, List<String>> map = new HashMap<>();
        String[] results = new String[logs.length];

        for (int i = 0; i < logs.length; i++) {
            String[] action = new String[3];
            action = logs[i].split(" ");
            String key = action[0];

            if (map.containsKey(key)) {
                map.get(key).add(action[1]);
                map.get(key).add(action[2]);
            } else {
                List<String> lists = new ArrayList<>();
                lists.add(action[1]);
                lists.add(action[2]);
                map.put(key, lists);

            }
        }
        Iterator<String> keys = map.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            int valueSize = map.get(key).size();
            if (valueSize == 4) {
                map.remove(key);
            }

        }

        Map<String, String> unsortedMap = new HashMap<>();
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                System.out.println(key + map.get(key).get(1));
                unsortedMap.put(key, map.get(key).get(1));

            }

        }

        Map<String, String> sortedMap = sortByValue(unsortedMap);

        return results;
    }

    private static Map<String, String> sortByValue(Map<String, String> unsortedMap) {

        List<Map.Entry<String, String>> list = new LinkedList<>(unsortedMap.entrySet())

        

        return null;
    }

}