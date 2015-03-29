/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import java.util.List;

/**
 *
 * @author cuvellierdavid
 */
public class Golf {
    public List<Integer> compute(int club1, int club2, 
            int club3, int target, List<Integer> path){
        int a = sum(path);
        if (a > target) {return null;};
        if (a == target) {return path;};
        if (a < target) {
            int diff = target-a;
            if ((diff) >= club3) { path.add(club3);}
            else if ((diff) >= club2) {path.add(club2) ;}
            else if ((diff) >= club1) {path.add(club1) ;}
        }
        return compute(club1,club2,club3,target, path);
    }
    
    private int sum(List<Integer> path)
    {
        int result =0;
        for(Integer a : path){
            result = result +a;
        }
        return result;
    }
}
