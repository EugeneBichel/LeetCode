package com.bichel.algorithms.bfs_dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee empl: employees) {
            map.put(empl.id, empl);
        }

        return bfs(map.get(id), map);
    }

    private int bfs(Employee empl, Map<Integer, Employee> map) {
        int importance = 0;

        Queue<Employee> q = new LinkedList<>();
        q.add(empl);

        while(!q.isEmpty()) {
            Employee em = q.poll();
            importance += em.importance;

            for(Integer id: em.subordinates) {
                q.add(map.get(id));
            }
        }

        return importance;
    }
}
