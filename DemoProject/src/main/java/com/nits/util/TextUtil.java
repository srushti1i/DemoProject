package com.nits.util;

public class TextUtil {
		public static String shortenString(String text,int maxLength) {
			if(text.length()<=maxLength) {
				return text;
			}
			return text.substring(0, maxLength)+"....";
		}
}
