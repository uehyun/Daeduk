package day03;

import java.util.ArrayList;

public class Human extends Animal {
	ArrayList<String> tools = new ArrayList<String>();
	
	public Human() {
		tools.add("반지");
	}
	
	public void farming(String tool) {
		tools.add(tool);
	}

	@Override
	public String toString() {
		String str = "";
		for (String tool : tools) {
			str += tool + " ";
		}
		return str;
	}
	
}
