package com.qualint.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoService {
  public List<Integer> twoSum(List<Integer> nums, Integer target) {
    Map<Integer, Integer> complement = new HashMap<>();
    for (int i = 0; i < nums.size(); i++) {
      Integer index = complement.get(nums.get(i));
      if (index != null) {
        List<Integer> newList = new ArrayList<>();
        newList.add(index);
        newList.add(i);
        complement.clear();
        return newList;
      }
      complement.put(target - nums.get(i), i);
    }
    complement.clear();
    return nums;
  }
}
