package com.jumia.util;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Tony on 14/01/2020.
 */
@Component
public class GeneralUtil {
	public static boolean isEmptyString(String input){
    	return input==null || input.trim().length()==0;
    }

	public static boolean isEmptyList(List inputList){
		return inputList==null || inputList.isEmpty() || inputList.size()==0;
	}
}
