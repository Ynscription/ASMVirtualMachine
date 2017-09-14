package tp.pr5.mv.cpu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import tp.pr5.mv.controller.MemoryObserver;
//Yeah! hashmaps!


public class Memory {
	
	MemoryObserver memoryO;
	
	private HashMap <Integer,Integer> memory;

	
	public Memory() {
		memory = new HashMap<Integer,Integer>();
	}
	
	

	public Integer read(Integer memPosition) {
		if (memory.containsKey(memPosition)) {
			return memory.get(memPosition);
		
		}
		return null;
		

	}

	public void write(Integer num, Integer pos) {
		memory.put(pos, num);
		if (memoryO != null) {
			memoryO.update(new TreeMap<Integer,Integer>(memory));
		}

	}
	
	public void addMemoryObserver (MemoryObserver mo) {
		memoryO = mo;
	}
	
	public String toString(){
		String r = "";
		if (memory.isEmpty()) {
			return "<vacia>";
		}
		
		TreeMap<Integer, Integer> treeMemory = new TreeMap<Integer, Integer>(memory);
		Iterator<Integer> i = treeMemory.keySet().iterator();
		
		while (i.hasNext()) {
			int v = (int) i.next();
			r = r + "[" + v + "]: " + memory.get(v) + " ";
		}
		return r;	
	}
	
}